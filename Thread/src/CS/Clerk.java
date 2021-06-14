package CS;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/15 21:30
 * @description：
 */

public class Clerk {

    private int proCount = 0;

    public  synchronized void produce() {
        if(proCount < 20){
            ++proCount;
            System.out.println(Thread.currentThread().getName() + ": 开始生产产品第" + proCount +"个产品");

            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consueme() {
        if(proCount > 0){
            System.out.println(Thread.currentThread().getName() + ": 开始消费第" + proCount + "个产品");
            --proCount;

            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class ClerkTest{
    public static void main(String[] args) {

        Clerk clerk = new Clerk();

        //生成者
        Productor productor = new Productor(clerk);
        productor.setName("生产者1");
        //Productor productor1 = new Productor(clerk);

        //消费者
        Customer customer = new Customer(clerk);
        customer.setName("消费者1");
        Customer customer1 = new Customer(clerk);
        customer1.setName("消费者2");

        productor.start();
        customer.start();
        customer1.start();

    }
}
