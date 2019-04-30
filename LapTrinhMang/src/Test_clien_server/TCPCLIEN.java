package Test_clien_server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPCLIEN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket Listener=null;
		String server;
		BufferedReader Reader;
		BufferedWriter Writer;
		Socket ServerSocket=null;
		try {
			Listener=new ServerSocket(9119);
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
				
				Writer.write(">>"+server);
				Writer.newLine();
				Writer.flush();
				if(server.equals("Z3R0KEN"))
				{
					Writer.write("Z3R0KEN");
					Writer.newLine();
					Writer.flush();
					break;
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
