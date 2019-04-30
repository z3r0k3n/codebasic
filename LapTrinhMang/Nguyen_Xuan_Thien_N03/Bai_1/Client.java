package Bai_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ResponeFromServer;	
		BufferedReader Reader=null;
		BufferedWriter Writer=null;
		Socket ClientSocket=null;
		Scanner in=new Scanner(System.in);
		
		try {
			ClientSocket=new Socket("localhost", 9999);
			Reader=new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
			Writer=new BufferedWriter(new OutputStreamWriter(ClientSocket.getOutputStream()));			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
					
			Writer.write(in.nextInt());
			Writer.newLine();
			Writer.flush();
			ResponeFromServer=Reader.read();
			System.out.println("server: "+ ResponeFromServer);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
