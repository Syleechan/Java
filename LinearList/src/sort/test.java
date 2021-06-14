package sort;

import prac.BigHeap;

import java.util.Arrays;
import java.util.Random;

import static sort.Sort.mergeSort;

/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/30 10:16
 * @description：
 */

public class test {
    public static void main(String[] args) {
        /*
        int[] arr = new int [10];
        arr = inflate(10);
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

         */

        int[] arr = new int[]{20,100,30,50,200,88,72,12,33,15};
        //Heap heap = new Heap(arr);
        //heap.doHeap();
        BigHeap bigHeap = new BigHeap(arr);
        bigHeap.buildHeap(arr);
        System.out.println(bigHeap.toString());


    }

    public static int[] inflate(int size) {
        Random random = new Random();

        int[] num = new int[size];

        for (int i = 0; i < size; i++) {
             num[i] = random.nextInt(1000);
        }
        return num;
    }
}
