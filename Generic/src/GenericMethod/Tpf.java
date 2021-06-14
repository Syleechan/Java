package GenericMethod;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/17 20:33
 * @description：
 */

public class Tpf {

    @Test
    public void test(){
        List<?> list = null;

        list = new ArrayList<String>();
        list = new ArrayList<Double>();

        list.add(null);

        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();

        l1.add("aaa");
        l1.add("bbb");

        list = l1;

        //报错 只能添加null
        //list.add("sss");

        list.add(null);

        //但可以读取
        Object o = list.get(0);
        System.out.println(o);
    }
}
