/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.Client;

import Java_SQL.Older;
import Java_SQL.Sach;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Manager {
    private byte[] receivebuf;
    private DatagramPacket receiveServer;
    private DatagramSocket theClient;
    private Older older;
    private Scanner in = new Scanner(System.in);
    public Manager() {
        try {
            older = new Older();
            theClient = new DatagramSocket();
            receivebuf = new byte[1024];
            receiveServer = new DatagramPacket(receivebuf, receivebuf.length);
            
        } catch (SocketException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Xemsach ()
    {
        try {
            //gui
            older.setChoice(Older.Xem_sach);
            theClient.send(sendPacket(older));
            //nhan
            theClient.receive(receiveServer);
            older = odin(receiveServer);
            ArrayList<Sach> listBook = older.getListB();
            for (Sach s : listBook)
            {
                System.out.println("Server: ->"+s.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Muonsach()
    {
        try{
            older.setChoice(Older.Muon_sach);
            System.out.println("Nhập ID: ");
            older.setID(in.nextLine());
            theClient.send(sendPacket(older));
            //nhan
            theClient.receive(receiveServer);
            older = odin(receiveServer);
            System.out.println("Client: -> row"+older.getChoice());
            
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void Trasach()
    {
        try{
            //gui
            older.setChoice(Older.Tra_sach);
            System.out.println("Nhập ID: ");
            older.setID(in.nextLine());
            theClient.send(sendPacket(older));
            //nhan
            theClient.receive(receiveServer);
            older = odin(receiveServer);
            System.out.println("Server: ->"+older.getChoice());
            
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //gui
    private DatagramPacket sendPacket(Older older)
    {
        DatagramPacket sendServer = null;
        byte[] sendbuf;
        ByteArrayOutputStream arrout;
        ObjectOutputStream output;
        InetAddress address;
        
        try{
            address = InetAddress.getLocalHost();
            arrout = new ByteArrayOutputStream();
            output = new ObjectOutputStream(arrout);
            output.writeObject(older);
            sendbuf = arrout.toByteArray();
            sendServer = new DatagramPacket(sendbuf, sendbuf.length, address, 9999);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sendServer;
    }
    //nhan
    private Older odin (DatagramPacket receiveServer)
    {
        
        ByteArrayInputStream arrin;
        ObjectInputStream input;
        
        try{
            
            arrin = new ByteArrayInputStream(receiveServer.getData());
            input = new ObjectInputStream(arrin);
            older = (Older) input.readObject();
            
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return older;
    }
}
