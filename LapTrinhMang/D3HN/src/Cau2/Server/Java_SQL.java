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
    
    public String Dangnhap (String user)
    {
        String kq="";
        query = "select * from Dangnhap where Name =?";
        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, user);
            rs = pstm.executeQuery();
            while (rs.next()) {
                kq=rs.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    
    
}
