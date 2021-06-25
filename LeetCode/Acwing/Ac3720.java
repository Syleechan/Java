import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/6/23 19:30
 * @description：
 */

public class Ac3720 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++)a[i] = sc.nextInt();
        for(int i = 0; i < n; i++)b[i] = sc.nextInt();

        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0; i < n; i++){
            if(a[i] + b[n - i] > x){
                System.out.println("false");
                System.exit(1);
            }
        }
        System.out.println("true");
    }

}
