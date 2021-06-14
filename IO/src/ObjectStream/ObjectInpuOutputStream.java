package ObjectStream;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.*;
import java.security.PublicKey;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/19 20:51
 * @description：
 */

public class ObjectInpuOutputStream {

    @Test
    //持久化 序列化
    public void test(){
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("E:\\Study\\IO\\src\\ObjectStream\\object.dat"));

            oos.writeObject(new String("ssss"));

            //java对象可序列化需要满足条件
            oos.writeObject(new Person("李", 20));

            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    //反序列化
    public void test1(){
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("E:\\Study\\IO\\src\\ObjectStream\\object.dat"));

            Object obj = ois.readObject();

            String str = (String) obj;

            Object obj1 = ois.readObject();
            Person p = (Person) obj1;
            System.out.println(str);
            System.out.println(p.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
