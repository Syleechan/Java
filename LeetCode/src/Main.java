import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.setOut;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/25 14:58
 * @description：
 */

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
//        while((s = br.readLine()) != null){
//            System.out.println(s);
//        }
        String s1 = "123";
        System.out.println(s1.substring(3).length());
        List<String> list = new ArrayList<>();
        String join = String.join(" ", list);
        Deque<Integer> queue = new ArrayDeque<>();

        int a = 2 * 3 * 4 * 5;
        for(int i = 2; i <= 5; i++){
            System.out.println(0);
        }


         PriorityQueue<int[]> p = new PriorityQueue<>((o1, o2) -> o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1]);

    }
}
