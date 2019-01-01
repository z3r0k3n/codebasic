/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De3;

/**
 *
 * @author ASM
 */
public class Nhavien extends Person{
    private String phongban;
    private double hesoluong,thamnien,luongcoban;

    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }

    public double getHesoluong() {
        return hesoluong;
    }

    public void setHesoluong(double hesoluong) {
        this.hesoluong = hesoluong;
    }

    public double getThamnien() {
        return thamnien;
    }

    public void setThamnien(double thamnien) {
        this.thamnien = thamnien;
    }

    public double getLuongcoban() {
        return luongcoban;
    }

    public void setLuongcoban(double luongcoban) {
        this.luongcoban = luongcoban;
    }

    public Nhavien() {
        super();
        this.phongban = "";
        this.hesoluong = 0;
        this.thamnien = 0;
        this.luongcoban = 0;
    }

    public Nhavien(String hoten, String ngaysinh, String diachi, String gioitinh,String phongban, double hesoluong, double thamnien, double luongcoban) {
        super(hoten, ngaysinh, diachi, gioitinh);
        this.phongban = phongban;
        this.hesoluong = hesoluong;
        this.thamnien = thamnien;
        this.luongcoban = luongcoban;
    }

    public double luongthucling()
    {
        return luongcoban*hesoluong*(1+thamnien/100);
    }
    @Override
    public String toString() {
        String st="";
        st+=super.toString()+"|\t"+this.phongban+"|\t"+this.hesoluong+"|\t"+this.thamnien+"|\t"+this.luongcoban+"|\t"+luongthucling()+"|";
        return st;
    }
    
}
