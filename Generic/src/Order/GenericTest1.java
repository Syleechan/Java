package Order;

import org.junit.Test;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/17 19:41
 * @description：
 */

public class GenericTest1 {

    @Test
    public void test(){
        Order order = new Order();
        order.setOrder(123);
        order.setOrder("abc");

        Order<String> order1 = new Order<String>("AA",1001,"Order");

    }

    @Test
    public void test1(){
        SubOrder subOrder = new SubOrder();

        //子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不需要再指明泛型类型
        subOrder.setOrder(123);
    }

    @Test
    public void test2(){
        SubOrder subOrder = new SubOrder();

        //子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不需要再指明泛型类型
        subOrder.setOrder(123);


        SubOrder1<String> stringSubOrder1 = new SubOrder1<String>();
        stringSubOrder1.setOrder(".....asc");
    }

}
