package com.nhnhathuy.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientTCP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Nhap vao so can tinh: ");
		BufferedReader inUser = new BufferedReader(new InputStreamReader(System.in));
		try {
			String sendData = inUser.readLine();
			Socket clientSocket = new Socket("localhost",8888);
			
			PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream());
						outToServer.println(sendData);
						outToServer.flush();
			BufferedReader inFormServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String receiveData = inFormServer.readLine();
			System.out.println(receiveData);
		}
		catch (IOException ex)
		{
		Logger.getLogger(ClientTCP.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
