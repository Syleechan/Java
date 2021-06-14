import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/27 15:55
 * @description：
 */

public class Solution312 {

    @Test
    public void  test(){
        int[] nums = {3,1,5,8};
        maxCoins(nums);
        List<Integer> list = new ArrayList<>();

    }

    private int[][] mem;
    private int[] arr;
    public int maxCoins(int[] nums){
        int len = nums.length;
        arr = new int[len + 2];
        for(int i = 1; i < len + 1; i++){
            arr[i] = nums[i - 1];
        }
        arr[0] = arr[len + 1] = 1;
        mem = new int[len + 2][len + 2];
        for(int i = 0; i < len + 2; i++){
            Arrays.fill(mem[i], -1);
        }

        return partitionCaculate(0, len + 1);
    }

    public int partitionCaculate(int left, int right){
        if(right - left <= 1)return 0;

        if(mem[left][right] != -1)return mem[left][right];

        for(int i = left + 1; i < right; i++){
            int sum = arr[left] * arr[i] * arr[right];//初始left, right都为1
            sum += partitionCaculate(left, i) + partitionCaculate(i, right);
            mem[left][right] = Math.max(mem[left][right], sum);

        }
        return mem[left][right];
    }




//超时
//    int max = 0;
//    public int maxCoins(int[] nums) {
//        dfs(nums, 0, 0);
//        return max;
//    }
//
//    public void dfs(int[] nums, int level, int sum){
//        if(level == nums.length){
//            max = Math.max(max, sum);
//        }
//
//        for(int i = 0; i < nums.length; i++){
//            int target = nums[i];
//            int left = i - 1 < 0 ? 1 : nums[i - 1];
//            int right = i + 1 >= nums.length ? 1 : nums[i + 1];
//            int[] temp = new int[nums.length - 1];
//            int m = 0, n = 0;
//            while(n < temp.length){
//                if(m == i){
//                    m++;
//                    continue;
//                }
//                temp[n++] = nums[m++];
//            }
//
//            dfs(temp, level + 1, sum + target * left * right);
//        }
//    }
}
