import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/6/15 15:04
 * @description：
 */

public class HeapSort {


    @Test
    public void test(){
        int[] arr = {1, 7, 9, 6, 4, 2};
        heapsort(arr);
    }

    public void heapsort(int[] arr){
        int len = arr.length;
        for(int i = (len - 1) / 2; i >= 0; i--){
            adjust(arr, i, len);
        }

        for(int i = len - 1; i > 0; i--){
            swap(arr, i, 0);
            adjust(arr, 0, i);
        }

        System.out.println(Arrays.toString(arr));
    }




    public void adjust(int[] arr, int parent, int len){
        int left = 2 * parent + 1;
        int t = arr[parent];
        while(left < len){
            if(left + 1 < len && arr[left] < arr[left + 1])left++;
            if(t >= arr[left])break;

            arr[parent] = arr[left];
            parent = left;
            left = 2 * left + 1;
        }
        arr[parent] = t;

    }


    public void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
