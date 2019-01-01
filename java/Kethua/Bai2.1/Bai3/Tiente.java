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
public class Tiente extends Giaodich {
    private double tigia,Thanhtien;
    //==========================================================================
    //setter & getter
    
    public double getTigia() {
        return tigia;
    }

    public void setTigia(double tigia) {
        this.tigia = tigia;
    }
    
    public double getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien() {
        this.Thanhtien =super.getDongia()*super.getSoluong()*this.tigia;
    }
    //==========================================================================
    //Constructor

    public Tiente(double tigia, int Magd, int soluong, double Dongia, String Ngaygd) {
        super(Magd, soluong, Dongia, Ngaygd);
        this.tigia = tigia;
        setThanhtien();
    }
    
}
