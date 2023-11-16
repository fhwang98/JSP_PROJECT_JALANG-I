package com.project.jr.crt.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtSchAdminDTO;
import com.project.jr.crt.repository.CrtSchAdminDAO;
import com.project.jr.faq.model.FAQDTO;

@WebServlet("/crt/admin/crtschadmindetail.do")
public class CrtSchAdminDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String crtSchSeq= req.getParameter("crtSchSeq");
		
		CrtSchAdminDAO dao = new CrtSchAdminDAO();
		
		CrtSchAdminDTO dto = dao.detail(crtSchSeq);
		

			
			//날짜 자르기
		
			String testRcStartDate = dto.getTestRcStartDate();			
			dto.setTestRcStartDate(testRcStartDate.substring(0, 10));
			
			String testRcEndDate = dto.getTestRcEndDate();			
			dto.setTestRcEndDate(testRcEndDate.substring(0, 10));
		
			String testStartDate = dto.getTestStartDate();			
			dto.setTestStartDate(testStartDate.substring(0, 10));
		
			String testEndDate = dto.getTestEndDate();			
			dto.setTestEndDate(testEndDate.substring(0, 10));
			
			String passday = dto.getPassDay();			
			dto.setPassDay(passday.substring(0, 10));
			
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crtschadmindetail.jsp");

		dispatcher.forward(req, resp);
	}
}
