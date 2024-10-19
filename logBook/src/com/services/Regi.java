package com.services;


import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import com.dog.connectionTable;


public class Regi 
{
Scanner s=new Scanner(System.in);

	
	public void userReg() 
	{
		try 
		{
		String insertData="insert into userdetail values(?,?,?,?,?)";
		PreparedStatement ps=connectionTable.con().prepareStatement(insertData);
		System.out.println("Enter user id:");
		ps.setInt(1, s.nextInt());
		System.out.println("Enter user name:");
		String name=s.next();
		ps.setString(2,name);
		System.out.println("Enter user mobile no:");
		ps.setLong(3,s.nextLong());
		String email=name+"@logbook";
		ps.setString(4,email);
		ps.setString(5,generateSecurePassward());
		
		
		ps.execute();
		ps.close();
		connectionTable.con().close();
		System.err.println("email id="+email);
		System.err.println("Password:"+generateSecurePassward());
		System.out.println("Registration complete...");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void userLogin()
	{
		System.out.println("Enter email address:");
		String email=s.next();
		System.out.println("Enter password");
		String password=s.next();
		String retrivedata="select * from userdetail";
		PreparedStatement ps;
		
		
			try {
				ps = connectionTable.con().prepareStatement(retrivedata);
				ResultSet rs;
				rs = ps.executeQuery();
				boolean temp=false;
				while(rs.next())
				{
					if(rs.getString(5).equals(password) && rs.getString(4).equals(email))
					{
						
						temp=true;
						break;
						
					}
					
				}
				if(temp==true)
				{
					System.out.println("login sucessfully.....");
				}
				else
				{
					System.err.println("invalid passworld and email...");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public void adminLogin()
	{
		System.out.println("Enter email address:");
		String email=s.next();
		System.out.println("Enter password");
		String password=s.next();
		String retrivedata="select * from admin";
		PreparedStatement ps;
		
		
			try {
				ps = connectionTable.con().prepareStatement(retrivedata);
				ResultSet rs;
				rs = ps.executeQuery();
				boolean temp=false;
				while(rs.next())
				{
					if(rs.getString(4).equals(password) && rs.getString(3).equals(email))
					{
						
						temp=true;
						break;
						
					}
					
				}
				if(temp==true)
				{
					admin();
				}
				else
				{
					System.out.println("invalid passworld and email...");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public String generateSecurePassward()
	{
		final String lowerCase="abcdefghijklmnopqrstuvwxyz";
		final String upperCase=lowerCase.toUpperCase();
		final String number="0123456789";
		final String otherChar="!@#$%&*";
		final String combine=lowerCase+upperCase+number+otherChar;
		
		Random random=new Random();
		StringBuilder pass=new StringBuilder();
		for(int i=0;i<=4;i++)
		{
			int randomIndex=random.nextInt(combine.length());
			pass.append(combine.charAt(randomIndex));
			
			
		}
		
		
		return pass.toString();
	}
	public void login()
	{
		boolean ch=true;
		while(ch)
		{
		System.out.println("\n\n1:User\n2:Admin\n3:Back");
		System.out.println("who you are");
		switch (s.nextInt())
				{
					case 1: 
							userLogin();
							break;
					case 2:
						adminLogin();
						break;
					case 3:
						ch=false;
						break;
					default:
						System.out.println("Invalid choice!!!!");
				}
		}
		
	}
	public void admin() throws SQLException, Exception
	{
		Regi r=new Regi();
		CrudQueries c=new CrudQueries();
		boolean ch=true;
		while(ch)
		{
		System.out.println("\n\n1:Register User\n2:Delete Data\n3:Update User Data\n4:Retrivre User Data\n5:LogOut");
		System.out.println("What do you want to do?");
		switch (s.nextInt()) {
		case 1:
			r.userReg();
			break;
		case 2:
			c.deleteData();
			break;
		case 3:
			c.updateData();
			break;
		case 4:
			c.retrivedata();
			break;
		case 5:
			System.out.println("LogOut successfully....");
			ch=false;
			break;
			
		default:
			System.out.println("Invalid choice!!!!!");
			break;
			
		}	
		
		}

	

	}
}
