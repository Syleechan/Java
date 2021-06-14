/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/9 10:39
 * @description：
 */

public class FinalTest {
    public static void main(String []args){
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        final String f = getHello();
        String g = f + 2;
        //True 被final修饰的变量是String以及其它基本数据类型时，编译期间知道它的确切值时，编译器会将其作为常量使用
        //因此在运行期间用到final变量时，会直接访问值（常量），不需要再运行时确定
        boolean flag1 = a == c;
        //False 而对于变量d，需要再运行时通过编译 - 链接后确定其值
        boolean flag2 = a == e;
        //False 这里f虽然是final修饰，但是调用了getHello()方法，因此它需要在编译-链接时才能确定其值
        boolean flag3 = a == g;
        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
    }

    public static String getHello(){
        return "hello";
    }
}
