/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;
import java.util.Scanner;
import java.util.LinkedList;
/**
 *
 * @author ASM
 */
public class Bai3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input= new Scanner (System.in);
        dangkyxe xe1= new dangkyxe ();
        dangkyxe xe2= new dangkyxe ();
        dangkyxe xe3= new dangkyxe ();
        System.out.printf("Menu: \n1. Nhập thông tin và tạo các đối tượng xe1, xe2, xe3  \n" +
"2. Xuất bảng kê khai tiền thuế trước bạ của các xe.  \n" +
"3. Thoát.  \nChọn: ");
        int n=input.nextInt();
        switch (n)
            {
                case 1:
                    System.out.printf("Nhập thông tin xe 1\n ");
                    System.out.printf("Tên Chủ xe 1: ");
                    xe1.setTenChuXe();
                    System.out.printf("Loại xe 1: ");
                    xe1.setLoaiXe();
                    System.out.printf("Dung Tích xe 1: ");
                    xe1.setDungTich();
                    System.out.printf("Trị giá xe 1: ");
                    xe1.setTriGia();
                    
                    System.out.printf("Nhập thông tin xe 2:\n");
                    System.out.printf("Tên Chủ xe 2: ");
                    xe2.setTenChuXe();
                    System.out.printf("Loại xe 2: ");
                    xe2.setLoaiXe();
                    System.out.printf("Dung Tích xe 2: ");
                    xe2.setDungTich();
                    System.out.printf("Trị giá xe 2: ");
                    xe2.setTriGia();
                    
                    System.out.printf("Nhập thông tin xe 3:\n");
                    System.out.printf("Tên Chủ xe 3: ");
                    xe3.setTenChuXe();
                    System.out.printf("Loại xe 3: ");
                    xe3.setLoaiXe();
                    System.out.printf("Dung Tích xe 3: ");
                    xe3.setDungTich();
                    System.out.printf("Trị giá xe 3: ");
                    xe3.setTriGia();                    
                case 2:
                    System.out.printf("%-20s|%-15s|%-15s|%-20s|%-15s|\n", "Tên Chủ Xe","Loại Xe","Dung Tích","Trị Giá","Thuế Phải Nộp");
                    System.out.printf("==========================================================================================\n");
                    System.out.printf("%-20s|%-15s|%15d|%20.2f|%15.2f|\n", xe1.getTenChuXe(),xe1.getLoaiXe(),xe1.getDungTich(),xe1.getTriGia(),xe1.Thue());
                    System.out.printf("%-20s|%-15s|%15d|%20.2f|%15.2f|\n", xe2.getTenChuXe(),xe2.getLoaiXe(),xe2.getDungTich(),xe2.getTriGia(),xe2.Thue());
                    System.out.printf("%-20s|%-15s|%15d|%20.2f|%15.2f|\n", xe3.getTenChuXe(),xe3.getLoaiXe(),xe3.getDungTich(),xe3.getTriGia(),xe3.Thue());
                    break;
                case 3:
                    break;
            }
        
    }
    
}
