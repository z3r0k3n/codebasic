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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
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
        Scanner in= new Scanner(System.in);
        Older older;
        //String send;
        //BufferedReader input;
        //BufferedWriter output;
        ObjectInputStream input;
        ObjectOutputStream output;
        ServerSocket listener;
        Socket socketServer;
        
        try {
            //===========================================================
            System.out.println("Server running...");
            listener = new ServerSocket(9999);
            socketServer= listener.accept();
            input= new ObjectInputStream(socketServer.getInputStream());
            output = new ObjectOutputStream(socketServer.getOutputStream());
            System.out.println("Accept...");
            //nhan
            older = (Older) input.readObject();
            System.out.println("Client: ->"+older.getSend());
            //gui
            output.writeObject(older);
            /*input = new BufferedReader(new InputStreamReader(socketServer.getInputStream()));
            output = new BufferedWriter(new OutputStreamWriter(socketServer.getOutputStream()));
            
            send= input.readLine();
            System.out.println(send);
            output.write(send);
            output.newLine();
            output.flush();*/
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
