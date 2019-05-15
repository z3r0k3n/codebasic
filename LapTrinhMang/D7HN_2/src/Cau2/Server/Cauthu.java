/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Server;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Zero Ken
 */
public class Cauthu implements Serializable{
    private String ID,ten;
    private int vitrithidau;
    private Date namsinh;
    private double luongmacdinh;

    public int int_vitri (String str_vitri)
    {
        int i=0;
        while (i<=2) {
            if (Order.vitri[i].equals(str_vitri)) break;
            i++;
        }
        return i;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getVitrithidau() {
        return vitrithidau;
    }

    public void setVitrithidau(String vitrithidau) {
        this.vitrithidau = int_vitri(vitrithidau);
    }

    public Date getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(Date namsinh) {
        this.namsinh = namsinh;
    }

    public double getLuongmacdinh() {
        return luongmacdinh;
    }

    public void setLuongmacdinh(double luongmacdinh) {
        this.luongmacdinh = luongmacdinh;
    }

    public Cauthu() {
    }

    public Cauthu(String ID, String ten, String vitrithidau, Date namsinh,double luongmacdinh) {
        this.ID = ID;
        this.ten = ten;
        this.vitrithidau = int_vitri(vitrithidau);
        this.namsinh = namsinh;
        this.luongmacdinh = luongmacdinh;
    }

    @Override
    public String toString() {
        return "Cauthu{" + "ID=" + ID + ", ten=" + ten + ", vitrithidau=" + Order.vitri[vitrithidau] + ", namsinh=" + namsinh + ", luongmacdinh=" + luongmacdinh + '}';
    }
    
    
}
