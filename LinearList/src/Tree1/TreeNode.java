package Tree1;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/3/27 22:35
 * @description：
 */

public class TreeNode {

    private int val;
    protected TreeNode left;
    protected TreeNode right;
    TreeNode(){};

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
