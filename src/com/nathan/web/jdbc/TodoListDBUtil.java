package com.nathan.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class TodoListDBUtil 
{
	
		
		private DataSource dataSource;
		
		public TodoListDBUtil(DataSource theDataSource) 
		{ 
			dataSource = theDataSource; 
		}
		
		public List<Todo>getTodos()throws Exception{
			

			List<Todo> todos = new ArrayList<Todo>();

			Connection myConn=null;
			Statement myStmt=null;
			ResultSet myRs=null;
			
			try 
			{
				myConn = dataSource.getConnection();

				myStmt = myConn.createStatement();

				String sql ="select * from webtodolist.todo order by id";
				myRs = myStmt.executeQuery(sql);

				while(myRs.next())
				{
					int id=myRs.getInt("id");
					String description=myRs.getString("description");
					Todo todotemp = new Todo(id,description);
					todos.add(todotemp);
					
				}

				return todos;
			}
		
			
			
			finally {
				close(myConn,myStmt,myRs);
			}	
			
		}
		
		public void addTodo(Todo todo)
		{ 
			Connection myConn=null; 
			PreparedStatement myStmt = null;
			ResultSet myRs= null;
			try
			{
				myConn = dataSource.getConnection(); 
				String sql = "INSERT INTO Todo (id,description) VALUES (?, ?);"; 
				myStmt = myConn.prepareStatement(sql);    
				int id = todo.getId();
				String description = todo.getDescription();  
		
				myStmt.setInt(1, id);
				myStmt.setString(2, description); 
				myStmt.execute();
			} 
			catch(Exception e)
			{ 
				System.out.println(e.getMessage());
			}
		
			
			finally{ close(myConn,myStmt,myRs); }
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
		
		public Todo fetchTodo(int id) 
		{ 
			Connection myConn=null; 
			Statement myStmt = null; 
			ResultSet myRs= null; 
			Todo todo=null;
			try 
			{
				System.out.println("PJJ");
				myConn = dataSource.getConnection(); 
				System.out.println("PJJ");
				myStmt= myConn.createStatement(); 
				System.out.println("PJJ");
				String sql= "select * from todo where id="+id+ ";"; 
				myRs = myStmt.executeQuery(sql);
				while(myRs.next())
				{ 
					int ide=myRs.getInt("id");
					String description=myRs.getString("description"); 
				
					todo = new Todo(ide,description);
				}
				return todo; 
			}
			catch(Exception e)
			{ 
				System.out.println(e.getMessage());
				
				System.out.println("Y'a eu un soucis dans le fetchStudent");
				return null; 
			} 
			finally
			{ 
				close(myConn,myStmt,myRs);
			}
		}
		
		public void updateTodo(Todo todo) 
		{
			Connection myConn=null; 
			PreparedStatement myStmt = null;
			try 
			{
				myConn = dataSource.getConnection(); 
				String sql = "update todo set description=? where id=?"; 
				myStmt = myConn.prepareStatement(sql);
				myStmt.setString(1, todo.getDescription()); 
				myStmt.setInt(2, todo.getId());
				
				
				myStmt.execute();
			} 
			catch(Exception e)
			{ 
				System.out.println(e.getMessage()); 
			}
			finally
			{ 
				close(myConn,myStmt,null); 
			}
		}
		
		public void deleteTodo(int id) 
		{ // TODO Auto-generated method stub 
			Connection myConn=null; 
			Statement myStmt = null; 
			try 
			{ 
				myConn = dataSource.getConnection(); 
				myStmt= myConn.createStatement(); 
				String sql= "delete from todo where id="+id; myStmt.execute(sql);
			}
			catch(Exception e)
			{ 
				System.out.println(e.getMessage());
			}
			finally
			{ 
				close(myConn,myStmt,null); 
			}
		}
		
		

		
		
		
		
		

		
		
}


