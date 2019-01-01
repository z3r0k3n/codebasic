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
public class Nha extends Giaodich{
    private String Loainha,Diachi;
    private double Thanhtien;
    //==========================================================================
    public String getLoainha() {
        return Loainha;
    }

    public void setLoainha(String Loainha) {
        this.Loainha = Loainha;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public double getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien() {
        if(getLoainha()=="Cao Cấp")
            this.Thanhtien = super.getDientich()*super.getDongia();
        else
            this.Thanhtien = super.getDientich()*super.getDongia()*0.9;
    }
//==========================================================================
    public Nha() {
        super();
        this.Loainha="";
        this.Diachi="";
        this.Thanhtien=0;
    }

    public Nha(String Loainha, String Diachi, String Magd, String Ngaygd, double Dientich, double Dongia) {
        super(Magd, Ngaygd, Dientich, Dongia);
        this.Loainha = Loainha;
        this.Diachi = Diachi;
        setThanhtien();
    }
}
