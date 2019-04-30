package Bai_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket Listener=null;
		String server;
		BufferedReader Reader;
		BufferedWriter Writer;
		Socket ServerSocket=null;
		try {
			Listener=new ServerSocket(9155);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			ServerSocket=Listener.accept();
			Reader= new BufferedReader(new InputStreamReader(ServerSocket.getInputStream()));
			Writer= new BufferedWriter(new OutputStreamWriter(ServerSocket.getOutputStream()));
			
			while(true) {
				server=Reader.readLine();
				if(server.equals("ex"))
				{
					Writer.write("ex");
					Writer.newLine();
					Writer.flush();
					break;
				}
				Writer.write(server.toUpperCase());
				Writer.newLine();
				Writer.flush();
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
