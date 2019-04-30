/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Udp.Client;

import Java_SQL.Older;
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
        Scanner in= new Scanner(System.in);
        int i=0;
        Manager m= new Manager();
        do {
            System.out.println("Menu:\n1.Tìm kiếm sản phẩm\n2.Lập hóa đơn\n3.EXIT\nChọn:");
            i=in.nextInt();
            in.nextLine();
            switch (i) {
                case Older.TIM_KIEM_SAN_PHAM:
                    m.timkiem();
                    break;
                case Older.LAP_HOA_DON:
                    m.hoadon();
                    break;
                case Older.EXIT:
                    System.out.println("Exit!!!");
                    break;
                default:
                    System.out.println("Mục bạn vùa chọn không có vui lòng xem lại menu");
            }
        } while (i!=Older.EXIT);
        
    }
    
}
