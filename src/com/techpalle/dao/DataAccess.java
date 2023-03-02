package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techpalle.model.Student;

public class DataAccess 
{
	private static final String dbUrl = "jdbc:mysql://localhost:3306/palle";
	private static final String dbUsername = "root";
	private static final String dbPassword = "admin";
	
	private static Connection con = null;
	private static Statement s = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static final String insertQry = "insert into student(name, email, password, state) values (?,?,?,?)";
	private static final String updateQry = "update student set name=?, password=?, state=? where email=?";
	private static final String deleteQry = "delete from student where email=?";
	private static final String qry = "select * from student";
	
	public static void insertStud(String name, String email, String password, String state)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = con.prepareStatement(insertQry);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, state);
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void updateStud(String name, String password, String state, String email)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = con.prepareStatement(updateQry);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, state);
			ps.setString(4, email);
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void deleteStud(String email)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = con.prepareStatement(deleteQry);
			ps.setString(1, email);
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (ps != null)
				{
					ps.close();
				}
				if (con != null)
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<Student> showAll()
	{
		ArrayList<Student> al = new ArrayList<Student>();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			s = con.createStatement();
			
			rs = s.executeQuery(qry);
			
			while(rs.next())
			{
				int sid = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String password = rs.getString(4);
				String state = rs.getString(5);
				
				Student s = new Student(sid, name, email, password, state);
				al.add(s);
			}
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs != null)
				{
					rs.close();
				}
				if (s != null)
				{
					s.close();
				}
				if (con != null)
				{
					con.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return al;
	}
}
