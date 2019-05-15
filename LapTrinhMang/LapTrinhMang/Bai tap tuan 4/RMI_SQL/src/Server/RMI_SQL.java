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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_sql.SinhVien;

/**
 *
 * @author Zero Ken
 */
public class RMI_SQL extends UnicastRemoteObject implements Interface_RMI{
    
    private String url="jdbc:jtds:sqlserver://localhost:1433/SinhVien;instance=SQLEXPRESS";
    private String user="sa";
    private String pass="123";
    private Connection conn=null;
    private ResultSet rs;
    private Statement stmt;
    private PreparedStatement pstm;
    private String query;
    public RMI_SQL() throws RemoteException{
        try {
            conn= DriverManager.getConnection(url, user, pass);
            stmt= conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(RMI_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @Override
    public ArrayList<SinhVien> Xemsinhvien() throws RemoteException {
        ArrayList<SinhVien> listSV= new ArrayList<>();
        try {
            query="select * from Thongtinsinhvien";
            rs=stmt.executeQuery(query);
            while(rs.next())
            {
                SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                listSV.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RMI_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSV;
    }

    @Override
    public int Themsinhvien(SinhVien sv) throws RemoteException {
        int qk=0;
        try {
            query="Insert into Thongtinsinhvien values (?,?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, sv.getID());
            pstm.setString(2, sv.getName());
            pstm.setString(3, sv.getQue_quan());
            pstm.setDate(4, new java.sql.Date(sv.getBirthday().getTime()));
            qk=pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RMI_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qk;
    }

    @Override
    public int XoaSinhvien(String ID) throws RemoteException {
        int kq=0;
        try{
            query="delete from Thongtinsinhvien where ID=?";
            pstm= conn.prepareStatement(query);
            pstm.setString(1, ID);
            kq=pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RMI_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public int CapnhapSinhvien(SinhVien sv) throws RemoteException {
        int kq=0;
        try{
            query="update Thongtinsinhvien set Name=?,Que_quan=?,Birthday=? where ID=?";
            pstm= conn.prepareStatement(query);
            pstm.setString(1, sv.getName());
            pstm.setString(2, sv.getQue_quan());
            pstm.setDate(3, new java.sql.Date(sv.getBirthday().getTime()));
            pstm.setString(4, sv.getID());
            kq=pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RMI_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public ArrayList<SinhVien> Timkiemsinhvien(String ID) throws RemoteException {
        ArrayList<SinhVien> SV= new ArrayList<>();
        try{
            query="select * from Thongtinsinhvien where ID=?";
            pstm= conn.prepareStatement(query);
            pstm.setString(1, ID);
            rs= pstm.executeQuery();
            while(rs.next())
            {
                SinhVien sv= new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                SV.add(sv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RMI_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SV;
    }
    
}
