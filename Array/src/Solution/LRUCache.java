package Solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/11 13:37
 * @description：
 */

public class LRUCache {

    private int capacity;
    private HashMap<Integer, Integer> map;
    private List<Integer> list;
    private int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        System.out.println("null");
    }



    public int get(int key) {
        int value = map.getOrDefault(key, -1);
        System.out.println(value);
        if(value == -1)return value;

        int index = list.indexOf(key);//找下标
        list.remove(index);//移除
        list.add(key);//放到list末尾

        return value;
    }

    public void put(int key, int value) {
        size++;
        if(size > capacity){
            if(list.contains(key)){
                int idx = list.indexOf(key);
                list.remove(idx);
                list.add(key);
                map.put(key, value);
                System.out.println("null");
                return;
            }else{
                int idx1 = list.get(0);
                list.remove(0);
                map.remove(idx1);
                map.put(key, value);
                list.add(key);
                System.out.println("null");
                return;

            }
        }
        map.put(key, value);
        if(list.contains(key)){
            int index = list.indexOf(key);
            list.remove(index);
            list.add(key);
        }else{
            list.add(key);
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        LRUCache lru = new LRUCache(10);
        lru.put(10, 13);
        lru.put(3, 17);
        lru.put(6, 11);
        lru.put(10, 5);
        lru.put(9, 10);
        lru.get(13);
        lru.put(2,19);
        lru.get(2);
        lru.get(3);
        lru.put(5,25);

        lru.get(8);
        lru.put(9,22);
        lru.put(5,5);
        lru.put(1,30);
        lru.get(11);
        lru.put(9,12);
        lru.get(7);
        lru.get(5);
        lru.get(8);
        lru.get(9);

        lru.put(4,30);
        lru.put(9,3);
        lru.get(9);
        lru.get(10);
        lru.get(10);
        lru.put(6,14);
        lru.put(3,1);
        lru.get(3);
        lru.put(10,11);
        lru.get(8);

        lru.put(2,14);
        lru.get(1);
        lru.get(5);
        lru.get(4);
        lru.put(11,4);
        lru.put(12,24);

    }

    @Test
    public  void test(){


    }
}
