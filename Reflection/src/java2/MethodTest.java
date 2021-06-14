package java2;

import java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/23 16:05
 * @description：
 */

public class MethodTest {
    @Test
    public void test1(){
        Class clazz = Person.class;

        //获取当前运行类极其所有父类种声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }
        System.out.println();

        //当前运行时类种声明的所有方法(不包括父类种声明)
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods){
            System.out.println(m);
        }
    }

    @Test
    //获取 权限修饰符  返回值类型  方法名
    public void test2(){
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method m : declaredMethods){
            Annotation[] annos = m.getAnnotations();
            for(Annotation a : annos) {
                System.out.println(a);
            }
            //权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            //返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            //方法名
            System.out.println(m.getName() + "\t");

            //参数
            System.out.println("(");

            Class<?>[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes == null && parameterTypes.length == 0)){
                for (int i = 0; i < parameterTypes.length; i++) {
                    if( i == parameterTypes.length - 1){
                        System.out.println(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                }


            }

            System.out.println(")");
            //抛出异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if(!(exceptionTypes == null && exceptionTypes.length == 0)){
                System.out.print("Throws : ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(exceptionTypes.length - 1 == i){
                        System.out.print(exceptionTypes[i].getName());
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }

            System.out.println();
        }


    }

}
