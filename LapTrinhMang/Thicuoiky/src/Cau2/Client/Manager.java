/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Client;

import Cau2.Server.Order;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Manager {
    private Socket socketClient;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Order order = new Order();
    private Scanner in= new Scanner(System.in);

    public Manager() {
        try {
            socketClient = new Socket("localhost", 9999);
            output = new ObjectOutputStream(socketClient.getOutputStream());
            input = new ObjectInputStream(socketClient.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Anh_viet()
    {
        try {
            //gử
            System.out.println("Nhập từ tiếng anh bạn cần tra: ");
            order.setAnh(in.nextLine());
            order.setChoice(Order.Anh_viet);
            output.writeObject(order);
            //Nhận
            order = (Order) input.readObject();
            System.out.println("Server: ->"+order.getViet());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Viet_anh()
    {
        try {
            //gử
            System.out.println("Nhập từ tiếng Việt bạn cần tra: ");
            order.setViet(in.nextLine());
            order.setChoice(Order.Viet_anh);
            output.writeObject(order);
            //Nhận
            order = (Order) input.readObject();
            System.out.println("Server: ->"+order.getAnh());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Anh và nghĩa
    public void Anh_nghia()
    {
        try {
            //gử
            System.out.println("Nhập từ tiếng anh bạn cần tra: ");
            order.setAnh(in.nextLine());
            order.setChoice(Order.Anh_ngia);
            output.writeObject(order);
            //Nhận
            order = (Order) input.readObject();
            System.out.println("Server: ->"+order.getNghia());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void exit ()
    {
        try {
            order.setChoice(Order.Exit);
            output.writeObject(order);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
