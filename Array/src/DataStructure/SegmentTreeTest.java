package DataStructure;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/17 16:14
 * @description：
 */

public class SegmentTreeTest {
    public static void main(String[] args) {
        int[] arr = {1,4,3,6};
        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.buildTree(0, 0, arr.length - 1);

        System.out.println(segmentTree.toString());
        System.out.println(segmentTree.queryTree(2, 3));


        segmentTree.update(2, 7);

        System.out.println(segmentTree.toString());
        System.out.println(segmentTree.queryTree(2,3));
    }
}
