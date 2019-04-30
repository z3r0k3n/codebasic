package UDPdemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerUDPDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramPacket receiveData;
		DatagramPacket sentData;
		DatagramSocket serverSocket=null;
		String receiveStrFromClient;
		String modifiedStr;
		InetAddress ipAddress;
		int port;
		//==========================================================
		byte[] buffRe=new byte[1024];
		receiveData=new DatagramPacket(buffRe, buffRe.length);
		try {
			serverSocket=new DatagramSocket(7788);
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (true)
		{
		try {
			
			serverSocket.receive(receiveData);
			receiveStrFromClient=new String(receiveData.getData());
			modifiedStr=receiveStrFromClient.toUpperCase();
		//gui di.
			byte[] buffSend = new byte[1024];
			buffSend= modifiedStr.getBytes();
			ipAddress=receiveData.getAddress();
			port = receiveData.getPort();
			sentData=new DatagramPacket(buffSend, buffSend.length, ipAddress, port);
			serverSocket.send(sentData);
			
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

}
