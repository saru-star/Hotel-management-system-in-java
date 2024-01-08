package project;

import java.sql.*;
import java.lang.*;

import javax.swing.JOptionPane;

public class tables {
	static Connection con;
	static Statement st;

	public static void main(String[]args)throws ClassNotFoundException, SQLException  {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hotel";
			String username = "root";
			String password = "Saparna123@#";
			Connection con = DriverManager.getConnection(url, username, password);
			st=con.createStatement();
//			st.executeUpdate("create table users(name varchar(200),email varchar(200),password varchar(50),securityQuestion varchar(500),answer varchar(200),address varchar(200),status varchar(20))");
//			st.executeUpdate("create table room(roomNo varchar(200),roomType varchar(200),bed varchar(50),price int,status varchar(200))");
			st.executeUpdate("create table customer(id int,name varchar(200),mobileNumber varchar(200),nationality varchar(200),gender varchar(50),email varchar(200),idProof varchar(200),address varchar(200),checkIn varchar(200),roomNo varchar(50),bed varchar(50),roomType varchar(50),pricePerDay int(10),numberOfDaysStay int(10),totalAmount varchar(50),checkout varchar(50))");
			
		    JOptionPane.showMessageDialog(null, "Table created Successfully");
		
		
		
	}}


