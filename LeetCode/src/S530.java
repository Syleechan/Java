import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/30 11:18
 * @description：
 */

public class S530 {

    @Test
    public void test(){
        int[] servers = {10,63,95,16,85,57,83,95,6,29,71};
        int[] tasks = {70,31,83,15,32,67,98,65,56,48,38,90,5};
        int[] res = assignTasks(servers, tasks);
        for(int num : res){
            System.out.print(num + " ");
        }
        TreeSet<Integer> set = new TreeSet<>();
        Integer[] integers = set.toArray(new Integer[set.size()]);
        List<Integer> list = new ArrayList<>(set);

//        System.out.println(assignTasks(servers, tasks).toString());
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> free = new PriorityQueue<>((o1, o2) -> (o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]));
        PriorityQueue<Pair<Integer, int[]>> wait = new PriorityQueue<>((o1, o2) -> {
            if(!o1.getKey().equals(o2.getKey()))return o1.getKey() - o2.getKey();
            int[] a = o1.getValue();
            int[] b = o2.getValue();
            return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        });
        int len = tasks.length, n = servers.length;
        for(int i = 0; i < n; i++){
            int[] a = new int[]{servers[i], i};
            free.offer(a);
        }
        int[] res = new int[len];
        int index = 0;
        int time = 0;
        for(int i = 0; i < len; i++){
            int[] temp;
            if(free.isEmpty()){
                Pair<Integer, int[]> p =  wait.peek();
                temp = p.getValue();
            }else{
                temp = free.poll();
            }
            res[index++] = temp[1];
            time = tasks[i] + i;
            wait.add(new Pair<>(tasks[i] + i, temp));
            while(!wait.isEmpty() && wait.peek().getKey() <= i + 1){
                Pair<Integer, int[]> t = wait.poll();
                free.add(t.getValue());
            }
        }
        return res;




    }
}
