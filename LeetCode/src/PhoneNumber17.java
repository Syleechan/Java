import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/25 21:27
 * @description：
 */

public class PhoneNumber17 {
    HashMap<Character, String> map = new HashMap<Character, String>(){
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    @Test
    public void test(){
        letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if(digits.length() == 0)return list;


        // //取第一个字符将map里的子字符串逐一加到list
        // String firtStr = map.get(digits.charAt(0));
        // for(int i = 0; i < firtStr.length(); ++i){
        //     list.add(firtStr.substring(i, i + 1));
        // }

        // //逐个合并并更新list
        // for(int i = 1; i < digits.length(); ++i){
        //     String str = map.get(digits.charAt(i));
        //     list = addString(list, str);
        // }
        // return list;

        addString(list, digits, 0, "");
        return list;


    }

    public void addString(List<String> list, String digits, int level, String s){
        if(level == digits.length()){
            list.add(s);
            return;
        }

        for (int i = level; i < digits.length(); i++) {
            String str = map.get(digits.charAt(i));
            for(int j = 0; j < str.length(); j++){
                addString(list, digits, level + 1, s + str.charAt(j));
            }
        }


    }
}
