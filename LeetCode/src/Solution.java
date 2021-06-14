import org.junit.Test;

import java.util.HashMap;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/24 16:05
 * @description：
 */

public class Solution {

    @Test
    public void Test(){
        BinarySubstrings("1000111000011111");
    }

    //二进制字符串连续0和连续1在一起, 且各自长度相等，这样字符串的最大长度

    int BinarySubstrings(String s){
        char[] c = s.toCharArray();
        int len = c.length;
        int left = 0, right = 0;
        int leftPart = 0, rightPart = 0;
        int maxLen = 0;

        while(right < len){

            char temp = c[right];
            left = right;
            while (right < len && temp == c[right]){
                right++;
            }
            //if(right == len)return maxLen;

            rightPart = right - left;
            if(leftPart == rightPart){
                maxLen = Math.max(maxLen, leftPart + rightPart);
            }

            leftPart = rightPart;

        }
        return maxLen;
    }
}
