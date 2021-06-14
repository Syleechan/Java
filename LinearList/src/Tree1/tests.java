package Tree1;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/3/27 22:37
 * @description：
 */

public class tests {

    @Test
    public void test(){
        generateTrees(3).forEach(s -> System.out.println(s.toString()));
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        //只有一个数字，当前数字作为一棵树加入结果中
        if (start == end) {
            TreeNode tree = new TreeNode(start);
            allTrees.add(tree);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            System.out.println("i = " + i);
            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                String lefts = left == null ? "l" : left.toString();
                System.out.println(lefts);
                for (TreeNode right : rightTrees) {
                    String rights = right == null ?  "r" : right.toString();
                    System.out.println(rights);
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                    System.out.println(currTree.toString());
                }
            }
            System.out.println("------------------");
        }
        return allTrees;
    }

}
