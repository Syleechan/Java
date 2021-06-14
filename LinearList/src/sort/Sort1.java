package sort;

import java.util.Arrays;
import java.lang.Byte;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/6 15:24
 * @description：
 */

public class Sort1 {

    public static void main(String[] args) {
        byte[] a = new byte[]{23,30,127,60,11,1,-20};
        countingSort(a,0,a.length - 1);
        System.out.println(Arrays.toString(a));
    }





    /** The number of distinct byte values. */
    private static final int NUM_BYTE_VALUES = 1 << 8;
    /**
     *
     * 对待排序数组a中的[left, end部分进行排序]
     * 比如要对整个数组排序就是countingSort(a, 0, a.length - 1)
     * @param a    待排序的数组
     * @param left  待排序数组中，待排序部分的左边界
     * @param right 待排序数组中，待排序部分的右边界
     */
    public static void countingSort(byte[] a, int left, int right) {
        int[] count = new int[NUM_BYTE_VALUES];

        for (int i = left - 1; ++i <= right;
             count[a[i] - Byte.MIN_VALUE]++){
            System.out.println(a[i] - Byte.MIN_VALUE);
        }
        //byte取值 -128 ~ 127 ，先减去一个min_value 筛选后再加上 min_value
        //从NUM_BYTE_VALUE这一步设为256开始就准备用筛选进行排序
        for (int i = NUM_BYTE_VALUES, k = right + 1; k > left; ) {
            //将计数为0的过滤掉，从大到小过滤，妙啊！
            while (count[--i] == 0);//过滤掉之前数组值在count里转换后count值为1的下标
            byte value = (byte) (i + Byte.MIN_VALUE);//255   +  -128，数组里的不会进行操作
            int s = count[i];//count为1

            do {//先进入循环
                //将最大值从数组末尾开始赋值就完成了排序
                a[--k] = value;
            } while (--s > 0);
        }
    }
}
