package Client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Server.Interface_B4NC;
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
        int i=0;
        Interface_B4NC ib;
        String input;
        //==============================================
        try{
        ib= (Interface_B4NC) Naming.lookup("rmi://localhost:9999/tudien");
        do {
            System.out.println("Menu:\n1.Anh-Viet.\n2.Viet-Anh\n3.Nghĩa\n4.Exit.\nChọn");
            i= in.nextInt();
            in.nextLine();
            switch (i) {
                case 1:
                    System.out.println("Nhập từ: ");
                    input=in.nextLine();
                    System.out.println("Server: ->"+ib.Anh_Viet(input));
                    break;
                case 2:
                    System.out.println("Nhập từ: ");
                    input=in.nextLine();
                    System.out.println("Server: ->"+ib.Viet_Anh(input));
                    break;
                case 3:
                    System.out.println("Nhập từ: ");
                    input=in.nextLine();
                    System.out.println("Server: ->"+ib.Dinh_Ngia(input));
                    break;
                case 4:
                    System.out.println("EXIT!!!");
                    break;
                default:
                    System.out.println("Mục bạn chọn không có trong menu");;
            }
        } while (i!=4);
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
