package Ali;

import java.util.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/16 18:54
 * @description：
 */

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();

        }

        int num = arr[n - x];



        Arrays.sort(arr);
        int count = 0;
        for(int i = n - 1; i >= 0; i--){
            if(arr[i] == 0 || arr[i] < num)break;;
            count++;
        }

        System.out.println(count);

    }
}
