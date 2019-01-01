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
import java.util.ArrayList;
import java.util.Scanner;
public class Testcase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in=new Scanner(System.in);
        ArrayList<Sinhvien> listSV=new ArrayList();
        Sinhvien sv1=new Sinhvien (111,"Nguyễn Văn A",5,6);
        listSV.add(sv1);
        Sinhvien sv2=new Sinhvien (222,"Trần Văn B",8,8);
        listSV.add(sv2);
        System.out.println("\nNhập mã sinh viên: ");
        int a=in.nextInt();
        in.nextLine();
        System.out.println("\nNhap họ tên sinh viên: ");
        String b=in.nextLine();
        System.out.println("\nNhập điểm thực hành: ");
        float d=in.nextFloat();
        System.out.println("\nNhập điểm lý thuyêt: ");
        float c=in.nextFloat();
        Sinhvien sv3=new Sinhvien(a,b,c,d);
        listSV.add(sv3);
        System.out.printf("\n%20s|%20s|%20s|%20s|%20s|", "Mã sinh viên","Họ và tên sinh viên","Điểm lý thuyết","Điểm thực hành","Điểm trung bình");
        for (Sinhvien sv:listSV)
        {
            System.out.printf("\n%20d|%20s|%20.2f|%20.2f|%20.2f|", sv.getMasv(),sv.getName(),sv.getDiemlt(),sv.getDiemth(),sv.getDiemlt(),sv.Diemtb());
        }
        
        
    }
    
}
