/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/7 21:41
 * @description：
 */

public class Student {
    String name;
    int age;
    int id;

    public Student(String name, int age, int id){
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString(){
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", id= " + id +
                '}';
    }

}
