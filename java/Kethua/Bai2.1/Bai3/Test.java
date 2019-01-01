/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;

/**
 *
 * @author ASM
 */
import java.util.Scanner;
public class Test {
    public static void main (String[] args)
    {
        Scanner in=new Scanner (System.in);
        int x;
        Manager m=new Manager ();
        do
        {
            System.out.println("\nMenu:\n1: Nhập danh sách giao dich vàng.\n2: Nhập danh sách giao dịch Tiền tệ.\n3: Xuất danh sách giao dich vàng.\n4: Xuất danh sách giao dịch tiền tệ.\n5: Tính tổng số lượng trong danh sách giao dịch vàng.\n6: Tính tổng số lượng trong danh sách giao dịch tiền tệ.\n7: Tính trung bình thành tiền của giao dịch tiền tệ.\n8: Giao dịch vàng có đơn giá hơn 1 tỷ.\n9: Giao dịch tiền tệ có đơn giá hơn 1 tỷ\n10: Exit\nChọn: ");
            x=in.nextInt();
            switch (x)
            {
                case 1:
                    m.nhapVang();
                    break;
                case 2:
                    m.nhapTiente();
                    break;
                case 3:
                    m.xuatVang();
                    break;
                case 4:
                    m.xuatTiente();
                    break;
                case 5:
                    m.sumVang();
                    break;
                case 6:
                    m.sumTiente();
                    break;
                case 7:
                    m.avgTiente();
                    break;
                case 8:
                    m.dongiaVang();
                    break;
                case 9:
                    m.dongiaTiente();
                    break;
                case 10:
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!( REMEMBER-ME )!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                default:
                    System.out.println("!!!!!Mục bạn chọn ko có.!!!!!");
                    break;
            }
        }
        while (x!=10);
    }
    
}
