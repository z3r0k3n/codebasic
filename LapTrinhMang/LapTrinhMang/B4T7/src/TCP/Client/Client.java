/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.Client;

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
        Manager m= new Manager();
        Scanner in= new Scanner(System.in);
        int i;
        do{
            System.out.println("Menu \n1.Xem danh sách.\n2.Mượn sách.\n3.Trả sách\n4.Exit\nChọn:");
            i=in.nextInt();
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
                    m.ngatketnoi();
                    System.out.println("Đã ngắt kết nối với Server");
                    break;
                default:
                    System.out.println("Mục bạn vùa chọn ko có trong Menu vui lòng chọn lại :<");
                    break;
            }
        }while (i!=Older.Ngat_ket_noi);
    }
    
}
