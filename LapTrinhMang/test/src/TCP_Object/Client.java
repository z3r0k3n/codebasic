/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP_Object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException{
        // TODO code application logic here
        Socket socketclient;
        ObjectInputStream input;
        ObjectOutputStream output;
        try {
            //===================================
            socketclient = new Socket("localhost", 9999);
            output = new ObjectOutputStream(socketclient.getOutputStream());
            input= new ObjectInputStream(socketclient.getInputStream());
            System.out.println("accept");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
