/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4;

/**
 *
 * @author ASM
 */
public class Giaodich {
    private String Magd,Ngaygd;
    private double Dongia,Dientich;
    //==========================================================================
    public String getMagd() {
        return Magd;
    }

    public void setMagd(String Magd) {
        this.Magd = Magd;
    }

    public String getNgaygd() {
        return Ngaygd;
    }

    public void setNgaygd(String Ngaygd) {
        this.Ngaygd = Ngaygd;
    }

    public double getDientich() {
        return Dientich;
    }

    public void setDientich(double Dientich) {
        this.Dientich = Dientich;
    }

    public double getDongia() {
        return Dongia;
    }

    public void setDongia(double Dongia) {
        this.Dongia = Dongia;
    }
    //==========================================================================

    public Giaodich() {
        this.Magd="";
        this.Ngaygd="";
        this.Dongia=0;
        this.Dientich=0;
    }

    public Giaodich(String Magd, String Ngaygd, double Dientich, double Dongia) {
        this.Magd = Magd;
        this.Ngaygd = Ngaygd;
        this.Dientich = Dientich;
        this.Dongia = Dongia;
    }
    
}
