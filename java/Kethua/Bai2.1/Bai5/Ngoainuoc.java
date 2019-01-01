/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai5;

/**
 *
 * @author ASM
 */
public class Ngoainuoc extends Khachhang{
    private String Quoctich;
    private double Thanhtien;
    //==========================================================================
    public String getQuoctich() {
        return Quoctich;
    }

    public void setQuoctich(String Quoctich) {
        this.Quoctich = Quoctich;
    }

    public double getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien() {
        this.Thanhtien=super.getSoluong()*super.getDongia();
    }
    //==========================================================================

    public Ngoainuoc() {
    }

    public Ngoainuoc(String Makh, String Tenkh, String Ngayhd,String Quoctich, int Soluong, double Dongia) {
        super(Makh, Tenkh, Ngayhd, Soluong, Dongia);
        this.Quoctich = Quoctich;
        setThanhtien();
    }
    
    
}
