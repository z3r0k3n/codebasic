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
import java.sql.Statement;
import java.util.ArrayList;
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
    private Statement stmt;
    private PreparedStatement pstm;

    public Java_SQL() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Thuvien> listSach ()
    {
        ArrayList<Thuvien> list = null;
        query = "select * from thuvien";
        try {
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Thuvien tv = new Thuvien(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(tv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public String Timsach (String tensach)
    {
        String nguoimuon="";
        query = "select * form Thuvien where Tensach = ?";
        try {
            pstm = conn.prepareCall(query);
            pstm.setString(1, tensach);
            rs = pstm.executeQuery();
            while (rs.next()) {
                nguoimuon = rs.getString(3).trim();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nguoimuon;
    }
    
    public int muon (String Nguoimuon,String Tensach)
    {
        int row=0;
        query="update Thuvien set Nguoimuon Nguoimuon = ? where Tensach= ?";
        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, Nguoimuon);
            pstm.setString(2, Tensach);
            row = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return row;
    }
}
