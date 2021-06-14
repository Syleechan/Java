import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/28 15:36
 * @description：
 */

public class Solution149 {

    @Test
    public void test(){
        int[][] points = {{1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4}};
        System.out.println(maxPoints(points));

        StringBuilder sb = new StringBuilder();
    }

    public int maxPoints(int[][] points){

//        Arrays.sort(points, (o1, o2) -> {
//            if(o1[0] != o2[0])return o1[0] - o2[0];
//            return o1[1] - o2[1];
//        });
        double min = Double.MIN_EXPONENT;
        int len = points.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            int[] parent = points[i];
            for(int j = 0; j < len; j++){
                if(i == j)continue;
                int[] child = points[j];
                if(child[0] == parent[0]){
                    map.put(min, map.getOrDefault(min, 0) + 1);
                    continue;
                }
                double k = (double)(parent[1] - child[1]) / (double)(parent[0] - child[0]);
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
            for(double key : map.keySet()){
                max = Math.max(max, map.get(key));
            }
        }



        return max + 1;
    }
}
