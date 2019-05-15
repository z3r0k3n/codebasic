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
            System.out.println("Menu:\n1.Thêm khách hàng\n2.Tính tiền phòng\n3.Exit\nChọn: ");
            i= in.nextInt();
            in.nextLine();
            switch (i) {
                case Order.Them_khach_hang:
                    m.Themkh();
                    break;
                case Order.Tinh_tien_phong:
                    m.Tinhtien();
                    break;
                case Order.Exit:
                    m.exit();
                    break;
                default:
                    System.out.println("Mục bạn chọn ko có trong menu vui lòng nhập lại");
                    break;
            }
        } while (i!=Order.Exit);
        
    }
    
}
