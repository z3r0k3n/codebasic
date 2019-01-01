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
public class Sachthamkhao extends Sach {
    private double Thue,Thanhtien;
    //==========================================================================
    //Seter and Geter

    public double getThue() {
        return Thue;
    }

    public void setThue(double Thue) {
        this.Thue = Thue;
    }

    public double getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien() {
        this.Thanhtien = this.Thue+super.getDongia()*super.getSoluong();
    }
    //==========================================================================
    //Constructor.

    public Sachthamkhao() {
        super();
        this.Thue=0;
        this.Thanhtien=0;
    }

    public Sachthamkhao(double Thue, int masach, String Ngaynhap, double Dongia, int Soluong, String Nhaxuatbat) {
        super(masach, Ngaynhap, Dongia, Soluong, Nhaxuatbat);
        this.Thue = Thue;
        setThanhtien();
    }
    //==========================================================================
    //Tostring
    @Override
    public String toString() {
        String st="";
        st+=super.toString()+"|\t\t"+this.Thue+"|\t\t"+this.Thanhtien;
        return st;
    }
    
}
