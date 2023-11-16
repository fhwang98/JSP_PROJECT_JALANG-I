package com.project.jr.forbidden.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.forbidden.model.ForbiddenAdminDTO;
import com.project.jr.forbidden.repository.ForbiddenAdminDAO;

@WebServlet("/forbidden/admin/forbiddenadminadd.do")
public class ForbiddenAdminAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/forbidden/admin/forbiddenadminadd.jsp");

		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		String forbidden = req.getParameter("forbidden");
		
		ForbiddenAdminDAO dao = new ForbiddenAdminDAO();
		
		ForbiddenAdminDTO dto = new ForbiddenAdminDTO();
		
		dto.setForbidden(forbidden);
		
		int result = dao.add(dto);
		
		if (result == 1) {
			
			resp.sendRedirect("/jr/forbidden/admin/forbiddenadminlist.do");
			
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
	}
	
}
