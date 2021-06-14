package StreamAPITest;

import Lamda.Person;
import Lamda.PersonData;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/24 14:24
 * @description：
 */

public class StreamAPITest {

    @Test
    public void test1(){
        List<Person> list = PersonData.getPerson();
        Stream<Integer> stream2 = Stream.of(1, 2, 3, null);

        stream2.forEach(System.out::println);

        //顺序流
        Stream<Person> stream = list.stream();
        //并行流
        Stream<Person> stream1 = list.parallelStream();

    }


    @Test
    public void test2(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }


    @Test
    public void test3(){

    }





}
