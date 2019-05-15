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
    public static final int Xem_sach =1;
    public static final int Muon_sach =2;
    public static final int Tra_sach =3;
    public static final int Ngat_ket_noi =4;
    
    int choice;
    String ID;
    
    public ArrayList<Sach> listB;

    public ArrayList<Sach> getListB() {
        return listB;
    }

    public void setListB(ArrayList<Sach> listB) {
        this.listB = listB;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
    
}
