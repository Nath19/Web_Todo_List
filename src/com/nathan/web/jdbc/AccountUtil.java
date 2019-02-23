package com.nathan.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

public class AccountUtil {
	
	private DataSource dataSource;
	
	public AccountUtil(DataSource theDataSource) 
	{ 
		dataSource = theDataSource; 
	}
	
	
	private void close(Connection myConn , Statement myStmt,ResultSet myRs)
	{
		try {
			if(myStmt!=null)
				myStmt.close();
			if(myRs!=null)
				myRs.close();
			if(myConn!=null)
				myConn.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
		
	
	public String getRole(Account compte)
	{
		
		String sql = "select role from account where username=?";
		String url ="jdbc:mysql://localhost:3306/webtodolist?useSSL=false"; 
		String username = "root";
		String password ="Newtonienne973";
		String role=null;

		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection(url, username, password);
			PreparedStatement st = myCon.prepareStatement(sql);
			st.setString(1,compte.getUsername());
			ResultSet rs = st.executeQuery();


			/*
			System.out.println("Capteur 1");
			myStmt= myConn.createStatement(); 
			System.out.println("Capteur 1");

			String user=compte.getUsername();
			String sql= "select role from account where username="+user+";"; 
			myRs = myStmt.executeQuery(sql);
			System.out.println("Capteur 1");*/

			while(rs.next())
			{ 
				role=rs.getString("role"); 
			
				
			}

			return role; 
		}
		catch(Exception e)
		{ 
			System.out.println(e.getMessage());
			
			System.out.println("Y'a eu un soucis dans le getRole");
			return null; 
		} 
	
	}

}
