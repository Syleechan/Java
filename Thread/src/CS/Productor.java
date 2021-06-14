package CS;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/15 21:30
 * @description：
 */

public class Productor extends Thread{
    private  Clerk clerk;

    public Productor(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": 开始生产产品...");
        while (true){

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produce();
        }

    }
}
