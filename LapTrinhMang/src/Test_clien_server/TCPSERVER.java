package Test_clien_server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.sun.org.apache.regexp.internal.recompile;

public class TCPSERVER {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		Socket Cliensocket=null;
		BufferedReader Reader=null;
		BufferedWriter Writer=null;
		try {
			Cliensocket=new Socket("localhost", 9119);
			Reader=new BufferedReader(new InputStreamReader(Cliensocket.getInputStream()));
			Writer=new BufferedWriter(new OutputStreamWriter(Cliensocket.getOutputStream()));
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			while(true)
			{
				Writer.write(in.nextLine());
				Writer.newLine();
				Writer.flush();
				String ResponseLine;
				if((ResponseLine=Reader.readLine())!=null)
				{
					System.out.println("server:"+ResponseLine);
					if(ResponseLine.indexOf("Z3R0KEN")!=-1) break;
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
