import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/17 19:31
 * @description：
 */

public class GenericTest {
    @Test
    public void test(){
        TreeSet<Student> ts = new TreeSet<>();

        ts.add(new Student("pp", 20 , 10));
        ts.add(new Student("ee", 20 , 10));
        ts.add(new Student("gg", 20 , 10));
        ts.add(new Student("aa", 20 , 10));

        Iterator<Student> it = ts.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
