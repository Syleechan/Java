import org.junit.Test;

import java.util.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/30 17:48
 * @description：
 */

public class Solution3 {
    private List<String> res = new ArrayList<>();
    int maxLen = 0;
    HashSet<String> set = new HashSet<>();
    HashMap<String, String> mem = new HashMap<>();
    @Test
    public void test(){
        String s = "aabaab!bb";
        dfs(s, 0);

        System.out.println(res.toString());
        PriorityQueue<String> res = new PriorityQueue<>(1, (o1, o2) -> {
            return ((o1 + o2).compareTo(o2 + o1));
        });

    }

    public void dfs(String s, int index){
        if(s.length() == 0)return;
        String[] objects =(String[]) res.toArray();


        for (int i = index; i < s.length(); i++){
            String str = s.substring(index, i + 1);
            if(str.length() < maxLen)continue;

            if(judge(str) && !set.contains(str)){
                if(str.length() > maxLen){
                    maxLen = str.length();
                    res.clear();
                }
                set.add(str);
                res.add(str);
                dfs(s, index + 1);
            }

        }

    }

    public boolean judge(String s){
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return  set.size() == s.length();
    }
}
