import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/26 18:02
 * @description：
 */

public class Ship1011 {

    @Test
    public void test(){
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        shipWithinDays(weights,5);
    }



    public int shipWithinDays(int[] weights, int D) {
        int sum = Arrays.stream(weights).sum();
        int max = Arrays.stream(weights).max().getAsInt();

        int l = max, r = sum;
        while(l < r){
            int mid = (l + r) / 2;
            if(canCarry(weights, D, mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return l;
    }

    public boolean canCarry(int[] weights, int D, int C){
        int count = 1;
        int capcaity = 0;
        int i = 0;
        while(i < weights.length){
            capcaity += weights[i];
            if(capcaity > C){
                capcaity = weights[i];
                count++;
            }

            if(count > D){
                return false;
            }
        }

        return true;
    }
}
