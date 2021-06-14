import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/1 18:13
 * @description：
 */

public class SolutionByte {

    private int val = 0;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int maxLeft;
        int maxRight;

//        public void test(){
//            Field[] declaredFields = SolutionByte.class.getDeclaredFields();
//            for(Field f : declaredFields){
//                System.out.println(f);
//            }
//        }
    }

    int maxLen = 0;
    public void findMax(TreeNode root){
        if(root == null)return;

        if(root.left == null){
            root.maxLeft = 0;
        }

        if(root.right == null){
            root.maxRight = 0;
        }

        if(root.left != null){
            findMax(root.left);
        }

        if(root.right != null){
            findMax(root.right);
        }

        if (root.left != null) {
            root.maxLeft = Math.max(root.left.maxLeft, root.left.maxRight) + 1;
        }


        if(root.right != null){
            root.maxRight = Math.max(root.right.maxLeft, root.right.maxRight) + 1;
        }
        maxLen = Math.max( root.maxLeft + root.maxRight, maxLen);

    }



    public int FindMax1(TreeNode root){
        if (root == null)return 0;

        int maxLeft = FindMax1(root.left);
        int maxRight = FindMax1(root.right);

        maxLen =Math.max(maxLeft + maxRight, maxLen);

        return Math.max(maxLeft,  maxRight) + 1;


    }




}
