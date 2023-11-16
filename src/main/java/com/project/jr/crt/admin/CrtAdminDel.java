package com.project.jr.crt.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.repository.CrtAdminDAO;

@WebServlet("/crt/admin/crtadmindel.do")
public class CrtAdminDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String crtSeq = req.getParameter("crtSeq");
		
		req.setAttribute("crtSeq", crtSeq);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crtadmindel.jsp");

		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String crtSeq = req.getParameter("crtSeq");
		
		CrtAdminDAO dao = new CrtAdminDAO();
		
		int result = dao.del(crtSeq);
		
		if (result == 1) {
			
			resp.sendRedirect("/jr/crt/admin/crtadminlist.do");
			
		} else {
			
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed.');history.back();</script>");
			writer.close();
		}

	}
	
}
