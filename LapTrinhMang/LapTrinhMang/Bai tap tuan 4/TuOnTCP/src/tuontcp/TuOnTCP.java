/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuontcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Zero Ken
 */
public class TuOnTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String url = "jdbc:jtds:sqlserver://localhost:1433/Sinh_Vien;instance=SQLEXPRESS";
        String user = "sa";
        String password = "123";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM Thongtinsinhvien";
            Statement stmt = conn.createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString(2));
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
