import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/27 15:02
 * @description：
 */

public class NextPermutation {

    @Test
    public void test(){
        getPermutation(3,3);
    }

    public String getPermutation(int n, int k) {
        int[] pos = new int[n];
        pos[0] = 1;
        for(int i = 1; i < pos.length; i++){
            pos[i] = pos[i - 1] * i;
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        k--;//下标从0开始
        for(int i = n - 1; i >= 0; i--){
            int index = k / pos[i];
            sb.append(list.get(index));
            list.remove(index);
            k -= pos[i] * index;
        }

        return sb.toString();
    }
}
