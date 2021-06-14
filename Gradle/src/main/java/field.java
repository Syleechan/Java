import com.sun.javafx.beans.IDProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/10 10:55
 * @description：
 */


public class field {



    public static void main(String []args) throws NoSuchFieldException {
        Field fields = Student.class.getDeclaredField("id");
        Annotation[] ss = fields.getAnnotations();
        System.out.println(ss[0]);
    }





    class Student{
        int id;
        String name;
        String sex;

        public void setId(int id){this.id = id;}
        public int getId(){return id;}
    }

}
