import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/17 17:13
 * @description：
 */

public class MapTest {

    @Test
    public void test(){
        HashMap<String, Integer> map = new HashMap();
        map.put("aa", 12);
        map.put("bb", 22);
        map.put("aa", 33);

        System.out.println("a : " +  map.put("cc", 33));

        for(Map.Entry<String, Integer> o : map.entrySet()){
            System.out.println(o.getKey() + "   " + o.getValue());
        }
    }
}
