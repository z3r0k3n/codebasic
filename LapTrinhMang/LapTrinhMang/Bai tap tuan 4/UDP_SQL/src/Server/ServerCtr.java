/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import java_sql.Java_SQl;
import java_sql.Older;





/**
 *
 * @author Zero Ken
 */
public class ServerCtr {
    
    public static DatagramPacket sendPacket(Older odin,DatagramPacket receivePacket)
    {
        ObjectOutputStream output= null;
        DatagramPacket sendClient= null;
        try {
            byte[] sendBuff= new byte[1024];
            ByteArrayOutputStream arrayout= new ByteArrayOutputStream();
            output = new ObjectOutputStream(arrayout);
            output.writeObject(odin);
            sendBuff= arrayout.toByteArray();
            InetAddress address= receivePacket.getAddress();
            int port= receivePacket.getPort();
            sendClient= new DatagramPacket(sendBuff, sendBuff.length, address, port);
             } catch (IOException ex) {
            Logger.getLogger(ServerCtr.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerCtr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sendClient;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            // TODO code application logic here
            DatagramSocket theServer = null;
            DatagramPacket receiveClient = null;
            ObjectInputStream input = null;
            ByteArrayInputStream arrin;
            Older older= new Older();
            byte[] receiveBuff = null;
            java_sql.Java_SQl js = new Java_SQl();
        try {
            //==================================================================
            theServer= new DatagramSocket(9999);
            receiveBuff= new byte[1024];
            receiveClient= new DatagramPacket(receiveBuff, receiveBuff.length);
        } catch (SocketException ex) {
            Logger.getLogger(ServerCtr.class.getName()).log(Level.SEVERE, null, ex);
        }
            //==================================================================
            while (true)
            {
            try {
            //test
            //nhận
            theServer.receive(receiveClient);
            arrin= new ByteArrayInputStream(receiveClient.getData());
            input= new ObjectInputStream(arrin);
            older=(Older)input.readObject();
            //gửi
            switch(older.getChoice())
            {
                case Older.Xem_danh_sach_sinh_vien:
                    older.setListSv(js.Xemdanhsach());
                    theServer.send(sendPacket(older, receiveClient));
                    break;
                case Older.Them_mot_sinh_vien:
                    older.setRow(js.Themsinhvien(older.getSv()));
                    theServer.send(sendPacket(older, receiveClient));
                    break;
                case Older.Xoa_mot_sinh_vien:
                    older.setRow(js.xoasinhvien(older.getThongbao()));
                    theServer.send(sendPacket(older, receiveClient));
                    break;
                case Older.Cap_nhap_mot_sinh_vien:
                    older.setRow(js.Capnhapsinhvien(older.getSv()));
                    theServer.send(sendPacket(older, receiveClient));
                    break;
                case Older.Tim_kiem_mot_sinh_vien:
                    older.setListSv(js.Timsinhvien(older.getThongbao()));
                    theServer.send(sendPacket(older, receiveClient));
                    break;
            }
            /*js= new Java_SQl();
            older.setListSv(js.Xemdanhsach());
            theServer.send(sendPacket(older, receiveClient));*/
            } catch (UnknownHostException ex) {
            Logger.getLogger(ServerCtr.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            Logger.getLogger(ServerCtr.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (ClassNotFoundException ex) {
                    Logger.getLogger(ServerCtr.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        
    }
    
}
