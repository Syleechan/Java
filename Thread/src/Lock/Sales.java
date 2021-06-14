package Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/14 21:43
 * @description：
 */

public class Sales implements Runnable{

    private int total = 100;

    private int no = 1;

    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run(){
        while(true) {
            try {
                lock.lock();
                if (this.total > 0 & this.no <= 100) {
                    try {
                        Thread.sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    String msg = Thread.currentThread().getName() + "售出第 " + this.no + " 张票";
                    System.out.println(msg);
                    this.total--;
                    this.no++;
                    //Thread.yield();
                } else {
                    System.out.println("票已售完");
                    System.exit(0);
                }

            }finally {
                lock.unlock();
            }

        }
    }

}

