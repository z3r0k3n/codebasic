/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_SQL;

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
public class Java_SQL {
    private String Url="jdbc:jtds:sqlserver://localhost:1433/Cuahang;instance=SQLEXPRESS",user="sa",pass="123",query;
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private PreparedStatement pstm;

    public Java_SQL() {
        try {
            conn= DriverManager.getConnection(Url, user, pass);
            stmt= conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<SanPham> listSP (String ID)
    {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            
            query = "select * from Sanpham  where ID = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, ID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sp= new SanPham(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
                list.add(sp);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    /*Xử lý hóa đơn: hóa đơn trước sẽ mang cá giá trị như mã sản phầm và số lương
    hoa dơn sau là hoa dơn đã được xử hoàn thành từ thông tin hóa đơn trước đưa vào
    viec tình thành tiền cho từng sản phẩm sẽ do class xử lý việc tính tổng tiền
    thì do server sử lý sau khi hoàn thành hóa đơn sau */
    public ArrayList<Hoadon> giatien (ArrayList<Hoadon> hoadontruoc)
    {
        ArrayList<Hoadon> hoadonsau = new ArrayList<>();
        query = "select * from Sanpham where ID =?";
        try{
            pstm= conn.prepareStatement(query);
            for (Hoadon hd: hoadontruoc)
            {
                pstm.setString(1, hd.getID());
                rs=pstm.executeQuery();
                while (rs.next()) {
                    SanPham SP= new SanPham(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
                    Hoadon HD= new Hoadon(SP.getID(), SP.getTenSP(), hd.getSoluong(), SP.getGia());
                    hoadonsau.add(HD);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoadonsau;
    }
    
    
}
