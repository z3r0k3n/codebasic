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
public class Ngay extends Hoadon {
    private int Ngaythue;
    private double Thanhtien;
    //==========================================================================
    public int getNgaythue() {
        return Ngaythue;
    }

    public void setNgaythue(int Ngaythue) {
        this.Ngaythue = Ngaythue;
    }

    public double getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien() {
        if (getNgaythue()>7)
            this.Thanhtien = super.getDongia()*7+((getNgaythue()-7)*super.getDongia()-(getNgaythue()-7)*super.getDongia()*0.2);
        else 
            this.Thanhtien = super.getDongia()*super.getDongia();
    }
    //==========================================================================
    public Ngay() {
    }

    public Ngay( String Mahd, String Ngayhd, String Tenkh, String Maphong, double Dongia, int Ngaythue) {
        super(Mahd, Ngayhd, Tenkh, Maphong, Dongia);
        this.Ngaythue = Ngaythue;
        setThanhtien();
    }
    
}
