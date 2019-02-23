package com.nathan.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class EditTodoServlet
 */
@WebServlet("/EditTodoServlet")
public class EditTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private TodoListDBUtil todoutil;
	@Resource(name="jdbc/webtodolist") 
	private DataSource dataSource;
	int id;
	
	@Override 
	public void init() throws ServletException 
	{ 
		super.init(); 
		todoutil = new TodoListDBUtil(dataSource); 
		
		}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		id=Integer.parseInt(request.getParameter("TodoId")); 
		Todo todo= todoutil.fetchTodo(id); 
	
		request.setAttribute("Todo", todo); 
		request.getRequestDispatcher("edit-todo.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String description = request.getParameter("description"); 
		Todo todo = new Todo(id,description); 
		todoutil.updateTodo(todo); 

		response.sendRedirect("WelcomeInstructorServlet");
	}

}
