import org.junit.Test;

import java.util.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/18 18:41
 * @description：
 */

public class Main {

    @Test
    public void test(){
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
//        longString("abcabcbb");
        maximalSquare(matrix);
    }


    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int area = 0;
        int[][] nums = new int[row][col + 1];

        for(int i = 0; i < row; i++){
            for(int j = 1; j < col + 1; j++){
                if(matrix[i][j - 1] == '1'){
                    nums[i][j] = nums[i][j - 1] + 1;
                }else{
                    nums[i][j] = 0;
                }
            }
        }

        for(int i = row - 1; i >= 0; i--){
            for(int j = col; j > 0; j--){
                if(nums[i][j] == 0)continue;

                int len = nums[i][j];
                for(int k = i; k >= 0; k--){
                    len = Math.min(len, nums[k][j]);
                    int width = i - k + 1;
                    int squareLen = Math.min(width, len);
                    area = Math.max(area, squareLen * squareLen);
                }
            }
        }

        return area;
    }

    public List<String> longString(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        char[] arr = str.toCharArray();
        int maxLen = 0;
        int start = 0;
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            index = start;
            if(map.containsKey(arr[i])){
                start = Math.max(start, map.get(arr[i]));
            }
            String substring = str.substring(index, i);
            if(i + 1 - start > maxLen){
                maxLen = i + 1 - start;
                res.clear();
                res.add(substring);
            }else if(i + 1 - start == maxLen){
                if(!res.contains(substring)){
                    res.add(substring);
                }
            }

            map.put(arr[i], i + 1);
        }
        return res;

    }
}
