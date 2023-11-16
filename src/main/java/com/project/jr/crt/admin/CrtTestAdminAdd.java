package com.project.jr.crt.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.crt.model.CrtTestDTO;
import com.project.jr.crt.repository.CrtTestDAO;

@WebServlet("/crt/admin/crttestadminadd.do")
public class CrtTestAdminAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crttestadminadd.jsp");

		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");
		
		
		String crtTestSeq = req.getParameter("crtTestSeq");
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
		
		CrtTestDAO dao = new CrtTestDAO();
		
		CrtTestDTO dto = new CrtTestDTO();
		
		dto.setCrtTestSeq(crtTestSeq);
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
		
		
		int result = dao.add(dto);
		
		if (result == 1) {
			
			resp.sendRedirect("/jr/crt/admin/crttestadminlist.do");
			
		} else {
			System.out.println(crtTestSeq);
			System.out.println(crtTestName);
			System.out.println(crtSeq);
			System.out.println(crtTestTypeSeq);
			System.out.println(examPay);
			System.out.println(expiryDate);
			System.out.println(passLine);
			System.out.println(testSubject);
			System.out.println(questionType);
			System.out.println(qustionNum);
			System.out.println(testTime);
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
	}
}
