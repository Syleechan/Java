package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/23 19:18
 * @description：
 */


interface Human{
    String getBelief();

    void eat(String food);
}


class SuperMan implements Human{

    private Human human;

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

/**
 * 想要实现动态代理，解决：
 * 1.如何根据加载到内存种的被代理类，动态的创建一个代理类及其对象
 * 2.当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 */

class  ProxyFactory{
    //调用此方法，发回一个代理类的对象
    //传进来被代理类的对象，根据传进来的被代理类对象，动态的创建相应的被代理类的方法
    public static Object getProxyInstance(Object obj){//obj：被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        // 类的加载器，类的接口（实现了哪些接口）
       return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);

    }
}

class MyInvocationHandler implements InvocationHandler{

    //需要使用被代理类的对象进行赋值
    //不能写死，声明成Object类
    private Object object;

    public void bind(Object object) {
        this.object = object;
    }

    //当我们通过代理类的对象，调用方法a时，会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //method:即为代理类对象调用的方法，此方法也就作为了被代理类的对象要调用的方法
        //object:被代理的对象
        Object invoke = method.invoke(object, args);
        //上述方法的返回值就作为当前类中的invoke()的返回值
        return invoke;
    }
}


public class ProxyTest {

    public static void main(String[] args) {

        SuperMan superMan = new SuperMan();
        //代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时，
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("汉堡");

        System.out.println("******************************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory clothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        clothFactory.produceCloth();

    }
}
