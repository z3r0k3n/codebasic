/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_SQL;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Zero Ken
 */
public class Older implements Serializable{
    public static final int TIM_KIEM_SAN_PHAM=1,LAP_HOA_DON=2,EXIT=3;
    
    private SanPham sp;
    private ArrayList<SanPham> listsp;
    private String ID;
    private int choice;
    private ArrayList<Hoadon> HD;
    private double tongtien;

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public ArrayList<Hoadon> getHD() {
        return HD;
    }

    public void setHD(ArrayList<Hoadon> HD) {
        this.HD = HD;
    }




    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    
    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public ArrayList<SanPham> getListsp() {
        return listsp;
    }

    public void setListsp(ArrayList<SanPham> listsp) {
        this.listsp = listsp;
    }

    public Older() {
    }
    
}
