/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

/**
 *
 * @author ASM
 */
import java.util.HashSet;
import java.util.Scanner;
public class Bai4 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner (System.in);
        NganHang nh1= new NganHang (111111,"ABC",1234);
        NganHang nh2= new NganHang (222222,"ASD");
        NganHang nh3= new NganHang ();
        nh1.NapTien(1000000);
        nh2.RutTien(25);
        System.out.printf ("Nhập Số Tài Khoản: ");
        nh3.setSoTK(in.nextLong());
        System.out.printf ("Nhập Tên Tài Khoản: ");
        nh3.setTenTK(in.next());
        System.out.printf ("Nhập Số Tiền Trong Tài Khoản: ");
        nh3.setSoTien(in.nextDouble());
        nh3.DaoHan();
        System.out.println(nh1.ToString());
        System.out.println(nh2.ToString());
        System.out.println(nh3.ToString());
    }
    
}
