package tree;

import com.sun.javafx.tk.TKPulseListener;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/27 19:13
 * @description：
 */

public class BinaryTree {

    public static Node create(char[] pre, char[] mid){
        if(pre == null || mid == null){
            throw new  IllegalArgumentException("");
        }

        if (pre.length != mid.length){
            throw new IllegalArgumentException("");
        }

        return build(pre, 0, pre.length - 1, mid, 0, mid.length - 1);
    }

    private static Node build(char[] pre, int lPre, int rPre, char[] mid, int lMid, int rMid) {

        //先序第一个为中序序列的根节点 root
        char midChar = pre[lPre];

        int midIndex = getMidIndex(mid, lMid, rMid, midChar);

        if(midIndex == -1){
            throw new IllegalArgumentException("");
        }

        int lNum = midIndex - lMid;
        int rNum = rMid - midIndex;

        Node l;
        //叶节点
        if(lNum == 0){
            l = null;
        }else {
            // right - (lPre + 1) + 1 = lNum  right = lNum + lPre
            //不是叶节点继续构造左节点
            //根节点左半部分
            l = build(pre, lPre + 1, lNum + lPre, mid, lMid, midIndex - 1);
        }

        Node r;
        if(rNum == 0){
            r = null;
        }else{
            //根节点右半部分
            r = build(pre, lPre + 1 + lNum, rPre , mid, midIndex + 1, rMid);
        }

        return new Node(l,r,midChar);

    }

    //拿到中序的根节点的index
    private static int getMidIndex(char[] target, int start, int end, char targetChar) {
        for(int i = start; i <= end; ++i){
            if(target[i] == targetChar){
                return i;
            }

        }
        return -1;
    }

    public static void preTraverse(Node node) {
        if(node != null){
            System.out.print(node.val + " ");
            preTraverse(node.lChild);
            preTraverse(node.rChild);
        }
    }

    public static void midTraverse(Node node) {
        if(node != null){
            midTraverse(node.lChild);
            System.out.print((node.val + " "));
            midTraverse(node.rChild);
        }
    }

    public static void postTraverse(Node node) {
        if(node != null){
            postTraverse(node.lChild);
            postTraverse(node.rChild);
            System.out.print(node.val + " ");
        }
    }

    public static void BFS(Node root){
        Queue<Node> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
            while (!queue.isEmpty()){
                Node node = queue.poll();
                System.out.print(node.val);
                if(node.lChild != null){
                    queue.add(node.lChild);
                }
                if(node.rChild != null){
                    queue.add(node.rChild);
                }
            }
        }
    }



    static class Node {
        Node lChild;
        Node rChild;
        char val;


        public Node(Node lChild, Node rChild, char val) {
            this.lChild = lChild;
            this.rChild = rChild;
            this.val = val;
        }
    }
}
