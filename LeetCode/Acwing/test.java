import org.junit.Test;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/7/4 18:42
 * @description：
 */

public class test {

    @Test
    public void test(){
        String[] strs = {"021", "312", "0000", "101", "111000", "1", "221"};
        for(String s : strs){
            System.out.println(func(s));
        }
    }

    public String func(String s){
        char[] dic = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int pre = 0, cur;
        for(int i = 0; i < s.length(); i++){
            cur = dic[i] - '0';
            if(pre == cur){
                sb.append(dic[i]);
            }else if(pre > cur){
                addRight(sb, pre - cur);
                sb.append(dic[i]);
            }else{
                addLeft(sb, cur - pre);
                sb.append(dic[i]);
            }
            pre = cur;
        }
        if(pre != 0)addRight(sb, pre);
        return sb.toString();
    }

    public void addLeft(StringBuilder sb, int k){
        while(k-- > 0)sb.append('(');
    }

    public void addRight(StringBuilder sb, int k){
        while(k-- > 0)sb.append(')');
    }

















}
