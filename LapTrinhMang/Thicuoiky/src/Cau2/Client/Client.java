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
        int i = 0;
        do {
            System.out.println("Menu:\n1.Anh-Việt.\n2.Việt-Anh\n3.Anh-Nghĩa\n4.Exit\nChọn:");
            i= in.nextInt();
            in.nextLine();
            switch (i) {
                case Order.Anh_viet:
                    m.Anh_viet();                    
                    break;
                case Order.Viet_anh:
                    m.Viet_anh();
                    break;
                case Order.Anh_ngia:
                    m.Anh_nghia();
                    break;
                case Order.Exit:
                    m.exit();
                    break;
                default:
                    System.out.println("Mục bạn vừa nhập không có trong menu vui lòng nhập lại :<");
            }
        } while (i!=Order.Exit);
        
    }
    
}
