/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/12 22:05
 * @description：
 */

public class SaleTicket1 extends Thread {

    private static int ticket = 100;

    //private static Object object = new Object();

    @Override
    public void run(){
        while(true){
            //synchronized(obj) 创建一个共用对象作为同步
            //synchronized (this) 注意如果创建了多个不同对象让thread指向了不同的对象，此时this指向的是各自的对象不是
            //同一个会失去作用，慎用this
            //此效果和 obj的效果一样
            synchronized (SaleTicket.class){
                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": 买票号为 " + ticket);
                    ticket--;
                }else{
                    System.exit(0);
                }
            }

        }
    }
}
