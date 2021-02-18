package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

public class UpdateDemo {

	public static void main(String[] args) {
		Connection con;
		PreparedStatement pstmt;
		String sqlUpdate;
		//int cnt=0;

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to database...");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","hameeda12");
			sqlUpdate = "Update candidates "+"SET last_name=? "+"where id=?";
			pstmt=con.prepareStatement(sqlUpdate);
			//prepare data for update
			Scanner s=new Scanner(System.in);
			System.out.println("enter the employee id");
			int eid=s.nextInt();
			System.out.println("enter the employee lastname");
			String lastname =s.next();
			pstmt.setString(1,lastname);
			pstmt.setInt(2,eid);
			int rowaffected=pstmt.executeUpdate();
			System.out.println(String.format("Row affected %d",rowaffected));
			//reuse the prepared statement
			lastname="grohe";
			eid=101;
			pstmt.setString(1,lastname);
			pstmt.setInt(2,eid);
			rowaffected=pstmt.executeUpdate();
			System.out.println(String.format("Row affected %d",rowaffected));
			

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

	}
	
}
