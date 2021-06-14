package tree;

/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/27 20:30
 * @description：
 */

public class Test {
    public static void main(String[] args) {

        char[] pre = {'A','B','E', 'K','L','F','D','H','J'};
        char[] mid = {'K','E','L', 'B','F','A','H','D','J'};

        BinaryTree.Node node = BinaryTree.create(pre, mid);

        /*
        BinaryTree.preTraverse(node);
        System.out.println();
        BinaryTree.midTraverse(node);
        System.out.println();
        BinaryTree.postTraverse(node);

         */
        BinaryTree.BFS(node);

    }
}
