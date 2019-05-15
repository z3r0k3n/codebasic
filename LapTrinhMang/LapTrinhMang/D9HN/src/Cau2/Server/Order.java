/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Server;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Zero Ken
 */
public class Order implements Serializable{
    public static  final int Xem_Danh_Sach=1,Muon_Sach=2,Exit=3;
    private ArrayList<Thuvien> Listsach = new ArrayList<>();
    private int row,choice;

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public Order() {
    }

    public ArrayList<Thuvien> getListsach() {
        return Listsach;
    }

    public void setListsach(ArrayList<Thuvien> Listsach) {
        this.Listsach = Listsach;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
