/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7;

/**
 *
 * @author ASM
 */
public class Customer extends Person{
    private String tencongty;
    private double trigia;

    public String getTencongty() {
        return tencongty;
    }

    public void setTencongty(String tencongty) {
        this.tencongty = tencongty;
    }

    public double getTrigia() {
        return trigia;
    }

    public void setTrigia(double trigia) {
        this.trigia = trigia;
    }

    public Customer(String hoten, String diachi,String tencongty,double trigia) {
        super(hoten, diachi);
        this.tencongty = tencongty;
        this.trigia = trigia;
    }

    public String Danhgia()
    {
        if(this.trigia>100000000)
            return "VIP";
        else
            return "";
    }
    @Override
    public String toString() {
        String st="";
        st+=super.toString()+"|\t\t"+this.tencongty+"|\t\t"+this.trigia+"|\t\t"+Danhgia()+"|";
        return st;
    }
    
}
