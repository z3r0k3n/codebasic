/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author ASM
 */
public class sinhvien {
    private int masv;
    private String hoten;
    private float diemlt;
    private float diemth;
    sinhvien ()
    {
        masv = 0;
        hoten ="";
        diemlt=0;
        diemth=0;
    }
    sinhvien (int a,String b,float c,float d)
    {
        masv =a;
        hoten=b;
        diemlt=c;
        diemth=d;
    }
    public void setMasv (int a)
    {
        masv=a;
    }
    public int getMasv ()
    {
        return masv;
    }
    public void setHoten (String b)
    {
        hoten=b;
    }
    public String getHoten ()
    {
       return hoten;
    }
    public void setDiemLT (float c)
    {
        diemlt=c;
    }
    public float getDiemLT ()
    {
        return diemlt;
    }
    public void setDiemTH (float d)
    {
        diemth = d;
    }
    public float getDiemTH ()
    {
        return diemth;
    }
    public float DiemTB()
    {
        float tb=(diemlt+diemth)/2;
        return tb;
    }
    public String ToString ()
    {
        String st="";
        st+="\n Mã Sinh Viên: "+ masv;
        st+="\n Họ Tên Sing Viên: "+hoten;
        st+="\n Điểm Lý Thuyết: "+diemlt;
        st+="\n Điểm Thực Hành: "+diemth;
        st+="\n Điểm Trung Bình: "+DiemTB();
        return st;
    }
}
