/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.Client;

import Java_SQL.Older;
import Java_SQL.Sach;
import RMI.Server.Interface_B4T7;
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
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Scanner in= new Scanner(System.in);
            Interface_B4T7 IB4T7;
            IB4T7 = (Interface_B4T7) Naming.lookup("rmi://localhost:9999/quanlysach");
            int i;
            do{
                System.out.println("Menu\n1.Xem sách\n2.Mươn sách\n3.Trả sách\n4.Exit\nChọn: ");
                i= in.nextInt();
                in.nextLine();
                switch (i) {
                    case Older.Xem_sach:
                        ArrayList<Sach> listBook = IB4T7.Xemdanhsach();
                        for (Sach s: listBook)
                        {
                            System.out.println(s.toString());
                        }
                        break;
                    case Older.Muon_sach:
                        System.out.println("Nhập ID: ");
                        System.out.println("Server: -> Row " + IB4T7.Muonsach(in.nextLine()));
                        break;
                    case Older.Tra_sach:
                        System.out.println("Nhập ID: ");
                        System.out.println("Server: -> Row " + IB4T7.Trasach(in.nextLine()));
                        break;
                    case Older.Ngat_ket_noi:
                        System.out.println("Ngắt kết nối");
                        break;
                    default:
                        System.out.println("Mục Bạn vừa chọn không có trong menu");;
                        break;
                }
            }while (i!=4);
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
