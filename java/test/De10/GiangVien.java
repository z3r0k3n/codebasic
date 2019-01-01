/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De10;

import java.io.Serializable;

/**
 *
 * @author ASM
 */
public class GiangVien implements Serializable{
    private String hoten,magv,diachi,gioitinh,khoa;

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getMagv() {
        return magv;
    }

    public void setMagv(String magv) {
        this.magv = magv;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public GiangVien() {
        this.hoten = "";
        this.magv = "";
        this.diachi = "";
        this.gioitinh = "";
        this.khoa = "";
    }

    public GiangVien(String hoten, String magv, String diachi, String gioitinh, String khoa) {
        this.hoten = hoten;
        this.magv = magv;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.khoa = khoa;
    }

    @Override
    public String toString() {
        String st="";
        st+="\n|\t\t"+this.hoten+"|\t\t"+this.magv+"|\t\t"+this.diachi+"|\t\t"+this.gioitinh+"|\t\t"+this.khoa;
        return st;
    }
    
    
}
