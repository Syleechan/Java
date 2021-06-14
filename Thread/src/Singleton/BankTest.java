package Singleton;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/13 21:58
 * @description：
 */

//将单例模式的懒汉式改成线程安全
public class BankTest {
}

class Bank{
    Bank(){}

    private static Bank instance = null;

    public static  Bank getInstance(){
        //方式一：效率比较差
//        synchronized (Bank.class){
//            if(instance == null){
//                instance = new Bank();
//
//            }
//            return  instance;
//        }

        //方式二：效率较高，先判断进不进，就不用在外等待再去判断
        if(instance == null){
            synchronized (Bank.class){
                    instance = new Bank();
                    return  instance;
            }
        }

        return instance;
    }
}