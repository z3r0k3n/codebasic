/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Client;

import Cau2.Server.Cauthu;
import Cau2.Server.Order;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    public void themcauthu ()
    {
        try {
            Cauthu ct = new Cauthu();
            System.out.println("Nhập ID cầu thủ: ");
            ct.setID(in.nextLine());
            System.out.println("Nhập tên cầu thủ: ");
            ct.setTen(in.nextLine());
            System.out.println("Nhập năm sinh cầu thủ (dd/MM/yyyy): ");
            String strdate = in.nextLine();
            DateFormat format= new SimpleDateFormat("dd/MM/yyyy");
            ct.setNamsinh(format.parse(strdate));
            System.out.println("Nhập vị trí thi đấu (mẫu: tiền đạo,hậu vệ,trung vệ): ");
            ct.setVitrithidau(in.nextLine());
            System.out.println("Nhập lương mạc định của cầu thủ");
            ct.setLuongmacdinh(in.nextFloat());
            in.nextLine();
            System.out.println(ct.toString());
            order.setCt(ct);
            order.setChoice(Order.Them_cau_thu_moi);
            Output.writeObject(order);
            //nhan
            order = (Order) Input.readObject();
            System.out.println("Server: ->row"+order.getRow());
        } catch (ParseException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Tongluong ()
    {
        try {
            order.setChoice(Order.Tinh_tong_luong_thang_cua_cau_thu);
            System.out.println("Nhập ID cầu thủ: ");
            order.setID(in.nextLine());
            System.out.println("Nhập số trận thu đấu: ");
            order.setSotran(in.nextInt());
            Output.writeObject(order);
            //nhận
            order = (Order) Input.readObject();
            System.out.println("Server: ->"+ order.getTongluong());
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
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
