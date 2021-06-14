package Print;

import javafx.util.Pair;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/30 19:57
 * @description：
 */

public class PrintABC extends Thread{
    private volatile int count = 101;
    public PrintABC(){};

    public static ReentrantLock lock = new ReentrantLock();

    public void run(){
        while(count > 0){
            lock.lock();
            int n = new Integer(Thread.currentThread().getName());
            try {
                if(count % 3 == n){
                    char c = (char) ('a' + n);
                    System.out.println("Thread " + Thread.currentThread().getName() + " : " + c);
                    count--;
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
