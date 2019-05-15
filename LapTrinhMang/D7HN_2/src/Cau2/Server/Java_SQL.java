/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Server;

import java.sql.Connection;
import java.sql.Date;
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
    
    public int Themcauthu(Cauthu ct)
    {
        int row =0;
        query = "insert into cauthu values (?,?,?,?,?)";
        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, ct.getID());
            pstm.setString(2, ct.getTen());
            pstm.setDate(3, new Date(ct.getNamsinh().getTime()));
            pstm.setInt(4, ct.getVitrithidau());
            pstm.setDouble(5, ct.getLuongmacdinh());
            row = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    
    public double tongluong (String ID, int sotran)
    {
        double luong = 0;
        query ="select * from cauthu where ID =?";
        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, ID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                luong = rs.getDouble(5)+sotran*rs.getDouble(5)*Order.thuong[rs.getInt(4)];
            }
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return luong;
    }
}
