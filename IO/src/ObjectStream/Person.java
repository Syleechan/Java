package ObjectStream;

import java.io.Serializable;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/19 21:01
 * @description：
 */

public class Person implements Serializable {

    //标识接口Serializable
    public static final long serialVersionUID = -12346273929L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
