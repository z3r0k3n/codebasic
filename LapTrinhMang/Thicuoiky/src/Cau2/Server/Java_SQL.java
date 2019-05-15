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
    //Anh_viet
    public String Anh_viet (String Anh)
    {
        String viet="";
        query = "select * from Tudien where Anh =?";
        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, Anh);
            rs = pstm.executeQuery();
            while (rs.next()) {
                viet = rs.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return viet;
    }
    //Viet_anh
    public String Viet_anh (String Viet)
    {
        String anh="";
        query = "select * from Tudien where Viet = ?";
        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, Viet);
            rs = pstm.executeQuery();
            while (rs.next()) {
                anh = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return anh;
    }
    //Anh_Nghia
    public String Anh_Nghia (String Anh)
    {
        String nghia="";
        query = "select * from Tudien where Anh =?";
        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, Anh);
            rs = pstm.executeQuery();
            while (rs.next()) {
                nghia = rs.getString(3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nghia;
    }
}
