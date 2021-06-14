package Lamda;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/23 20:51
 * @description：
 */

public class LambdaTest {
    @Test
    public void test(){
        Runnable r = () -> System.out.println("123");

        r.run();
        System.out.println("******************");

        Runnable r1 = () -> System.out.println("123");

        r1.run();
    }

    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        System.out.println(com.compare(12,21));

        System.out.println("**************");

        //lamda表达式
        Comparator<Integer> com1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com1.compare(12, 21));

        System.out.println("**************");

        //方法引用
        Comparator<Integer> com2 = Integer :: compare;

        System.out.println(com2.compare(12,21));
    }

}
