/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP_Object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException{
        // TODO code application logic here
        ServerSocket listner;
        Socket socketServer;
        ObjectOutputStream output;
        ObjectInputStream input;
        try {
            //==============
            listner = new ServerSocket(9999);
            socketServer = listner.accept();
            output = new ObjectOutputStream(socketServer.getOutputStream());
            input= new ObjectInputStream(socketServer.getInputStream());
            System.out.println("accept :>");
        } catch (IOException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
