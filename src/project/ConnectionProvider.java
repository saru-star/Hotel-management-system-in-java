package project;
import java.sql.*;
import java.sql.DriverManager;
import java.lang.*;
public class ConnectionProvider {
	public static Connection getCon() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","saru@123");
			return con;
		}
		catch(Exception e) {
			return null;
		}
	}
}
