import org.junit.Test;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/28 21:35
 * @description：
 */

public class Solution765 {

    @Test
    public void test(){
        int[] row = {0, 2, 3, 5, 1, 4};
        System.out.println(minSwapsCouples(row));
    }

    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int n = len / 2;
        UnionFind f = new UnionFind(n);
        for(int i = 0; i < len; i += 2){
            f.union(row[i] / 2, row[i + 1] / 2);
        }
        return n - f.count;
    }

    class UnionFind{
        int[] parent;
        int count;
        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
            count = n;
        }

        public void union(int x, int y){
            int x_root = find(x);
            int y_root = find(y);
            if(x_root == y_root)return;
            parent[x_root] = y_root;
            count--;
        }

        public int find(int x){
//            if(x == parent[x])return x;
//            //路径压缩
//            while(x != parent[x]){
//                parent[x] = parent[parent[x]];
//                x = parent[x];
//            }
            return x == parent[x] ? x : find(parent[x]);
        }
    }
}
