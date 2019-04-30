/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.BufferedReader;
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
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in= new Scanner(System.in);
        DatagramPacket receiveServer;
        DatagramSocket theclient;
        byte[] receivebuf;
        Older older;
        //========================================
        try{
            older=new Older();
            theclient= new DatagramSocket();
            receivebuf = new byte[1024];
            receiveServer = new DatagramPacket(receivebuf, receivebuf.length);
            //dang nhap
            do{
                System.out.println("Nhập user: ");
                older.setUser(in.nextLine());
                System.out.println("Nhập pass: ");
                older.setPass(in.nextLine());
                theclient.send(sendPacket(older));
                
                theclient.receive(receiveServer);
                older = odin(receiveServer);
                System.out.println("Server: ->"+older.send);
            }while (older.getUser().equals("0"));
            //chat
            System.out.println("Chuyển qua chế độ chat.");
            while (true) {
                older.setSend(in.nextLine());
                theclient.send(sendPacket(older));
                
                theclient.receive(receiveServer);
                older= odin(receiveServer);
                System.out.println("Server: ->"+older.send);
            }
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //nhan
    public static Older odin (DatagramPacket receiveServer)
    {
        Older older=null;
        ByteArrayInputStream arrin;
        ObjectInputStream input;
        //=============
        try{
            arrin= new ByteArrayInputStream(receiveServer.getData());
            input = new ObjectInputStream(arrin);
            older = (Older) input.readObject();
        }catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return older;
    }
    //gui
    public static DatagramPacket sendPacket(Older older)
    {
        DatagramPacket sendClient=null;
        ObjectOutputStream output;
        ByteArrayOutputStream arrout;
        InetAddress address = null;
        byte[] sendbuf;
        int port = 0;
        //=====================
        try{
            sendbuf= new byte[1024];
            arrout = new ByteArrayOutputStream();
            output = new ObjectOutputStream(arrout);
            output.writeObject(older);
            sendbuf = arrout.toByteArray();
            address = InetAddress.getLocalHost();
            port = 9999;
            sendClient = new DatagramPacket(sendbuf, sendbuf.length, address, port);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sendClient;
    }
    static class input extends Thread()
    {
        BufferedReader
    }
}

