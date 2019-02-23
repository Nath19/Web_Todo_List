package com.nathan.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.swing.JOptionPane;

import com.nathan.web.jdbc.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountUtil accountutil ;
	
	@Resource(name="jdbc/studentdb")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		accountutil =new AccountUtil(dataSource);
	}
	

	public LoginServlet()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		
		
		
		
		
		
		
		try
		{
			Cookie [] cookies = request.getCookies(); 
			if(cookies!= null){ 
				for(Cookie cookie:cookies)
				{
					if(cookie.getName().equals("uname"))
					{
						request.setAttribute("uname", cookie.getValue());
					}
				}
				 
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("problème dans le do get login ");

		}
		
		
		
	}
	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uname =request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		Account lecompte=new Account(uname,pass);
		
		
		
		
		LoginDao dao = new LoginDao();
		
		String role=accountutil.getRole(lecompte);
		
		Cookie cookie = new Cookie("uname", uname); 
		Cookie cookie2 = new Cookie("pass", pass); 
		cookie.setMaxAge(60*60*24);
		cookie2.setMaxAge(60*60*24);// in seconds, here for 24 hours response.addCookie(cookie) ;
		response.addCookie(cookie); 
		response.addCookie(cookie2); 
		
		
		
		
		if(dao.check(uname, pass))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);

			if(role.equals("instructor"))
			{
			
				session.setAttribute("role","Instructor");
				response.sendRedirect("WelcomeInstructorServlet");
				
		
			}
				
			
			else
			{
		
				response.sendRedirect("WelcomeStudentServlet");

			}
			
		}
		else
		{
			request.setAttribute("alertMsg", "Username or Password incorrect");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
			rd.include(request, response);
	
			
		}
	}

}
