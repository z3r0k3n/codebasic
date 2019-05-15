/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Client;

import Cau2.Server.Order;
import java.util.Scanner;

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
        Manager m = new Manager();
        int i;
        do {
            System.out.println("Menu \n1.Xem danh sach\n2.Mượn sách\n3.Exit\nChọn: ");
            i = in.nextInt();
            in.nextLine();
            switch (i) {
                case Order.Xem_Danh_Sach:
                    m.Xemlist();
                    break;
                case Order.Muon_Sach:
                    m.Muonsach();
                    break;
                case Order.Exit:
                    m.exit();
                    System.out.println("Disconnect");
                    break;
                default:
                    System.out.println("Mục bạn vừa chọn ko có trong menu");
            }
        } while (i!=Order.Exit);
        
    }
    
}
