import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/7/8 17:28
 * @description：
 */

public class Byte {

    @Test
    public void test(){
        int n = 18;
        System.out.println(Arrays.toString(func(100)));
    }


    // 2^i * 3^j * 5^k * 7^m
    public int[] func(int n){
        int[] ans = new int[n];
        ans[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0, p7 = 0;
        for(int i = 1; i < n; i++){
            int num = Math.min(ans[p2] * 2, Math.min(ans[p3] * 3, Math.min(ans[p5] * 5, ans[p7] * 7)));
            if(num == ans[p2] * 2)p2++;
            if(num == ans[p3] * 3)p3++;
            if(num == ans[p5] * 5)p5++;
            if(num == ans[p7] * 7)p7++;
            ans[i] = num;
        }
        return ans;
    }

}
