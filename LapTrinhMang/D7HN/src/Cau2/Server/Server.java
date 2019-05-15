/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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
        ServerSocket Listener=null;
        Socket serverSocket=null;
        ObjectOutputStream Output=null;
        ObjectInputStream Input=null;
        Order order = new Order();
        //=========================================
        Java_SQL js = new Java_SQL();
        //=========================================================================================================
  
        try {
            System.out.println("Server running....!!!");
            Listener=new ServerSocket(9999);
            serverSocket = Listener.accept();
            Output=new ObjectOutputStream(serverSocket.getOutputStream());
            Input=new ObjectInputStream(serverSocket.getInputStream());
            System.out.println("Acept :>");
            
            do {
                order = (Order) Input.readObject();
                switch (order.getChoice()) {
                    case Order.Them_khach_hang:
                        order.setRow(js.Themkh(order.getKh()));
                        Output.writeObject(order);
                        break;
                    case Order.Tinh_tien_phong:
                        order.setTien(js.Tongtien(order.getTen(), order.getDay()));
                        Output.writeObject(order);
                        break;
                    case Order.Exit:
                        System.out.println("Ngắt kết nối");
                        break;
                }
            } while (order.getChoice()!= Order.Exit);
            
        }   catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
