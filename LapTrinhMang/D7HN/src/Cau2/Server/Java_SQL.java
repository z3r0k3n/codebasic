/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Java_SQL {
    private String url="jdbc:jtds:sqlserver://localhost:1433/Java_SQL;instance=SQLEXPRESS",user="sa",pass="123",query;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pstm;

    public Java_SQL() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int Themkh(Khachhang kh)
    {
        int row = 0;
        query = "insert into khachsan values (?,?,?)";
        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, kh.getID());
            pstm.setString(2, kh.getTen_khach_hang());
            pstm.setInt(3, kh.getLoai_phong());
            row = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return row;
    }
    
    public double Tongtien (String name,int day)
    {
        
        double tien = 0;
        query = "select * from khachsan where name = ?";
        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, name);
            rs=pstm.executeQuery();
            while (rs.next()) {
                tien = Order.Giatien[rs.getInt(3)]*day;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tien;
    }
}
