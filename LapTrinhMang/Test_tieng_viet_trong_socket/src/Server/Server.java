/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

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
        Socket socketClient;
        BufferedReader input;
        BufferedWriter output;
        String send,receive;
        //===========================================
        try{
            listener = new ServerSocket(9999);
            socketClient = listener.accept();
            input = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            output = new BufferedWriter (new OutputStreamWriter(socketClient.getOutputStream()));
            
            send =receive = input.readLine();
            System.out.println("Client: ->"+receive);
            output.write(send);
            output.newLine();
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
