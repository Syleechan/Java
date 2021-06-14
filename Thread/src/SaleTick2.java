/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/12 20:53
 * @description：
 */

class SaleTicket2 implements Runnable {

    private static  int total = 100;

    private static int no = 1;

    private  Object object = new Object();

    @Override
    public void run() {
        while(true){

                sale();
        }
    }

    private static synchronized void  sale() {
        if(total > 0 & no <= 100){
            try{
                Thread.sleep(100);

            }catch (InterruptedException e){
                e.printStackTrace();
            }

            String msg = Thread.currentThread().getName() + "售出第 " + no + " 张票";
            System.out.println(msg);
            total--;
            no++;
            //Thread.yield();
        }else{
            System.out.println("票已售完");
            System.exit(0);
        }
    }


}
