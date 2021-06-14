package tx;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/30 10:51
 * @description：
 */

public class Solution430 {
    @Test
    public void test(){
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
//        {15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}}
        reverse(matrix);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void reverse(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int begin = 0, end = n - 1;
            while(begin < end){
                swap(matrix, i,begin, end);
                begin++;
                end--;
            }
        }

        for (int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }


    public void swap(int[][] matrix, int col, int a, int b){
        int temp = matrix[a][col];
        matrix[a][col] = matrix[b][col];
        matrix[b][col] = temp;

    }


}
