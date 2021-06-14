package StreamAPITest;

import Lamda.Person;
import Lamda.PersonData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/24 15:27
 * @description：
 */

public class StreamTest2 {
    @Test
    public void test1(){
        List<Person> people = PersonData.getPerson();

        //全匹配：是否所有数据都符合，符合返回true
        boolean allMatch = people.stream().allMatch(e -> e.getAge() > 30);

        //任意匹配：只要一个符合就返回true
        boolean anyMatch = people.stream().anyMatch(e -> e.getAge() > 30);

    }

    //规约
    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
