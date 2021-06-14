import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/26 15:50
 * @description：
 */

public class FindDuplicates442 {

    @Test
    public void test(){
        int[] arr = {4,3,2,7,8,2,3,1};
        int sum = Arrays.stream(arr).sum();
        int max = Arrays.stream(arr).max().getAsInt();

        findDuplicates(arr);
    }

    public void findDuplicates(int[] nums){
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++){
            while(nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int i = 0; i < len; i++){
            if(nums[i] != i + 1){
                res.add(nums[i]);
            }
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
