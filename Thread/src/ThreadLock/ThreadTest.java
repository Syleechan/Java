package ThreadLock;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/13 22:12
 * @description：
 */

public class ThreadTest {

    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(() -> {
            synchronized (s1) {
                s1.append("a");
                s2.append("b");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //醒了等着拿s2
                synchronized (s2){
                    s1.append("1");
                    s2.append("2");

                    System.out.println(s1);
                    System.out.println(s2);
                }
            }


        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("c");
                    s2.append("d");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //醒了等着拿s1
                    synchronized (s1){
                        s1.append("3");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();

    }
}
