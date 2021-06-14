package Solution;

import org.junit.Test;
import java.util.HashSet;


/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/14 10:54
 * @description：
 */

public class QuickSelect {
    @Test
    public  void test() {
        int[] arr = {3,2,1,5,6,4};
        int len = arr.length;
        System.out.println(findTopK(arr, 2, 0, len - 1));

        HashSet<String> set = new HashSet<>();


    }

    public int quickSort(int[] arr, int left, int right){
        int partitionPivot = arr[left];

        while(left < right){
            while(left < right && arr[right] >= partitionPivot){
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= partitionPivot){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = partitionPivot;
        return left;
    }

    public int quickSelect(int[] arr, int k, int left, int right){
        int pivot = quickSort(arr, left, right);
        if(pivot - left + 1 == k){
            return arr[pivot];
        }else if(pivot - left + 1 > k){//k大在左半区
            return quickSelect(arr, k, left, pivot - 1);
        }else{//k大在右半区
            return  quickSelect(arr, k - (pivot - left + 1), pivot + 1, right);
        }
    }

    public int findTopK(int[] arr, int k, int left, int right){
        return  quickSelect(arr, k, left, right);
    }
}
