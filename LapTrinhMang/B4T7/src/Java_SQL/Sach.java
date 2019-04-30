/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_SQL;

import java.io.Serializable;

/**
 *
 * @author Zero Ken
 */
public class Sach implements Serializable{
    String ID,Ten_sach,Nha_xuat_ban;
    int Tong_so_luong,So_luong_cho_muon;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTen_sach() {
        return Ten_sach;
    }

    public void setTen_sach(String Ten_sach) {
        this.Ten_sach = Ten_sach;
    }

    public String getNha_xuat_ban() {
        return Nha_xuat_ban;
    }

    public void setNha_xuat_ban(String Nha_xuat_ban) {
        this.Nha_xuat_ban = Nha_xuat_ban;
    }

    public int getTong_so_luong() {
        return Tong_so_luong;
    }

    public void setTong_so_luong(int Tong_so_luong) {
        this.Tong_so_luong = Tong_so_luong;
    }

    public int getSo_luong_cho_muon() {
        return So_luong_cho_muon;
    }

    public void setSo_luong_cho_muon(int So_luong_cho_muon) {
        this.So_luong_cho_muon = So_luong_cho_muon;
    }

    public Sach(String ID, String Ten_sach, String Nha_xuat_ban, int Tong_so_luong, int So_luong_cho_muon) {
        this.ID = ID;
        this.Ten_sach = Ten_sach;
        this.Nha_xuat_ban = Nha_xuat_ban;
        this.Tong_so_luong = Tong_so_luong;
        this.So_luong_cho_muon = So_luong_cho_muon;
    }

    public Sach() {
    }

    @Override
    public String toString() {
        return "Sach{" + "ID=" + ID + ", Ten_sach=" + Ten_sach + ", Nha_xuat_ban=" + Nha_xuat_ban + ", Tong_so_luong=" + Tong_so_luong + ", So_luong_cho_muon=" + So_luong_cho_muon + '}';
    }
    
}
