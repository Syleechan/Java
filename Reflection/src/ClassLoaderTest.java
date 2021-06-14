import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/21 21:35
 * @description：
 */

public class ClassLoaderTest {
    @Test
    public void test1(){
        //系统加载器
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用系统加载器parent方法获得扩展加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        //调用扩展类加载器无法获取引导类加载器
        //引导类加载器主要负责java的核心类库，无法加载自定义类的
        System.out.println(classLoader1.getParent());

        //引导类加载器无法获取
        ClassLoader classLoader2 = String.class.getClassLoader();
        System.out.println(classLoader2);
    }

    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();//读取配置文件
        //读取配置文件的方式一:文件流
        FileInputStream fis = new FileInputStream("src\\xxx");//相对路径
        pros.load(fis);


        //读取配置文件方式二：使用ClassLoader
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("xxx");//默认在src下
        pros.load(is);


    }


}
