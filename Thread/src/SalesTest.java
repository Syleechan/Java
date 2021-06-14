import Lock.Sales;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/12 20:59
 * @description：
 */

public class SalesTest {
    public static void main(String[] args) {
       Sales s = new Sales();
//        Sales saleTicket1 = new Sales();
//        Sales saleTicket11 = new Sales();
//        Sales saleTicket12 = new Sales();
//
        //三个不同对象，用synchronized(this)是错误方法，此时this指向各自的对象，同步锁不起作用
//        Thread t1 = new Thread(saleTicket1,"售票窗口1");
//        Thread t2 = new Thread(saleTicket11, "售票窗口2");
//        Thread t3 = new Thread(saleTicket12, "售票窗口3");

        Thread t1 = new Thread(s,"售票窗口1");
        Thread t2 = new Thread(s, "售票窗口2");
        Thread t3 = new Thread(s, "售票窗口3");
//
        t1.start();
        t2.start();
        t3.start();
//        System.out.println(Thread.activeCount());




    }
}
