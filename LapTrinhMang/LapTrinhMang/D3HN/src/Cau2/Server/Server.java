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
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Server {
    private static InetAddress ad;
    private static int p;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Java_SQL js = new Java_SQL();
        Boolean kt = null;
        DatagramSocket theServer = null;
        DatagramPacket receiveClient;
        byte[] receivebuf = new byte[1024];
        Order order = new Order();
        String setPass;
        //========================================
        try{
            System.out.println("Server running...");
            theServer = new DatagramSocket(9999);
            receiveClient = new DatagramPacket(receivebuf, receivebuf.length);
            
        
            // đăng nhập
            do {
                theServer.receive(receiveClient);
                order = unbox(receiveClient);
                setPass = js.Dangnhap(order.getUser()).trim();
                System.out.println(setPass);
                System.out.println(order.getUser()+"|"+order.getPass());
                if (order.getPass().equals(setPass))
                {
                    kt =true;
                    order.setKq(kt);
                    theServer.send(packetbox(order, receiveClient));
                    break;
                }
                else
                {
                    kt = false;
                    order.setKq(kt);
                    theServer.send(packetbox(order, receiveClient));
                }
                System.out.println(kt);
            } while (true);
            System.out.println("=> connected\n=> Chat ready");
           
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //chat
            //luồng nhận
            new read(theServer);
            //luồng gui
            new send(theServer);
        
    }
    //đóng gói packet để gui di
    public static DatagramPacket packetbox (Order order,DatagramPacket receiveClient)
    {
        ObjectOutputStream output = null;
        byte[] sendbuf = new byte[1024];
        ad = receiveClient.getAddress();
        p = receiveClient.getPort();
        try {
            
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
        DatagramPacket sendClient= new DatagramPacket(sendbuf,sendbuf.length, ad, p);
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
    //tạo luồng nhận
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
                System.out.println("Client: ->"+readstr);
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
            while (true){
                try {
                    System.out.println("Server: ");
                    sendstr = in.nextLine();
                    sendbuf = sendstr.getBytes();
                    sendPacket = new DatagramPacket(sendbuf, sendbuf.length, ad, p);
                    socketSV.send(sendPacket);
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
