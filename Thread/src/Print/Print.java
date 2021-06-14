package Print;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/30 19:16
 * @description：
 */

public class Print implements Runnable {
    private  volatile int count;

    public  Print(int n){
        this.count = n;
    }


    @Override
    public void run() {
        while(count > 0){
            synchronized (this){
                notify();
                String id = Thread.currentThread().getName();
                int num = Integer.parseInt(id);
                if(count % 3 == num){
                        System.out.println("currentThread " + id + " : " + count);
                        count--;
                }else{
                    try {
                        wait();
                    } catch (InterruptedException e) {
                            e.printStackTrace();
                    }
                }
            }
        }
    }
}
