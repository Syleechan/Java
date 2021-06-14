import org.junit.Test;

import java.util.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/7 21:49
 * @description：
 */

public class Solution45 {

    @Test
    public void test(){
        int[] arr = {3,30,34,5,9};
        minNumber(arr);
//        Arrays.sort(arr, Collections.reverseOrder());
//        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
//        Integer.compare()

        Comparator myComparator = new myComparator();


    }

    class myComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public String minNumber(int[] nums) {
        int len = nums.length;
        PriorityQueue<String> pq = new PriorityQueue<>(len, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        for(int i = 0; i < len; i++){
            pq.add(String.valueOf(nums[i]));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }

        return sb.toString();

    }
}
