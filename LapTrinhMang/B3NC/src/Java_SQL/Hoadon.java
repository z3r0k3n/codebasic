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
public class Hoadon implements Serializable{
    private String ID,sanpham;
    private int Soluong;
    private double dongia,thanh_tien;

    @Override
    public String toString() {
        return "Hoadon{" + "ID=" + ID + ", sanpham=" + sanpham + ", Soluong=" + Soluong + ", dongia=" + dongia + ", thanh_tien=" + thanh_tien + '}';
    }

    public Hoadon() {
    }

    public Hoadon(String ID, String sanpham, int Soluong, double dongia) {
        this.ID = ID;
        this.sanpham = sanpham;
        this.Soluong = Soluong;
        this.dongia = dongia;
        this.thanh_tien = this.Soluong*this.dongia;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSanpham() {
        return sanpham;
    }

    public void setSanpham(String sanpham) {
        this.sanpham = sanpham;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getThanh_tien() {
        return thanh_tien;
    }

    public void setThanh_tien(double thanh_tien) {
        this.thanh_tien = thanh_tien;
    }
    
}
