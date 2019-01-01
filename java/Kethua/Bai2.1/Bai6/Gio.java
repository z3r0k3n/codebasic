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
public class Gio extends Hoadon{
    private int Giothue;
    private double Thanhtien;
    //==========================================================================
    public int getGiothue() {
        return Giothue;
    }

    public void setGiothue(int Giothue) {
        this.Giothue = Giothue;
    }

    public double getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien() {
        this.Thanhtien = super.getDongia()*getGiothue();
    }
    //==========================================================================
    public Gio() {
    }

    public Gio(String Mahd, String Ngayhd, String Tenkh, String Maphong, double Dongia,int Giothue) {
        super(Mahd, Ngayhd, Tenkh, Maphong, Dongia);
        this.Giothue = Giothue;
        setThanhtien();
    }
    
}
