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
public class Xengoai extends Xe{
    private String noiden;
    private int songay;

    public String getNoiden() {
        return noiden;
    }

    public void setNoiden(String noiden) {
        this.noiden = noiden;
    }

    public int getSongay() {
        return songay;
    }

    public void setSongay(int songay) {
        this.songay = songay;
    }

    public Xengoai(String machuyen, String taixe, String soxe, String noiden, int songay, double doanhthu) {
        super(machuyen, taixe, soxe, doanhthu);
        this.noiden = noiden;
        this.songay = songay;
    }

    @Override
    public String toString() {
        String st="";
        st+=super.toString()+"|\t\t"+this.noiden+"|\t\t"+this.songay+"|";
        return st;
    }
    
}
