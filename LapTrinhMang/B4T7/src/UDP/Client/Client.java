/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP.Client;

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
        Scanner in = new Scanner(System.in);
        Manager m = new Manager();
        int i=0;
        do{
            System.out.println("Menu:\n1.Xem sách\n2.Mượn sách\n3.Trả sách\n4.Exit\nChọn:");
            i= in.nextInt();
            switch (i) {
                case Older.Xem_sach:
                    m.Xemsach();
                    break;
                case Older.Muon_sach:
                    m.Muonsach();
                    break;
                case Older.Tra_sach:
                    m.Trasach();
                    break;
                case Older.Ngat_ket_noi:
                    System.out.println("Ngắt kết nối :3");
                    break;
                default:
                    System.out.println("Mục bạn vừa chọn không có trong Menu vui lòng chọn lại TT^TT");
            }
        }while (i!=4);
    }
    
}
