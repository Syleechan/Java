import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/28 15:22
 * @description：
 */

public class DisjoinSet {
    static final int N = 6;

    public int find(int x, int[] parent, int[] rank){
        if(parent[x] != -1){
            x = find(parent[x], parent, rank);
        }
        return x;
    }

    public boolean union(int x, int y, int[] parent, int[] rank){
        int x_root = find(x, parent, rank);
        int y_root = find(y, parent, rank);
//        if(x_root == y_root)
        if(x_root == y_root)return  false;
        if(rank[x_root] < rank[y_root]){
            parent[x_root] = y_root;
        }else if(rank[x_root] > rank[y_root]){
            parent[y_root] = x_root;
        }else{
            parent[x_root] = y_root;
            rank[y_root]++;
        }
        return true;
    }

    @Test
    public void test(){
        int[] parent = new int[N];
        int[] rank = new  int[N];
        Arrays.fill(rank, 1);
        Arrays.fill(parent, -1);
        int[][] matrix = {{0, 1}, {1, 2}, {1, 3}, {2, 5}, {3, 4}, {2, 4}};
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {2, 5}, {3, 4}};
//        for(int i = 0; i < N; i++){
//            int x = matrix[i][0];
//            int y = matrix[i][1];
//            if(!union(x, y, parent)){
//                System.out.println("Cycle existed!");
//                break;
//            }
//        }

        for(int i = 0; i < N - 1; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            if(!union(x, y, parent, rank)) {
                System.out.println("Cycle existed!");
            }
        }
        System.out.println("UnCycle");

    }
}
