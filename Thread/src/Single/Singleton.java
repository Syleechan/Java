package Single;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/8 16:01
 * @description：
 */

public class Singleton {
    private Singleton (){}

    private Singleton instance = null;

    public Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

class Singleton1{
    private Singleton1 (){};

    private Singleton1 instance = new Singleton1();

    public Singleton1 getInstance(){
        return instance;
    }
}
