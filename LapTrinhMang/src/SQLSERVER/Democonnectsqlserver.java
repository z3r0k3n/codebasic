package SQLSERVER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Democonnectsqlserver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url= "jdbc:jtds:sqlserver://localhost:1433/simplehr";
		String user= "sa";
		String password = "123";
		try {
			Connection conn= DriverManager.getConnection(url, user, password);
			Statement stmt=conn.createStatement();
			String sql ="Select * from DEPARTMENT";
			ResultSet rs= null;
			rs=stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
