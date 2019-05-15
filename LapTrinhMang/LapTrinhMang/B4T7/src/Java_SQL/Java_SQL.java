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
    private String url="jdbc:jtds:sqlserver://localhost:1433/Java_QLsach;instance=SQLEXPRESS";
    private String user = "sa";
    private String pass = "123";
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private String query;
    private PreparedStatement pstm;

    public Java_SQL() {
        try{
            conn=DriverManager.getConnection(url, user, pass);
            stmt=conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Sach> listBook()
    {
        ArrayList<Sach> listB = new ArrayList<>();
        try{
            query ="select * from Thong_tin_sach";
            rs=stmt.executeQuery(query);
            while (rs.next()) {
                Sach s=new Sach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                listB.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listB;
    }
    
    public int Muon_sach (String ID)
    {
        int row=0;
        try {
        query = "update Thong_tin_sach set So_luong_cho_muon = So_luong_cho_muon +1 where ID = ?";
        pstm=conn.prepareStatement(query);
        pstm.setString(1, ID);
        row = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    
    public int Tra_sach (String ID)
    {
        int row =0;
        try{
            query = "update Thong_tin_sach set So_luong_cho_muon= So_luong_cho_muon -1 where ID =?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, ID);
            row = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
}
