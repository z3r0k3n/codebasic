/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in= new Scanner(System.in);
        DatagramSocket theServer = null;
        DatagramPacket receiveClient = null;
        Older older;
        byte[] receivebuf;
        ServerSocket socketServer;
        try {
            //================================================
            theServer= new DatagramSocket(9999);
            receivebuf = new byte[1024];
            receiveClient = new DatagramPacket(receivebuf, receivebuf.length);
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        //dang nhap
        while (true) 
        {
            try {
                theServer.receive(receiveClient);
                older=odin(receiveClient);

                if(older.getUser().equals("sa")&&older.getPass().equals("123"))
                {
                    older.setSend("đăng nhập thành công :>");
                    older.setUser("1");
                    theServer.send(sendPacket(older, receiveClient));
                    break;
                }
                
                else 
                {
                    older.setSend("đăng nhập không thành công TT^TT");
                    older.setUser("0");
                    theServer.send(sendPacket(older, receiveClient));
                }
                
            } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Đã chuyển qua chat :3");
        //chat
        while (true)
        {
            try {
                //nhan
                theServer.receive(receiveClient);
                older=odin(receiveClient);
                System.out.println("Client: ->"+older.getSend());
                //gui
                older.setSend(in.nextLine());
                theServer.send(sendPacket(older, receiveClient));
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    //Gửi
    public static DatagramPacket sendPacket(Older older,DatagramPacket receiveClient)
    {
        DatagramPacket sendClient=null;
        ObjectOutputStream output;
        byte[] sendbuff;
        ByteArrayOutputStream arrout;
        InetAddress address;
        int port;
        //========================================
        
        try {
            sendbuff = new byte[1024];
            arrout = new ByteArrayOutputStream();
            output = new ObjectOutputStream(arrout);
            output.writeObject(older);
            sendbuff = arrout.toByteArray();
            address = receiveClient.getAddress();
            port = receiveClient.getPort();
            sendClient = new DatagramPacket(sendbuff, sendbuff.length, address, port);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sendClient;
    }
    //Nhận
    public static Older odin (DatagramPacket receiveClient)
    {
        Older older=null;
        ByteArrayInputStream arrin;
        ObjectInputStream input;
        
        try {
            arrin = new ByteArrayInputStream(receiveClient.getData());
            input = new ObjectInputStream(arrin);
            older = (Older) input.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return older;
    }
    
}
