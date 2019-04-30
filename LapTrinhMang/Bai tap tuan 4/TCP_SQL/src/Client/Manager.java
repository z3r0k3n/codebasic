/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_sql.Older;
import java_sql.SinhVien;



/**
 *
 * @author Zero Ken
 */
public class Manager {
    private Scanner in= new Scanner(System.in);
    private Socket clientSocket=null;
    private ObjectOutputStream Output=null;
    private ObjectInputStream Input=null;
    private Older older=null;
    
    
    
    //Ketnoi
    public Manager() {
        try {
            clientSocket=new Socket("localhost", 9999);
            Output=new ObjectOutputStream(clientSocket.getOutputStream());
            Input=new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Xem danh sách sinh viên.
    public void Xemdanhsach()
    {
        try {
            //Gưi.
            older=new Older();
            older.setChoice(Older.Xem_danh_sach_sinh_vien);
            Output.writeObject(older);
            //Nhận.
            older= (Older) Input.readObject();
            ArrayList<SinhVien> listSV=older.getListSv();
            //Xuất ra màn hình
            for (SinhVien sv:listSV) System.out.println(sv.toString());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Them mới một sinh viên
    public void Themsinhvien()
    {
        try {
            //Gửi.
            older=new Older();
            older.setChoice(Older.Them_mot_sinh_vien);
            SinhVien sv=new SinhVien();
            
            System.out.println("Them một sinh viên: ");
            System.out.println("Nhập ID:");
            sv.setID(in.nextLine());
            
            System.out.println("Nhập Tên:");
            sv.setName(in.nextLine());
            
            System.out.println("Nhập quê quán: ");
            sv.setQue_quan(in.nextLine());
            
            System.out.println("Nhập Ngày sinh(dd/MM/yyyy): ");
            String srtBirthday=in.nextLine().trim();
            DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            sv.setBirthday(format.parse(srtBirthday));
            older.setSv(sv);
            Output.writeObject(older);
            //Nhan
            older=(Older) Input.readObject();
            System.out.println(older.getThongbao());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Xóa một sinh viên
    public void Xoasinhvien()
    {
        try {
            //gui
            older=new Older();
            older.setChoice(Older.Xoa_mot_sinh_vien);
            
            System.out.println("Xóa một sinh viên: ");
            System.out.println("Nhập ID sinh viên cần xóa");
            older.setThongbao(in.nextLine());
            
            Output.writeObject(older);
            //Nhan
            older=(Older) Input.readObject();
            System.out.println(older.getThongbao());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Sửa một sinh viên
    public void capnhapsinhvien()
    {
        try {
            //Gửi
            older=new Older();
            older.setChoice(Older.Cap_nhap_mot_sinh_vien);
            SinhVien sv=new SinhVien();
            
            System.out.println("Cập nhập một sinh viên: ");
            System.out.println("Nhập ID sinh viên cần cập nhập: ");
            sv.setID(in.nextLine());
            
            System.out.println("Nhập Tên:");
            sv.setName(in.nextLine());
            
            System.out.println("Nhập quê quán: ");
            sv.setQue_quan(in.nextLine());
            
            System.out.println("Nhập Ngày sinh(dd/MM/yyyy): ");
            String srtBirthday=in.nextLine().trim();
            DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            sv.setBirthday(format.parse(srtBirthday));
            older.setSv(sv);
            Output.writeObject(older);
            //Nhan
            older=(Older) Input.readObject();
            System.out.println(older.getThongbao());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Tìm kiếm một sinh viên
    public void Timkiemsinhvien()
    {
        try {
            //Gửi
            older=new Older();
            older.setChoice(Older.Tim_kiem_mot_sinh_vien);
            
            System.out.println("Tìm kiếm thông tin một sinh viên");
            System.out.println("Nhập ID sinh viên cần Tìm kiếm: ");
            older.setThongbao(in.nextLine());
            
            Output.writeObject(older);
            //Nhận
            older=(Older)Input.readObject();
            ArrayList<SinhVien> listSV=older.getListSv();
            for (SinhVien sv:listSV) System.out.println(sv.toString());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void exit()
        {
        try {
            older=new Older();
            older.setChoice(Older.Ngat_ket_noi);
            Output.writeObject(older);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
