package Lamda;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/23 20:58
 * @description：
 */


/**
 * (o1, o2) -> Integer.compare(o1, o2);
 * 格式：
 *      ->左边：lamda形参列表，其实就是接口中的抽象方法的形参列表
 *      ->右边：lamda体 重写的抽象方法的方法体
 *
 * 使用：
 */

public class LambdaTest1 {
    @Test
    public void test1(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        con.accept("123");


        System.out.println("**********");

        Consumer<String> con1 = (String s) ->{
            System.out.println(s);
        };
        con1.accept("456");

        //类型推断
        Consumer<String> con2 = System.out::println;
        con2.accept("789");

    }
}
