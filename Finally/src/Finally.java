/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/26 17:03
 * @description：
 */

public class Finally {
    public  static  void  main(String[] args){
        //
        //System.out.println(method(0));
        System.out.println(method());
    }


    public static int method(){
        int a = 10;
        try{
            //int a = 10;
            int k = a / 0;
            System.out.println(k);
        }catch (ArithmeticException e){
             a = 20;
            //e.printStackTrace();
            //return a;
        }finally {
            a = 30;
            //return a;
        }
        return a;
    }

    public void arrayTest(){
        int[] a = new int[10];
        for(int i = 0 ; i < a.length; ++i){
            a[i] = i;
        }
    }


    public static void test(){
        int a = Integer.MAX_VALUE;
        int b = a + 1;
        System.out.println("a :" + a + " b :" + b);
        System.out.println("b - a = " + (b-a));


    }
}
