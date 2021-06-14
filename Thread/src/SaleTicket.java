/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/12 20:53
 * @description：
 */

public class SaleTicket implements Runnable {

    private int total = 100;

    private int no = 1;

    private  Object object = new Object();

    @Override
    public void run() {
        while(this.total > 0 & this.no <= 100){
            synchronized (this.object){
                if(this.total > 0 & this.no <= 100){
                    try{
                        Thread.sleep(100);

                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    String msg = Thread.currentThread().getName() + "售出第 " + this.no + " 张票";
                    System.out.println(msg);
                    this.total--;
                    this.no++;
                    //Thread.yield();
                }else{
                    System.out.println("票已售完");
                    System.exit(0);
                }
            }
        }
    }


}
