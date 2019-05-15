/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau1;

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
        DatagramSocket theCLient;
        DatagramPacket sendServer = null,receiveServer;
        byte[] sendbuf,receivebuf;
        Scanner in= new Scanner(System.in);
        String send;
        InetAddress address;
        //=====================
        try{
            address = InetAddress.getLocalHost();
            theCLient = new DatagramSocket();
            while (true) {
                sendbuf = new byte[1024];
                System.out.println("Nhập số cần tính trị tuyệt đôi: ");
                send = in.nextLine();
                sendbuf = send.getBytes();
                sendServer = new DatagramPacket(sendbuf, sendbuf.length, address, 9999);
                theCLient.send(sendServer);
                //nhan
                receivebuf= new byte[1024];
                receiveServer = new DatagramPacket(receivebuf, receivebuf.length);
                theCLient.receive(receiveServer);
                send = new String(receiveServer.getData()).trim();
                System.out.println("Server: ->"+send);
            }
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
