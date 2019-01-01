/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai6;

import java.text.ParseException;
import java.util.Scanner;
/**
 *
 * @author ASM
 */

public class Test {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Scanner in=new Scanner (System.in);
        Manager m=new Manager();
        int i;
        do
        {
            System.out.println("\nMenu: \n1: Nhập danh sách các hóa đơn thuê phòng theo giờ.\n2: Nhập danh sách các hóa đơn thuê phòng theo ngày.\n3: Xuất danh sách các hóa đon thuê phòng theo giờ.\n4: Xuất danh sách các hóa đơn thuê phòng theo ngày.\n5: Tính tổng số lượng cho thuê phòng theo giờ.\n6: Tính tổng số lượng cho thuê phòng theo ngày.\n7: Tính trung bình thành tiền của hóa đơn thuê phòng theo giờ trong tháng 9/2013.\n8: Tính trung bình thành tiền của hóa đơn thuê phòng theo ngày trong tháng 9/2013.\n9: Exit\nChọn: ");
            i=in.nextInt();
            switch (i)
            {
                case 1:
                    m.inputgio();
                    break;
                case 2:
                    m.inputngay();
                    break;
                case 3:
                    m.outputgio();
                    break;
                case 4:
                    m.outputNgay();
                    break;
                case 5:
                    m.sumGio();
                    break;
                case 6:
                    m.sumNgay();
                    break;
                case 7:
                    m.avgGio();
                    break;
                case 8:
                    m.avgNgay();
                    break;
                case 9:
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!( REMEMBER-ME )!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                default:
                    System.out.println("!!!!!Lựa chọn ko phù hợp.!!!!!");
                    break;
            }
        }
        while (i!=9);
    }
}
