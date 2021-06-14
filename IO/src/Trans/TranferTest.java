package Trans;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/19 19:46
 * @description：
 */

public class TranferTest {
    @Test
    public void test() throws IOException {
        FileInputStream fis  = null;
        FileOutputStream fos = null;

        InputStreamReader isr = null;
        OutputStreamWriter osw = null;

        try {
            File f1 = new File("E:\\Study\\IO\\src\\Trans\\dbcp.txt");
            File f2 = new File("E:\\Study\\IO\\src\\Trans\\dpcp_gbk.txt");

            fis = new FileInputStream(f1);
            fos = new FileOutputStream(f2);

            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            osw = new OutputStreamWriter(fos, "gbk");

            char[] buffer = new char[20];
            int len;

            while((len = isr.read(buffer)) != -1){
                osw.write(buffer, 0 ,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //不关没数据
            isr.close();
            osw.close();
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
    public static void main(String[] args) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(isr);

        try {
            String str;
            while(true){
                str = br.readLine();
                if(str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")){
                    System.out.println("end");
                    break;
                }

                String  data = str.toUpperCase();
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }

    }
}
