package java2;

import java1.Person;
import org.junit.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/23 16:28
 * @description：
 */

public class OtherTest {

    @Test
    public void  test1(){
        Class<Person> clazz = Person.class;

        //获取构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor);
        }

        System.out.println();
        System.out.println();

        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            System.out.println(c);
        }

        System.out.println();
        System.out.println();
        //获取运行时类的父类
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);

        System.out.println();
        System.out.println();

        //获取带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        System.out.println();
        System.out.println();

        //获取父类的泛型
        ParameterizedType  parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
        //class 去getname
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }

    @Test
    public void test3(){
        Class<Person> clazz = Person.class;

        Class<?>[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }

        System.out.println();

        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }
    }


    @Test
    public void test4(){
        Class<Person> clazz = Person.class;
        System.out.println(clazz.getPackage());

        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation a : annotations){
            System.out.println(a);
        }
    }
}
