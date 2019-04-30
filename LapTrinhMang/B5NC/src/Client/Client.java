/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Server.Iml_B5NC;
import Server.SanPham;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
            Iml_B5NC ib= new Iml_B5NC();
            ib = (Iml_B5NC) Naming.lookup("rmi://localhost:9999/Game");
            SanPham sp = ib.Laysanpham();
            int i=1;
            double gia;
            System.out.println("Sản phẩm đoán giá lần này là :"+sp.getTenSP());
            do {
                System.out.println("Nhập Giá cho sản phâm lần "+i+": ");
                gia=in.nextDouble();
                if (ib.doangia(gia, sp).equals("-1"))
                {
                    System.out.println("Giá bạn đứa ra thấp hơn giá của sản phẩm!!!");
                }
                else if (ib.doangia(gia, sp).equals("1"))
                {
                    System.out.println("Giá bạn đưa ra lớn hơn giá sản phẩm !!!");
                }
                else
                {
                    System.out.println("Giá bạn nhập chính xác giá sản phẩm");
                    break;
                }
                i++;
            } while (i!=7);
            if (i==7) System.out.println("Bạn đã thua giá của sản phẩm là: "+sp.getGia());
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
