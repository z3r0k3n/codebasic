package Bai_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.sun.org.apache.regexp.internal.recompile;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		Socket Cliensocket=null;
		BufferedReader Reader=null;
		BufferedWriter Writer=null;
		try {
			Cliensocket=new Socket("localhost", 9110);
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
					if(ResponseLine.indexOf("ex")!=-1) break;
					System.out.println("server:"+ResponseLine);
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
