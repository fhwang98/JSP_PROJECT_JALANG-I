package com.project.jr.forbidden.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.forbidden.model.ForbiddenAdminDTO;
import com.project.jr.forbidden.repository.ForbiddenAdminDAO;

@WebServlet("/forbidden/admin/forbiddenadmindetail.do")
public class ForbiddenAdminDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String forbiddenSeq = req.getParameter("forbiddenSeq");
		
		ForbiddenAdminDAO dao = new ForbiddenAdminDAO();
		
		ForbiddenAdminDTO dto = dao.detail(forbiddenSeq);
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/forbidden/admin/forbiddenadmindetail.jsp");

		dispatcher.forward(req, resp);
	}
}
