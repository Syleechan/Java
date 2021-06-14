package GenericMethod;

import org.junit.Test;

import java.util.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/17 20:14
 * @description：
 */

public class MethodTest {

    //泛型方法可以声明为静态。因为泛型参数实在调用方法时确定的，并非在实例化类时确定的
    public static  <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();

        list.addAll(Arrays.asList(arr));
        return list;
    }

    public <T> List<T> list(){

        HashMap<String ,Integer> map = new HashMap<>();
        map.put("aa0",12);


        List<T> list = new ArrayList<>();
        Collection<T> values = (Collection<T>) map.values();

        //可以用addAll
        //也可以遍历依次添加
        list.addAll(values);

        return list;
                //报错
                //(List<T>) values;


    }


    @Test
    public void test(){

        Integer[] arr = new Integer[]{1,2,3,4};
        System.out.println(Arrays.toString(arr));
        List<Integer> list = copyFromArrayToList(arr);

        System.out.println(list);

    }

    @Test
    public void test1(){
        List list = list();
        System.out.println(list);


    }
}
