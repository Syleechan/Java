package com.practice;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(list);
        LinkedList<Integer> list1 = new LinkedList<>(insertSortForLinkedList(list));
        System.out.println(list1);

    }

    public static LinkedList<Integer> insertSortForLinkedList(LinkedList<Integer> list){
        int len = list.size();
        for(int i = 1; i < len; ++i){
            int j = i - 1;
            int temp = list.get(i);
            list.remove(i);
            while (j >= 0 && temp < list.get(j)){
                j--;
            }
            list.add(j+1,temp);
        }
        return list;
    }
}
