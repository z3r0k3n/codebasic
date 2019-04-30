/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Client_TCP {
    public static void main(String[] args) {
        Socket socketClient;
        BufferedReader input=null;
        BufferedWriter output = null;
        String receiveServer;
        Scanner in= new Scanner(System.in);
        try {
            //======================================================================
            socketClient= new Socket("localhost", 9999);
            input= new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            output= new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Client_TCP.class.getName()).log(Level.SEVERE, null, ex);
        }
            while(true)
            {
            try {
                System.out.println("Nhập vào một số từ 0 đến 5");
                output.write(in.nextLine());
                output.newLine();
                output.flush();
                receiveServer = input.readLine();
                if(receiveServer.equals("ex"))
                {
                    System.out.println("Server: >Ngắt kết nối :>");
                    break;
                }
                System.out.println("Server: >"+receiveServer);
            } catch (IOException ex) {
                Logger.getLogger(Client_TCP.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
    }
}
