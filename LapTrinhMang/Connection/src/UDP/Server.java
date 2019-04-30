/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
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
        String sendstr = null,receivestr;
        byte[] sendbuf,receivebuf;
        DatagramSocket theServer;
        DatagramPacket sendClient, receiveClient;
        InetAddress address;
        int port;
        //====================================================
        try {
            theServer = new DatagramSocket(9999);
            sendbuf = new byte[1024];
            receivebuf = new byte[1024];
            receiveClient = new DatagramPacket(receivebuf, receivebuf.length);
            
            while (true) {
                //nhận
                theServer.receive(receiveClient);
                receivestr = new String (receiveClient.getData(),0,receiveClient.getLength()).trim();
                
                //gui
                address = receiveClient.getAddress();
                port = receiveClient.getPort();
                sendbuf = sendstr.getBytes();
                sendClient = new DatagramPacket(sendbuf, receivebuf.length, address, port);
                theServer.send(sendClient);
            }
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
