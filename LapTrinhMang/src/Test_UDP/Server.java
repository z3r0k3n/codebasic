package Test_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		byte[] inbuf= new byte [256];
		DatagramSocket socket= new DatagramSocket();
		DatagramPacket packet= new DatagramPacket(inbuf, inbuf.length);
		socket.receive(packet);
		int numByteReceived = packet.getLength();
		System.out.println(numByteReceived);
	}

}
