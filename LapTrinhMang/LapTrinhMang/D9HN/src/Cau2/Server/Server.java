/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Server;

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
public class Server {/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatagramSocket theServer;
        DatagramPacket receiveClient;
        Order order = null;
        byte[] receivebuf = new byte[1024];
        //================================
        try{
            order= new Order();
            theServer = new DatagramSocket(9999);
            receiveClient = new DatagramPacket(receivebuf, receivebuf.length);
            do {
                theServer.receive(receiveClient);
                
            } while (order.getChoice()!= order.e);
            
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DatagramPacket packetbox (Order od,DatagramPacket receiveClient)
    {
        DatagramPacket sendClient = null;
        byte[] sendbuf = new byte[1024];
        ByteArrayOutputStream arrout;
        ObjectOutputStream output;
        InetAddress address;
        int port;
        //======================
        try{
            arrout = new ByteArrayOutputStream();
            output = new ObjectOutputStream(arrout);
            address = receiveClient.getAddress();
            port = receiveClient.getPort();
            output.writeObject(od);
            sendbuf = arrout.toByteArray();
            sendClient = new DatagramPacket(sendbuf, sendbuf.length, address, port);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sendClient;
    }
    
    public Order unbox (DatagramPacket receivePacket)
    {
        Order od= new Order();
        byte[] receivebuf = new byte[1024];
        ByteArrayInputStream arrin;
        ObjectInputStream input;
        //=================================================
        try{
            arrin = new ByteArrayInputStream(receivePacket.getData());
            input = new ObjectInputStream(arrin);
            od = (Order) input.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return od;
    }
}