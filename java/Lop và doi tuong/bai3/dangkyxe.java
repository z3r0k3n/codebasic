/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;
import java.util.Scanner;
/**
 *
 * @author ASM
 */
public class dangkyxe {
    Scanner input = new Scanner(System.in);
    private String tenchuxe;
    private String loaixe;
    private int dungtich;
    private float trigia;
    dangkyxe()
    {
        tenchuxe="";
        loaixe="";
        dungtich=0;
        trigia=0;
    }
    dangkyxe (String a,String b,int c,float d)
    {
        tenchuxe=a;
        loaixe=b;
        dungtich=c;
        trigia=d;
    }
    public void setTenChuXe ()
    {
        tenchuxe =input.nextLine();
    }
    public String getTenChuXe ()
    {
        return tenchuxe;
    }
    public void setLoaiXe ()
    {
        loaixe=input.nextLine();
    }
    public String getLoaiXe ()
    {
        return loaixe;
    }
    public void setDungTich ()
    {
        dungtich=input.nextInt();
    }
    public int getDungTich ()
    {
        return dungtich;
    }
    public void setTriGia ()
    {
        trigia = input.nextFloat();
    }
    public float getTriGia ()
    {
        return trigia;
    }
    public float Thue()
    {
        float th;
        if (dungtich<100)
        {
            th = trigia/100;
        }
        else if (dungtich>=100 & dungtich<=200)
        {
            th = trigia*3/100;
        }
        else
        {
            th=trigia*5/100;
        }
        return th;
    }
}