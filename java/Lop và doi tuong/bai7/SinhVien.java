/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai7;

/**
 *
 * @author ASM
 */
public class SinhVien {
    private int MaSV,SDT;
    private String Name,DC;
    //--------------------------------------------------------------------------
    public void setMaSV(int a)
    {
        this.MaSV=a;
    }
    public int getMaSV()
    {
        return MaSV;
    }
    public void setName (String b)
    {
        this.Name=b;
    }
    public String getName()
    {
        return Name;
    }
    public void setDC(String c)
    {
        this.DC=c;
    }
    public String getDC()
    {
        return DC;
    }
    public void setSDT(int d)
    {
        this.SDT=d;
    }
    public int getSDT()
    {
        return SDT;
    }
    //--------------------------------------------------------------------------
    SinhVien ()
    {
        this.MaSV=0;
        this.Name="EMPTY";
        this.DC="EMPTY";
        this.SDT=0;
    }
    SinhVien(int a,String b,String c,int d)
    {
        this.MaSV=a;
        this.Name=b;
        this.DC=c;
        this.SDT=d;
    }
    //--------------------------------------------------------------------------
}
