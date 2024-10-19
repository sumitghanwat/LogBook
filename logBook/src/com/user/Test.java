package com.user;

import java.util.Scanner;

import com.services.CrudQueries;
import com.services.Regi;

public class Test {

	public static void main(String[] args) {
		Regi r=new Regi();
		CrudQueries c=new CrudQueries();
		System.out.println("_________________________Welcome to Logbook___________________________________");
		while(true)
		{
			Scanner s=new Scanner(System.in);
			System.out.println("\n\n1:Registeration\n2:Login\n3:Exit");
			System.err.println("Enter your choice:");
			int ch=s.nextInt();
			switch (ch) {
			case 1:
				try {
					r.userReg();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					r.login();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 3:
				System.out.println("Thank you....");
				System.exit(0);
				break;
			
			
			default:
				System.out.println("Invalid choice...");
				break;
			}
			
		}

	}

}
