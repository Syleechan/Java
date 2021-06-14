import org.junit.Test;

import java.util.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/3/11 17:52
 * @description：
 */

public class Tests {


    @Test
    public  void test() {
      int[] arr = {10,1,2,7,6,1,5};
      int[] height = {4,2,0,3,2,5};
        List<Integer> lists = new ArrayList<>();

        for (int i: arr
             ) {

        }


        Arrays.sort(height);

        //List<List<Integer>> lists = combinationSum2(arr, 8)
        multiply("2", "3");

        StringBuffer stringBuffer = new StringBuffer();
    }








    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> arrList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);
        backtrace(candidates, target, arrList, list, 0);
        return arrList;
    }

    public void backtrace(int[] candidates, int target, List<List<Integer>> arrList, List<Integer> list, int index){
        if(index >= candidates.length) return;
        if(target < 0) return;

        if(target == 0){
            arrList.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(candidates[i] > target) break;
            if(i > index && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            backtrace(candidates, target - candidates[i], arrList, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public int trap(int[] height) {
        int len = height.length;
        if(len <= 2) return 0;
        int res = 0;
        int l = 0 , r = len - 1;
        int lmax = 0, rmax = 0;
        while(l < r){
            if(height[l] <= height[r]){
                if(height[l] >= lmax){
                    lmax = height[l];
                }else{
                    res += lmax - height[l];
                }
                l++;
            }else{
                if(height[r] >= rmax){
                    rmax = height[r];
                }else{
                    res += rmax - height[r];
                }
                r--;
            }
        }
        return res;

    }

    public int trap1(int[] height){
        int ans = 0;
        if(height.length < 3)return 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        for(int i = 1; i < height.length - 1; i ++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        for(int i = len - 2; i >=0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        for(int i = 1; i < len - 1; i++){
            int min = Math.min(leftMax[i], rightMax[i]);
            if(min > height[i]){
                ans += min - height[i];
            }
        }
        return ans;

    }

    int trap2(int[] height){
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        int i = 0;
        while (i < height.length){
            while(!st.isEmpty() && height[st.peek()] < height[i]){
                int top = st.pop();
                if(st.isEmpty()) break;
                int wide = i - st.peek() - 1;
                int trapHeight = Math.min(height[i], height[st.peek()]) - height[top];
                ans += wide * trapHeight;
            }
            st.push(i++);
        }
        return ans;
    }

    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];

        for(int i = len1 - 1; i >= 0 ; i--){
            for(int j = len2 - 1; j >= 0; j--){
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                sum += res[i + j + 1];
                res[i + j + 1] = sum /10;
                res[i + j] = sum % 10;

            }
        }

        StringBuilder sb = new StringBuilder("");
        boolean flag = false;
        for(int i = 0; i < res.length; i++){
            if(res[i] == 0 && !flag)continue;
            flag = true;
            sb.append(res[i]);
        }

        return sb.toString();
    }


}
