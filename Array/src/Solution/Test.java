package Solution;

import java.util.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/17 15:26
 * @description：
 */

public class Test {
    static int i = 0;

    public int aMethod() {

        i++;
        return i;
    }


    public static void main(String args[]) {
//        Test test = new Test();
//        test.aMethod();
//        int j = test.aMethod();
//        System.out.println(j);

        Comparator<Map.Entry<Integer, Integer>> com = (o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue())) {
                return o2.getValue() - o1.getValue();
            }

            return o1.getKey() - o2.getKey();
        };

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, com);


        List<String> res = new ArrayList<>();
        res.add("A");
        res.add("B");
        res.add("C");

        int index1 = res.indexOf("A");
        int index2 = res.indexOf("B");


        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.toString());
        }
        System.out.println();
        list.clear();

        map.put(1, 40);
        map.put(5, 40);
        list = new ArrayList<>(map.entrySet());
        list.sort(com);
        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.toString());
        }
        list.clear();

        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });


    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            //@Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            p.offer(new int[]{nums[i], i});
        }

        int len = nums.length;
        int arrLen = len - k + 1;
        int[] res = new int[arrLen];
        res[0] = p.peek()[0];

        for (int i = k; i < len; i++) {
            p.offer(new int[]{nums[i], i});
            while (p.peek()[1] <= i - k) {
                p.poll();
            }
            res[i - k + 1] = p.peek()[0];
        }

        return res;

    }

}


