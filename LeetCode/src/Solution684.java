import org.junit.Test;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/28 21:57
 * @description：
 */

public class Solution684 {
    @Test
    public void test(){
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(findRedundantConnection(edges));
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind f = new UnionFind(n);
        for(int i = 0; i < n; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            if(!f.union(x, y))return edges[i];
        }

        return new int[]{-1, -1};
    }

    class UnionFind{
        int[] parent;
        int[] rank;
        public UnionFind(int n){
            parent = new int[n + 1];
            rank = new int[n + 1];
            for(int i = 1; i < n + 1; i++){
                parent[i] = -1;
                rank[i] = 1;
            }
        }

        public boolean union(int x , int y){
            int x_root = find(x);
            int y_root = find(y);
            if(x_root == y_root)return false;
            if(rank[x_root] > rank[y_root]){
                parent[y_root] = x_root;
            }else if(rank[x_root] < rank[y_root]){
                parent[x_root] = y_root;
            }else{
                parent[x_root] = y_root;
                rank[y_root]++;
            }
            return true;
        }

        public int find(int x){
            if(parent[x] == -1)return x;
            while(parent[x] != -1){
                parent[x] = parent[parent[x]];
            }
            return x;
        }
    }
}
