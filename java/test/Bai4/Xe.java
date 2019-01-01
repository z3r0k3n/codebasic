/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4;

/**
 *
 * @author ASM
 */
public class Xe {
    private String machuyen,taixe,soxe;
    private double doanhthu;

    public double getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(double doanhthu) {
        this.doanhthu = doanhthu;
    }
    

    public String getMachuyen() {
        return machuyen;
    }

    public void setMachuyen(String machuyen) {
        this.machuyen = machuyen;
    }

    public String getTaixe() {
        return taixe;
    }

    public void setTaixe(String taixe) {
        this.taixe = taixe;
    }

    public String getSoxe() {
        return soxe;
    }

    public void setSoxe(String soxe) {
        this.soxe = soxe;
    }

    public Xe(String machuyen, String taixe, String soxe, double doanhthu) {
        this.machuyen = machuyen;
        this.taixe = taixe;
        this.soxe = soxe;
        this.doanhthu = doanhthu;
    }

    @Override
    public String toString() {
        String st="";
        st+="|\t\t"+this.machuyen+"|\t\t"+this.taixe+"|\t\t"+this.soxe;
        return st;
    }
    
}
