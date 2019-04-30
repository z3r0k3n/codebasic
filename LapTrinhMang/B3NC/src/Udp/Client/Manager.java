/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Udp.Client;

import Java_SQL.Hoadon;
import Java_SQL.Older;
import Java_SQL.SanPham;
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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Manager {
    private DatagramSocket theClient;

    private DatagramPacket receiveserver;
   
    private byte[] receivebuf;


    private Older older = new Older();
    private Scanner in= new Scanner(System.in);
    public Manager() {
        try {
            theClient= new DatagramSocket();
            receivebuf = new byte[1024];
            receiveserver = new DatagramPacket(receivebuf,receivebuf.length);
        } catch (SocketException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void timkiem()
    {
        try {
            older.setChoice(Older.TIM_KIEM_SAN_PHAM);
            System.out.println("Nhập ID:");
            older.setID(in.nextLine());
            theClient.send(packetbox(older));
            
            theClient.receive(receiveserver);
            older = unbox(receiveserver);
            for (SanPham sp: older.getListsp())
            {
                System.out.println(sp.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hoadon()
    {
        older.setChoice(Older.LAP_HOA_DON);
        ArrayList<Hoadon> listhd=new ArrayList<>();
        try {
            String ID;
            
            do {
                Hoadon Hd = new Hoadon();
                System.out.println("Nhập ID:");
                ID = in.nextLine();
                if (ID.equals("exit")) break;
                Hd.setID(ID);
                System.out.println("Nhập Số lượng: ");
                Hd.setSoluong(in.nextInt());
                in.nextLine();
                listhd.add(Hd);
            } while (true);
            older.setHD(listhd);
            theClient.send(packetbox(older));
            
            theClient.receive(receiveserver);
            older = unbox(receiveserver);
            for (Hoadon h: older.getHD())
            {
                System.out.println(h.toString());
            }
            System.out.println("Tổng tiền: "+older.getTongtien());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DatagramPacket packetbox(Older oder)
    {
        byte[] sendbuf = new byte[1024];
        InetAddress address;
        ByteArrayOutputStream arrout;
        ObjectOutputStream output;
        DatagramPacket sendServer = null;
        try {
            address= InetAddress.getLocalHost();
            arrout= new ByteArrayOutputStream();
            output = new ObjectOutputStream(arrout);
            output.writeObject(oder);
            sendbuf = arrout.toByteArray();
            sendServer = new DatagramPacket(sendbuf, sendbuf.length, address, 9999);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sendServer;
    }
    
    public Older unbox (DatagramPacket receivepacket)
    {
        Older od= new Older();
        ByteArrayInputStream arrin;
        ObjectInputStream input;
        try {
            
            arrin = new ByteArrayInputStream(receivepacket.getData());
            input = new ObjectInputStream(arrin);
            od = (Older) input.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return od;
    }
    
}
