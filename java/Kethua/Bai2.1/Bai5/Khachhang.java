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
public class Khachhang {
    private String Makh,Tenkh,Ngayhd;
    private int Soluong;
    private double Dongia;
    //==========================================================================

    public String getMakh() {
        return Makh;
    }

    public void setMakh(String Makh) {
        this.Makh = Makh;
    }

    public String getTenkh() {
        return Tenkh;
    }

    public void setTenkh(String Tenkh) {
        this.Tenkh = Tenkh;
    }

    public String getNgayhd() {
        return Ngayhd;
    }

    public void setNgayhd(String Ngayhd) {
        this.Ngayhd = Ngayhd;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public double getDongia() {
        return Dongia;
    }

    public void setDongia(double Dongia) {
        this.Dongia = Dongia;
    }
    //==========================================================================
    public Khachhang() {
    }

    public Khachhang(String Makh, String Tenkh, String Ngayhd, int Soluong, double Dongia) {
        this.Makh = Makh;
        this.Tenkh = Tenkh;
        this.Ngayhd = Ngayhd;
        this.Soluong = Soluong;
        this.Dongia = Dongia;
    }
    
}
