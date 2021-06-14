package Print;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/30 19:26
 * @description：
 */

public class Test {
    public static void main(String[] args) {
        PrintABC p1 = new PrintABC();
        Thread t1 = new Thread(p1, "0");
        Thread t2 = new Thread(p1, "1");
        Thread t3 = new Thread(p1, "2");
        t1.start();
        t2.start();
        t3.start();

    }
}
