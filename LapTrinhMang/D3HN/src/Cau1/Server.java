/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Server {

    public static int giaithua (int x)
    {
        int i,y=1;
        for (i=1;i<=x;i++)
        {
            y*=i;
        }
        return y;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocket listener;
        Socket socketServer;
        String sostr;
        int so;
        BufferedReader input;
        BufferedWriter output;
        //=======================
        try{
            System.out.println("Server running ....");
            listener = new ServerSocket(9999);
            socketServer = listener.accept();
            output = new BufferedWriter(new OutputStreamWriter(socketServer.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(socketServer.getInputStream()));
            System.out.println("accecp :>");
            while (true) {
                //nhận
                sostr = input.readLine();
                if (sostr.equals("exit")) 
                {
                    output.write("exit"); 
                    output.newLine();
                    output.flush();
                    break;
                }
                so = Integer.parseInt(sostr);
                so = giaithua(so);
                //gửi
                output.write(String.valueOf(so));
                output.newLine();
                output.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
