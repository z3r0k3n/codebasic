/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Client;

import Cau2.Server.Order;
import Cau2.Server.Server;
import Cau2.Server.Thuvien;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class Manager {
    private DatagramSocket theClient;
    private DatagramPacket packetServer;
    private byte[] receivebuf;
    private Order order = new Order();
    private Scanner in = new Scanner(System.in);
    public Manager() { 
        try {
            receivebuf = new byte[1024];
            theClient= new DatagramSocket();
            packetServer = new DatagramPacket(receivebuf, receivebuf.length);
        } catch (SocketException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Xemlist ()
    {
        order.setChoice(Order.Xem_Danh_Sach);
        try {
            theClient.send(packetbox(order));
            
            theClient.receive(packetServer);
            order = unbox(packetServer);
            for (Thuvien tv: order.getListsach())
            {
                System.out.println(tv.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Muonsach ()
    {
        order.setChoice(Order.Muon_Sach);
        System.out.println("Nhập sách cần Mượn");
        order.setTensach(in.nextLine());
        System.out.println("Nhập Người mượn: ");
        order.setNguoinhan(in.nextLine());
        try {
            theClient.send(packetbox(order));
            
            theClient.receive(packetServer);
            order = unbox(packetServer);
            System.out.println("Server: ->Row: "+order.getRow());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void exit ()
    {
        try {
            order.setChoice(Order.Exit);
            theClient.send(packetbox(order));
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DatagramPacket packetbox (Order od)
    {
        DatagramPacket sendServer = null;
        byte[] sendbuf = new byte[1024];
        ByteArrayOutputStream arrout;
        ObjectOutputStream output;
        InetAddress address;
        int port =9999;
        //======================
        try{
            arrout = new ByteArrayOutputStream();
            output = new ObjectOutputStream(arrout);
            address = InetAddress.getLocalHost();
            
            output.writeObject(od);
            sendbuf = arrout.toByteArray();
            sendServer = new DatagramPacket(sendbuf, sendbuf.length, address, port);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sendServer;
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
