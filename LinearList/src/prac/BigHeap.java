package prac;

import sort.Heap;

import java.util.Arrays;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/5 21:54
 * @description：
 */

public class BigHeap {
    int[] arr;
    int size;



    public BigHeap(int[] arr){
        this.arr = arr;
        this.size = arr.length;
    }

    public void buildHeap(int[] arr){
        for(int i = arr.length / 2 - 1; i >= 0; --i){
            adjustHeap(arr, i ,arr.length );
        }

        for(int j = arr.length - 1; j > 0; --j){
            Heap.swap(arr,0,j);
            adjustHeap(arr,0,j);
        }
    }

    private void adjustHeap(int[] arr, int i, int last) {
        for(int j = i * 2 + 1 ; j < last; j = j * 2 + 1){
            if(j + 1 < last && arr[j] < arr[j + 1]) ++j;
            if(arr[j] > arr[i]){
                Heap.swap(arr,i,j);
            }else{
                break;
            }
        }

    }

    /*
    private void recursionAdjustHeap(int[] arr, int i, int last){
        int j = 2 * i + 1;
        if(j + 1 < last && arr[j] < arr[j + 1])++j;
        if(arr[j] > arr[i]){

            recursionAdjustHeap(arr,2 * j + 1, last);
            Heap.swap(arr, i ,j);
        }

    }
    
     */






    @Override
    public String toString(){

        return Arrays.toString(arr);
    }


    /*
    private static void adjustBigHeapNode(int[] arr, int i, int lastIndex) {

int left = 2*i+1;
if(!(left<=lastIndex))
return;

int right = left+1;
int k = left;

if(left<lastIndex){
if(arr[left]<arr[right]){
k = right;
}
}
if(arr[k] > arr[i]){
swap(arr,k,i);
adjustBigHeapNode(arr,k,lastIndex);
}
}
     */

}
