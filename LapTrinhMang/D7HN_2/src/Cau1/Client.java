/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau1;

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
        Rmi_Interface ri;
        int a,b,c;
        try {
            ri = (Rmi_Interface)Naming.lookup("rmi://localhost:9999/tamgiac");
            System.out.println("Nhập a:");
            a=in.nextInt();
            in.nextLine();
            System.out.println("nhập b:");
            b=in.nextInt();
            in.nextLine();
            System.out.println("Nhập c:");
            c=in.nextInt();
            in.nextLine();
            System.out.println("Server: ->"+ri.tamgiac(a, b, c));
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
