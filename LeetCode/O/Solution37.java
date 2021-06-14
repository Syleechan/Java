import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/6 18:57
 * @description：
 */

public class Solution37 {
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }



    public TreeNode deserialize(String data) {
        if(data.equals("[]"))return null;
        String[] strs = data.substring(1, data.length() - 1).split(",");
        TreeNode[] arr = new TreeNode[strs.length + 1];
        //System.arraycopy(strs, 0, arr, 1, strs.length);

        for(int i = 0; i < strs.length; i++){
            arr[i + 1] = strs[i].equals("null") ? null : new TreeNode(Integer.parseInt(strs[i]));
        }
        TreeNode root = arr[1];
//        for(int i = 1; i <= strs.length / 2; i++){
//            if(arr[i] == null)continue;
//            arr[i].left = arr[2 * i];
//            arr[i].right = arr[2 * i + 1];
//        }


        return root;

    }

    @Test
    public void test(){
         deserialize("[1,2,3,null,null,4,5]");
    }

}
