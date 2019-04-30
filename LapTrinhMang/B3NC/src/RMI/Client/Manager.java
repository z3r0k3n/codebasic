/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.Client;

import Java_SQL.Hoadon;
import Java_SQL.Older;
import Java_SQL.SanPham;
import RMI.Server.B3NC_Interface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Manager {
    private Scanner in= new Scanner(System.in);
    private B3NC_Interface bi;
    private Older older;

    public Manager() {
        try {
            bi = (B3NC_Interface) Naming.lookup("rmi://localhost:9999/cuahang");
            older = new Older();
        } catch (NotBoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Timkiem ()
    {
        try {
            System.out.println("Nhập ID: ");
            older.setID(in.nextLine());
            ArrayList<SanPham> listSP = bi.listSP(older.getID());
            for (SanPham spp: listSP) {
                System.out.println(spp.toString());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Laphoadon()
    {
        try {
            ArrayList<Hoadon> listhoadon = new ArrayList<>();
            String id;
            do {
                Hoadon hd = new Hoadon();
                System.out.println("Nhập ID: ");
                id=in.nextLine();
                if (id.equals("exit")) break;
                hd.setID(id);
                System.out.println("Nhập số lượng: ");
                hd.setSoluong(in.nextInt());
                in.nextLine();
                listhoadon.add(hd);
            } while (true);
            
            listhoadon = bi.Taohoadon(listhoadon);
            double tongtien=0;
            for (Hoadon hd: listhoadon)
            {
                System.out.println(hd.toString());;
                tongtien+=hd.getThanh_tien();
            }
            System.out.println("Tổng tiền: "+tongtien);
            
        } catch (RemoteException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
