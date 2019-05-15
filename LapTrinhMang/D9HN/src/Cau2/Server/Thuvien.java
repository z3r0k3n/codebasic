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
public class Thuvien implements Serializable{
    private String ID,Tensach,nguoimuon;

    @Override
    public String toString() {
        return "Thuvien{" + "ID=" + ID + ", Tensach=" + Tensach + ", nguoimuon=" + nguoimuon + '}';
    }

    public Thuvien() {
    }

    public Thuvien(String ID, String Tensach, String nguoimuon) {
        this.ID = ID;
        this.Tensach = Tensach;
        this.nguoimuon = nguoimuon;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTensach() {
        return Tensach;
    }

    public void setTensach(String Tensach) {
        this.Tensach = Tensach;
    }

    public String getNguoimuon() {
        return nguoimuon;
    }

    public void setNguoimuon(String nguoimuon) {
        this.nguoimuon = nguoimuon;
    }
}
