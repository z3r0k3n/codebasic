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
    public static final int TAO_MOI_TAI_KHOAN=1,XEM_DANH_SACH_TAI_KHOAN=2,GUI_TIEN=3,RUT_TIEN=4;
    
    private Account newacc;
    private int choice;
    private int row;
    private ArrayList<Account> list;
    private double sotien;
    private String ID;

    public double getSotien() {
        return sotien;
    }

    public void setSotien(double sotien) {
        this.sotien = sotien;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<Account> getList() {
        return list;
    }

    public void setList(ArrayList<Account> list) {
        this.list = list;
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
    
    public Account getNewacc() {
        return newacc;
    }

    public void setNewacc(Account newacc) {
        this.newacc = newacc;
    }
    
}
