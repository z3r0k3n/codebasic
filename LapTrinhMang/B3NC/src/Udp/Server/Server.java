/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Udp.Server;

import Java_SQL.Hoadon;
import Java_SQL.Java_SQL;
import Java_SQL.Older;
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
import java.util.ArrayList;
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
        byte[] receivebuf;
        DatagramSocket theServer;
        DatagramPacket receiveClient;
        Older older= new Older();
        double tongtien = 0;
        try {
            // TODO code application logic here
            theServer = new DatagramSocket(9999);
            receivebuf = new byte[1024];
            receiveClient = new DatagramPacket(receivebuf, receivebuf.length);
            Java_SQL js = new Java_SQL();
            do {
                theServer.receive(receiveClient);
                older = unbox(receiveClient);
                switch (older.getChoice()) {
                    case Older.TIM_KIEM_SAN_PHAM:
                        older.setListsp(js.listSP(older.getID()));
                        theServer.send(packetbox(older, receiveClient));
                        break;
                    case Older.LAP_HOA_DON:
                        older.setHD(js.giatien(older.getHD()));
                        for (Hoadon hd: older.getHD())
                        {
                            tongtien +=hd.getThanh_tien();
                        }
                        older.setTongtien(tongtien);
                        theServer.send(packetbox(older, receiveClient));
                        break;
                }
            } while (true);
            
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Tách packet nhận được thành các object của older;
    public static Older unbox (DatagramPacket receiveClient)
    {
        Older older = new Older();
        ObjectInputStream input;
        ByteArrayInputStream arrin;
        //=======================================
        try{
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
    //đóng gói packet để gui di
    public static DatagramPacket packetbox (Older older, DatagramPacket receiveClient)
    {
        DatagramPacket sendClient = null;
        ObjectOutputStream output;
        byte[] sendbuf;
        ByteArrayOutputStream arrout;
        InetAddress address;
        int port;
        //==================================================
        try{
            sendbuf = new byte[1024];
            arrout = new ByteArrayOutputStream();
            output = new ObjectOutputStream(arrout);
            output.writeObject(older);
            sendbuf = arrout.toByteArray();
            address = receiveClient.getAddress();
            port = receiveClient.getPort();
            sendClient = new DatagramPacket(sendbuf, sendbuf.length, address, port);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sendClient;
    }
    
}
