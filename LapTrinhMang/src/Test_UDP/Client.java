/**
 * 
 */
package Test_UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Zero Ken
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InetAddress dst = InetAddress.getLocalHost();
		int port= 8080;
		byte[] outbut = new byte[1024];
		int len=1024;
		DatagramPacket request = new DatagramPacket(outbut, len, dst, port);
		DatagramSocket socket= new DatagramSocket();
		socket.send(request);
	}

}
