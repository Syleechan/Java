/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/27 17:35
 * @description：
 */

public class TestList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
//
//        testLinkedAdd(linkedList);
//        System.out.println(linkedList);
//
//        insertLinkedAt(linkedList, "888", 1);
//        System.out.println(linkedList);
//
//        insertLinkedHead(linkedList,"666");
//        System.out.println(linkedList);
//
//        linkedList.remove("100");
//        System.out.println(linkedList);
//
//        System.out.println(linkedList.size());
//        String str =  linkedList.remove(8);
//        System.out.println(str);
//        System.out.println(linkedList);
//
//        linkedList.set(3,"999");
//        System.out.println(linkedList);

        insertLinkedTail(linkedList, "1");
        insertLinkedTail(linkedList, "4");
        insertLinkedTail(linkedList, "3");
        insertLinkedTail(linkedList, "2");
        insertLinkedTail(linkedList, "5");
        insertLinkedTail(linkedList, "2");
        insertLinkedTail(linkedList, "3");

    }
    


    private static void testLinkedAdd(LinkedList linkedList){
        for(int i = 100; i < 110; ++i){
            linkedList.add(Integer.toString(i));
        }
    }

    public static void testRemove(LinkedList linkedList){
        linkedList.add(null);
        System.out.println(linkedList.toString());


    }

    /*
    public static void testAdd(LinkedList linkedList){
        for(int i = 0; i < 20; ++i){
            linkedList.add(Integer.toString(i));
        }
        System.out.println(linkedList);
    }

     */

    public static void  insertLinkedAt(LinkedList linkedList, String e, int index){
        linkedList.add(e, index);
    }

    public static void insertLinkedHead(LinkedList linkedList, String e){
        linkedList.addHead(e);
    }

    public static  void insertLinkedTail(LinkedList linkedList, String e){linkedList.add(e);}
}
