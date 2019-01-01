/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7;

/**
 *
 * @author ASM
 */
public class Person {
    private String hoten,diachi;

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Person(String hoten, String diachi) {
        this.hoten = hoten;
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        String st="";
        st+="|\t\t"+this.hoten+"|\t\t"+this.diachi;
        return st;
    }
    
}
