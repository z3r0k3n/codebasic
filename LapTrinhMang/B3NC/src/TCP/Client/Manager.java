/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.Client;

import Java_SQL.Hoadon;
import Java_SQL.Older;
import Java_SQL.SanPham;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Array;
import java.util.ArrayList;
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
    private ArrayList<Hoadon> listHD= new ArrayList<>();
    private ArrayList<SanPham> listSP= new ArrayList<>();
    private Older older= new Older();
    private Scanner in = new Scanner(System.in);
    public Manager() {
        try {
            socketClient = new Socket("localhost", 9999);
            output = new ObjectOutputStream(socketClient.getOutputStream());
            input = new ObjectInputStream(socketClient.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void timkiem ()
    {
        try {
            //gui
            older.setChoice(Older.TIM_KIEM_SAN_PHAM);
            System.out.println("Tìm kiếm sản phẩm:\nNhập ID:");
            older.setID(in.nextLine());
            output.writeObject(older);
            //nhan
            older =(Older)input.readObject();
            listSP = older.getListsp();
            for (SanPham sp : listSP)
            {
                System.out.println(sp.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hoadon ()
    {
        try {
            //gui
            older.setChoice(Older.LAP_HOA_DON);
            System.out.println("Tạo hóa đơn: ");
            String ID="";
            
            do {
                Hoadon hd = new Hoadon();
                System.out.println("Nhập ID:");
                ID=in.nextLine();
                if (ID.equals("exit")) break;
                hd.setID(ID);
                System.out.println("Nhập số lượng");
                hd.setSoluong(in.nextInt());
                in.nextLine();
                listHD.add(hd);
            } while (true);
            
            older.setHD(listHD);
            output.writeObject(older);
            //nhan
            older = (Older) input.readObject();
            for (Hoadon HD:older.getHD()) {
                System.out.println(HD.toString());
            }
            System.out.println("Tổng tiền: "+older.getTongtien());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Exit()
    {
        try {
            older.setChoice(Older.EXIT);
            output.writeObject(older);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
