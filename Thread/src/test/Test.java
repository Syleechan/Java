package test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/14 22:03
 * @description：
 */

class Account{
    private double m = 0;

    public Account(double m) {
        this.m = m;
    }


    public  synchronized void deposit(double atm){
        if(atm > 0){
            m += atm;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " : 存钱: " + atm + "余额为： " + m );
    }


}

class Customer extends Thread{
    private Account account;

    //多个对象需要共用一把锁时加静态初始化一次
    private static ReentrantLock lock = new ReentrantLock(true);

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            lock.lock();
            account.deposit(1000);
            lock.unlock();
        }

    }
}

public class Test{
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);

        Thread t1 =   new Thread(customer1,"甲");
        Thread t2 =   new Thread(customer2, "已");

        t1.start();
        t2.start();
    }
}