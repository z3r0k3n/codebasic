/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Server;

import java.io.Serializable;

/**
 *
 * @author Zero Ken
 */
public class Order implements Serializable{
    public static final int Them_khach_hang=1,Tinh_tien_phong=2,Exit=3;
    public static final String Loai_phong= "SAB";
    public static final int[] Giatien ={500000,250000,100000};
    private Khachhang kh;
    private int row,choice,day;
    private String Ten;
    private double Tien;

    public Khachhang getKh() {
        return kh;
    }

    public void setKh(Khachhang kh) {
        this.kh = kh;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public double getTien() {
        return Tien;
    }

    public void setTien(double Tien) {
        this.Tien = Tien;
    }
}
