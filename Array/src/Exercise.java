import java.util.Scanner;

/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/18 21:38
 * @description：
 */

public class Exercise {
    public static void main(String[] args){
        int n = new Scanner(System.in).nextInt();

        //汉诺塔问题
        //将a以b为中转移动到c上
        move(n, 'a', 'b', 'c');
    }

    //递归
    //将规模较大的问题转化为小规模问题
    public static void move(int n, char a ,char b, char c){
        if(n == 1){
            System.out.println("\t" + a + "->" + c);
        }else{
            //小盘永远在大盘上
             //移动n-1个盘子时，c是空的，则以c为中转，将a先移到b
            move(n-1, a, c, b);
            //再将剩下的一个大盘直接移动到c
            System.out.println("\t" + a + "->" + c);
            //a此时空了，再将n-1个盘子从b以a为中转移动到c
            move(n-1, b, a, c);
        }
    }
}
