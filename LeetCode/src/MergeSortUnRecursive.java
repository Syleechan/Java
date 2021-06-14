import org.junit.Test;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/24 18:37
 * @description：
 */

public class MergeSortUnRecursive {

    @Test
    public void test(){
        int[] arr = new int[]{4, 9, 11, 8, 67, 3, 4, 2, 32};
        sort(arr);
        print(arr);
    }



    public void sort(int[] arr){
        int step = 2;
        int i = 0;
        int len = arr.length;

        while(step <= len){
            i = 0;
            while(i + step <= len){
                int left = i;
                int right = i + step - 1;
                int mid = (left + right) / 2;
                merge(arr, left,mid,right);
                i += step;
            }
            //剩余部分
            int left = i;
            int right = len - 1;
            int mid = (left + right) / 2;
            merge(arr, left, mid, right);
            step *= 2;

        }
    }

    public  void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int index = 0;
        int l1 = left, l2 = mid + 1;
        while(l1 <= mid && l2 <= right){
            if(arr[l1] <= arr[l2]){
                temp[index++] = arr[l1++];
            }else{
                temp[index++] = arr[l2++];
            }
        }

        while(l1 <= mid)temp[index++] = arr[l1++];
        while(l2 <= right)temp[index++] = arr[l2++];
        int j = 0;
        for(int i = left; i <= right; i++){
            arr[i] = temp[j++];
        }
    }

    public void print(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();;
    }
}
