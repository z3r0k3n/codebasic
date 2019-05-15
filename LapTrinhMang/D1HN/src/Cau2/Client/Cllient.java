/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Client;

import Cau2.Server.Order;
import Cau2.Server.RMI_interface;
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
public class Cllient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in= new Scanner(System.in);
        RMI_interface ri;
        int choice;
        
        try{
            ri=(RMI_interface) Naming.lookup("rmi://localhost:9999/VT-DD");
            do {
                System.out.println("Menu: \n1:Viết tắt sang viết đầy đủ\n2: Viết đầy đủ sang viết tắt\n3Exit\nChọn:");
                choice =in.nextInt();
                in.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập từ viết tắt: ");
                        String DD=ri.VT_DD(in.nextLine());
                        System.out.println("Server: ->"+DD);
                        break;
                    case 2:
                        System.out.println("Nhập từ viết đầy đủ:");
                        String VT=ri.DD_VT(in.nextLine());
                        System.out.println("Server: ->"+VT);
                        break;
                    case 3:
                        System.out.println("Exit");
                        break;
                }
            } while (choice!=3);
            
        } catch (NotBoundException ex) {
            Logger.getLogger(Cllient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Cllient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Cllient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
