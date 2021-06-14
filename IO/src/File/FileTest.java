package File;

import org.junit.Test;

import java.io.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/17 21:16
 * @description：
 */

public class FileTest {

    @Test
    public void test() throws IOException {
        File file = new File("File/hello.txt");

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file.length());

        FileReader fr = new FileReader(file);
        FileWriter fw = new FileWriter(file);


    }
}
