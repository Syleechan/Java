package sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/4 21:06
 * @description：
 */

public class Heap {
    private int[] elements;
    private int size;

    public Heap(int[] arr){
        this.size = arr.length;
        int[] tmp = new int[arr.length + 1];
        System.arraycopy(arr,0,tmp, 1, arr.length );
        elements = tmp;

        //建堆

    }

    void  doHeap(){
        for (int i = size / 2; i >= 1 ; i--) {
            fixDown(i);
        }
    }


    //
    private void fixDown(int index){
        /*
        int child = 2 * index;
        //叶子节点，无左右孩子
        if(child > size){
            return;
        }

        //有左右孩子，左右孩子比较大小
        if(child + 1 <= size && elements[child] < elements[child + 1]){
            ++child;
        }

        //父节点与孩子节点的较大者进行交换
        if(elements[index] < elements[child]){
            swap(elements, index, child);
        }

         */

        for(int i = 2 * index; i <= size; i *= 2){
            if(i + 1 <= size && elements[i] < elements[i + 1]){
                ++i;
            }

            if(elements[index] < elements[i]){
                swap(elements, index, i);
                index = i;
            }else {
                break;
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }



    @Override
    public String toString(){
        return Arrays.toString(elements);
    }

}
