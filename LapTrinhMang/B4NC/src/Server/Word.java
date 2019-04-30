/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
public class Word extends UnicastRemoteObject implements Interface_B4NC{
    private String url ="jdbc:jtds:sqlserver://localhost:1433/Thuvien;instance=SQLEXPRESS",user="sa",pass="123",query;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement pstm;
    public Word() throws RemoteException{
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    @Override
    public String Anh_Viet(String Anh) throws RemoteException {
        query ="select * from Tudien where Anh = ?";
        String viet = null;
        try{
            pstm = conn.prepareStatement(query);
            pstm.setString(1, Anh);
            rs= pstm.executeQuery();
            while (rs.next()) {
                viet = rs.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        }
        return viet;
    }

    @Override
    public String Viet_Anh(String Viet) throws RemoteException {
        query ="select * from Tudien where Viet = ?";
        String Anh = null;
        try{
            pstm = conn.prepareStatement(query);
            pstm.setString(1, Viet);
            rs= pstm.executeQuery();
            while (rs.next()) {
                Anh = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Anh;
    }

    @Override
    public String Dinh_Ngia(String Anh) throws RemoteException {
        query ="select * from Tudien where Anh = ?";
        String Nghia = null;
        try{
            pstm = conn.prepareStatement(query);
            pstm.setString(1, Anh);
            rs= pstm.executeQuery();
            while (rs.next()) {
                Nghia = rs.getString(3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Word.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Nghia;
    }
    
}
