package com.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.dog.connectionTable;


public class CrudQueries 
{
	Scanner s=new Scanner(System.in);
	public void deleteData() throws SQLException, Exception
	{
		String delete="delete from userdetail where id=?";
		PreparedStatement ps=connectionTable.con().prepareStatement(delete);
		System.out.println("Enter id who want to delete:");
		int id=s.nextInt();
		String retrive="select * from userdetail";
		PreparedStatement ps1=connectionTable.con().prepareStatement(retrive);
		ResultSet rs=ps1.executeQuery();
		boolean temp=false;
		while(rs.next())
		{
			if(rs.getInt(1)==id)
			{
				temp=true;
			}
		}
		if(temp==true)
		{
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			connectionTable.con().close();
			System.out.println("Data is deleted...");
		}else {
			System.err.println("id is not present");
		}
		
	}
	public void updateData() throws SQLException, Exception
	{
		String update="update userdetail set password=? where id=?";
		PreparedStatement ps=connectionTable.con().prepareStatement(update);
		System.out.println("Enter id of user which you want update:");
		int id=s.nextInt();
		String retrive="select * from userdetail";
		PreparedStatement ps1=connectionTable.con().prepareStatement(retrive);
		ResultSet rs=ps1.executeQuery();
		boolean temp=false;
		while(rs.next())
		{
			if(rs.getInt(1)==id)
			{
				temp=true;
			}
		}
		if(temp==true)
		{
			
			ps.setInt(2, id);
			System.out.println("Enter New Password:");
			ps.setString(1, s.next());
			ps.execute();
			System.out.println("Password is updated");
			ps.close();
			connectionTable.con().close();
		}else {
			System.err.println("Invalid id!!!!");
		}
	}
	public void retrivedata() throws SQLException, Exception
	{
		String retrive="select * from userdetail";
		PreparedStatement ps=connectionTable.con().prepareStatement(retrive);
		ResultSet rs=ps.executeQuery();
		System.out.println("_________________________________________________________User Details_______________________________________");
		while(rs.next())
		{
			System.out.println("id="+rs.getInt(1)+"\tName:"+rs.getString(2)+"\tMoblieNo:"+rs.getString(3)+"\tEmail:"+rs.getString(4));
		}
	}

}
