package Picture;

import org.junit.Test;

import java.io.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/18 21:02
 * @description：
 */

public class PictureTest {

    @Test
    public void test() throws IOException {
        //不能使用字符流处理图片，媒体等字节数据
//        FileInputStream fis = new FileInputStream("01.jpg");
//        FileOutputStream fos = new FileOutputStream("E:\\Study\\IO\\src\\Picture\\123.jpg");
//
//        byte[] buffer = new byte[1024];
//        int len;
        long start = System.currentTimeMillis();
        copyFile("E:\\Study\\IO\\src\\Picture\\01.jpg", "E:\\Study\\IO\\src\\Picture\\123.jpg");
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    public void copyFile(String srcPath, String dstPath) throws IOException{

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File(srcPath));
            fos = new FileOutputStream(new File(dstPath));

            byte[] buffer = new byte[10];
            int len;

            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            assert fis != null;
            fis.close();
            assert fos != null;
            fos.close();
        }


    }

}
