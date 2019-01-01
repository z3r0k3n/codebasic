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
public class Student extends Person{
    private double diem1,diem2;

    public double getDiem1() {
        return diem1;
    }

    public void setDiem1(double diem1) {
        this.diem1 = diem1;
    }

    public double getDiem2() {
        return diem2;
    }

    public void setDiem2(double diem2) {
        this.diem2 = diem2;
    }

    public Student(String hoten, String diachi,double diem1, double diem2) {
        super(hoten, diachi);
        this.diem1 = diem1;
        this.diem2 = diem2;
    }
    public double Diemtb()
    {
        return (this.diem1+this.diem2)/2;
    }
    public String Danhgia()
    {
        if(Diemtb()<5)
            return "Yếu";
        else if (Diemtb()>=5&&Diemtb()<7)
            return "Trung bình";
        else if (Diemtb()>=7&&Diemtb()<9)
            return "Khá";
        else 
            return "Giỏi";
    }

    @Override
    public String toString() {
        String st="";
        st+=super.toString()+"|\t\t"+this.diem1+"|\t\t"+this.diem2+"|\t\t"+Diemtb()+"|\t\t"+Danhgia()+"|";
        return st;
    }
    
}
