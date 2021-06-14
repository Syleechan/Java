package DicTrie;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/6/2 16:47
 * @description：
 */

public class Shuffler {

    @Test
    public void test(){
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = i + 1;
        }
        int[] shuffler = shuffler(a);
        System.out.println(Arrays.toString(shuffler));

    }

    public int[] shuffler(int[] a){
        Random rd = new Random();
        for(int i = a.length - 1; i >= 0; i--){
            int j = rd.nextInt(i + 1);//左闭右开
            swap(a, i, j);
        }
        return a;
    }

    public void swap(int[] a, int i, int j ){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
