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
public class Sinhvien {
    private int Masv;
    private String Name;
    private float Diemlt,Diemth;

    public int getMasv() {
        return Masv;
    }

    public void setMasv(int Masv) {
        this.Masv = Masv;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public float getDiemlt() {
        return Diemlt;
    }

    public void setDiemlt(float Diemlt) {
        this.Diemlt = Diemlt;
    }

    public float getDiemth() {
        return Diemth;
    }

    public void setDiemth(float Diemth) {
        this.Diemth = Diemth;
    }

    public Sinhvien() {
    }

    public Sinhvien(int Masv, String Name, float Diemlt, float Diemth) {
        this.Masv = Masv;
        this.Name = Name;
        this.Diemlt = Diemlt;
        this.Diemth = Diemth;
    }
    public float Diemtb(){
        return (this.Diemlt+this.Diemth)/2;
    }

    @Override
    public String toString() {
        String st="";
        st+="\nMã sinh viên: "+getMasv();
        st+="\nHọ tên sinh viên: "+getName();
        st+="\nĐiểm thực hành: "+getDiemth();
        st+="\nĐiểm lý thuyết: "+getDiemlt();
        st+="\nĐiểm trung bình: "+Diemtb();
        st+="\n===================================";
        return st;
    }
    
}
