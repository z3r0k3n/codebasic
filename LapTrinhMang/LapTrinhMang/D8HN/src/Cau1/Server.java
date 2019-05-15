/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
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
        DatagramSocket theServer;
        DatagramPacket sendClient = null,receiveClient;
        byte[] sendbuf,receivebuf;
        Double x;
        String xstr;
        //===============
        try{
            System.out.println("server running...");
            
            theServer= new DatagramSocket(9999);
            
            do {
                sendbuf = new byte[1024];
                receivebuf = new byte[1024];
                receiveClient = new DatagramPacket(receivebuf, receivebuf.length);
                //Nhan
                theServer.receive(receiveClient);
                xstr = new String(receiveClient.getData()).trim();
                x= Double.parseDouble(xstr);
                if (x<0) x*=-1;
                else if (x==0) x=0.0;
                xstr = String.valueOf(x);
                //gui
                sendbuf =xstr.getBytes();
                sendClient = new DatagramPacket(sendbuf, sendbuf.length, receiveClient.getAddress(), receiveClient.getPort());
                theServer.send(sendClient);
            } while (true);
            
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
