package Solution;

import org.junit.Test;

import java.util.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/16 15:12
 * @description：
 */

public class mt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println();
        sc.nextLine();
        Deque<Integer> queue = new ArrayDeque<>();
        Queue<Integer> q = new LinkedList<>();
        new HashSet<Integer>();


    }


    @Test
    public void test(){
        System.out.println(isIsomorphic("egg", "add"));
    }
    public boolean isIsomorphic(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();

        int len = s.length();
        int[] countS = new int[26];
        int[] countT = new int[26];

        for(int i = 0; i < len; i++){
            countS[s.charAt(i) - 'a']++;
            countS[t.charAt(i) - 'a']++;
        }

        int num1 = 0, num2 = 0;
        for(int i = 0; i < 26; i++){
            if(countS[i] != 0)num1++;
            if(countT[i] != 0)num2++;
        }

        return num1 == num2;
    }
}
