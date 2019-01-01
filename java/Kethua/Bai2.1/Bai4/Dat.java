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
public class Dat extends Giaodich {
    private String Loaidat;
    private double Thanhtien;
    //==========================================================================
    public String getLoaidat() {
        return Loaidat;
    }

    public void setLoaidat(String Loaidat) {
        this.Loaidat = Loaidat;
    }

    public double getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien() {
        if (getLoaidat()=="A")
            this.Thanhtien = super.getDongia()*super.getDientich()*1.5;
        else
            this.Thanhtien = super.getDongia()*super.getDientich();
    }
    //==========================================================================

    public Dat() {
        super();
        this.Loaidat="";
        this.Thanhtien=0;
    }

    public Dat(String Loaidat, String Magd, String Ngaygd, double Dientich, double Dongia) {
        super(Magd, Ngaygd, Dientich, Dongia);
        this.Loaidat = Loaidat;
        setThanhtien();
    }
    
    
    
}
