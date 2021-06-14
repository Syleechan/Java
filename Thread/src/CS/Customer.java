package CS;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/15 21:30
 * @description：
 */

public class Customer extends Thread{
    private Clerk clerk;

    public Customer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": 开始消费产品...");
        while (true){

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consueme();
        }
    }
}
