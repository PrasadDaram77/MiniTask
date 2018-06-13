package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	
	static{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getCon(){
		Connection con=null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void cleanup(Connection con,PreparedStatement st,ResultSet rs){
		
		try{
			if(rs!=null)
				rs.close();
			if(st!=null){
				st.close();
			}
			if(con!=null){
				con.close();
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
		public static void clean(Connection con,Statement st){
			
			try{
				if(st!=null){
					st.close();
				}
				if(con!=null){
					con.close();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
