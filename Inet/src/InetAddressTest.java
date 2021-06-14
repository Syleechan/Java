import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/20 11:50
 * @description：
 */

public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {

//        InetAddress inetAddress1 = InetAddress.getByAddress();
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress);

        InetAddress inetAddress1 = InetAddress.getByName("www.atguigu.com");
        System.out.println(inetAddress1);
        System.out.println(inetAddress1.getHostAddress());
        System.out.println(inetAddress1.getHostName());



        System.out.println(InetAddress.getLocalHost());
    }
}
