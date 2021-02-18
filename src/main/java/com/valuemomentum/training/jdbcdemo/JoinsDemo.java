package com.valuemomentum.training.jdbcdemo;
import java.sql.*;
//jdbc program to display candidates details and  their skills
public class JoinsDemo {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet rs;
		try {
			// register jdbc driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// creating connection object
			System.out.println("Connection to database");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","hameeda12");
			// execute a query and retrieve the data
			stmt=con.createStatement();
			rs=stmt.executeQuery("select c.id,first_name,name from candidates c INNER JOIN  "
			        + "candidate_skills s ON c.id=candidate_id  INNER JOIN  "
			        + "skills sk ON s.skill_id=sk.id  ;");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
				//)+" "+rs.getString(3));
				//rs.getString(4)+" "+rs.getString("email")+" "+rs.getString(6)+" "
				//+rs.getInt(7)+" "+rs.getString(8));
			}

			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}



