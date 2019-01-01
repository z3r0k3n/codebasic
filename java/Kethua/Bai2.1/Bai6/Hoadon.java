/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai6;

/**
 *
 * @author ASM
 */
public class Hoadon {
    private String Mahd,Ngayhd,Tenkh,Maphong;
    private double Dongia;
    //==========================================================================
    public String getMahd() {
        return Mahd;
    }

    public void setMahd(String Mahd) {
        this.Mahd = Mahd;
    }

    public String getNgayhd() {
        return Ngayhd;
    }

    public void setNgayhd(String Ngayhd) {
        this.Ngayhd = Ngayhd;
    }

    public String getTenkh() {
        return Tenkh;
    }

    public void setTenkh(String Tenkh) {
        this.Tenkh = Tenkh;
    }

    public String getMaphong() {
        return Maphong;
    }

    public void setMaphong(String Maphong) {
        this.Maphong = Maphong;
    }

    public double getDongia() {
        return Dongia;
    }

    public void setDongia(double Dongia) {
        this.Dongia = Dongia;
    }
    //==========================================================================
    public Hoadon() {
    }

    public Hoadon(String Mahd, String Ngayhd, String Tenkh, String Maphong, double Dongia) {
        this.Mahd = Mahd;
        this.Ngayhd = Ngayhd;
        this.Tenkh = Tenkh;
        this.Maphong = Maphong;
        this.Dongia = Dongia;
    }
    
}
