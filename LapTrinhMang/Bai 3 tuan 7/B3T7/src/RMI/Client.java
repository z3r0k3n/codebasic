/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

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
        Scanner in= new Scanner(System.in);
        Interface_B3T7 IB3T7;
        Older older= new Older();
        try {
            IB3T7 = (Interface_B3T7) Naming.lookup("rmi://localhost:9999/mess");
            do {
                System.out.println("Nhập User:");
                older.setUser(in.nextLine());
                System.out.println("Nhập Pass:");
                older.setPass(in.nextLine());
                older= IB3T7.Dangnhap(older);
                System.out.println("Server: ->"+older.getSend());
            } while (older.getUser().equals("0"));
            System.out.println("Chuyển sang chế độ chat:");
            //chat
            while (true) {
                System.out.println("Server: ->"+IB3T7.chat(in.nextLine()));
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
