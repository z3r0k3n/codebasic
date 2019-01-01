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
public class Trongnuoc extends Khachhang {
    private String Doitương;
    private int dinhmuc;
    private double Thanhtien;

    Trongnuoc(String a, String b, String c, String d, int e, int f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //==========================================================================
        public double getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien() {
        if (super.getSoluong()<=getDinhmuc())
            this.Thanhtien=super.getSoluong()*super.getDongia();
        else
            this.Thanhtien=super.getDongia()*getDinhmuc()+(super.getSoluong()-getDinhmuc())*super.getDongia()*2.5;
    }
    
    public String getDoitương() {
        return Doitương;
    }

    public void setDoitương(String Doitương) {
        this.Doitương = Doitương;
    }

    public int getDinhmuc() {
        return dinhmuc;
    }

    public void setDinhmuc(int dinhmuc) {
        this.dinhmuc = dinhmuc;
    }
    //==========================================================================\

    public Trongnuoc() {
    }

    public Trongnuoc(String Makh, String Tenkh, String Ngayhd,String Doitương, int Soluong, double Dongia, int dinhmuc) {
        super(Makh, Tenkh, Ngayhd, Soluong, Dongia);
        this.Doitương = Doitương;
        this.dinhmuc = dinhmuc;
        setThanhtien();
    }
    
}
