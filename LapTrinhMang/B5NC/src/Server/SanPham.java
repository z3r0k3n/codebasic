/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.Serializable;

/**
 *
 * @author Zero Ken
 */
public class SanPham implements Serializable{
    int id;
    String TenSP;
    double gia;

    public SanPham(int id, String TenSP, double gia) {
        this.id = id;
        this.TenSP = TenSP;
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public SanPham() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
}
