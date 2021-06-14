package java1;

import jdk.jfr.events.ExceptionThrownEvent;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/19 21:01
 * @description：
 */

@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInteface {



    private String name;
    public int age;
    public int id;

    public Person() {
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }


    @MyAnnotation(value = "abc")
    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private  String show(String nation){
        System.out.println("我的国籍是： " + nation);
        return nation;
    }


    public String display(String interests){
        return interests;
    }



    @Override
    public void info() throws RuntimeException {
        System.out.println("我是人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }


}
