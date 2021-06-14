import org.junit.Test;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/28 17:26
 * @description：
 */

public class Solution273 {
    private final String[] Thousand = {"", "Thousand", "Million", "Billion"};
    private final String[] Hundred = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};//10是ten
    private final String[] LessThanTwenty = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    @Test
    public void test(){
        numberToWords(1234567891);
    }



    public String numberToWords(int num) {
        if(num <= 19) return LessThanTwenty[num];

        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            if(num % 1000 != 0){
                StringBuilder temp = new StringBuilder();
                helper(temp, num % 1000);
                sb.insert(0, temp.append(Thousand[index]).append(" "));
            }
            index++;
            num /= 1000;
        }
        return sb.toString();
    }

    public void helper(StringBuilder temp, int num){
        if(num == 0)return;

        if(num < 20){
            temp.append(LessThanTwenty[num]).append(" ");

        }else if(num < 100){
            temp.append(Hundred[num / 10]).append(" ");
            helper(temp, num % 10);

        }else if(num < 1000){
            temp.append(LessThanTwenty[num / 100]).append(" ").append("Hundred").append(" ");
            helper(temp, num % 100);

        }

    }
}
