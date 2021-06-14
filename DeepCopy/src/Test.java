/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/27 14:23
 * @description：
 */

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {

        ThirdLevel thirdLevel = new ThirdLevel(100);

        SecondLevel secondLevel = new SecondLevel(0.1, thirdLevel);
        //1,2,0.1,100
        FirstLevelImplements firstLevelImplements = new FirstLevelImplements(1,2,secondLevel);

        //深拷贝 sec,third
        FirstLevelImplements clone = (FirstLevelImplements) firstLevelImplements.clone();


        //给拷贝来的对象赋值并不会影响first对象的值的改变
        clone.sec.thirdLevel.k = 20;
        System.out.println(firstLevelImplements.sec.thirdLevel.k);

        clone.sec.j = 0.2;
        System.out.println(firstLevelImplements.sec.j);

        clone.i = 10;
        System.out.println(firstLevelImplements.i);
    }
}
