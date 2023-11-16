package com.project.jr.crt.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtDTO;
import com.project.jr.crt.model.CrtTestDTO;
import com.project.jr.crt.repository.CrtTestDAO;

@WebServlet("/crt/admin/crttestadminedit.do")
public class CrtTestAdminEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String crtSeq = req.getParameter("crtSeq");
		
		CrtTestDAO dao = new CrtTestDAO();
		
		CrtTestDTO dto = dao.detail(crtSeq);

		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crttestadminedit.jsp");

		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String crtTestName = req.getParameter("crtTestName");
		String crtSeq = req.getParameter("crtSeq");
		String crtTestTypeSeq = req.getParameter("crtTestTypeSeq");
		String examPay = req.getParameter("examPay");
		String expiryDate = req.getParameter("expiryDate");
		String passLine = req.getParameter("passLine");
		String testSubject = req.getParameter("testSubject");
		String questionType = req.getParameter("questionType");
		String qustionNum = req.getParameter("qustionNum");
		String testTime = req.getParameter("testTime");
		String crtTestSeq = req.getParameter("crtTestSeq");
		
		CrtTestDAO dao = new CrtTestDAO();
		
		CrtTestDTO dto = new CrtTestDTO();
		
   	 	dto.setCrtTestName(crtTestName);
   	 	dto.setCrtSeq(crtSeq);
   	 	dto.setCrtTestTypeSeq(crtTestTypeSeq);
   	 	dto.setExamPay(examPay);
   	 	dto.setExpiryDate(expiryDate);
   	 	dto.setPassLine(passLine);
   	 	dto.setTestSubject(testSubject);
   	 	dto.setQuestionType(questionType);
   	 	dto.setQustionNum(qustionNum);
   	 	dto.setTestTime(testTime);
   	 	dto.setCrtTestSeq(crtTestSeq);
		
		int result = dao.edit(dto);
		
		if (result == 1) {
			
			resp.sendRedirect("/jr/crt/admin/crttestadmindetail.do?crtSeq=" + crtSeq);
			
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
	}
}
