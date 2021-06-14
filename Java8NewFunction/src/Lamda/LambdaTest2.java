package Lamda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/23 21:29
 * @description：
 */

public class LambdaTest2 {

    @Test
    public void test1(){

        func(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("买水价格为： " + aDouble);
            }
        });

        System.out.println("***************");

        func(400, money -> System.out.println("买水价格为： " + money));

    }

    public void func(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    @Test
    public void test2(){
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "abd"));

        System.out.println("*************");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abc", "abe"));
    }

    @Test
    public void test3(){
        BiPredicate<String, String> pre1 = String::equals;
        System.out.println(pre1.test("abc", "abc"));
    }

    @Test
    public void test4(){
        Person person = new Person("Tom", 20);

        Function<Person, String> func1 = Person::getName;

        System.out.println(func1.apply(person));

        Supplier<Person> supplier = Person::new;
        System.out.println(supplier.get());

    }

}
