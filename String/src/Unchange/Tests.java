package Unchange;

import org.junit.Test;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/3/3 15:12
 * @description：
 */

public class Tests {
    @Test
    public void test1(){
        String s1 = "abcd";
        String s2 = "abc";
        String s3 = s2 + "d";
        final String s4 = "abc";
        String s5 = s4 + "d";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s5);//true 常量 + 常量在常量池中
        s1 = "hello";
        System.out.println(s1 == s2);//false
    }

    @Test
    public void test2(){
        String str1 = "123";
//        int num = (int)str1;//错误的
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);//"123"
        String str3 = num + "";

        System.out.println(str1 == str3);//false
    }
}
