import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/3/15 10:35
 * @description：
 */

public class NQueue {

    @Test
    public void test(){
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);
    }


    public List<List<String>> solveNQueens(int n){
        List<List<String>> res = new ArrayList<>();
        char[][] queue = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                queue[i][j] = '.';
            }
        }

        backtrace(queue,n,0,res);
        return res;

    }


    public void backtrace(char[][] queue, int n, int row, List<List<String>> res){
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                list.add(String.valueOf(queue[i]));
            }
            res.add(list);
            return;
        }

        if(row > n)return;

        for(int i = 0; i < n; i++){
            boolean flag = judge(queue, row, i, n);
            if(!flag)continue;
            queue[row][i] = 'Q';
            backtrace(queue, n, row + 1, res);
            queue[row][i] = '.';
        }

    }

    public boolean judge(char[][] queue, int row, int col, int n){
        for(int i = 0; i <= row; i++){
            for(int j = 0; j < n ; j++){
                if(queue[i][j] == 'Q' && (col == j || Math.abs(col - j) == Math.abs(row - i) || row == i) )
                    return false;
            }
        }
        return true;
    }


}
