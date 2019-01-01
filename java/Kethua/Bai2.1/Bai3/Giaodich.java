/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;

/**
 *
 * @author ASM
 */
public class Giaodich {
    private int Magd,soluong;
    private double Dongia;
    private String Ngaygd;
    //==========================================================================
    //Seter and geter

    public int getMagd() {
        return Magd;
    }

    public void setMagd(int Magd) {
        this.Magd = Magd;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return Dongia;
    }

    public void setDongia(double Dongia) {
        this.Dongia = Dongia;
    }

    public String getNgaygd() {
        return Ngaygd;
    }

    public void setNgaygd(String Ngaygd) {
        this.Ngaygd = Ngaygd;
    }
    //==========================================================================
    //Constructor
    Giaodich ()
    {
        this.Magd=0;
        this.Ngaygd="";
        this.Dongia=0;
        this.soluong=0;
    }

    public Giaodich(int Magd, int soluong, double Dongia, String Ngaygd) {
        this.Magd = Magd;
        this.soluong = soluong;
        this.Dongia = Dongia;
        this.Ngaygd = Ngaygd;
    }
    
}
