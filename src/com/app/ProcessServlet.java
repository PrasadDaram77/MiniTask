package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String un=request.getParameter("un");
		String pwd=request.getParameter("pwd");




		try{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");               

			PreparedStatement ps=con.prepareStatement("select * from admin");
			ResultSet rs=ps.executeQuery();                

			/* Printing column names */

			ResultSetMetaData rsmd=rs.getMetaData();

			while(rs.next()){
				out.println("<h1>Name:"+rs.getString(1));
				out.println("<h1>Name:"+rs.getString(2));
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}

	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}                



}	









































