package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/16 15:12
 * @description：
 */

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100 ; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}


class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100 ; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}






public class ThreadPool {

    public static void main(String[] args) {
        //提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //强转将接口实现强转为类对象才能调用方法去设置属性
        ThreadPoolExecutor service = (ThreadPoolExecutor) executorService;

//        service.setKeepAliveTime();
//        service.setCorePoolSize();
//        service.setMaximumPoolSize();


        //创建线程池以及线程数量后设置线程池的属性
        //java.util.concurrent.ThreadPoolExecutor的类实现了Executorservice接口
        //System.out.println(executorService.getClass());

        //执行指定的线程操作，需要提供实现runnable接口或者callable接口实现类的对象
        //适合适用于runnable
        executorService.execute(new NumberThread());
        executorService.execute(new NumberThread1());
        //适合适用于callable
        //executorService.submit()
        executorService.shutdown();
    }
}
