import java.util.Scanner;

/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/18 22:41
 * @description：
 */

public class recurse {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(recuseMulti(n));
    }

    public static int recuseMulti(int n){
        if(n == 1) {
            return 1;
        }else{
            return n*recuseMulti(n-1);
        }
    }
}
