/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/27 13:50
 * @description：
 */

public class Test {

    public static void main(String[] args) {
        Father f = new Son();
        System.out.println(f.i);
        System.out.println(Father.j);
        f.printI();
    }

}
class Father {

    static  int j = 20;
    int i = 100;
    public Father() {
        System.out.println("super field = " + i);
        printI();
    }


    public void printI() {
        System.out.println("super method = " + i);
    }

}

class Son extends Father{
    private int i = 200;
    //构造子类时，父类先被构造执行默认构造函数 输出 i = 100
    //此时调用printI发现子类有方法覆盖，调用子类方法，注意此时仍在Father默认构造函数中，子类还未被初始化
    //因此jvm调用子类默认构造函数将i初始化为0
   public void printI() {
        System.out.println("super method = " + i);
        super.printI();
    }
}
