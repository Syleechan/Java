package Proxy;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/23 19:05
 * @description：
 */


/**
 * 静态代理：编译期间 代理类和被代理类被确定下来
 */



interface ClothFactory{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;//用被代里类对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做些准备");

        factory.produceCloth();

        System.out.println("代理工厂做些后续的收尾");
    }

}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("NIKE工厂生产一批运动服");
    }
}



public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        //创建代理类的对象
        ClothFactory clothFactory = new ProxyClothFactory(nike);

        clothFactory.produceCloth();
    }
}
