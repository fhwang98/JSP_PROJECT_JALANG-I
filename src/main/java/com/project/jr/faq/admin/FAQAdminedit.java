package com.project.jr.faq.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.faq.model.FAQDTO;
import com.project.jr.faq.repository.FAQAdminDAO;

@WebServlet("/faq/admin/faqadminedit.do")
public class FAQAdminedit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String faqSeq = req.getParameter("Seq");
		
		FAQAdminDAO dao = new FAQAdminDAO();
		
		FAQDTO dto = dao.detail(faqSeq);
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/faq/admin/faqadminedit.jsp");

		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String faqSeq = req.getParameter("faqSeq");
		String faqtitle = req.getParameter("faqtitle");
		String faqContent = req.getParameter("faqContent");
		
		FAQAdminDAO dao = new FAQAdminDAO();
		
		FAQDTO dto = new FAQDTO();
		
		dto.setFaqSeq(faqSeq);
		dto.setFaqtitle(faqtitle);
		dto.setFaqContent(faqContent);
		
		int result = dao.edit(dto);
		
		if (result == 1) {
			
			resp.sendRedirect("/jr/faq/admin/faqadmindetail.do?Seq=" + faqSeq);
		
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
	}
	
}
