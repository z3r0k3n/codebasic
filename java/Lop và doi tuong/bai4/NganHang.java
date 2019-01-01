/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4;

/**
 *
 * @author ASM
 */
public class NganHang {
    private long sotk;
    private String tentk;
    private double sotien;
    NganHang ()
    {
        sotk=0;
        tentk="";
        sotien=0;
    }
    NganHang (long a,String b,double c)
    {
        sotk=a;
        tentk=b;
        sotien=c;
    }
    public void setSoTK (long a)
    {
        sotk=a;
    }
    public long getSoTK ()
    {
        return sotk;
    }
    public void setTenTK (String b)
    {
        tentk=b;
    }
    public String getTenTK ()
    {
        return tentk;
    }
    public void setSoTien (double c)
    {
        sotien=c;
    }
    public double getSoTien ()
    {
        return sotien;
    }
    public String ToString ()
    {
        String st= "";
        st+="\n Số Tài Khoản: " +sotk;
        st+="\n Tên Tài Khoản: "+tentk;
        st+="\n Số Tiền Trong Tài Khoản: "+sotien+" USD";
        return st;
    }
    private double ls=0.035;
    NganHang (long a,String b)
    {
        sotk=a;
        tentk=b;
        sotien=50;
    }
    public double NapTien (double tiennap)
    {
        if (tiennap<=0)
        {
            System.out.printf ("Số tiền nạp không hợp lệ");
            return 0;
        }
        else
        {
            sotien +=tiennap;
            return sotien;
        }
    }
    public double RutTien (double tienrut)
    {
        if (tienrut>sotien)
        {
            System.out.printf ("Số tiền rút lớn hơn sô tiền trong tài khoản.");
            return 0;
        }
        else
        {
            sotien +=tienrut;
            return sotien;
        }
        
    }
    public double DaoHan ()
    {
        
        sotien+=(sotien*ls);
        return sotien;
    }
}
