package pku;

/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/26 16:33
 * @description：
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class BufferZone {

    public BufferZone() {

    }
    private static final int BufferSize = 4000;
    private static final int channelNum = 20;

    private static AtomicLong positionInput = new AtomicLong();

    private volatile boolean firstGet = true;

    private ByteBuffer buffer = ByteBuffer.allocateDirect(BufferSize);   //分配缓冲区
    private BufferControl bufferControl = new BufferControl(buffer);    //包装缓冲区
    private int queueLength = 0;    //消息队列长度
    private static ChannelManager channelManager;   //通道管理

    static {
        FileChannel[] channels = new FileChannel[channelNum];
        for (int i = 0; i < channelNum; i++) {
            try {
                File file=new File("data");
                if(!file.exists()){
                    file.mkdir();
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile("data/queue_data", "rw");
                channels[i] = randomAccessFile.getChannel();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        channelManager = new ChannelManager(channels);
    }


    private BufferTableManager bufferTable = new BufferTableManager();  //管理消息块的表



    public void put(byte[] message) {
        while (message.length + 2 > buffer.remaining()) {
            flush();    //缓冲区满，推到管道里
        }
        buffer.putShort((short) message.length);
        buffer.put(message);
        this.queueLength++; //消息队列长度
    }

    private void flush() {
        long inputPos = positionInput.getAndIncrement();
        bufferTable.add(inputPos * BufferSize, queueLength - 1);  //磁盘内偏移和该缓冲区最后一条消息的位置相对位置（从0开始）
        buffer.clear(); //把缓冲区重置，但是不改变缓冲区内容,position = 0,limit = capacity
        try {
            FileChannel channel = channelManager.getChannel();
            channel.write(buffer, inputPos * BufferSize);   //从磁盘偏移点写入buffer中的数据
            channelManager.freeChannel(channel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        buffer.clear();
    }

    public synchronized Collection<byte[]> get(long offset, long num) {
        if (firstGet) {
            flush();
            firstGet = false;
        }

        List<byte[]> result = new ArrayList<>();

        long totalRead = 0;//已经读了多少条
        long current = offset;//正在读第几条消息

        for (int i = 0; i < num; i++) {
            TableItemInfo itemWrapper = bufferTable.offsetInFile(current);  //得到这条消息在哪个块，块内偏移和块内最后一条消息索引
            if (itemWrapper == null) {
                return result;
            }
            buffer.clear();
            //读盘
            try {
                FileChannel channel = channelManager.getChannel();
                channel.read(buffer, itemWrapper.offset);   //读一整块
                channelManager.freeChannel(channel);
            } catch (IOException e) {
                e.printStackTrace();
            }
            buffer.clear();

            if (i == 0) {
                bufferControl.skip(itemWrapper.offsetInBlock);  //跳过offset之前的
            }

            for (; current <= itemWrapper.lastMessageCount; current++) {
                if (totalRead == num) {
                    return result;
                }
                byte[] message = bufferControl.nextMessage();

                result.add(message);
                totalRead++;
            }
            buffer.clear();
        }
        return result;
    }

    //记录消息的逻辑地址和物理地址，知道offset在第几页，存储页号，以及这一页存了多少消息
    private static class BufferTableManager {
        private List<TableItem> tableItems = new ArrayList<>();

        public synchronized void add(long offset, int lastMessageCount) {
            tableItems.add(new TableItem(offset, lastMessageCount));
        }

        //给一条消息 我需要读哪一页？
        public TableItemInfo offsetInFile(long offset) {
            long startInBlock = 0;

            for (int i = 0; i < tableItems.size(); i++) {
                TableItem tableItem = tableItems.get(i);
                if (tableItem.lastMessageCount < offset) {
                    startInBlock = tableItem.lastMessageCount + 1;
                } else {
                    return new TableItemInfo((int) (offset - startInBlock), tableItem.offset, tableItem.lastMessageCount);
                }
            }
            return null;
        }
    }

    //这个包装类可以给知道一条消息的块号，块内偏移
    public static class TableItemInfo {
        public int offsetInBlock;   //块内偏移
        public long offset;
        public long lastMessageCount;

        public TableItemInfo(int offsetInBlock, long offset, long lastMessageCount) {
            this.offsetInBlock = offsetInBlock;
            this.offset = offset;
            this.lastMessageCount = lastMessageCount;
        }
    }


    private static class TableItem {

        public long offset;//磁盘偏移(第几个缓冲块)
        public int lastMessageCount;//最后一条消息是队列中的第几条消息

        public TableItem(long offset, int lastMessageCount) {
            this.offset = offset;
            this.lastMessageCount = lastMessageCount;
        }
    }

    //缓冲区包装
    private static class BufferControl {
        ByteBuffer buffer;

        public BufferControl(ByteBuffer buffer) {
            this.buffer = buffer;
        }

        //跳过n条消息
        public void skip(int n) {
            for (int i = 0; i < n; i++) {
                short messageLength = buffer.getShort(); //取信息长度
                int oldPos = buffer.position();
                buffer.position(oldPos + messageLength);
            }
        }
        //取下一条消息
        public byte[] nextMessage() {
            short messageLength = buffer.getShort();
            byte[] message = new byte[messageLength];
            for(int i = 0;i<messageLength;++i){
                message[i] = buffer.get();
            }
            return message;
        }
    }

    //通道管理
    public static class ChannelManager {
        private Semaphore semaphore;
        private HashMap<FileChannel, Boolean> channelState = new HashMap<>();

        public ChannelManager(FileChannel[] channels) {
            semaphore = new Semaphore(channels.length);
            for (FileChannel channel : channels) {
                channelState.put(channel, false);
            }
        }

        //信号量加1
        public FileChannel getChannel() {
            FileChannel target = null;
            try {
                semaphore.acquire();
                target = findFree();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return target;
        }

        //信号量减1
        public synchronized void freeChannel(FileChannel channel) {
            channelState.put(channel, false);
            semaphore.release();
        }

        private synchronized FileChannel findFree() {
            for (FileChannel channel : channelState.keySet()) {
                if (!channelState.get(channel)) {
                    channelState.put(channel, true);
                    return channel;
                }
            }
            return null;
        }

    }
}
