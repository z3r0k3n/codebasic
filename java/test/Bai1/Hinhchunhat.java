/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author ASM
 */
public class Hinhchunhat {
    private double dai,rong,dt,cv;

    public double getDt() {
        return dt;
    }

    public void setDt() {
        this.dt=this.dai*this.rong;
    }

    public double getCv() {
        return cv;
    }

    public void setCv() {
        this.cv = (this.rong+this.dai)*2;
    }
    

    public double getDai() {
        return dai;
    }

    public void setDai(double dai) {
        this.dai = dai;
    }

    public double getRong() {
        return rong;
    }

    public void setRong(double rong) {
        this.rong = rong;
    }

    public Hinhchunhat(double dai, double rong) {
        this.dai = dai;
        this.rong = rong;
        setCv();
        setDt();
    }

    public Hinhchunhat() {
    }

    @Override
    public String toString() {
        String st="";
        st+="\nChiều dài của hình chữ nhật: "+dai;
        st+="\nchiều rộng của hình chữ nhật: "+rong;
        st+="\ndien tich hinh chữ nhat: "+getDt();
        st+="\nChu vi của hình chữ nhật: "+getCv();
        return st;
    }
    
}
