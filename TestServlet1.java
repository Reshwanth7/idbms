package com.resh.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet1
 */
@WebServlet("/TestServlet1")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/student_course_tracker")
	private DataSource dataSource;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		Connection myconn= null;
		Statement mystmt= null;
		ResultSet myrs= null;
		
		try {
			
			myconn= dataSource.getConnection();
			String sql = "select * from student";
			mystmt = myconn.createStatement();
			myrs = mystmt.executeQuery(sql);
			while (myrs.next()) {
				 String email = myrs.getString("email");
				 out.println(email);
			
			}
		}
		catch (Exception e) {
			
			e.printStackTrace();
			out.println("error" +e);
			
		}
		
	}

}
