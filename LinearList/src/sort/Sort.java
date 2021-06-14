package sort;

/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/29 21:44
 * @description：
 */

public class Sort {

    public static void mergeSort(int[] target){

        mergeSort(target, 0 ,target.length - 1);
    }

    private static void mergeSort(int[] target, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;

            mergeSort(target, start, mid);

            mergeSort(target, mid + 1, end);

            merge(target, start, mid , end);
        }
    }

    private static void merge(int[] target, int start, int mid, int end) {
        int lStart = start;

        int rStart = mid + 1;

        int[] tmp = new int[end - start + 1];
        int tmpStart = 0;

        //两两比较
        while(lStart <= mid && rStart <= end){
            if(target[lStart] < target[rStart]){
                tmp[tmpStart++] = target[lStart++];
            }else{
                tmp[tmpStart++] = target[rStart++];
            }
        }

        //两个分表 长度不一 剩下的是有序没有归并的直接复制到tmp里
        while(lStart <= mid){
            tmp[tmpStart++] = target[lStart++];
        }

        while(rStart <= end){
            tmp[tmpStart++] = target[rStart++];
        }

        //排好序赋值回原数组
        //arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length);
        for(int i = 0; i < tmp.length; ++i){
            target[start + i] = tmp[i];
        }
    }
}
