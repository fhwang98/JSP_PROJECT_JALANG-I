package com.project.jr.forbidden.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.forbidden.repository.ForbiddenAdminDAO;

@WebServlet("/forbidden/admin/forbiddenadmindel.do")
public class ForbiddenAdminDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String forbiddenSeq = req.getParameter("forbiddenSeq");
		
		req.setAttribute("forbiddenSeq", forbiddenSeq);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/forbidden/admin/forbiddenadmindel.jsp");

		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String forbiddenSeq = req.getParameter("forbiddenSeq");
		
		ForbiddenAdminDAO dao = new ForbiddenAdminDAO();
		
		int result = dao.del(forbiddenSeq);
		
		if (result == 1) {
			
			resp.sendRedirect("/jr/forbidden/admin/forbiddenadminlist.do");
			
		} else {
			
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed.');history.back();</script>");
			writer.close();
		}
	}
}
