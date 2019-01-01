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
public class Vang extends Giaodich{
    private String Loaivang;
    private double Thanhtien;
    //==========================================================================

    public double getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien() {
        this.Thanhtien = super.getDongia()*super.getSoluong();
    }
    
    public String getLoaivang() {
        return Loaivang;
    }

    public void setLoaivang(String Loaivang) {
        this.Loaivang = Loaivang;
    }
    //==========================================================================
    //constructor
    
    public Vang(String Loaivang, int Magd, int soluong, double Dongia, String Ngaygd) {
        super(Magd, soluong, Dongia, Ngaygd);
        this.Loaivang = Loaivang;
        setThanhtien();
    }
    //==========================================================================
    //Totring
}
