package Tcp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/20 15:18
 * @description：
 */

public class TcpTest2 {

    @Test
    public void client() throws IOException {
        Socket sc = new Socket(InetAddress.getByName("127.0.0.1"),9290);

        OutputStream os = sc.getOutputStream();

        FileInputStream fis = new FileInputStream(new File("E:\\Study\\IO\\src\\Picture\\01.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0 , len);
        }

        //read是个阻塞的过程,如果不给信号，server不知道你有没有写完一直在while循环中
        sc.shutdownOutput();

        //接受来自服务器端的数据显示在控制台上
        InputStream is = sc.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[20];
        int lens;
        while((lens = is.read(buf)) != -1){
            baos.write(buf,0 , lens);
        }
        System.out.println(baos.toString());

        baos.close();
        fis.close();
        os.close();
        sc.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9290);
        Socket s = ss.accept();

        InputStream is = s.getInputStream();

        FileOutputStream fos = new FileOutputStream(new File("E:\\Study\\IO\\src\\Picture\\20.jpg"));

        byte[] buffer = new byte[1024];
        int len;

        while((len = is.read(buffer)) != -1){
            fos.write(buffer, 0, len);
        }


        OutputStream os = s.getOutputStream();
        os.write("收到".getBytes());


        os.close();
        fos.close();
        is.close();
        s.close();
        ss.close();


    }



}
