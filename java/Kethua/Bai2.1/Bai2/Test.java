/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

/**
 *
 * @author ASM
 */
import java.util.Scanner;
public class Test {
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in =new Scanner (System.in);
        int x,y;
        String z;
        Manager m=new Manager();
        do
        {
            System.out.println("\nMenu.\n1:Nhập sách giao khoa.\n2:Nhập sách tham khảo.\n3:Xuất sách giao khoa.\n4:Xuất sách tham khảo.\n5:Tổng thành tiền sách giáo khoa.\n6:Tổng thành tiền của sách tham khảo.\n7:Trung bình cộng đơn giá của các sách thâm khảo.\n8:Xuất sách giáo khoa theo nhà xuất bản.\n9:Exit.\nChọn: ");
            x=in.nextInt();
            switch (x)
            {
                case 1:
                    System.out.println("Số lượng thông tin sách cần nhập");
                    y=in.nextInt();
                    m.addSachgiaokhoa(y);
                    break;
                case 2:
                    System.out.println("Số lượng thông tin sách cần nhập");
                    y=in.nextInt();
                    m.addSachthamkhao(y);
                    break;
                case 3:
                    m.showSachgiaokhoa();
                    break;
                case 4:
                    m.showSachthamkhao();
                    break;
                case 5:
                    m.sumSachgiaokhoa();
                    break;
                case 6:
                    m.sumSachthamkhao();
                    break;
                case 7:
                    m.avgDongiasachthamkhao();
                    break;
                case 8:
                    System.out.println("Nhập nhà xuất bản bạn muốn tìm: ");
                    in.nextLine();
                    z=in.nextLine();
                    m.timsachtheonhaxuatban(z);
                    break;
                case 9:
                    System.out.println("===================================( REMEMBER-ME )===================================");
                    break;
                default:
                    System.out.println("!!!!!!!!!!!!!!!!!!!Mục bạn chọn ko có!!!!!!!!!!!!!!!!!!!");
            }
        }
        while (x!=9);
    }
}
