/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/27 15:52
 * @description：
 */

public class TestStringArrray {

    public static void main(String[] args) {
//        String[] s = new String[10];
//        for(int j = 0; j < s.length; ++j){
//            s[j] = j + ", ";
//        }
//        System.out.println(s.getClass());
//        System.out.println(toString(s));
//        String str = "word&quotCount";
//        String str1 = "nnn";
//        str = str.replace("&quot","");
//        str1 = str1.replace("nnn","");
//        System.out.println(str);
//        System.out.println(str1);

        test();
    }


    public static String toString(String[] s){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length; ++i){

            if(i == s.length - 1){
                stringBuffer.append(s[i], 0, s[i].lastIndexOf(','));
                break;
            }
            stringBuffer.append(s[i]);
        }
        return stringBuffer.toString();
    }


    public static void test(){
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb = new StringBuffer("abcdefghijklmnopq");

        //初始 length + 16
        StringBuffer sb2 = new StringBuffer("a");
        System.out.println(sb2.capacity() + "---" + sb2.length());
        //ensureCapacityInternal(count + len)
        //17 + 17 = mincap
        //value.length（oldcap） = 17 左移一位 再加 2  = 36
        //mincap与value.length比较，大者作为新容量
        //然后还会对上限有个比较
        sb2.append(sb);
        System.out.println(sb2.capacity() + "---" + sb2.length());

        System.out.println(17<<1);

        System.out.println(sb1.capacity() + "---" + sb1.length());
        System.out.println(sb.capacity() + "---" + sb.length());


    }
}
