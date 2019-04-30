/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.Server;

import Java_SQL.Sach;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
public class Java_SQL_B4T7 extends UnicastRemoteObject implements Interface_B4T7{
    
    private String url ="jdbc:jtds:sqlserver://localhost:1433/Java_QLsach;instance=SQLEXPRESS",user="sa",pass="123",query;
    private ResultSet rs;
    private PreparedStatement pstm;
    private Statement stmt;
    private Connection conn;
    public Java_SQL_B4T7() throws RemoteException{
        try {
            conn= DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL_B4T7.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    @Override
    public ArrayList<Sach> Xemdanhsach() throws RemoteException {
        ArrayList<Sach> listS = new ArrayList<>();
        try{
            query = "select * from Thong_tin_sach";
            rs= stmt.executeQuery(query);
            while (rs.next()) {
                Sach s = new Sach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                listS.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL_B4T7.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listS;
    }

    @Override
    public int Muonsach(String ID) throws RemoteException {
        int i=0;
        try {
            query="update Thong_tin_sach set So_luong_cho_muon = So_luong_cho_muon -1 where ID = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, ID);
            i = pstm.executeUpdate();
            } catch (SQLException ex) {
            Logger.getLogger(Java_SQL_B4T7.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    @Override
    public int Trasach(String ID) throws RemoteException {
        int i=0;
        
        try{
            query = "update Thong_tin_sach set So_luong_cho_muon = So_luong_cho_muon + 1 where ID = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, ID);
            i= pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL_B4T7.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return i;
    }
    
}
