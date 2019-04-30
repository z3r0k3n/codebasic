/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_SQL;

import java.io.Serializable;

/**
 *
 * @author Zero Ken
 */
public class SanPham implements Serializable{
    String ID,TenSP;
    float Gia;
    int Soluongton;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenSP() {
        return TenSP;
    }

    @Override
    public String toString() {
        return "SanPham{" + "ID=" + ID + ", TenSP=" + TenSP + ", Gia=" + Gia + ", Soluongton=" + Soluongton + '}';
    }

    public SanPham() {
    }

    public SanPham(String ID, String TenSP, float Gia, int Soluongton) {
        this.ID = ID;
        this.TenSP = TenSP;
        this.Gia = Gia;
        this.Soluongton = Soluongton;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public float getGia() {
        return Gia;
    }

    public void setGia(float Gia) {
        this.Gia = Gia;
    }

    public int getSoluongton() {
        return Soluongton;
    }

    public void setSoluongton(int Soluongton) {
        this.Soluongton = Soluongton;
    }
    
}
