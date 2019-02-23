package com.nathan.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class WelcomeInstructorServlet
 */
@WebServlet("/WelcomeInstructorServlet")
public class WelcomeInstructorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public TodoListDBUtil  todolistDBU;
	
	@Resource(name="jdbc/webtodolist")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeInstructorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		
		System.out.println("Hello world");
		try
		{
			listTodo(request,response); 	 	
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("problème dans le do get ");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String description= req.getParameter("description");
		Todo todo = new Todo(description); 
		todolistDBU.addTodo(todo);
		try {
			listTodo(req,resp);
		} catch (Exception e) {
		// TODO Auto-generated catch block e.printStackTrace();
		}
	}
	
	
	public void afficher(List<Todo> liste)
	{
		for(int i=0;i<liste.size();i++)
		{
			System.out.println(liste.get(i).toString());
		}

	}
	
	
	
	public void listTodo(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println("listetodo");

		List<Todo> todos =todolistDBU.getTodos(); 
		
		request.setAttribute("TODO_LIST", todos); 
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("welcome-instructor.jsp");
		 
		dispatcher.forward(request, response);

	

	}
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		todolistDBU =new TodoListDBUtil(dataSource);
	}


}
