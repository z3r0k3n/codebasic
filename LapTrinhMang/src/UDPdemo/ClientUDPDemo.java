package UDPdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDPDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader inUser; 
		String sendStr;
		DatagramPacket sendPacket;
		DatagramPacket receivePacket;
		DatagramSocket clientSocket;
		InetAddress address;
		String receiveStr;
		//================================================================
		inUser = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			sendStr=inUser.readLine();
			byte[] buf = new byte[1024];
			buf=sendStr.getBytes(); 
			address= InetAddress.getLocalHost();
			//Gui
			sendPacket= new DatagramPacket(buf, buf.length, address, 7788);
			clientSocket=new DatagramSocket();
			clientSocket.send(sendPacket);
			//Nhan
			byte[] bufRecivie= new byte[1024];
			receivePacket = new DatagramPacket(bufRecivie, bufRecivie.length);
			clientSocket.receive(receivePacket);
			receiveStr=new String(receivePacket.getData());
			System.out.println("Server: "+receiveStr);
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
