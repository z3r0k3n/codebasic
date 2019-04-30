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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

/**
 *
 * @author Zero Ken
 */
public class Iml_B5NC extends UnicastRemoteObject implements B5NC_Interface{

    private String url ="jdbc:jtds:sqlserver://localhost:1433/Haychongiadung;instace=SQLEXPRESS",user="sa",pass="123",query;
    private Connection conn;
    private ResultSet rs;
    private Random rd;
    private PreparedStatement pstm;
    
    
    public Iml_B5NC() throws RemoteException{
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Iml_B5NC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    @Override
    public SanPham Laysanpham() throws RemoteException {
        SanPham sp = new SanPham();
        sp.setId(rd.nextInt(5));
        query ="select * from Game where ID = ?";
        try{
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, sp.getId());
            rs = pstm.executeQuery();
            while (rs.next()) {
                sp = new SanPham(rs.getInt(1), rs.getString(2), rs.getFloat(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Iml_B5NC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sp;
    }

    @Override
    public String doangia(double gia,SanPham sp) throws RemoteException {
        String kq="";
        if (gia < sp.getGia())
            kq="-1";
        else if (gia > sp.getGia())
            kq="1";
        
        return kq;
        
    }
    
}
