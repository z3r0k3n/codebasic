/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.util.Scanner;
import java_sql.Older;

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
        Scanner in= new Scanner(System.in);
        Older older= new Older();
        Manager m= new Manager();
        int i;
        do {
            i=m.choice();
            
            switch (i) {
                case Older.Xem_danh_sach_sinh_vien:
                    m.XemSinhvien();
                    break;
                case Older.Them_mot_sinh_vien:
                    m.Themsinhvien();
                    break;
                case Older.Xoa_mot_sinh_vien:
                    m.Xoasinhvien();
                    break;
                case Older.Cap_nhap_mot_sinh_vien:
                    m.Capnhapsinhvien();
                    break;
                case Older.Tim_kiem_mot_sinh_vien:
                    m.timkiemsinhvien();
                    break;
                case Older.Ngat_ket_noi:
                    System.out.println("Ngắn kết nối vs server .......");
                    break;
                default:
                    System.out.println("Mục bạn vừa chọn ko có trong menu");
            }
        } while (i!=6);
        
    }
    
}
