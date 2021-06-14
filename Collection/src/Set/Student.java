package Set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/7 21:41
 * @description：
 */

public class Student implements Comparable {
    String name;
    int age;
    int id;

    public Student(String name, int age, int id){
        this.name = name;
        this.age = age;
        this.id = id;
    }

//    @Override
//    public String toString(){
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", age=" + age + '\'' +
//                ", id= " + id +
//                '}';
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }


//    @Override
//    public boolean equals(Object obj) {
//        System.out.println("equals");
//        //先判断对象 堆内存地址不同false
//        if(this == obj)
//            return true;
//        if(obj == null || this.getClass() != obj.getClass())
//            return false;
//
//        //强转为对象类型
//        Student stu = (Student) obj;
//
//        //比较对象成员 实参比较值，形参比较地址：equals
//        if(this.age != stu.age || this.id != stu.id)return false;
//
//        //都是指向常量区的str，所以相等
//        return this.name != null ? this.name.equals(stu.name) : stu.name == null;
//
//    }
//
//
//
//    //自定义定义哈希值计算方法
//    //如果不重写，则new出来的两个相同值的对象地址本来就不同，则hash值也不同，自然不会调用equals方法
//    //因此这类重写了，且确保用常量值
//    @Override
//    public int hashCode() {
//        int res = name != null ? name.hashCode() : 0;
//        //为甚恶魔用31，只占5位  i * 31 = (i << 5) -1
//        res = 31 * res + age;
//        System.out.println(res);
//        return res;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                id == student.id &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }

    //从大到小
    @Override
    public int compareTo(Object o){
        if(o instanceof Student){
            int com =  ((Student) o).age - age;
            if(com != 0){
                return com;
            }else{
                return ((Student) o).name.compareTo(name);
            }
        }else {
            throw new RuntimeException("类型不匹配");
        }

    }
}


