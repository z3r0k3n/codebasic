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
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.html.HTML;

/**
 *
 * @author Zero Ken
 */
public class Server_UDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatagramPacket sendClient = null;
        DatagramPacket receiveClient;
        DatagramSocket theServer = null;
        InetAddress address;
        byte[] buf=null;
        byte[] sendbuf=null;
        int port;
        ServerSocket socketServer;
        String receivestr;
        String sendsr;
        //======================================================================
        buf= new byte[1024];
        sendbuf = new byte[1024];
        receiveClient = new DatagramPacket(buf, buf.length);
        try {
            theServer= new DatagramSocket(9999);
            System.out.println("Server running....");
        } catch (IOException ex) {
            Logger.getLogger(Server_UDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {            
        
        try {
            theServer.receive(receiveClient);
            receivestr= new String (receiveClient.getData(),0,receiveClient.getLength()).trim();
            System.out.println(receivestr);
            sendsr= INT_String(receivestr);
            System.out.println(sendsr);
            sendbuf = sendsr.getBytes();
            address = receiveClient.getAddress();
            port= receiveClient.getPort();
            sendClient= new DatagramPacket(sendbuf, sendbuf.length, address, port);
            theServer.send(sendClient);
        } catch (IOException ex) {
            Logger.getLogger(Server_UDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    }
    
    public static String INT_String (String no)
    {
        String kq="";
        switch (no) {
            case "0":
                kq="Không";
                break;
            case "1":
                kq="Một";
                break;
            case "2":
                kq="Hai";
                break;
            case "3":
                kq="Ba";
                break;
            case "4":
                kq="Bốn";
                break;
            case "5":
                kq="Năm";
                break;
            default:
                kq="Số vừa nhập không nằm trong khoảng từ 0 đến 5";
                break;
        }
        return kq;
    }
    
}
