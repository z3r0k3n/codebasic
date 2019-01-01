/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author ASM
 */
public class Xengoai extends Xe{
    private String Noiden;
    private int Songay;
Xengoai()
{
    super();
    this.Noiden="";
    this.Songay=0;
}
Xengoai(String Sochuyen,String Taixe,String Soxe,double Doanhthu,String Noiden,int Songay)
{
    super(Sochuyen,Taixe,Soxe,Doanhthu);
    this.Noiden=Noiden;
    this.Songay=Songay;
}
public String toString ()
{
    String st="";
    st+=super.toString() + "|\t\t" + this.Noiden + "|\t\t" + this.Songay+"|";
    return st;
}

    public String getNoiden() {
        return Noiden;
    }

    public int getSongay() {
        return Songay;
    }

    public void setNoiden(String Noiden) {
        this.Noiden = Noiden;
    }

    public void setSongay(int Songay) {
        this.Songay = Songay;
    }
}
