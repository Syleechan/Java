import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/21 16:36
 * @description：
 */

public class ReflectionTest {
    @Test
    public void test() {
        Person p = new Person("Tom", 12);

        p.age = 10;

        System.out.println(p.toString());

        p.show();

    }

    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
       Class<Person> clazz =  Person.class;
       //通过反射调用，创建Person类的对象
       Constructor<Person> cst = clazz.getConstructor(String.class, int.class);

       Object obj = cst.newInstance("Jack", 20);

       Person p = (Person) obj;

        System.out.println(p.toString());

        //通过反射，调用对象指定的属性，方法
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p.toString());

        //方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("****************");



        //通过反射调用Person私有属性和方法
        //调用私有构造器
        Constructor<Person> ds = clazz.getDeclaredConstructor(String.class);
        ds.setAccessible(true);
        Object obj1 = ds.newInstance("Tom");
        Person p1 = (Person) obj1;
        System.out.println(p1);

        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Lee");
        System.out.println(p1);

        //调用私有方法
        Method show1 = clazz.getDeclaredMethod("show1", String.class);
        show1.setAccessible(true);
        String res = (String) show1.invoke(p1, "123");
//        show1.invoke(p1);
        System.out.println(res);

    }

    @Test
    public void test2() throws ClassNotFoundException {
        //1:调用运行时类的属性： .class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象
        Person p = new Person();
        Class clazz = p.getClass();
        System.out.println(clazz);

        //方式三：调用class的静态方法：forname(String classPath)
        Class clazz2 = Class.forName("Person");
        System.out.println(clazz2);

        //都是true，同地址
        System.out.println(clazz1 == clazz);
        System.out.println(clazz1 == clazz2);

        //方式四：使用ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz3 = classLoader.loadClass("Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz3);
    }
}
