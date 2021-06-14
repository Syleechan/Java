package StreamAPITest;

import Lamda.Person;
import Lamda.PersonData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/24 14:32
 * @description：
 */

public class StreamTest1 {

    //筛选于切片
    @Test
    public void test1(){
        List<Person> people = PersonData.getPerson();

        //过滤出符合filter()内条件的数据
        Stream<Person> stream = people.stream();
        stream.filter(e -> e.getAge() > 30).forEach(System.out::println);

        System.out.println();

        //前面3个数据
        people.stream().limit(3).forEach(System.out::println);

        System.out.println();

        //跳过前三个
        people.stream().skip(3).forEach(System.out::println);

        System.out.println();

        people.add(new Person("扎克伯格", 35));
        people.stream().distinct().forEach(System.out::println);
    }


    @Test
    public void test2(){
        //map(Function f)接受一个函数作为参数
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        List<Person> people = PersonData.getPerson();
        people.stream().map(Person::getName).filter(name -> name.length() > 3).forEach(System.out::println);

        List<Person> list1 = people.stream().filter(name -> name.getName().length() > 3).collect(Collectors.toList());

        System.out.println("*****************");
        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println("*****************");

        Stream<Stream<Character>> rStream = list.stream().map(StreamTest1::fromStringToStream);
        rStream.forEach( s ->{
            s.forEach(System.out::println);
        });

        //flatMap接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的值存储
        Stream stream = list.stream().flatMap(StreamTest1::fromStringToStream);
        stream.forEach(System.out::println);
    }


    public static Stream fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }



    @Test
    public void test3(){
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(5);
        list1.add(6);

        list.addAll(list1);
    }

    @Test
    public void test4(){
        List<Integer> list = Arrays.asList(12, 43, 55, 8, 10, 23);
        list.stream().sorted().forEach(System.out::println);

        //抛异常，Person没有实现Comparable接口
//        List<Person> people = PersonData.getPerson();
//        people.stream().sorted().forEach(System.out::println);

        List<Person> people = PersonData.getPerson();
        people.stream().sorted(Comparator.comparingInt(Person::getAge)).forEach(System.out::println);

        System.out.println();
       // people.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);

//        people.stream().sorted((p1, p2)->Integer.compare(p1.getAge(), p2.getAge())).forEach(System.out::println);
    }
}
