import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/29 15:26
 * @description：
 */

public class Solution786 {

    HashMap<Double, int[]> map = new HashMap<>();

    @Test
    public void test(){
        int[] arr = {1, 2, 3, 5};
        int k = 3;
        int[] ans = kthSmallestPrimeFraction(arr, k);
        System.out.println(Arrays.toString(ans));

    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        //分数总共有 n * (n - 1) / 2种
        //堆排(nlohk)或者 快速选择排序（逼近klogk）
        int len = arr.length;
        int total = (len - 1) * len / 2;
        double[] score = new double[total];
        int index = 0;
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len; j++){
                double temp = (double)arr[i] / (double)arr[j];
                map.put(temp, new int[]{arr[i], arr[j]});
                score[index++] = temp;
            }
        }

        double ans = quickSelect(score, k, 0, total - 1);
        return map.get(ans);


    }

    public int quickSort(double[] arr, int left, int right){
        double temp = arr[left];
        while(left < right){
            while(left < right && arr[right] >= temp){
                right--;
            }
            arr[left] = arr[right];

            while(left < right && arr[left] <= temp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }

    public double quickSelect(double[] arr, int k, int left, int right){
        int index = quickSort(arr, left, right);
        if(index - left + 1 == k){
            return arr[index];
        }else if(index - left + 1 > k){//第k小在左半区
            return quickSelect(arr, k, left, index - 1);
        }else{//第k小在右半区
            return quickSelect(arr, k - (index - left + 1), index + 1, right);
        }
    }
}
