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

import com.project.jr.crt.model.CrtDTO;
import com.project.jr.crt.repository.CrtAdminDAO;
import com.project.jr.crt.repository.CrtDAO;
@WebServlet("/crt/admin/crtadminedit.do")
public class CrtAdminEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String crtSeq = req.getParameter("crtSeq");
		
		CrtAdminDAO dao = new CrtAdminDAO();
		
		CrtDTO dto = dao.detail(crtSeq);
		
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crtadminedit.jsp");

		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("UTF-8");
		
		String crtName = req.getParameter("crtName");
		String crtTypeSeq = req.getParameter("crtTypeSeq");
		String expiration = req.getParameter("expiration");
		String agencySeq = req.getParameter("agencySeq");
		String isRoutine = req.getParameter("isRoutine");
		String difficulty = req.getParameter("difficulty");
		String likeCnt = req.getParameter("likeCnt");
		String qualificationCate = req.getParameter("qualificationCate");
		String qualification = req.getParameter("qualification");
		String crtInfo = req.getParameter("crtInfo");
		String totalCnt = req.getParameter("totalCnt");
		String jobDesc = req.getParameter("jobDesc");
		String crtSeq = req.getParameter("crtSeq");

		CrtAdminDAO dao = new CrtAdminDAO();
		
		CrtDTO dto = new CrtDTO();
		
		dto.setCrtSeq(Integer.parseInt(crtSeq));
		dto.setCrtName(crtName);
		dto.setCrtTypeSeq(Integer.parseInt(crtTypeSeq));
		dto.setExpiration(expiration);
		dto.setAgencySeq(Integer.parseInt(agencySeq));
		dto.setIsRoutine(Integer.parseInt(isRoutine));
		dto.setDifficulty(Integer.parseInt(difficulty));
		dto.setLikeCnt(Integer.parseInt(likeCnt));
		dto.setQualificationCate(qualificationCate);
		dto.setQualification(qualification);
		dto.setCrtInfo(crtInfo);
		dto.setTotalCnt(Integer.parseInt(totalCnt));
		dto.setJobDesc(jobDesc);
		
		int result = dao.edit(dto);
		
		if (result == 1) {
			
			resp.sendRedirect("/jr/crt/admin/crtadmindetail.do?crtSeq=" + crtSeq);
		
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
		
	}
	
}
