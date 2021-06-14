import org.junit.Test;

import java.util.Random;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/21 21:48
 * @description：
 */

public class NewInstanceTest {

    @Test
    //异常：访问权限非法，实例异常
    //即想要创建运行时类的对象要求：
    //1.运行时必须提供空参构造器
    //2.空参的构造器的访问权限足够，通常为public
    public void test1() throws IllegalAccessException, InstantiationException {
        Class clazz = Person.class;

        //泛型没有确定需要强转
        //newInstance():调用此方法，创建对应的运行时类的对象

        //
        Person obj = (Person) clazz.newInstance();//空参构造器
        System.out.println(obj);
    }

    @Test
    public  void test2(){
        for (int i = 0; i < 100; i++) {


            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "Person";
                    break;
            }

            try {
                Object instance = getInstance(classPath);
                System.out.println(instance);
            } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Object getInstance(String classPath) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }


}
