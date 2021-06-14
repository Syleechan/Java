package Buffer;

import org.junit.Test;

import java.io.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/18 21:31
 * @description：
 */

public class BufferTest {

    @Test
    public void test () throws FileNotFoundException {
        copyFile("E:\\Study\\IO\\src\\Buffer\\01.jpg", "E:\\Study\\IO\\src\\Buffer\\123.jpg");

    }


    private void copyFile(String src, String dst) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;

        try {
            File srcFile = new File(src);
            File dstFile = new File(dst);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(dstFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];
            int len;

            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭资源
            //先关闭外层的流，再关闭内层的流
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //关闭外层流的同时，内层流也会自动的进行关闭
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
