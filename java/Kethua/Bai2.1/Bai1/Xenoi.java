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
public class Xenoi extends Xe {
    private int Sotuyen;
    private double Sokm;
    public void setSotuyen(int a)
    {
        this.Sotuyen=a;
    }
    public int getSotuyen()
    {
        return Sotuyen;
    }
    public void setSokm(double b)
    {
        this.Sokm=b;
    }
    public double getSokm ()
    {
        return Sokm;
    }
    Xenoi()
    {
        super();
        this.Sotuyen=0;
        this.Sokm=0;
    }
    Xenoi(String Sochuyen,String Taixe,String Soxe,double Doanhthu,int Sotuyen,double Sokm)
    {
        super(Sochuyen,Taixe,Soxe,Doanhthu);
        this.Sotuyen=Sotuyen;
        this.Sokm=Sokm;
    }
    public String toString ()
    {
      String st="";
      st+=super.toString()+"|\t\t"+this.Sotuyen+"|\t\t"+this.Sokm+"|";
      return st;
    }
}
