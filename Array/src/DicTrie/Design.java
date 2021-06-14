package DicTrie;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/23 14:31
 * @description：
 */

public class Design {
    //抢红包

    @Test
    public void test(){
        packaged1(100, 10);
    }

    public void packaged1(int money, int people){
        List<Integer> list = new ArrayList<>();
        int remain = money * 100;
        int restPeople = people;
        Random rd = new Random();

        for(int i = 0; i < people - 1; i++){
            int amount = rd.nextInt(remain / restPeople * 2) + 1;
            remain -= amount;
            restPeople--;
            list.add(amount);
        }
        list.add(remain);

        int i = 1;
        for(Integer m : list){
            System.out.println("第" + i + "个人的金额 ： " + new BigDecimal(m).divide(new BigDecimal(100)));
            i++;
        }
    }














    public void packaged(int m, int n){
        int sum = m * 100;//转换成分
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            Random random = new Random();
            int num = random.nextInt(sum - (n - i - 1)) + 1;//保证剩余的人 至少是1分
            if(i == n - 1)num = sum;
            arr[i] = num;
            sum -= num;
        }

        double[] res = new double[n];
        for(int i = 0; i < n; i++){
            res[i] = (double)arr[i] / (double) 100;
        }

        List<Double> list = new ArrayList<>();

        System.out.println(Arrays.toString(res));
        for (int i = 0; i < n; i++) {
            list.add(res[i]);
        }
        Collections.shuffle(list);
        System.out.println(list.toString());
        System.out.println(Arrays.toString(arr));
    }
}
