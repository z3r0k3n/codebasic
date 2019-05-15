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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocket listener;
        Socket socketServer;
        BufferedReader input = null;
        BufferedWriter output = null;
        try {
            //=====================================================
            System.out.println("running....");
            listener = new ServerSocket(9999);
            socketServer = listener.accept();
            output = new BufferedWriter(new OutputStreamWriter(socketServer.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(socketServer.getInputStream()));
            System.out.println("accept :3");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        do{
        try {
            String strX= input.readLine();
            System.out.println(strX);
            if (strX.equals("exit")) break;//thoat ket noi
            int x= Integer.parseInt(strX);
            //gui
            output.write(kiemtra(x));
            output.newLine();
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        }while(true);
    }
    
    public static String kiemtra(int x)
    {
        String kq ="";
        if(x%2==0) kq = "Là số chẵn";
        else kq = "Là số lẻ";
        return kq;
    }
}
