import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/26 20:58
 * @description：
 */

public class DiffWaysToCompute241 {

    @Test
    public void test(){
         res= dfs("2*3-4*5");
        System.out.println(res.toString());

        List<Integer> list = new ArrayList<>();

    }

    HashMap<String, List<Integer>> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (input.length() == 0) {
            return new ArrayList<>();
        }
        //如果已经有当前解了，直接返回
        if(map.containsKey(input)){
            return map.get(input);
        }
        List<Integer> result = new ArrayList<>();
        int num = 0;
        int index = 0;
        while (index < input.length() && !judgeOperator(input.charAt(index))) {
            num = num * 10 + input.charAt(index) - '0';
            index++;
        }
        if (index == input.length()) {
            result.add(num);
            //存到 map
            map.put(input, result);
            return result;
        }
        for (int i = 0; i < input.length(); i++) {
            if (judgeOperator(input.charAt(i))) {
                List<Integer> result1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> result2 = diffWaysToCompute(input.substring(i + 1));
                for (int j = 0; j < result1.size(); j++) {
                    for (int k = 0; k < result2.size(); k++) {
                        char op = input.charAt(i);
                        result.add(calculate(result1.get(j), op, result2.get(k)));
                    }
                }
            }
        }
        //存到 map
        map.put(input, result);
        return result;
    }



    public List<Integer> dfs(String expression){
        if(expression.length() == 0)return new ArrayList<>();

        if(map.containsKey(expression))return map.get(expression);

        int index = 0, num = 0;
        while(index < expression.length() && !judgeOperator(expression.charAt(index))){
            num = num * 10 + expression.charAt(index++) - '0';
        }
        List<Integer> res = new ArrayList<>();

        if(index == expression.length()){
            res.add(num);
            map.put(expression, res);
            return res;
        }

        for(int i = 0; i < expression.length(); i++){
            char op = expression.charAt(i);
            if(judgeOperator(op)){
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                List<Integer> leftPart = dfs(left);
                List<Integer> rightPart = dfs(right);
                for(int a : leftPart){
                    for(int b : rightPart){
                        res.add(calculate(a, op, b));
                    }
                }
            }

        }
        map.put(expression, res);
        return res;
    }


    public int calculate(int a, char op, int b){
        switch(op){
            case '*' : return a * b;
            case '+' : return a + b;
            case '-' : return a - b;
        }
        return -1;
    }




    public boolean judgeOperator(char c){
        return c == '*' || c == '+' || c == '-';
    }








}
