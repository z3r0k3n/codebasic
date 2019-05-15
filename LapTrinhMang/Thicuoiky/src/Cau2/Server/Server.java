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
        ServerSocket listener;
        Socket socketServer;
        ObjectOutputStream output;
        ObjectInputStream input;
        Order order = new Order();
        Java_SQL js= new Java_SQL();
        //============================
        try{
            System.out.println("Server running ...");
            listener = new ServerSocket(9999);
            socketServer = listener.accept();
            output = new ObjectOutputStream(socketServer.getOutputStream());
            input = new ObjectInputStream(socketServer.getInputStream());
            System.out.println("Accepted :>");
            do {
                order = (Order) input.readObject();
                System.out.println(order.getViet());
                switch (order.getChoice()) {
                    case Order.Anh_viet:
                        order.setViet(js.Anh_viet(order.getAnh()));
                        output.writeObject(order);
                        break;
                    case Order.Viet_anh:
                        order.setAnh(js.Viet_anh(order.getViet()));
                        output.writeObject(order);
                        break;
                    case Order.Anh_ngia:
                        order.setNghia(js.Anh_Nghia(order.getAnh()));
                        output.writeObject(order);
                        break;
                    case Order.Exit:
                        System.out.println("Đã ngắt kết nối");
                        break;
                    
                }
            } while (order.getChoice()!=Order.Exit);
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
