import org.junit.Test;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/27 19:12
 * @description：
 */

public class SolutionMinIndex {

    @Test
    public void test(){
        int[] arr = {0,1,1,1,2,2,2,2,3,3,3,3};
        int k = 2;
        binarySearchMin(arr,k);
        binarySearchMax(arr,k);

        for(char c = '1'; c <= '9'; c++){
            System.out.println(c);
        }

        StringBuilder sb = new StringBuilder();
        sb.length();
    }

    public int binarySearchMin(int[] arr, int k){
        int begin = 0, end = arr.length - 1;
        while (begin < end){
            int mid = (begin + end) / 2;
            if(arr[mid] >= k){
                end = mid;
            }else{
                begin = mid + 1;
            }
        }
        System.out.println(begin);
        return begin;
    }

    public int binarySearchMax(int[] arr, int k){
        int begin = 0, end = arr.length - 1;
        while(begin < end){
            int mid = (begin + end) / 2;
            if(arr[mid] <= k){
                begin++;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(begin);
        return begin;

    }
}
