package Lamda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/24 14:19
 * @description：
 */

public class PersonData {
    public static List<Person> getPerson(){
        List<Person> list = new ArrayList<>();

        list.add(new Person("马化腾", 33));
        list.add(new Person("马云", 12));
        list.add(new Person("刘强东", 33));
        list.add(new Person("雷军", 26));
        list.add(new Person("李彦宏", 65));
        list.add(new Person("比尔盖茨", 42));
        list.add(new Person("任正非", 26));
        list.add(new Person("扎克伯格", 35));

        return list;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int size = words.length;
        int len = s.length();
        List<Integer> res = new ArrayList<>();
        if(len == 0 || size == 0) return res;

        int wordLength = words[0].length();
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        for(String str : words){
            int val = map1.getOrDefault(str, 0);
            map1.put(str, val + 1);
        }

        for(int i = 0; i < len - wordLength * size + 1; ++i){
            HashMap<String, Integer> map2 = new HashMap<String, Integer>();
            int num = 0;
            while(num < size){
                String word = s.substring(i + num * size, i + (num + 1) * size);
                if(map1.containsKey(word)){
                    int val1 = map2.getOrDefault(word, 0);
                    map2.put(word, val1 + 1);

                    if(map2.get(word) > map1.get(word)){
                        break;
                    }
                }else{
                    break;
                }
                ++num;
            }

            if(num == size){
                res.add(i);
            }
        }
        return res;
    }
}
