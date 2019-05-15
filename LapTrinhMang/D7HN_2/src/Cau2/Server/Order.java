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
    public static final int Them_cau_thu_moi=1,Tinh_tong_luong_thang_cua_cau_thu=2,Exit=3;
    public static final String[] vitri={"tiền đạo","hậu vệ","trung vệ"};
    public static final double[] thuong = {0.025 , 0.02 , 0.015};
    private Cauthu ct;
    private int row,sotran,choice;
    private double tongluong;

    public double getTongluong() {
        return tongluong;
    }

    public void setTongluong(double tongluong) {
        this.tongluong = tongluong;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
    private String ID;
    

    public Cauthu getCt() {
        return ct;
    }

    public void setCt(Cauthu ct) {
        this.ct = ct;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSotran() {
        return sotran;
    }

    public void setSotran(int sotran) {
        this.sotran = sotran;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
}
