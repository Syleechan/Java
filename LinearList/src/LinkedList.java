import java.util.Objects;

/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/27 16:48
 * @description：
 */

public class LinkedList implements LinearList {


    private Node first;
    private Node last;
    private int size;

    public LinkedList(){}

    private class Node{
        String value;
        Node next;

        public Node(String value, Node next){
            this.value = value;
            this.next = next;
        }

        public Node() {

        }
    }


    public int size(){return size;}

    boolean isEmpty(){return size == 0;}






    @Override
    public boolean add(String e, int index) {
        rangeCheckForAdd(index);

        Node pre = preNode(index);

        link(pre,e);

        return true;
    }

    private void link(Node pre, String e) {
        //前驱为空，直接插入
        if(pre == null){
            //初始 first last 都为空，建立新节点后 first.next = first == null
            first = new Node(e, first);
            //插入前size为空，则插入后 first = last
            if(size == 0){
                last = first;
            }
        }else{//其它位置都有前驱
            Node node = new Node();
            node.next = pre.next;
            pre.next = node;
            node.value = e;

            //pre.next = new Node(e,pre.next);
            if(node.next == null){
                last = node;
            }
        }

        ++size;
    }

    private Node preNode(int index) {
        //第一个元素前驱为null
        if(index == 0){
            return null;
        }

        Node node = first;
        //遍历找到前驱
        for(int i = 1; i < index; ++i){
            node = node.next;
        }

        return node;

    }

    private void rangeCheckForAdd(int index) {
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException("Index: " + index + "size: " + size);
        }
    }

    //尾插法
    @Override
    public boolean add(String e) {
        link(last, e);
        return true;
    }


    //头插法
    public boolean addHead(String e){
        link(null,e);
        return true;
    }

    @Override
    public String remove(int index) {
        rangeCheck(index);

        Node pre = preNode(index);


        return unlink(pre);
    }

    private String unlink(Node pre) {
        String oldValue = null;
        //删表头
        if(pre == null){
            oldValue = first.value;
            first = first.next;
            //只有一个节点
            if(first == null){
                last = null;
            }

        }else{//不是表头节点
            Node cur = pre.next;
            oldValue = cur.value;

            pre.next = cur.next;
            //表尾节点
            if(pre.next == null){
                last = pre;
            }
        }

        --size;
        return oldValue;
    }

    private void rangeCheck(int index) {
        // 0, size - 1
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("Index: " + index + "size: " + size);
        }
    }

    @Override
    public boolean remove(String e) {
        if(size == 0){
            throw new ArrayIndexOutOfBoundsException("");
        }

        Node pre = new Node();
        for(Node node = first; node != null; node = node.next){
            if(Objects.equals(e,node.value)){
                unlink(pre);
            }
            pre = node;
        }
        return true;
    }

    @Override
    public void set(int index, String newValue) {

        rangeCheck(index);
        //找到的pre也就是index 指向的node
        Node node = preNode(index + 1);
        node.value = newValue;

    }

    @Override
    public int indexOf(String e) {
        int index = 0;

        for(Node node = first; node != null; node = node.next){
            if(Objects.equals(node.value,e)){
                return index;
            }
            ++index;
        }


        return -1;
    }

    @Override
    public String toString(){
        if(size == 0){
            return "[]";
        }

        StringBuffer stringBuffer = new StringBuffer("[");

        for(Node node = first; node.next != null; node = node.next){
            stringBuffer.append(node.value + ", ");
        }
        stringBuffer.append(last.value + ']');

        return stringBuffer.toString();

    }

}
