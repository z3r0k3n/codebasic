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
    private String url="jdbc:jtds:sqlserver://localhost:1433/Taikhoannganhang;instance=SQLEXPRESS";
    private String user="sa";
    private String pass="123";
    private Connection conn= null;
    private ResultSet rs;
    private Statement stmt;
    private String query;
    private PreparedStatement pstm;
    //Ket noi
    public Java_SQL()
    {
        
        try {
            conn= DriverManager.getConnection(url,user,pass);
            stmt= conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int newacc(Account acc)
    {
        int row=0;
        query = "insert into Account values (?,?,?,?)";
        try {
            pstm = conn.prepareCall(query);
            pstm.setString(1, acc.getID());
            pstm.setDouble(2, acc.getBALANCE());
            pstm.setDate(3, new java.sql.Date(acc.getDEPOSITDAY().getTime()));
            pstm.setDate(4, new java.sql.Date(acc.getWITHDRAWDAY().getTime()));
            row = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    
    public ArrayList<Account> danhsach()
    {
        ArrayList<Account> list = new ArrayList<>();
        try {
            query = "select * from Account";
            rs=stmt.executeQuery(query);
            while (rs.next()) {
                Account a= new Account(rs.getString(1), rs.getDouble(2), rs.getDate(3), rs.getDate(4));
                list.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }    
    
    public int rut (String ID,double sotien)
    {
        int row=0;
        try {
            query = "update Account set BALANCE = BALANCE - ? where ID =?";
            pstm = conn.prepareStatement(query);
            pstm.setDouble(1, sotien);
            pstm.setString(2, ID);
            row=pstm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    
    
}

  