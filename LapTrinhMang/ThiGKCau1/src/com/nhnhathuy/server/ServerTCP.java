package com.nhnhathuy.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerTCP {

	public static void main(String[] args) {
	
		ServerSocket theServer = null;
		try {
		// TODO Auto-generated method stub
		theServer = new ServerSocket(8888);
		
		Socket serviceSocket = theServer.accept();
		BufferedReader inFormClient = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
		String receiveData = inFormClient.readLine();
		int a = Integer.parseInt(receiveData);
		String strTich = random(a);
		System.out.println(strTich);
		PrintWriter outToClient = new PrintWriter(serviceSocket.getOutputStream());
		//BufferedWriter outToClient= new BufferedWriter(new OutputStreamWriter(serviceSocket.getOutputStream()));
		outToClient.println(strTich);
		//outToClient.write(strTich);
		outToClient.flush();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	
	public static String random(int n) {
		int a,b;
		Random  rd= new Random();
		a = rd.nextInt(n);
		b = rd.nextInt(n);
		String product = "";
		product+="So random thu nhat la: " +a+"  So random thu hai la: " +b+"  Tong hai so random la: " +(a+b);
		return product;
		
	}
}
