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
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Client_UDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatagramPacket sendServer,receiveServer;
        DatagramSocket theClient = null;
        byte[] sendbuf,receivebuf = null;
        String sendstr,receivestr;
        Scanner in= new Scanner(System.in);
        InetAddress address = null;
        try {
            //======================================================================
            theClient= new DatagramSocket();
            sendbuf= new byte[1024];
            receivebuf= new byte[1024];
            address= InetAddress.getLocalHost();
            System.out.println("Address: "+address);
        } catch (SocketException ex) {
            Logger.getLogger(Client_UDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client_UDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            
            
            try {
                //gui
                System.out.println("Nhập một số từ 0 đến 5");
                sendstr= in.nextLine();
                sendbuf=sendstr.getBytes();
                sendServer= new DatagramPacket(sendbuf, sendbuf.length, address, 9999);
                theClient.send(sendServer);
                //Nhan
                receivebuf= new byte[1024];
                receiveServer= new DatagramPacket(receivebuf, receivebuf.length);
                theClient.receive(receiveServer);
                receivestr= new String(receiveServer.getData(),0,receiveServer.getLength()).trim();
                System.out.println("Server: >"+receivestr);
            } catch (IOException ex) {
                Logger.getLogger(Client_UDP.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
