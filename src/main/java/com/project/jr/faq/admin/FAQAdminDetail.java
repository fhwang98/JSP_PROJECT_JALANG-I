package com.project.jr.faq.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.project.jr.faq.model.FAQDTO;
import com.project.jr.faq.repository.FAQAdminDAO;

@WebServlet("/faq/admin/faqadmindetail.do")
public class FAQAdminDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String faqSeq = req.getParameter("Seq");
		
		FAQAdminDAO dao = new FAQAdminDAO();
		
		FAQDTO dto  = dao.detail(faqSeq);
		

			//날짜 자르기
			String regdate = dto.getFaqWriteDate();			
			dto.setFaqWriteDate(regdate.substring(0, 10));
			
		
		req.setAttribute("dto", dto);
		
		System.out.println(dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/faq/admin/faqadmindetail.jsp");

		dispatcher.forward(req, resp);
	}
}
