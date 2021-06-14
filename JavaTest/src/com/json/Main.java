package com.json;

import jdk.nashorn.internal.parser.JSONParser;

/**
 * @author ：LeeChan
 * @date ：Created in 2020/11/23 11:02
 * @description：
 */

public class Main {
    public static void main(String[] args) {
        String text = "{}";
        JSONParser jsonParser = null;
        Object obj = jsonParser.parse().equals(text);




    }
}
