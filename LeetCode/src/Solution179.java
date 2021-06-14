import org.junit.Test;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/6/14 17:05
 * @description：
 */

public class Solution179 {

    @Test
    public void test(){
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            s[i] = String.valueOf(nums[i]);
        }
        quickSort(s, 0, s.length - 1);
        if(s[0].equals("0"))return "0";
        StringBuilder sb = new StringBuilder();
        for(String t : s){
            sb.append(t);
        }
        return sb.toString();
    }

    public void quickSort(String[] s, int i, int j){
        if(i >= j)return;

        int left = i;
        int right = j;
        String t = s[left];
        String str = "";
        while(left < right){
            while(left < right && (s[right] + t).compareTo(t + s[right]) <= 0)right--;
            s[left] = s[right];
            while(left < right && (s[left] + t).compareTo(t + s[left]) >= 0)left++;
            s[right] = s[left];
        }
        s[left] = t;
        quickSort(s, i, left - 1);
        quickSort(s, left + 1, j);
    }
}
