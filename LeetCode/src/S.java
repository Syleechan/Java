import org.junit.Test;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/29 23:21
 * @description：
 */

public class S {
    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder();
        if(n.charAt(0) == '-'){
            int index = binaryserach2(n.toCharArray(), 1, n.length() - 1, x);
            sb.append(n.substring(0, index)).append(x).append(n.substring(index));
        }else{
            int index = binaryserach1(n.toCharArray(), 0, n.length() - 1, x);
            sb.append(n.substring(0, index)).append(x).append(n.substring(index));
        }
        return sb.toString();
    }

    public int binaryserach1(char[] dic, int left, int right, int x){
        while(left <= right){
            int a = dic[left] - '0';
            if(x <= a){
                left++;
            }else{
                break;
            }
        }
        return left;
    }

    public int binaryserach2(char[] dic, int left, int right, int x){
        while(left <= right){
            int a = dic[left] - '0';
            if(x > a){
                left++;
            }else{
                break;
            }
        }
        return left;
    }

    @Test
    public void test(){
        int[] a = {1, 2};
        int[] b = {2, 3};
//        System.out.println(minimumXORSum(a, b));
    }
}
