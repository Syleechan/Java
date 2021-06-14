package DataStructure;


import java.util.Arrays;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/17 15:10
 * @description：
 */

public class SegmentTree {
    private int[] data;
    private int[] tree;

    public SegmentTree(){}

    public SegmentTree(int[] data) {
        this.data = data;
        //假设为完全二叉树，则 2^(h - 1)为data.length
        //那么tree的size为 2 * data.length - 1.
        //还有叶子左右为0的的 再加上 2 * data.length
        this.tree =  new int[4 * data.length];
    }

    public void buildTree(int treeIndex, int l, int r){
        if(l == r){
            tree[treeIndex] = data[l];//叶子节点
            return;
        }

        int mid = (l + r) / 2;
        int leftIndex = 2 * treeIndex + 1;
        int rightIndex = 2 * treeIndex + 2;
        buildTree(leftIndex, l, mid);
        buildTree(rightIndex,mid + 1, r);
        tree[treeIndex] = tree[leftIndex] + tree[rightIndex];

    }


    public void update(int index, int val){
        updateTree(0, 0, data.length - 1, index, val);
    }

    public void updateTree(int treeIndex, int l, int r, int index, int val){
        if(l == r && l == index){
            data[index] = val;
            tree[treeIndex] = val;
            return;
        }

        int mid = (l + r) / 2;
        int leftIndex = 2 * treeIndex + 1;
        int rightIndex = 2 * treeIndex + 2;
        if(index >= l && index <= mid){
            updateTree(leftIndex, l, mid, index, val);
        }else{
            updateTree(rightIndex, mid + 1, r, index, val);
        }
        tree[treeIndex] = tree[leftIndex] + tree[rightIndex];
    }
    public int queryTree(int start, int end){
        return queryTree(0, 0, data.length - 1, start, end);
    }

    public int queryTree(int treeIndex, int l, int r, int start, int end){
        if(l > end || r < start)return 0;
        if(l == r)return tree[treeIndex];
        if(start <= l && r <= end)return tree[treeIndex];

        int mid = (l + r) / 2;
        int leftIndex = 2 * treeIndex + 1;
        int rightIndex = 2 * treeIndex + 2;
        int leftSum = queryTree(leftIndex, l, mid, start, end);
        int rightSum = queryTree(rightIndex, mid + 1, r, start, end);
        return leftSum + rightSum;
    }

    @Override
    public String toString() {
        return "SegmentTree{" +
                "tree=" + Arrays.toString(tree) +
                '}';
    }
}
