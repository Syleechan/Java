package Comunication;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/15 21:10
 * @description：
 */

public class ComunicationTest implements Runnable{

    private int num = 1;

    @Override
    public void run() {
        while(true){
            synchronized (this) {

                notify();
                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    ++num;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }



}


class Coumunication{
    public static void main(String[] args) {
        ComunicationTest comunicationTest = new ComunicationTest();
        Thread t1 = new Thread(comunicationTest,"线程1");
        Thread t2 = new Thread(comunicationTest,"线程2");

        t1.start();
        t2.start();
    }
}