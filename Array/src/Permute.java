import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/3/14 14:59
 * @description：
 */

public class Permute {
    @Test
    public void print(){
//        int[][] nums = {{1,1,2},{1,2,1},{2,1,1}};
//        System.out.println(nums.length);
        List<List<String>> res = new ArrayList<>();
//        //System.out.println(res);
//
//        String s = "acd";
//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//
//        HashMap<String, List<String>> map = new HashMap<>();
//
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        //String str = strs[0];
//        res = groupAnagrams(strs);
//        System.out.println(res);

        StringBuilder sb = new StringBuilder();

//        System.out.println(Arrays.stream(strs).collect(Collectors.groupingBy(str ->{char[] array = str.toCharArray();
//            Arrays.sort(array);
//            return new String(array);
//        })).values());


        System.out.println(myPow(2.00000, -2147483648));

      }

    public double myPow(double x, int n) {
        if(n == 0) return 1;

        if(n < 0){
            x = 1 / x;
            n = Math.abs(n);
            if(n == Integer.MIN_VALUE) n = Integer.MAX_VALUE;
        }

        double res = 1;
        for(int i = 0; i < n; i++){
            res *= x;
            if(0 < res && res < 1 ){
                if(0 < res * 100000 && res * 100000 < 0.5)return 0.0;
                if(0.5 <= res * 100000 && res * 100000 < 1) {
                    if(i == n- 1) {
                        return 0.1;
                    }else
                        return 0.0;
                }
            }
        }



        return res;

    }



    public List<List<String>> groupAnagrams(String[] strs) {
        int size = strs.length;
        List<String> list = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            String temp = str;
            temp = sortString(temp);

            if(!map.containsKey(temp)){
                map.put(temp, new ArrayList<>(Collections.singleton(str)));
            }else{
                map.get(temp).add(str);
            }
        }


        for(String str : map.keySet()){
            res.add(map.get(str));
        }

        return res;

    }

    public  String  sortString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

}
