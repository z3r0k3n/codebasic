/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.util.Scanner;

/**
 *
 * @author Zero Ken
 */
public class ClientCtr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i=0,t=0;
        Manager m=new Manager();
        Scanner in=new Scanner(System.in);
        do
        {
        System.out.println("Chọn 1 trong các ứng dụng sau:\n1. Xuất danh sách sinh viên.\n2. Thêm sinh viên mơi.\n3. Xóa một sinh viên\n4. Cập nhập cho sinh viên.\n5. Tìm sinh viên.\n6. Exit.\nChọn: ");
        i=in.nextInt();
        in.nextLine();
        switch(i)
        {
            case 1:
                m.Xemdanhsach();
                break;
            case 2:
                m.Themsinhvien();
                break;
            case 3:
                m.Xoasinhvien();
                break;
            case 4:
                m.capnhapsinhvien();
                break;
            case 5:
                m.Timkiemsinhvien();
                break;
            case 6:
                m.exit();
                System.out.println("Good bye :> ");
                break;
            default:
                System.out.println("!!!Mục bạn chọn không tông tại bạn có thể chọn lại (TT^TT) !!!");
                break;
        }
        }while (i!=6);
        
    }
    
}
    