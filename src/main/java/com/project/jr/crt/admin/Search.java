package com.project.jr.crt.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/crt/admin/search.do")
public class Search extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Search.java

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/search.jsp");
		dispatcher.forward(req, resp);
	}
}