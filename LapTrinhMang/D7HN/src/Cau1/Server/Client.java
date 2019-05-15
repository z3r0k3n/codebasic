/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau1.Server;

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
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatagramSocket theClient;
        DatagramPacket sendServer,receiveServer;
        
        Scanner in = new Scanner(System.in);
        InetAddress address;
        int port =9999;
        String sostr;
        //==========================================
        try{
            theClient = new DatagramSocket();
            address = InetAddress.getLocalHost();
            
            do {
                byte[] sendbuf = new byte[1024];
                byte[] receive = new byte[1024];
                receiveServer = new DatagramPacket(receive, receive.length);
                System.out.println("Nhập số");
                sostr = in.nextLine();
                if (sostr.equals("exit")) break;
                sendbuf = sostr.getBytes();
                sendServer = new DatagramPacket(sendbuf, sendbuf.length, address, port);
                theClient.send(sendServer);
                
                theClient.receive(receiveServer);
                sostr = new String(receiveServer.getData());
                System.out.println("Server: ->"+sostr);
            } while (true);
            
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
