/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De1;

import java.io.Serializable;

/**
 *
 * @author ASM
 */
public class Student extends Person implements Serializable{
    private String masv,email;
    private double diemtk;

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDiemtk() {
        return diemtk;
    }

    public void setDiemtk(double diemtk) {
        this.diemtk = diemtk;
    }

    public Student() {
        super();
        this.masv = "";
        this.email = "";
        this.diemtk = 0;
    }

    public Student(String hoten, String ngaysinh, String diachi, String gioitinh,String masv, String email, double diemtk) {
        super(hoten, ngaysinh, diachi, gioitinh);
        this.masv = masv;
        this.email = email;
        this.diemtk = diemtk;
    }

    @Override
    public String toString() {
        String st="";
        st+=super.toString()+"|\t\t"+this.masv+"|\t\t"+this.email+"|\t\t"+this.diemtk+"|";
        return st;
    }

}
