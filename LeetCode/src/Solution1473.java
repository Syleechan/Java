import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/4 15:38
 * @description：
 */

public class Solution1473 {


    @Test
    public void test(){
       int[] houses = {0,0,0,0,0};
       int[][] cost = {{1,10},{10,1},{10,1},{1,10},{5,1}};
       int m = 5;
       int n = 2;
       int target = 3;
       minCost(houses, cost, m, n, target);


    }

    private final int INF = 10001 * 101;//所有房子 * cost
    private int m;
    private int n;
    private int target;
    private int[] houses;
    private int[][] cost;
    private int[][][] mem;
    private int res;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.m = m;
        this.n = n;
        this.target = target;
        this.houses = houses;
        this.cost = cost;
        this.mem = new int[m + 1][n + 1][m + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                Arrays.fill(mem[i][j], -1);
            }
        }
//        int res = dfs(1, 0, 0, 0);
        this.res = INF;
        dfs1(0,0,0,0);
        int ans =  res == INF ? -1 : res;
        System.out.println(ans);
        return ans;
    }


    public void dfs1(int houseNo, int cur, int count, int sum){
        if(sum >= res || count > target)return;
        if(houseNo == m){
            if(count == target){
                res = Math.min(res, sum);
            }
            return;
        }

        int no = houses[houseNo];
        if(no == 0){
            for(int i = 1; i <= n; i++){
                int part = i == cur ? count : count + 1;
                int newCount = houseNo == 0 ? 1 : part;
                dfs1(houseNo + 1, i, newCount, sum + cost[houseNo][i - 1]);
            }
        }else{
            int part = no == cur ? count : count + 1;
            int newCount = houseNo == 0 ? 1 : part;
            dfs1(houseNo + 1, no, newCount, sum);
        }
    }





    //房间编号  颜色编号  分区数  当前花费
    public int dfs(int houseNo, int cur, int count, int money){
        if(count > target)return INF;//超过目标分区数
        if(houseNo == m + 1){
            return count == target ? 0 : INF;//到达了房间末尾，并且分区成功花费为0，否则INF
        }
        //记忆化
        if(mem[houseNo][cur][count] != -1)return mem[houseNo][cur][count];

        int no = houses[houseNo - 1];
        int res = INF;

        if(no == 0){//当前房子没有被涂色
            for(int i = 1; i <= n; i++){
                int part = cur == i ? count : count + 1;//如果当前颜色正好相同则不计分区否则加1
                int newCount = houseNo == 1 ? 1 : part;//如果是第一个房子，则cnt为1，否则为当前分区数
                int ans = dfs(houseNo + 1, i, newCount, money + cost[houseNo - 1][i - 1]);//选颜色的当前花费
                if(ans == INF)continue;
                res = Math.min(ans, money + cost[houseNo - 1][i - 1]);//选当前颜色花费最小的那个
            }
        }else{
            int part = no == cur ? count : count + 1;//与涂过的颜色相不相同
            int newCount = houseNo == 1 ? 1 : part;//再看是不是第一个房子
            int ans = dfs(houseNo + 1, no, newCount, money);//已经涂色 不需要花费
            res = Math.min(ans, res);
        }

        mem[houseNo][cur][count] = res;

        return res;
    }

//    CopyOnWriteArrayList
}
