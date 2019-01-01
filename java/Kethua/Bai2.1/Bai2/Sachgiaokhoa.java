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
public class Sachgiaokhoa extends Sach {
    private String Tinhtrang;
    private double Thanhtien;

    //==========================================================================
    //Seter and Geter

    public String setTinhtrang() {
        return Tinhtrang;
    }

    public void setTinhtrang(String Tinhtrang) {
        this.Tinhtrang = Tinhtrang;
    }


    public double getThanhtien() {
        return Thanhtien;
    }

    public void setThanhtien() {
         if(this.Tinhtrang=="Mới"||this.Tinhtrang=="mới"||this.Tinhtrang=="moi"||this.Tinhtrang=="Moi"||this.Tinhtrang=="New"||this.Tinhtrang=="new")
            this.Thanhtien = this.getDongia()*this.getSoluong();
        else
            this.Thanhtien = this.getDongia()*this.getSoluong()*0.5;
    }
    //==========================================================================
    //Constructor.
    Sachgiaokhoa() {
        super();
        this.Tinhtrang = "";
        this.Thanhtien = 0;
    }

    Sachgiaokhoa(String Tinhtrang, int masach, String Ngaynhap, double Dongia, int Soluong, String Nhaxuatbat) {
        super(masach, Ngaynhap, Dongia, Soluong, Nhaxuatbat);
        this.Tinhtrang = Tinhtrang;
        setThanhtien();
    }
    //==========================================================================
    //Tostring.
    public String toString ()
    {
        String st="";
        st+=super.toString()+"|\t\t"+this.Tinhtrang+"|\t\t"+this.Thanhtien;
        return st;
    }
    
}
