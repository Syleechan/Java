import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/3/17 17:23
 * @description：
 */

public class Solution {

    public static int num = 0;
    StringBuilder sb = new StringBuilder();

    @Test
    public void test1(){
//        System.out.println(numDistinct("rabbbit", "rabbit"));
        //System.out.println(numDistinct("babgbag", "bag"));

//        String s1 = "aabcc";
//        String s2 = "dbbca";
//        String s3 = "aadbbcbcac";
//        System.out.println(isInterleave(s1, s2, s3));
//
//        List<Long> res = new ArrayList<>();
//        Collections.sort(res);
//
//        Queue<Integer> queue = new LinkedList<Integer>();
//
//        Collections.reverse(res);
        String s = "()";
        System.out.println(longestValidParentheses(s));

        ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();
        Hashtable<Integer, String> map1 = new Hashtable<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        map.forEach((k, v)->{
            System.out.println(k + v);
        });
    }


    public int longestValidParentheses(String s) {
        if(s.length() <= 1)return 0;
        Deque<Integer> st = new ArrayDeque<>();
        int i = 0;
        int res = 0;
        while(!st.isEmpty() || i < s.length()){
            System.out.println(st.peek());
            //if(i == s.length())break;
            if(s.charAt(i) == '('){
                st.offer(i++);
            }else{
                st.pollLast();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    res = Math.max(i - st.peekLast() + 1, res);
                }
                i++;
            }

        }
        return res;
    }



    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.equals("")){
            if(!s1.equals("") || !s2.equals(""))
                return false;
        }
        //char[] arr1 = s1.toCharArray();
        char[] arr1 = new char[s2.length()];
        int len1 = s1.length(), len3 = s3.length();
        int i = 0, j = 0, k = 0;
        while(i < len1 || k < len3){
            if(i < len1 && s1.charAt(i) == s3.charAt(k)){
                i++;
                k++;
            }else{
                arr1[j++] = s3.charAt(k++);
            }
        }

        String temp = String.valueOf(arr1);
        return temp.equals(s2);

    }

    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len2 > len1)return 0;

        int[][] dp = new int[len2 + 1][len1 + 1];
        for(int j = 0; j < len1 + 1; j++){
            dp[0][j] = 1;
        }

        for(int i = 1; i < len2 + 1; i++){
            for(int j = 1; j < len1 + 1; j++){
                if(t.charAt(i - 1) == s.charAt(j - 1)){
                    if(i == j){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else{
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                    }
                }else
                    dp[i][j] = dp[i][j - 1];
            }
        }

        for(int i = 0; i < len2 + 1; i++){
            for(int j = 0; j < len1 + 1; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }



        return dp[len2][len1];
    }

    public void backtrace(String s, String t,int index1, int index){

        if(index == t.length()){
            num++;
            return;
        }
        for(int i = index1; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(index))continue;
            index++;
            backtrace(s, t, i + 1, index);
            index--;
        }
    }
}
