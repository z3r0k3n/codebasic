/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author ASM
 */
public class Bai2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        sinhvien sv1=new sinhvien(1,"tran anh minh",7,4);
        sinhvien sv2=new sinhvien(2,"phan trnh hung",9,9);
        sinhvien sv3=new sinhvien();
        
        sv3.setMasv(3);
        sv3.setHoten("tran thanh phong");
        sv3.setDiemLT(5);
        sv3.setDiemTH(4);
        System.out.printf("%-5s |%-20s |%-20s |%-20s |%-20s\n","MASV","Họ Tên","Điểm Lý Thuyết","Điểm Thực Hành","Điểm Trung Bình");
        System.out.printf("%5d |%-20s |%20.2f |%20.2f |%20.2f\n",sv1.getMasv(),sv1.getHoten(),sv1.getDiemLT(),sv1.getDiemTH(),sv1.DiemTB());
        System.out.printf("%5d |%-20s |%20.2f |%20.2f |%20.2f\n",sv2.getMasv(),sv2.getHoten(),sv2.getDiemLT(),sv2.getDiemTH(),sv2.DiemTB());
        System.out.printf("%5d |%-20s |%20.2f |%20.2f |%20.2f\n",sv3.getMasv(),sv3.getHoten(),sv3.getDiemLT(),sv3.getDiemTH(),sv3.DiemTB());
    }
    
}
