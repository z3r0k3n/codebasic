/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Java_SQl  {
    private String url="jdbc:jtds:sqlserver://localhost:1433/SinhVien;instance=SQLEXPRESS";
    private String user="sa";
    private String pass="123";
    private Connection conn= null;
    private ResultSet rs;
    private Statement stmt;
    private String query;
    private PreparedStatement pstm; 
    //Bất đầu thao tác voiws sql.
    public Java_SQl ()
    {
        
        try {
            conn= DriverManager.getConnection(url,user,pass);
            stmt= conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Xem toàn bộ danh sách sinh viên.
    public ArrayList<SinhVien> Xemdanhsach () 
    {
        ArrayList<SinhVien> listSV=new ArrayList<>();
        try {
            query="select * from Thongtinsinhvien";
            rs=stmt.executeQuery(query);
            while (rs.next())
            {
                SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                listSV.add(sv);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSV;
    }
    /*Thêm mới sinh viên gồm (ID, Name, dia chi, tuoi): nếu sinh viên đó trùng 
    id thì báo về cho người dùng biết rằng việc thêm moi sinh vien không thành
    công ngược lại thì trả về thành công*/
   
    public int Themsinhvien(SinhVien sv)
    {
        int kq=0;
        
            try {
                query="insert into Thongtinsinhvien values(?,?,?,?)";
                pstm=conn.prepareStatement(query);
                pstm.setString(1, sv.getID());
                pstm.setString(2, sv.getName());
                pstm.setString(3, sv.getQue_quan());
                pstm.setDate(4, new java.sql.Date(sv.getBirthday().getTime()));
                kq=pstm.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Java_SQl.class.getName()).log(Level.SEVERE, null, ex);
            }
        return kq;
    }
    //=========================================================================
    /*Xóa một sinh viên: người dùng Nhập ID của sinh viên nếu tìm thấy ID chương
    trình tiến hành xóa sinh viên và nhận được thông báo thành công còn ngược 
    lại thì chương trình sẽ báo ko tìm thấy id*/
    public int xoasinhvien(String ID)
    {
        int kq=0;

        try {
                query="delete from Thongtinsinhvien where ID = ?";
                pstm=conn.prepareStatement(query);
                pstm.setString(1, ID);
                kq=pstm.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(Java_SQl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        return kq;
    }
    //==========================================================================
    /*Cập nhập thông tin một sinh vien: Người dùng sẽ nhập mã sinh viên cần cập nhập
    nếu không có id thì sẽ báo ko có id cần chỉnh sửa. Nếu ID có thì tiến hành 
    cập nhập tên, quê quán, Ngày sinh. */
    public int Capnhapsinhvien(SinhVien sv)
    {
        int kq=0;
        
            try {
                query="update Thongtinsinhvien set Name=?,Que_quan=?,Birthday=? where ID=?";
                pstm=conn.prepareStatement(query);
                pstm.setString(1, sv.getName());
                pstm.setString(2, sv.getQue_quan());
                pstm.setDate(3,  new java.sql.Date(sv.getBirthday().getTime()));
                pstm.setString(4, sv.getID());
                kq=pstm.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(Java_SQl.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return kq;
    }
    //==========================================================================
    /*Tìm sinh viên: người dùng nhập ID của sinh viên cần tìm server trả về 
    thông tin theo mã sinh viên nếu sinh viên đó không có trong danh sách thì 
    thông báo sinh viên đó không năm trong danh sách.*/
    public ArrayList<SinhVien> Timsinhvien (String ID) 
    {
        ArrayList<SinhVien> listSV = new ArrayList<>();
        try {
            
            query="select * from Thongtinsinhvien where ID = ?";
            pstm= conn.prepareStatement(query);
            pstm.setString(1, ID);
            rs=pstm.executeQuery();
            while (rs.next())
            {
                SinhVien sv= new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                listSV.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSV;
    }
}
