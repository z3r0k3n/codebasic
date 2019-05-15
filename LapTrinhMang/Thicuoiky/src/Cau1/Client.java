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
        try {
            // TODO code application logic here
            Scanner in = new Scanner(System.in);
            RMI_iml ri;
            int i;
            ri = (RMI_iml) Naming.lookup("rmi://localhost:9999/giaithua");
            
            
            while (true) {
                System.out.println("Nhập số cần tính giai thừa: ");
                i = ri.giaithua(in.nextInt());
                if (i==-1) System.out.println("số bạn nhập vào không phải số dương :<");
                else System.out.println("Server: -> "+i);
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
