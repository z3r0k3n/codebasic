/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.Server;

import Java_SQL.Hoadon;
import Java_SQL.Java_SQL;
import Java_SQL.Older;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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
        // TODO code application logic here
        ServerSocket listener;
        Socket socketServer;
        ObjectOutputStream output;
        ObjectInputStream input;
        Older older;
        Java_SQL js;
        double tongtien=0;
        //=================================
        try{
            System.out.println("Server running ...");
            js=new Java_SQL();
            listener = new ServerSocket(9999);
            socketServer = listener.accept();
            output = new ObjectOutputStream(socketServer.getOutputStream());
            input = new ObjectInputStream(socketServer.getInputStream());
            System.out.println("Accept");
            do{
                older = (Older) input.readObject();
                switch (older.getChoice()) {
                    case Older.TIM_KIEM_SAN_PHAM:
                        older.setListsp(js.listSP(older.getID()));
                        output.writeObject(older);
                        break;
                    case Older.LAP_HOA_DON:
                        older.setHD(js.giatien(older.getHD()));
                        for (Hoadon hd: older.getHD())
                        {
                            tongtien += hd.getThanh_tien();
                        }
                        older.setTongtien(tongtien);
                        output.writeObject(older);
                        break;
                    case Older.EXIT:
                        System.out.println("Ngắt kết nối");
                        break;
                }
            }while (older.getChoice() != Older.EXIT);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
