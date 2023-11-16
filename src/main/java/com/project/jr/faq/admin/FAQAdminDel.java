package com.project.jr.faq.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.faq.repository.FAQAdminDAO;

@WebServlet("/faq/admin/faqadmindel.do")
public class FAQAdminDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String faqSeq = req.getParameter("Seq");
		
		req.setAttribute("faqSeq", faqSeq);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/faq/admin/faqadmindel.jsp");

		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String faqSeq = req.getParameter("faqSeq");
		
		FAQAdminDAO dao = new FAQAdminDAO();
		
		int result = dao.del(faqSeq);
		
		if (result == 1) {
			
			resp.sendRedirect("/jr/faq/admin/faqadminlist.do");
			
		} else {
			System.out.println(faqSeq);
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed.');history.back();</script>");
			writer.close();
		}
		
	}
}
