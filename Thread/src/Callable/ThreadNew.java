package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/15 22:02
 * @description：
 */

//1创建一个实现Callable的实现类
class NumThread implements Callable<Integer>{

    //2实现call方法，将此线程需要执行的操作声明在call方法中
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }

        return sum;//int -> Integer 作为Object子类赋值给Object
    }
}



public class ThreadNew {
    public static void main(String[] args) {
        //3创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4将此Callable接口实现类的对象作为值传递到FutureTask构造器中，创建FutureTaskde的对象
        FutureTask<Integer> futureTask = new FutureTask<>(numThread);
        //5将FT的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()方法
        new Thread(futureTask).start();

        try{
            //6获取Callable中call方法中的返回值
            //get方法的返回值即为FT构造器参数Callable实现类重现call()方法的返回值
            Integer sum = futureTask.get();//get还是Object，FT也是泛型，需要指明泛型类型
            System.out.println(sum);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        {

        }
    }
}
