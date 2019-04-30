package Bai_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static int giaithua (int x)
	{
		if(x<=0) System.out.println("So vua nhap ko hop le");
		int i=1,y=1;
		while(i<=x)
		{
			y=y*i;
			i++;
		}
		return y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ListenSocket=null;
		int ResponeFromClient;
		BufferedWriter Writer;
		BufferedReader Reader;
		Socket ServerSocket=null;
		
		try {
			ListenSocket=new ServerSocket(9169);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ServerSocket = ListenSocket.accept();
			Writer=new BufferedWriter(new OutputStreamWriter(ServerSocket.getOutputStream()));
			Reader=new BufferedReader(new InputStreamReader(ServerSocket.getInputStream()));
			
			ResponeFromClient=Reader.read();
			ResponeFromClient=giaithua(ResponeFromClient);
			Writer.write(ResponeFromClient);
			Writer.newLine();
			Writer.flush();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
