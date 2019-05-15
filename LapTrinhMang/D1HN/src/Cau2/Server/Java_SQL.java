/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

/**
 *
 * @author Zero Ken
 */
public class Java_SQL extends UnicastRemoteObject implements RMI_interface{
    private Connection conn;
    private ResultSet rs;

    private String Query;
    private PreparedStatement pstm;
    private String url="jdbc:jtds:sqlserver://localhost:1433/Java_SQL;instance=SQLEXPRESS",user="sa",pass="123";
    public Java_SQL() throws RemoteException{
        try {
            conn = DriverManager.getConnection(url, user, pass);

        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public String VT_DD(String VT) throws RemoteException {
        
        String kq="";
        Query = "select * from ViettatDB where Viettat =?";
        try {
            pstm = conn.prepareStatement(Query);
            pstm.setString(1, VT);
            rs= pstm.executeQuery();
            while (rs.next()) {
                kq = rs.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }

    @Override
    public String DD_VT(String DD) throws RemoteException {
        
        String kq="";
        Query = "select * from ViettatDB where Daydu =?";
        try {
            pstm = conn.prepareStatement(Query);
            pstm.setString(1, DD);
            rs= pstm.executeQuery();
            while (rs.next()) {
                kq = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Java_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
}
