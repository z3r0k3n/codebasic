/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *extends
 * @author ASM
 */
public class Xe {
    private String Sochuyen;
    private String Taixe;
    private String Soxe;
    private double Doanhthu;
    //--------------------------------------------------------------------------
    //Seter/geter
    public void setSochuyen(String a)
    {
        this.Sochuyen=a;
    }
    public String getSochuyen()
    {
        return Sochuyen;
    }
    public void setTaixe(String b)
    {
        this.Taixe=b;
    }
    public String getTaixe()
    {
        return Taixe;
    }
    public void setSoxe(String c)
    {
        this.Soxe=c;
    }
    public String getSoxe()
    {
        return Soxe;
    }
    public void setDoanhthu(double d)
    {
        this.Doanhthu=d;
    }
    public double getDoangthu()
    {
       return Doanhthu;
    }
    Xe(){
    }
    Xe(String Sochuyen,String Taixe,String Soxe,double Doanhthu)       
    {
        this.Sochuyen=Sochuyen;
        this.Taixe=Taixe;
        this.Soxe=Soxe;
        this.Doanhthu=Doanhthu;
    }
  
    public String toString ()
    {
        String st="";
        st+="\n|\t\t"+this.Sochuyen+"|\t\t"+this.Taixe+"|\t\t"+this.Soxe+"|\t\t"+this.Doanhthu;
        return st;
    }
}
