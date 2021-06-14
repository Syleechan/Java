import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/25 14:23
 * @description：
 */

public class Sweet135 {
    @Test
    public void test(){
        int[] arr = {1,3,4,5,2};
        candy(arr);

    }

    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for(int i = 1; i < len; i++){
            if(ratings[i] > ratings[i - 1]){
                dp1[i] = dp1[i - 1] + 1;
            }else if(ratings[i] == ratings[i - 1]){
                dp1[i] = 1;
            }else{
                dp1[i] = Math.max(dp1[i - 1] - 1, 1);
            }
        }

        for(int i = len - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                dp2[i] = dp2[i + 1] + 1;
            }else if(ratings[i] == ratings[i + 1]){
                dp2[i] = 1;
            }else{
                dp2[i] = Math.max(dp2[i + 1] - 1, 1);
            }
        }
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += Math.max(dp1[i], dp2[i]);
        }


        return sum;
    }
}
