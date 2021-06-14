package com.keyset;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ：LeeChan
 * @date ：Created in 2020/11/17 16:09
 * @description：
 */

public class Main {

    public static void main(String []args){
        Map<String, String> map = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map1.put("5","e");
        map.putAll(map1);
        map.forEach((k,v)-> System.out.println("k : " + k + " v : " +v));

        map.remove("5","e");


        System.out.println("keySet convert to Stream to collect:  " + map.keySet().stream().map(k-> k + " is " + map.get(k)).collect(Collectors.joining(" and ")));// keySet -- Set<String>
        //成为键值对集合set    entrySet -- Set<Entry<String, String>>
        System.out.println("直接打印 entrySet: " + map.entrySet());
        //成为key集合
        System.out.println("直接打印 keySet: " + map.keySet());

        //entrySet foreach遍历成为键值对集合set,默认对key进行操作
        map.entrySet().forEach(e-> System.out.println("k : " + e.getKey() + " v : " + e.getValue()));
        //keySet  foreach遍历关键值key
        map.keySet().forEach(k-> System.out.println("2 : " + k.indexOf("2") ));

        //getOrDefault用法
        System.out.println(map.getOrDefault("6","xxx"));//map里有对应value就get,否则输出default value

        for(Map.Entry<String, String> k :map.entrySet()){
            System.out.println(k.getKey() + "  " + k.getValue() + " HashCode: " + k.hashCode() );
        }

        System.out.println("KeySet遍历map : ");
        //KeySet遍历map
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            Object k = it.next();
            Object v = map.get(k);

            System.out.println("k : " + k + " v : " + v);
        }

        System.out.println("EntrySet遍历map : ");
        //EntrySet遍历map
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry e = (Map.Entry) iter.next();
            Object k = e.getKey();
            Object v = e.getValue();

            System.out.println("k : " + k + " v : " + v);
        }


        //String sql = map.keySet().stream().map(k-> k + " is " + String.valueOf(map.get(k))).collect(Collectors.joining(" and "));
        //字符串格式化用法
        //将会变化的一些值通过变量赋值，用String.format将其拼接成完整的字符串，方便后续修改
        //System.out.println(String.format("SELECT * FROM %s WHERE %s", "tableName", sql));

        //key如果不存在，新建键值对 k=msg,如果存在执行v.method操作，可以替换，追加。。。
        System.out.println(map.compute("1",(k,v)->(v == null) ? "msg" : v.replace(v,"msg")));




    }

}
