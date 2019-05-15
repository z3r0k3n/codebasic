/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Client;

import Cau2.Server.Khachhang;
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
    private Scanner in= new Scanner(System.in);
    private Socket clientSocket=null;
    private ObjectOutputStream Output=null;
    private ObjectInputStream Input=null;
    private Order order = new Order();
    public Manager() {
        try {
            clientSocket=new Socket("localhost", 9999);
            Output=new ObjectOutputStream(clientSocket.getOutputStream());
            Input=new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Themkh()
    {
        Khachhang kh = new Khachhang();
        System.out.println("Nhập ID");
        kh.setID(in.nextLine());
        System.out.println("Nhập Tên khách hàng: ");
        kh.setTen_khach_hang(in.nextLine());
        System.out.println("Nhập điểm");
        kh.setLoai_phong(in.nextLine());
        order.setChoice(Order.Them_khach_hang);
        order.setKh(kh);
        try {
            Output.writeObject(order);
            
            order = (Order) Input.readObject();
            System.out.println("Server: ->Row: "+ order.getRow());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Tinhtien()
    {
        System.out.println("Nhập Tên khách hàng: ");
        order.setTen(in.nextLine());
        System.out.println("Nhập số ngày thuê phòng: ");
        order.setDay(in.nextInt());
        try {
            order.setChoice(Order.Tinh_tien_phong);
            Output.writeObject(order);
            
            order = (Order) Input.readObject();
            System.out.println("Tổng tiền phòng là: "+order.getTien());
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
            Output.writeObject(order);
            System.out.println("Ngắt kết nối");
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
