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
public class Sach {
    private int masach;
    private String Ngaynhap;
    private double Dongia;
    private int Soluong;
    private String Nhaxuatbat;
    //==========================================================================
    //Seter and Geter
    public int getMasach() {
        return masach;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    public String getNgaynhap() {
        return Ngaynhap;
    }

    public void setNgaynhap(String Ngaynhap) {
        this.Ngaynhap = Ngaynhap;
    }

    public double getDongia() {
        return Dongia;
    }

    public void setDongia(double Dongia) {
        this.Dongia = Dongia;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public String getNhaxuatbat() {
        return Nhaxuatbat;
    }

    public void setNhaxuatbat(String Nhaxuatbat) {
        this.Nhaxuatbat = Nhaxuatbat;
    }
    //==========================================================================
    //Constructor.
    Sach() {
        this.masach=0;
        this.Ngaynhap="EMPTY";
        this.Dongia=0;
        this.Soluong=0;
        this.Nhaxuatbat="EMPTY";
    }

    Sach(int masach, String Ngaynhap, double Dongia, int Soluong, String Nhaxuatbat) {
        this.masach = masach;
        this.Ngaynhap = Ngaynhap;
        this.Dongia = Dongia;
        this.Soluong = Soluong;
        this.Nhaxuatbat = Nhaxuatbat;
    }
    //==========================================================================
    //Tostring.
    public String toString ()
    {
        String st="";
        st+="\n|\t\t"+this.masach+"|\t\t"+this.Ngaynhap+"|\t\t"+this.Dongia+"|\t\t"+this.Soluong+"|\t\t"+this.Nhaxuatbat;
        return st;
    }
}
