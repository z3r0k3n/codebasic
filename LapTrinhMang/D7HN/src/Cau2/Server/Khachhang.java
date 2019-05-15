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
public class Khachhang implements Serializable{
    private String ID,Ten_khach_hang;
    private int Loai_phong;

    public Khachhang(String ID, String Ten_khach_hang, String Loai_phong) {
        this.ID = ID;
        this.Ten_khach_hang = Ten_khach_hang;
        this.Loai_phong = Order.Loai_phong.indexOf(Loai_phong);
    }

    @Override
    public String toString() {
        return "Khachhang{" + "ID=" + ID + ", Ten_khach_hang=" + Ten_khach_hang + ", Loai_phong=" + Order.Loai_phong.charAt(Loai_phong) + "}";
    }

    public Khachhang() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTen_khach_hang() {
        return Ten_khach_hang;
    }

    public void setTen_khach_hang(String Ten_khach_hang) {
        this.Ten_khach_hang = Ten_khach_hang;
    }

    public int getLoai_phong() {
        return Loai_phong;
    }

    public void setLoai_phong(String Loai_phong) {
        this.Loai_phong = Order.Loai_phong.indexOf(Loai_phong);
    }
}
