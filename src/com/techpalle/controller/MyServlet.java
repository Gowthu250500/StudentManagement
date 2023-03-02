package com.techpalle.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Student;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getServletPath();
		switch (path)
		{
		case"/My":
			String o = request.getParameter("crud");
			if("insert".equalsIgnoreCase(o))
			{
				insertStud(request, response);
			}
			else if("update".equalsIgnoreCase(o))
			{
				updateStud(request, response);
			}
			else if("delete".equalsIgnoreCase(o))
			{
				deleteStud(request, response);
			}
			else
			{
				showAll(request, response);
			}
			break;
			default:
				getStartUpPage(request, response);
				break;
		}
	}

	
	private void showAll(HttpServletRequest request, HttpServletResponse response)
	{
		ArrayList<Student> arr = DataAccess.showAll();
		request.setAttribute("showAll", arr);
		
		try
		{
			RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}


	private void deleteStud(HttpServletRequest request, HttpServletResponse response) 
	{
		String email = request.getParameter("tbEmail");
		
		DataAccess.deleteStud(email);
	}


	private void updateStud(HttpServletRequest request, HttpServletResponse response)
	{
		String name = request.getParameter("tbName");
		String pass = request.getParameter("tbPass");
		String State = request.getParameter("ddlStates");
		String email = request.getParameter("tbEmail");
		
		DataAccess.updateStud(name, pass, State, email);
	}


	private void insertStud(HttpServletRequest request, HttpServletResponse response) 
	{
		String name = request.getParameter("tbName");
		String email = request.getParameter("tbEmail");
		String pass = request.getParameter("tbPass");
		String State = request.getParameter("ddlStates");
		
		DataAccess.insertStud(name, email, pass, State);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
