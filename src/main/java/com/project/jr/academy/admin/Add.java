package com.project.jr.academy.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.academy.model.AcademyDTO;
import com.project.jr.academy.repository.AcademyDAO;

@WebServlet("/academy/admin/add.do")
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Add.java

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/academy/admin/add.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String academyName = req.getParameter("acedemyName");
		String academyLocation = req.getParameter("acedemyLocation");
		String academyTel = req.getParameter("acedemyTel");
		
		AcademyDTO dto = new AcademyDTO();
		dto.setAcademyName(academyName);
		dto.setAcademyLocation(academyLocation);
		dto.setAcademyTel(academyTel);
		
		AcademyDAO dao = new AcademyDAO();
		
		int result = dao.addAcademy();
		
		
	}
}