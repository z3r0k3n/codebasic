/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_sql;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Zero Ken
 */
public class SinhVien implements Serializable{
    private String ID,Name,Que_quan;
    private Date Birthday;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getQue_quan() {
        return Que_quan;
    }

    public void setQue_quan(String Que_quan) {
        this.Que_quan = Que_quan;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    public SinhVien(){
    }
    
    public SinhVien(String ID, String Name, String Que_quan, Date Birthday) {
        this.ID = ID;
        this.Name = Name;
        this.Que_quan = Que_quan;
        this.Birthday = Birthday;
    }

    
    @Override
    public String toString() {
        DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        return "SinhVien{" + "ID=" + ID + ", Name=" + Name + ", Que_quan=" + Que_quan + ", Birthday=" + format.format(Birthday)+'}';
    }

    
   
}
