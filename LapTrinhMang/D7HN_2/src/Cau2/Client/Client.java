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
            System.out.println("Menu:\n1.Thêm cầu thủ mới.\n2.Tính tổng luong của cầu thủ.\n3.Exit\nChọn: ");
            i=in.nextInt();
            in.nextLine();
            switch (i) {
                case Order.Them_cau_thu_moi:
                    m.themcauthu();
                    break;
                case Order.Tinh_tong_luong_thang_cua_cau_thu:
                    m.Tongluong();
                    break;
                case Order.Exit:
                    m.exit();
                    break;
                default:
                    System.out.println("Mục bạn vừa chọn không có trong menu vui lòng chọn lại :>");
                    break;
            }
        } while (i != Order.Exit);
        
    }
    
}
