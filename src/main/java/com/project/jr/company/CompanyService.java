package com.project.jr.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/company/companyservice.do")
public class CompanyService extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String saveDirectory = getServletContext().getRealPath("ad3.png"); // 웹서버상의 절대경로.
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/company/companyservicemain.jsp");
		dispatcher.forward(req, resp);

	}	

}