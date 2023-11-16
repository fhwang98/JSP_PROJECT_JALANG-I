package com.project.jr.crt.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtSchAdminDTO;
import com.project.jr.crt.repository.CrtSchAdminDAO;

@WebServlet("/crt/admin/crtschadminedit.do")
public class CrtSchAdminEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String crtSchSeq = req.getParameter("crtSchSeq");
		
		CrtSchAdminDAO dao = new CrtSchAdminDAO();
		
		CrtSchAdminDTO dto = dao.detail(crtSchSeq);
		
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
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crtschadminedit.jsp");

		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String round = req.getParameter("round");
		String testRcStartDate = req.getParameter("testRcStartDate");
		String testRcEndDate = req.getParameter("testRcEndDate");
		String testStartDate = req.getParameter("testStartDate");
		String testEndDate = req.getParameter("testEndDate");
		String passDay = req.getParameter("passDay");
		String crtSchSeq = req.getParameter("crtSchSeq");
		
//        pstat.setString(1, dto.getRound());
//        pstat.setString(2, dto.getTestRcStartDate());
//        pstat.setString(3, dto.getTestRcEndDate());
//        pstat.setString(4, dto.getTestStartDate());
//        pstat.setString(5, dto.getTestEndDate());
//        pstat.setString(6, dto.getPassDay());
//        pstat.setInt(7, dto.getCrtSchSeq());
		
		
		
		
		CrtSchAdminDAO dao = new CrtSchAdminDAO();
		
		CrtSchAdminDTO dto = new CrtSchAdminDTO();
		
		dto.setRound(round);
		dto.setTestRcStartDate(testRcStartDate);
		dto.setTestRcEndDate(testRcEndDate);
		dto.setTestStartDate(testStartDate);
		dto.setTestEndDate(testEndDate);
		dto.setPassDay(passDay);
		dto.setCrtSchSeq(Integer.parseInt(crtSchSeq));
		
		
		int result = dao.edit(dto);
		
		if (result == 1) {
			
			resp.sendRedirect("/jr/crt/admin/crtschadmindetail.do?crtSchSeq=" + crtSchSeq);
		
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
	}
	
}
