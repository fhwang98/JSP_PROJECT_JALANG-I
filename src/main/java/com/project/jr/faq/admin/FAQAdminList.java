package com.project.jr.faq.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.faq.model.FAQDTO;
import com.project.jr.faq.repository.FAQAdminDAO;

@WebServlet("/faq/admin/faqadminlist.do")
public class FAQAdminList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String faqSeq = req.getParameter("faqSeq");
		
		FAQAdminDAO dao =  new FAQAdminDAO();
		
		ArrayList<FAQDTO> list = dao.list();
		
		for (FAQDTO dto : list) {
			
			//날짜 자르기
			String regdate = dto.getFaqWriteDate();			
			dto.setFaqWriteDate(regdate.substring(0, 10));
			
		}
		
		
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/faq/admin/faqadminlist.jsp");

		dispatcher.forward(req, resp);
	}
}