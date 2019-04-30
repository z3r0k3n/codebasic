/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_sql;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zero Ken
 */
public class Older implements Serializable{
    public static final int Xem_danh_sach_sinh_vien=1;
    public static final int Them_mot_sinh_vien=2;
    public static final int Xoa_mot_sinh_vien=3;
    public static final int Cap_nhap_mot_sinh_vien=4;
    public static final int Tim_kiem_mot_sinh_vien=5;
    public static final int Ngat_ket_noi=6;
    
    private int choice;
    //xem danh sach sinh vien
    private ArrayList<SinhVien> ListSv=new ArrayList<>();
    // thông báo từ việc them,xoa,cap nhap
    private String Thongbao;
    //Them và tìm kiêm
    private SinhVien sv;
    //row ket qua
    private int row;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }
    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public String getThongbao() {
        return Thongbao;
    }

    public void setThongbao(String Thongbao) {
        this.Thongbao = Thongbao;
    }
    public ArrayList<SinhVien> getListSv() {
        return ListSv;
    }

    public void setListSv(ArrayList<SinhVien> ListSv) {
        this.ListSv = ListSv;
    }
    
}
