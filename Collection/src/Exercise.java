import java.util.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/7 21:39
 * @description：
 */

public class Exercise {

    public static void listIterator(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        ListIterator<String> listIterator = list.listIterator();

        while (listIterator.hasNext())listIterator.next();
        while(listIterator.hasPrevious()){
            System.out.println("逆序index为：" + listIterator.previousIndex());
            System.out.println("逆序遍历为：" + listIterator.previous());
        }
    }

    public static void main(String[] args) {
        Collection<Student> st = new ArrayList<>();

        st.add(new Student("zs", 18, 001));
        st.add(new Student("lisi", 20, 002));
        st.add(new Student("wangwu", 18, 003));
        st.add(new Student("zhaoliu", 18, 007));

        Iterator<Student> iterator = st.iterator();
        //Exercise.listIterator();

        /*
        while(iterator.hasNext()){
            Student student = iterator.next();
            System.out.println(student.toString());
            System.out.println(iterator.toString());
        }

         */
    }







}
