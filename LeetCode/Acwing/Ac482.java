import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/6/23 19:54
 * @description：
 */

public class Ac482 {
    public static void main(String[] args) throws IOException {
        Date date = new Date();
        long time = date.getSeconds();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(s);
        int[] a = new int[n];
        for(int i = 0; i < n; i++)a[i] = Integer.parseInt(str[i]);

        int[] l = new int[n], r = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = 1;
            for(int j = 0; j < i; j++){
                if(a[j] < a[i])l[i] = Math.max(l[i], l[j] + 1);
            }
        }

        for(int i = n - 1; i >= 0; i--){
            r[i] = 1;
            for(int j = n - 1; j > i; j--){
                if(a[j] < a[i])a[i] = Math.max(r[i], r[j] + 1);
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++)res = Math.max(res, l[i] + r[i] - 1);
        System.out.println(n - res);
        long time1 = date.getTime();
        System.out.println(time1 - time);

    }
}
