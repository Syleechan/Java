package Set;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/17 15:41
 * @description：
 */

public class TreeSetTest {

    @Test
    public void test(){
        TreeSet treeSet = new TreeSet();

//        treeSet.add(11);
//        treeSet.add(9);
//        treeSet.add(5);

        treeSet.add(new Student("aa", 20 , 1));
        treeSet.add(new Student("bb", 18 , 5));
        treeSet.add(new Student("cc", 33 , 3));
        treeSet.add(new Student("dd", 32 , 7));
        treeSet.add(new Student("dd", 32 , 7));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            //整数默认从小到大
            System.out.println(iterator.next());
        }


    }


    @Test
    public void Test2(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if( o1 instanceof Student && o2 instanceof Student){
                    Student u1 = (Student) o1;
                    Student u2 = (Student) o2;
                    return Integer.compare(u1.age, u2.age);

                }else{
                    throw new RuntimeException("xxxx");
                }
            }
        };

        TreeSet ts = new TreeSet(com);

        ts.add(new Student("aa", 20 , 1));
        ts.add(new Student("bb", 18 , 5));
        ts.add(new Student("cc", 33 , 3));
        ts.add(new Student("dd", 32 , 7));
        ts.add(new Student("dd", 32 , 7));

        Iterator iterator = ts.iterator();
        while (iterator.hasNext()){
            //整数默认从小到大
            System.out.println(iterator.next());
        }
    }

}
