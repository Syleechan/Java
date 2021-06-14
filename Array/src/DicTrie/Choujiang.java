package DicTrie;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/6/2 16:32
 * @description：
 */


// 60万人，抽10万， 但只能选65535
//伪分桶, 分成6
public class Choujiang {
    //1 - 60000
    //60001 - 120000
    //。。。
    // 540001 - 600000

    @Test
    public void test(){
        List<Integer> res = func();
        for(int i : res){
            System.out.print(i + " ");
        }
    }

    public List<Integer> func(){
        HashSet<Integer> set = new HashSet<>();
        Random rd = new Random();
        while(set.size() != 100000){

            int people = rd.nextInt(60000) + 1;
            int bucket = rd.nextInt(10);
            int num = bucket * 60000 + people;
            set.add(num);
        }
        List<Integer> res = new ArrayList<>(set);
        return res;
    }

}
