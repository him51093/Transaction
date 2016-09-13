package rbs.module.transaction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.PrintWriter;

import rbs.module.transaction.dao.DaoImplementation;
import rbs.module.transaction.model.Transaction;
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	
	static Date stringToDate(String value){
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = null;
		try {
			date = format.parse(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date(date.getTime());
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		DaoImplementation d = new DaoImplementation();
		if(request.getParameter("select").equals("criteria1"))
		{	
			String username = request.getParameter("criteria_value");
			double y = Double.parseDouble(username);
			//out.println(d.getTransactions(y));
			ArrayList arr =d.getTransactions(y);
			
			request.setAttribute("resultSet", arr); 
			getServletConfig().getServletContext().getRequestDispatcher("/SearchDetails.jsp").forward(request,response);

		}
		if(request.getParameter("select").equals("criteria2"))
		{String username = request.getParameter("criteria_value");
			out.println(d.getTransactions(username));
		}
		if(request.getParameter("select").equals("criteria3"))
		{
			String username = request.getParameter("criteria_value");
		out.println(d.getTransactions(stringToDate(username)));
		}
		if(request.getParameter("select").equals("criteria4"))
		{   String username = request.getParameter("criteria_value");
			String username1 = request.getParameter("criteria_value1");
			out.println(d.getTransactions(stringToDate(username),stringToDate(username1)));
		}
		
	}

}
