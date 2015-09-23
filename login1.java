package com.igate.assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context=this.getServletContext();
		 String emp_id= request.getParameter("emp_id");
		 context.setAttribute("emp_ID",emp_id);//putting emp_id entered in form to context object
		 
		 Connection conn=null;
		// response.setContentType("text/html");wont be supported by post method
		try{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Login","root","root");
			String query="select * from credentials where emp_id=?";
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setString(1,emp_id);//setString(index,string or variable)
			ResultSet rs= stmt.executeQuery();
			while(rs.next()){
				PrintWriter out=response.getWriter();
				//out.println("<html><body>");
				//out.println("NAME:"+rs.getString("emp_name")+"</br> EMPLOYEE ID:"+rs.getString("emp_id")+"</br> PM:"+rs.getString("project_Manager")+"</br> DEPT:"+rs.getString("department")+"</br> LOCATION:"+rs.getString("location"));
				//out.println("</body></html>");
				request.getRequestDispatcher("firstpage.jsp").include(request,response);
			}
		}
			catch(Exception e){
				System.out.println(e.getMessage());
			
			}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	}

}
