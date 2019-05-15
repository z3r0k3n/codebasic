/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Server.Interface_RMI;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_sql.SinhVien;

/**
 *
 * @author Zero Ken
 */
public class Manager {
    private Scanner in= new Scanner(System.in);
    private Interface_RMI IR;

    public Manager() {
        try {
            IR= (Interface_RMI) Naming.lookup("rmi://localhost:9999/sinhvien");
        } catch (NotBoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void XemSinhvien()
    {
        ArrayList<SinhVien> lsv= new ArrayList<>();
        try {
            lsv= IR.Xemsinhvien();
            for(SinhVien sinhvien: lsv)
            {
                System.out.println(sinhvien.toString());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Themsinhvien()
    {
        int i;
        try {
            System.out.println("Server-> Thêm sinh viên: ");
            i= IR.Themsinhvien(inputsv());
            System.out.println("Server-> row:" + i);
        } catch (RemoteException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Xoasinhvien()
    {
        int i;
        try{
            System.out.println("Server-> Xóa sinh viên");
            System.out.println("Server-> nhập mã sinh viên");
            i=IR.XoaSinhvien(in.nextLine());
            System.out.println("Server-> row:" + i);
        } catch (RemoteException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Capnhapsinhvien()
    {
        int i;
        try{
            System.out.println("Server-> Cập nhập sinh viên");
            i=IR.CapnhapSinhvien(inputsv());
            System.out.println("Server-> row:" + i);
        } catch (RemoteException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void timkiemsinhvien()
    {
        ArrayList<SinhVien> listSinhvien = new ArrayList<>();
        try{
            System.out.println("Server-> Tìm kiếm sinh viên");
            System.out.println("server-> Nhập mã sinh viên");
            listSinhvien= IR.Timkiemsinhvien(in.nextLine());
            for(SinhVien sv: listSinhvien)
            {
                System.out.println(sv.toString());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public SinhVien inputsv()
    {
        SinhVien sv=new SinhVien();
        System.out.println("Nhập ID:");
        sv.setID(in.nextLine());
        System.out.println("Nhập Name:");
        sv.setName(in.nextLine());
        System.out.println("Nhập quê quán:");
        sv.setQue_quan(in.nextLine());
        System.out.println("Nhập ngày sinh:");
        String strBirth = in.nextLine();
        DateFormat form= new SimpleDateFormat("dd/MM/yyyy");
        try {
            sv.setBirthday(form.parse(strBirth));
        } catch (ParseException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sv;
    }
    public int choice ()
    {
        int i=0;
        System.out.println("Menu:\n1.Xem danh sách sinh viên.\n2.Thêm sinh viên.\n3.Xóa sinh viên.\n4.Cập nhập sinh viên.\n5.Tìm kiếm sinh viên\n6. Exit\nChoice:");
        i=in.nextInt();
        in.nextLine();
        return i;
    }
}
