package com.valuemomentum.training.jdbcdemo;

import java.sql.*;
public class DeleteDemo 
{
	public static void main(String[] args) {

	Connection con;
	Statement stmt;
	int cnt=0;

	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connecting to database...");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","hameeda12");
		String sql = "Delete from candidates where id=2;";
		System.out.println(" ");
		stmt= con.createStatement();
		cnt=stmt.executeUpdate(sql);
		if(cnt>0)
		{
			System.out.println("Record for young is deleted");

		}
		con.close();
	}
	catch(Exception ce)
	{
		System.out.println(ce);
	}
 }
}