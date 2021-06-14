package Udp;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/20 15:56
 * @description：
 */

public class UdpTest {

    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "I am udp";

        byte[] bytes = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, inet, 9999);

        socket.send(packet);

        socket.close();
    }

    @Test
    public void receiver() throws IOException {

        DatagramSocket socket = new DatagramSocket(9999);

        byte[] bytes = new byte[100];
        DatagramPacket packet = new DatagramPacket(bytes,0, bytes.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        socket.close();

    }
}
