/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_SQL;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Zero Ken
 */
public class Account implements Serializable{
    private String ID;
    private double BALANCE;
    private Date DEPOSITDAY, WITHDRAWDAY;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getBALANCE() {
        return BALANCE;
    }

    public void setBALANCE(double BALANCE) {
        this.BALANCE = BALANCE;
    }

    public Account(String ID, double BALANCE, Date DEPOSITDAY, Date WITHDRAWDAY) {
        this.ID = ID;
        this.BALANCE = BALANCE;
        this.DEPOSITDAY = DEPOSITDAY;
        this.WITHDRAWDAY = WITHDRAWDAY;
    }

    public Date getDEPOSITDAY() {
        return DEPOSITDAY;
    }

    public void setDEPOSITDAY(Date DEPOSITDAY) {
        this.DEPOSITDAY = DEPOSITDAY;
    }

    public Date getWITHDRAWDAY() {
        return WITHDRAWDAY;
    }

    public void setWITHDRAWDAY(Date WITHDRAWDAY) {
        this.WITHDRAWDAY = WITHDRAWDAY;
    }

    public Account() {
    }

    @Override
    public String toString() {
        DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        return "Account{" + "ID=" + ID + ", BALANCE=" + BALANCE + ", DEPOSITDAY=" + format.format(DEPOSITDAY) + ", WITHDRAWDAY=" + format.format(WITHDRAWDAY) + '}';
    }
    
}
