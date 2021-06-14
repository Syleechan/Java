package ProductorConSumer.Syncronized;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/30 20:13
 * @description：
 */

public class P {
    public static void main(String[] args) {
        Data data = new Data();
         new Thread(()->{
            while(true){
                try {
                    data.increment();
                    Thread.sleep(200);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"p1").start();

        new Thread(()->{
            while(true){
                try {
                    data.increment();
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"p2").start();

        new Thread(()->{
            while(true){
                try {
                    data.decrement();
                    Thread.sleep(300);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"c1").start();

        new Thread(()->{
            while(true){
                try {
                    data.decrement();
                    Thread.sleep(300);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"c2").start();


    }
}

class Data{
    private volatile int num = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while(num >= 20) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + " => produced : product remain " + num);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            while(num == 0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + " => consumed : product remain " + num);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
