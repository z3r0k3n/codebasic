/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Client;

import Cau2.Server.mayint_inf;
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
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        mayint_inf remote;
        double  a,b;
        int c,d;
        int choice = 0;
        try {
            remote = (mayint_inf) Naming.lookup("rmi://localhost:9999/maytinh");
            while (choice != 6 ) {
                System.out.println("Menu:\n1:Cộng\n2.Trừ\n3.Nhân\n4.Chia\n5.Tính ước chung lớn nhất\n6.Exit\nChọn: ");
                choice = in.nextInt();
                in.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Cộng Nhập hai số");
                        System.out.println("Nhập a:");
                        a= in.nextDouble();
                        in.nextLine();
                        System.out.println("Nhập b:");
                        b= in.nextDouble();
                        in.nextLine();
                        System.out.println("Kết quả: "+remote.Cong(a, b));
                        break;
                    case 2:
                        System.out.println("Nhập a:");
                        a= in.nextDouble();
                        in.nextLine();
                        System.out.println("Nhập b");
                        b= in.nextDouble();
                        in.nextLine();
                        System.out.println("Kết quả: "+remote.Tru(a, b));
                        break;
                    case 3:
                        System.out.println("Nhập a:");
                        a= in.nextDouble();
                        in.nextLine();
                        System.out.println("Nhập b:");
                        b= in.nextDouble();
                        in.nextLine();
                        System.out.println("Kết quả: "+remote.nhan(a, b));
                        break;
                    case 4:
                        System.out.println("Nhập a:");
                        a= in.nextDouble();
                        in.nextLine();
                        System.out.println("Nhập b:");
                        b= in.nextDouble();
                        in.nextLine();
                        System.out.println("Kết quả: "+remote.chia(a, b));
                        break;
                    case 5:
                        System.out.println("Nhập a:");
                        c= in.nextInt();
                        in.nextLine();
                        System.out.println("Nhập b:");
                        d= in.nextInt();
                        in.nextLine();
                        System.out.println("Kết quả: "+remote.uocchung(c, d));
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Mục bạn vừa nhập không có trong menu:v");
                }
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
