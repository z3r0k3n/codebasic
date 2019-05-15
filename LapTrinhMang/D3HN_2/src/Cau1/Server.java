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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Server {
    public static int giaithua (int x)
    {
        int i,y=1;
        for (i=1;i<=x;i++)
        {
            y*=i;
        }
        return y;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatagramSocket Theserver;
        DatagramPacket sendClient = null,receiveClient;
        String strso;
        int so;
        InetAddress address;
        int port;
        //=======================================
        try{
            Theserver = new DatagramSocket(9999);
            
            do {
                byte[] sendbuf= new byte[1024];
                byte[] receivebuf= new byte[1024];
                receiveClient = new DatagramPacket(sendbuf, sendbuf.length);
                Theserver.receive(receiveClient);
                strso = new String(receiveClient.getData()).trim();
                if (strso.equals("exit")) break;
                so = Integer.parseInt(strso);
                strso=String.valueOf(giaithua(so));
                sendbuf = strso.getBytes();
                
                
                address= receiveClient.getAddress();
                port = receiveClient.getPort();
                sendClient = new DatagramPacket(sendbuf, sendbuf.length, address, port);
                Theserver.send(sendClient);
            }while (true);
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
