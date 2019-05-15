/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        try {
            // TODO code application logic here
            String url="jdbc:jtds:sqlserver://localhost:1433/SinhVien;instance=SQLEXPRESS";
            String user="sa";
            String Pass="123";
            Connection conn= null;
            conn= DriverManager.getConnection(url, user, Pass);
            String query="select * from Thongtinsinhvien";
            ResultSet rs;
            Statement stmt;
            stmt=conn.createStatement();
            //==================================================================
            PreparedStatement pstm;
              try {
                query="insert into Thongtinsinhvien values(?,?,?,?)";
                pstm=conn.prepareStatement(query);
                pstm.setString(1, "444");
                pstm.setString(2, "qqq");
                pstm.setString(3, "rrr");
                String strBirthday = "22/22/2222";
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                format.parse(strBirthday);
                pstm.setDate(4, new java.sql.Date(format.parse(strBirthday).getTime()));
                pstm.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(Java_SQl.class.getName()).log(Level.SEVERE, null, ex);
            }
            //==================================================================
            query="select * from Thongtinsinhvien";
            rs=stmt.executeQuery(query);
            ArrayList<SinhVien> listSv=new ArrayList<>();
            
            while (rs.next())
            {
                SinhVien sv= new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
                listSv.add(sv);
            }
            for (SinhVien s: listSv)
            {
                
                System.out.println(s.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        //========================================================================
    }
    
}
