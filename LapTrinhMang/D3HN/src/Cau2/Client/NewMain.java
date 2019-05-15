/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Client;

import Cau2.Server.Order;
import Cau2.Server.Server;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DatagramSocket theClient = null;
        DatagramPacket receiveClient = null;
        byte[] receivebuf = new byte[1024];
        Order order = new Order();
        Scanner in = new Scanner(System.in);
        //==================================================
        try{
            
            theClient = new DatagramSocket();
            receiveClient = new DatagramPacket(receivebuf, receivebuf.length);
            do {
                //dang nhap
                //gui
                System.out.println("Đăng nhập: \nUser name:");
                order.setUser(in.nextLine());
                System.out.println("Password: ");
                order.setPass(in.nextLine());
                theClient.send(packetbox(order));
                //nhan
                theClient.receive(receiveClient);
                order = unbox(receiveClient);
                if (order.isKq()==true)
                {
                    System.out.println("Đăng nhập thành công :>");
                    break;
                }
                else System.out.println("Đăng nhập không thành công vui lòng kiểm tra lại :<");
            } while (true);
            System.out.println("Chat ready !!!!");

        } catch (SocketException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //luông gui
        new send(theClient);
        //luông nhận
        new read(theClient);
        
    }
    //gui
    public static DatagramPacket packetbox (Order order)
    {
        ObjectOutputStream output = null;
        byte[] sendbuf = new byte[1024];
        InetAddress address = null;
        int port = 9999;
        try {
            address = InetAddress.getLocalHost();
            ByteArrayOutputStream arrout = new ByteArrayOutputStream();
            output = new ObjectOutputStream(arrout);
            output.writeObject(order);
            sendbuf = arrout.toByteArray();
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        DatagramPacket sendClient= new DatagramPacket(sendbuf,sendbuf.length, address, port);
        return sendClient;
    }
    
    //để tách object từ packet
    public static Order unbox (DatagramPacket receiveClient)
    {
        Order od = new Order();
        ByteArrayInputStream arrin= new ByteArrayInputStream(receiveClient.getData());
        try {
            ObjectInputStream input = new ObjectInputStream(arrin);
            od = (Order) input.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return od;
    }
    
    //Luồng nhận
    static class read extends Thread
    {
        byte[] readbuf = new byte[1024];
        String readstr;
        DatagramPacket receivepacket;
        DatagramSocket socketClient;

        public read(DatagramSocket theSV) {
            socketClient = theSV;
            receivepacket = new DatagramPacket(readbuf, readbuf.length);
            start();
        }
        
        
        @Override
        public void run ()
        {
            do {
            try {
                socketClient.receive(receivepacket);
                readstr = new String (receivepacket.getData());
                System.out.println("Server: ->"+readstr);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            } while (true);
        }
    }
    //tạo luồng gửi
    static class send extends Thread
    {
        byte[] sendbuf = new byte[1024];
        String sendstr;
        DatagramPacket sendPacket;
        DatagramSocket socketSV;
        Scanner in= new Scanner(System.in);
        InetAddress address;
        public send(DatagramSocket theSV) {
            socketSV= theSV;
            try {
                address = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            start();
        }
        
        @Override
        public void run()
        {
            while (true) {
                try {
                    System.out.println("Client: ");
                    sendstr = in.nextLine();
                    sendbuf = sendstr.getBytes();
                    sendPacket = new DatagramPacket(sendbuf, sendbuf.length, address, 9999);
                    socketSV.send(sendPacket);
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
