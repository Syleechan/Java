/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/11 16:59
 * @description：Thread test
 */

public class Test {
    public volatile int count = 0;

    public  synchronized void  increase(){
        ++count;
    }

    public static void main(String[] args) {
        final Test test = new Test();
        for(int i = 0; i < 10; ++i) {
            new Thread(() -> {
                for (int j = 0, k = 1; j < 10000; ++j) {
                    test.increase();
                }
                System.out.println("Thread is running!");
            }).start();
        }

        //System.out.println(test.count);
        while(Thread.activeCount() > 2){
            Thread.yield();
            System.out.println("Thread is yield!");
        }

        System.out.println(test.count);
    }
}
