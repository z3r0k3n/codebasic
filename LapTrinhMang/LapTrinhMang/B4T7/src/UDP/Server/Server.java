/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.Server;

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
import java.net.SocketException;
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
        DatagramSocket theServer;
        DatagramPacket receiveClient;
        Older older;
        byte[] receivebuf;
        Java_SQL js = new Java_SQL();
        //==================================
        try{
            System.out.println("Server running ...");
            older = new Older();
            theServer = new DatagramSocket(9999);
            receivebuf = new byte[1024];
            receiveClient= new DatagramPacket(receivebuf, receivebuf.length);
            
            do{
                theServer.receive(receiveClient);
                older = odin(receiveClient);
                switch (older.getChoice()) {
                    case Older.Xem_sach:
                        older.setListB(js.listBook());
                        theServer.send(sendPacket(older, receiveClient));
                        break;
                    case Older.Muon_sach:
                        older.setChoice(js.Muon_sach(older.getID()));
                        System.out.println(older.getChoice());
                        theServer.send(sendPacket(older, receiveClient));
                        break;
                    case Older.Tra_sach:
                        older.setChoice(js.Tra_sach(older.getID()));
                        theServer.send(sendPacket(older, receiveClient));
                        break;
                }
            }while (true);
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //gui
    public static DatagramPacket sendPacket(Older older, DatagramPacket receiveClient)
    {
        DatagramPacket sendClient = null;
        ByteArrayOutputStream arrout;
        byte[] sendbuf;
        ObjectOutputStream output;
        InetAddress address;
        int port;
        
        
        try{
            arrout = new ByteArrayOutputStream();
            output = new ObjectOutputStream(arrout);
            sendbuf = new byte[1024];
            address = receiveClient.getAddress();
            port=receiveClient.getPort();
            output.writeObject(older);
            sendbuf = arrout.toByteArray();
            sendClient= new DatagramPacket(sendbuf, sendbuf.length, address, port);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sendClient;
    }
    
    //gui
    private static Older odin (DatagramPacket receiveClient)
    {
        Older older=null;
        ByteArrayInputStream arrin;
        ObjectInputStream input;
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
}
