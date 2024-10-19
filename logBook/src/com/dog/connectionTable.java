package com.dog;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionTable 
{
	public static Connection con() throws Exception
	{

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdetails","root","Root@123");
		return con;
	}

}
