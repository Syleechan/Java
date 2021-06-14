package Tcp;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/20 14:51
 * @description：
 */

public class TcpTest {

    @Test
    public void client() throws IOException {
        //指明服务器端IP 端口号
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAddress, 9999);

        //获取输出流输出数据
        OutputStream os = socket.getOutputStream();
        //写数据操作
        os.write("xxxxxxxxxxxx".getBytes());

        os.close();
        socket.close();
    }

    @Test
    public  void server() throws IOException {

//        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        //指明自己的端口号 为什么不指明自己IP，自己作为服务器直到自己的IP
        ServerSocket serverSocket = new ServerSocket( 9999);
        //调用accept的方法，接受来自于客户端的socket
        Socket socket =  serverSocket.accept();
        //获取输入流
        InputStream is = socket.getInputStream();

//        byte[] buffer = new byte[20];
//        int len;
//        while((len = is.read()) != -1){
//            String str = new String(buffer, 0 , len);
//            System.out.println(str);
//        }

        //获取输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[20];
        int len;
        while((len = is.read(buffer)) != -1){
            baos.write(buffer, 0, len);
        }

        System.out.println(baos.toString());

        baos.close();
        is.close();
        socket.close();
        serverSocket.close();

    }

}
