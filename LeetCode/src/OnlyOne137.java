import org.junit.Test;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/26 14:27
 * @description：
 */

public class OnlyOne137 {


    @Test
    public void test(){
        int[] nums = new int[]{3,1,2,4,1,2,4,1,2,4,5,5,5};
        singleNumber(nums);
    }



    public int singleNumber(int[] nums){
        int[] counts = new int[32];//用来计算每个数字1出现的次数
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < 32; j++){
                counts[j] += nums[i] & 1;
                nums[i] = nums[i] >>> 1;//向右移动一位，每一位与1与运算
            }
        }

        int res = 0, m = 3;
        for(int i = 0; i < 32; i++){
            res = res << 1;//最高位向左移动一位
            int num = counts[31 - i] % m;//出现三次的为0， 如果有单独的也为1 则4 % 3也为1
            res = res | num;

        }
        return res;
    }
}
