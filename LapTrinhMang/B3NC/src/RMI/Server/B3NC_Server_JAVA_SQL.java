/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.Server;

import Java_SQL.Hoadon;
import Java_SQL.SanPham;
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
public class B3NC_Server_JAVA_SQL extends UnicastRemoteObject implements B3NC_Interface{

    private String url="jdbc:jtds:sqlserver://localhost:1433/Cuahang;instance=SQLEXPRESS",user="sa",pass="123",query;
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private PreparedStatement pstm;
    
    
    public B3NC_Server_JAVA_SQL() throws RemoteException{
        try {
            conn=DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(B3NC_Server_JAVA_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @Override
    public ArrayList<SanPham> listSP(String ID) throws RemoteException {
        ArrayList<SanPham> list= new ArrayList<>();
        try{
            query ="select * from Sanpham where ID =?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, ID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
                list.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(B3NC_Server_JAVA_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public ArrayList<Hoadon> Taohoadon(ArrayList<Hoadon> hoadontruoc) throws RemoteException {
        ArrayList<Hoadon> hoadonsau = new ArrayList<>();
        query ="select * from Sanpham where ID =?";
        try{
        pstm = conn.prepareStatement(query);
        for (Hoadon hd:hoadontruoc)
        {
            pstm.setString(1, hd.getID());
            rs=pstm.executeQuery();
            while (rs.next())
            {
                Hoadon HD = new Hoadon(rs.getString(1), rs.getString(2), hd.getSoluong(), rs.getFloat(3));
                hoadonsau.add(HD);
            }
        }
        } catch (SQLException ex) {
            Logger.getLogger(B3NC_Server_JAVA_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoadonsau;
    }
    
}
