package Comparable;

import org.junit.Test;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.util.Arrays;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/16 18:56
 * @description：
 */

public class Comparable {

    @Test
    public void test1(){
        String[] str = {"AA", "BB", "CC", "DD", "KK", "MM", "GG" };
        //自然排序
        //实现了Comparable接口，重写了compareTo()，两两比较大小
        //重写compareble规则：
        //当前this大于形参对象obj，则返回正整数
        //小于 返回负整数，等于返回0
        Arrays.sort(str);

        System.out.println(Arrays.toString(str));
    }
}
//对于自定义类需要排序，则可以重写comparebleTo()方法
//