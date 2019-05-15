/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Server;

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
public class Server {
    private static InetAddress adress;
    private static int port;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            DatagramSocket theServer = new DatagramSocket(9999);
            new read(theServer);
            new send(theServer);
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //luồng nhận
    static class read extends Thread
    {
        byte[] readbuf = new byte[1024];
        String readstr;
        DatagramPacket receivepacket;
        DatagramSocket socketServer;

        public read(DatagramSocket theSV) {
            socketServer = theSV;
            receivepacket = new DatagramPacket(readbuf, readbuf.length);
            start();
        }
        
        
        @Override
        public void run ()
        {
            do {
            try {
                socketServer.receive(receivepacket);
                readstr = new String (receivepacket.getData());
                adress = receivepacket.getAddress();
                port = receivepacket.getPort();
                System.out.println("Client: ->"+readstr);
                
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (readstr.equals("tam biet")) break;
            } while (true);
        }
    }
    //Luồng gửi
    static class send extends Thread
    {
        byte[] sendbuf = new byte[1024];
        String sendstr;
        DatagramPacket sendPacket;
        DatagramSocket socketSV;
        Scanner in= new Scanner(System.in);

        public send(DatagramSocket theSV) {
            socketSV= theSV;
            start();
        }
        
        @Override
        public void run()
        {
            while (true){
                try {
                    System.out.println("Server: ");
                    sendstr = in.nextLine();
                    sendbuf = sendstr.getBytes();
                    sendPacket = new DatagramPacket(sendbuf, sendbuf.length, adress, port);
                    socketSV.send(sendPacket);
                    
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (sendstr.equals("tam biet")) break;
            }
        }
    }
}
