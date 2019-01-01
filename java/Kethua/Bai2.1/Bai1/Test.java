/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

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
        Scanner in = new Scanner(System.in);
        Manager m = new Manager();
        int x, y;
                do {
            System.out.println("\nMenu: \n1:Nhập danh sách chuyến xe nội.\n2:Nhập danh sách chuyến xe ngoại.\n3:Xuất danh sách các chuyến xe nội.\n4:Xuất danh sách các chuyến xe ngoại.\n5:Tổng doanh thu các chuyến xe nội.\n6:Tổng doanh thu các chuyến xe ngoại.\n7:Exit.\n Chọn: ");
            x = in.nextInt();
            switch (x) {
                case 1:
                    System.out.println("Số chuyến xe nội cần nhập vào danh sách: ");
                    y = in.nextInt();
                    m.addXenoi(y);
                    break;
                case 2:
                    System.out.println("Số chuyến xe ngoại cần nhập vào danh sách: ");
                    y = in.nextInt();
                    m.addXengoai(y);
                    break;
                case 3:
                    m.showXenoi();
                    break;
                case 4:
                    m.showXengoai();
                    break;
                case 5:
                    System.out.printf("Tổng doanh thu từ danh sách chuyến xe nội: %.2f",m.sumDoanhthuxenoi());
                    break;
                case 6:
                    System.out.printf("Tổng daonh thu từ danh sách chuyển xe ngoại: %.2f",m.sumDoanhthuxengoai());
                    break;
                case 7:
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!( REMEMBER-ME )!!!!!!!!!!!!!!!!!!!!!!");
            }
        } while (x != 7);
    }

}
