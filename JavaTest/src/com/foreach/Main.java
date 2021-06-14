package com.foreach;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：LeeChan
 * @date ：Created in 2020/11/13 10:00
 * @description：
 */

public class Main {
    public  static  void  main(String []args){
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B",20);
        items.put("C",30);

        for (Map.Entry<String, Integer> entry : items.entrySet()){
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }

        items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

        items.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
            if("C".equals(k)){
                System.out.println("Hello E");
            }
        });
    }
}
