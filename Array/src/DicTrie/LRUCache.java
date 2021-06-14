package DicTrie;

import java.util.HashMap;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/24 15:14
 * @description：
 */


//要求O(1) put get
public class LRUCache {

    class LinkedNode{
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;
        public LinkedNode(){};
        public LinkedNode(int _key, int _value){
            key = _key;
            value = _value;
        }
    }

    private int capacity;
    private int size;
    private HashMap<Integer, LinkedNode> map;
    private LinkedNode head;
    private LinkedNode tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<Integer, LinkedNode>();
        this.head = new LinkedNode();
        this.tail = new LinkedNode();
        //初始化双向链表
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        LinkedNode node = map.get(key);
        if(node == null)return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
      LinkedNode node = map.get(key);
      if(node == null){
          node = new LinkedNode(key,value);
          size++;
          if(size > capacity){
              LinkedNode temp = removeTail();
              map.remove(temp.key);
          }
          addToHead(node);
      }else{
          node.value = value;
          moveToHead(node);
      }
//      moveToHead(node);
      map.put(key, node);

    }

    public void addToHead(LinkedNode node){
        //先处理后面的节点防止断链
        node.next = head.next;
        head.next.pre = node;

        head.next = node;
        node.pre = head;
    }


    public void moveToHead(LinkedNode node){
        //LinkedNode temp = node.next;


        removeNode(node);
        addToHead(node);


    }

    public void removeNode(LinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }



    public LinkedNode removeTail (){
        LinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(10);
        lru.put(10, 13);
        lru.put(3, 17);
        lru.put(6, 11);
        lru.put(10, 5);
        lru.put(9, 10);
        lru.get(13);
        lru.put(2,19);
        lru.get(2);
        lru.get(3);
        lru.put(5,25);

        lru.get(8);
        lru.put(9,22);
        lru.put(5,5);
        lru.put(1,30);
        lru.get(11);
        lru.put(9,12);
        lru.get(7);
        lru.get(5);
        lru.get(8);
        lru.get(9);

        lru.put(4,30);
        lru.put(9,3);
        lru.get(9);
        lru.get(10);
        lru.get(10);
        lru.put(6,14);
        lru.put(3,1);
        lru.get(3);
        lru.put(10,11);
        lru.get(8);

        lru.put(2,14);
        lru.get(1);
        lru.get(5);
        lru.get(4);
        lru.put(11,4);
        lru.put(12,24);

    }
}
