package Set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/16 21:30
 * @description：
 */

public class SetTest {
    @Test
    public void test(){
        Set set = new HashSet<>();

        set.add(new Student("abc",20,1));
        set.add(new Student("abc",20,1));

        System.out.println(set);
    }

}
