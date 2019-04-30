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
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatagramSocket theClient;
        DatagramPacket sendServer = null,receiveServer;
        byte[] sendbuf,receivebuf;
        String sendstr = null,receivestr;
        InetAddress address;
        int port;
        Scanner in = new Scanner(System.in);
        //==================================
        try{
        theClient = new DatagramSocket();
        sendbuf= new byte[1024];
        receivebuf = new byte[1024];
        receiveServer = new DatagramPacket(receivebuf, receivebuf.length);
        //=============================================================
            while (true) {
                //gui
                address = InetAddress.getLocalHost();
                port = 9999;
                sendbuf = sendstr.getBytes();
                sendServer = new DatagramPacket(sendbuf, sendbuf.length, address, port);
                theClient.send(sendServer);
                //nhan
                theClient.receive(receiveServer);
                receivestr = new String (receiveServer.getData(),0,receiveServer.getLength()).trim();
                System.out.println("Server: -> "+receivestr);
            }
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
