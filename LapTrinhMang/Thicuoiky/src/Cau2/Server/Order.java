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
    public static final int Anh_viet =1,Viet_anh=2,Anh_ngia=3,Exit =4;
    private String Anh,Viet,Nghia;
    private int choice;

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }

    public String getViet() {
        return Viet;
    }

    public void setViet(String Viet) {
        this.Viet = Viet;
    }

    public String getNghia() {
        return Nghia;
    }

    public void setNghia(String Nghia) {
        this.Nghia = Nghia;
    }
}
