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
public class Employee extends Person{
    private double hesoluong;

    public double getHesoluong() {
        return hesoluong;
    }

    public void setHesoluong(double hesoluong) {
        this.hesoluong = hesoluong;
    }

    public Employee(String hoten, String diachi,double hesoluong) {
        super(hoten, diachi);
        this.hesoluong = hesoluong;
    }
    public double Tinhluong()
    {
        return this.hesoluong*5000000;
    }

    @Override
    public String toString() {
        String st="";
        st+=super.toString()+"|\t\t"+this.hesoluong+"|\t\t"+Tinhluong()+"|";
        return st;
    }
    
}
