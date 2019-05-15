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
        ObjectOutputStream output=null;
        ObjectInputStream input=null;
        Order order;
        Java_SQL js;
        try{
            js= new Java_SQL();
            order = new Order();
            System.out.println("Server running....!!!");
            Listener=new ServerSocket(9999);
            serverSocket = Listener.accept();
            output=new ObjectOutputStream(serverSocket.getOutputStream());
            input=new ObjectInputStream(serverSocket.getInputStream());
            System.out.println("Acept :>");
            
            do {
                order = (Order) input.readObject();
                switch (order.getChoice()) {
                    case Order.Them_cau_thu_moi:
                        order.setRow(js.Themcauthu(order.getCt()));
                        output.writeObject(order);
                        break;
                    case Order.Tinh_tong_luong_thang_cua_cau_thu:
                        order.setTongluong(js.tongluong(order.getID(), order.getSotran()));
                        output.writeObject(order);
                        break;
                    case Order.Exit:
                        System.out.println("Ngắt kết nối");
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
