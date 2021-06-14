package com.test;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：LeeChan
 * @date ：Created in 2020/11/10 21:28
 * @description：
 */

public class Main{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.addAll(1,list);
        System.out.println(list1);

        String allTypes = Arrays.stream(Type.values()).map(Type->Type.toString()).collect(Collectors.joining("  "));
        //map(Type->Type.name())
        //map(Type::name)
        //两者等同
        System.out.println("allTypes are : " + allTypes);

        String str = "cnm";

        System.out.println(MessageFormat.format("必须为{0}中的一种{1}", allTypes,str));



    }

    public enum Type{
        Just,
        Single,
        Csv,
        Jdbc
    }
}
