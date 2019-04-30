/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_SQL;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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
    public static void main(String[] args) {
        // TODO code application logic here
        DatagramSocket theClient;
        DatagramPacket receiveServer;
        byte[] receivebuf;
        //=========================================
        try{
            theClient = new DatagramSocket();
            receivebuf = new byte[1024];
            tcp
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DatagramPacket sendPacket (Older older)
    {
        DatagramPacket sendClient = null;
        ObjectOutputStream output;
        ByteArrayOutputStream arrayout;
        byte[] sendbuf = new byte[1024];
        InetAddress address;
        int port = 9999;
        
        try {
            address = InetAddress.getLocalHost();
            //==================
            arrayout = new ByteArrayOutputStream();
            output = new ObjectOutputStream(arrayout);
            output.writeObject(older);
            sendbuf = arrayout.toByteArray();
            sendClient = new DatagramPacket(sendbuf, sendbuf.length, address, port);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sendClient;
    }
    //nhan
    public static Older odin (DatagramPacket receiveClient)
    {
        Older older = null;
        ObjectInputStream input;
        ByteArrayInputStream arrin;
        //============
        try{
            arrin = new ByteArrayInputStream(receiveClient.getData());
            input = new ObjectInputStream(arrin);
            older = (Older) input.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return older;
    }
}
