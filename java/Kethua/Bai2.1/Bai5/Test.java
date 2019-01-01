/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai5;

/**
 *
 * @author ASM
 */
import java.text.ParseException;
import java.util.Scanner;
public class Test {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Scanner in= new Scanner (System.in);
        Manager m= new Manager ();
        int x;
        do
        {
            System.out.println("\nMenu: \n1: Nhập danh sách các hóa đơn khách hàng Việt Nam.\n2: Nhập danh sách các hóa đơn khách hàng nước ngoài.\n3: Xuất danh sách các hóa đơn khách hàng Việt Nam.\n4: Xuất danh sách các hóa đơn khách hàng nước ngoài.\n5: Tính tổng số lượng cho khách hàng Việt Nam.\n6: Tính tổng số lượng cho khách hàng nước ngoài.\n7: Tính trung bình thành tiền của khách hàng người nước ngoài.\n8: Xuất ra các hoá đơn khách hàng Việt Nam trong tháng 09 năm 2013.\n9: Xuất ra các hoá đơn khách hàng nước ngoài trong tháng 09 năm 2013\n10: Exit\nChọn: ");
            x=in.nextInt();
            in.nextLine();
            switch (x)
            {
                case 1:
                    m.inputTrongnuoc();
                    break;
                case 2:
                    m.inputNgoainuoc();
                    break;
                case 3:
                    m.outputTrongnuoc();
                    break;
                case 4:
                    m.outputNgoainuoc();
                    break;
                case 5:
                    m.SumTrongnuoc();
                    break;
                case 6:
                    m.SumNgoainuoc();
                    break;
                case 7:
                    m.avgNgoainuoc();
                    break;
                case 8:
                    m.timTrongnuoc();
                    break;
                case 9:
                    m.timNgoainuoc();
                    break;
                case 10:
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!( REMEMBER-ME )!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                default:
                    System.out.println("!!!!!Lựa chọn của bạn không có.!!!!!");
                    break;
            }
        }
        while (x!=10);
        
    }
}
