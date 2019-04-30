/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.Client;

import Java_SQL.Older;
import java.util.Scanner;

/**
 *
 * @author Zero Ken
 */
public class RMI_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int i;
        Manager m = new Manager();
        do {
            System.out.println("Menu:\n1.Tìm kiếm.\n2.Tạo hóa đơn.\n3.Thoát\nChọn: ");
            i = in.nextInt();
            in.nextLine();
            switch (i) {
                case Older.TIM_KIEM_SAN_PHAM:
                    m.Timkiem();
                    break;
                case Older.LAP_HOA_DON:
                    m.Laphoadon();
                    break;
                case Older.EXIT:
                    System.out.println("Exit!!!");
                    break;
                default:
                    System.out.println("Mục bạn vừa chọn không có trong menu vui lòng chọn lại");
            }
        } while (i!=3);
        
    }
    
}
