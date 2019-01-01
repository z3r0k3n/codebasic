/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai8;

/**
 *
 * @author ASM
 */
import java.util.Scanner;
public class Bai8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in=new Scanner (System.in);
        Manager m=new Manager();
        int x,y;
        do
        {
            System.out.println("\nMenu: \n1:Nhập CD.\n2:Số lượng CD trong danh sách.\n3:Tổng giá CD trong danh sách.\n4:Sắp xếp danh sách giảm dần theo giá thành\n5:Sắp xếp danh sách tăng dần theo tựa CD.\n6:Xuất toàn bộ danh sách.\n7:Exit.\n Chọn: ");
            x=in.nextInt();
            switch (x)
            {
                case 1:
                    System.out.println("Số lượng đia CD cần nhập: ");
                    y=in.nextInt();
                    m.AddCD(y);
                    break;
                case 2:
                    System.out.printf("Số lượng đĩa CD có trong danh sách: %d",m.totalcd());
                    break;
                case 3:
                    System.out.printf("Tổng giá CD có trong danh sách: %5.2f",m.totalprice());
                    break;
                case 4:
                    m.SortbyPriace();
                    break;
                case 5:
                    m.SortbyName();
                    break;
                case 6:
                    m.show();
                    break;
                case 7:
                    System.out.println("===========================( REMEMBER-ME )===========================");
                    break;
                default:
                    System.out.println("!!!!!Giá trị nhập ko có!!!!!");
            }
        }
        while (x!=7);
        }
}
