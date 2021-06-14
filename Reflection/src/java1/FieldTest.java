package java1;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/21 22:25
 * @description：
 */

public class FieldTest {
    @Test
    public void test1(){
        Class clazz = Person.class;

        //可以获取父类及自己的公有属性
        Field[] fields = clazz.getFields();
        for(Field f : fields){
            System.out.println(f);
        }

        System.out.println("\n");

        //只能拿到自己声明的公有属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f1 : declaredFields){
            System.out.println(f1);
        }
    }

    @Test
    public void test2(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            System.out.println(f);
            //权限修饰符
            int modifiers = f.getModifiers();
            //public 1  private 2
            System.out.print(modifiers + "\t");
            System.out.print(Modifier.toString(modifiers) + "\t");

            Class type = f.getType();
            System.out.print(type + "\t");

            String fName = f.getName();
            System.out.print(fName);

            System.out.println();
        }
    }
}
