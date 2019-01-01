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
public class Xenoi extends Xe{
    private int sotuyen;
    private double sokm;

    public int getSotuyen() {
        return sotuyen;
    }

    public void setSotuyen(int sotuyen) {
        this.sotuyen = sotuyen;
    }

    public double getSokm() {
        return sokm;
    }

    public void setSokm(double sokm) {
        this.sokm = sokm;
    }

    public Xenoi(String machuyen, String taixe, String soxe,int sotuyen, double sokm, double doanhthu) {
        super(machuyen, taixe, soxe, doanhthu);
        this.sotuyen = sotuyen;
        this.sokm = sokm;
    }

    @Override
    public String toString() {
        String st="";
        st+=super.toString()+"|\t\t"+this.sotuyen+"|\t\t"+this.sokm+"|";
        return st;
    }
    
}
