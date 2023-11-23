package com.project.jr.academy.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.academy.model.AcademyDTO;
import com.project.jr.academy.model.AcademyEduDTO;
import com.project.jr.academy.repository.AcademyDAO;

/**
 * 관리자 학원 관리 페이지 - 학원 정보 수정 페이지를 처리하는 서블릿
 * @author eugene
 *
 */
@WebServlet("/academy/admin/edit.do")
public class Edit extends HttpServlet {

	/**
	 * 학원 정보 수정 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("seq");
        AcademyDAO dao = new AcademyDAO();
        AcademyDTO dto = dao.get(seq);
        req.setAttribute("dto", dto);
        
        ArrayList<AcademyEduDTO> list = dao.getEduList(seq);
        for (AcademyEduDTO e : list) {
        	e.setEduRcStartDate(e.getEduRcStartDate().substring(0, 10));
        	e.setEduRcEndDate(e.getEduRcEndDate().substring(0, 10));
        	e.setEduStartDate(e.getEduStartDate().substring(0, 10));
        	e.setEduEndDate(e.getEduEndDate().substring(0, 10));
        }
        req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/academy/admin/edit.jsp");
        dispatcher.forward(req, resp);
	}
	
	/**
	 * 학원 정보 수정 doPost
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Edit.java
		String academySeq = req.getParameter("academySeq");
		String academyName = req.getParameter("academyName");
		String academyLocation = req.getParameter("academyLocation");
		String academyTel = req.getParameter("academyTel");
		String academyStar = req.getParameter("academyStar");
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		
		//전화번호
		if (!academyTel.matches("^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$")
				|| academyName.replace(" ", "").equals("")
				|| academyLocation.replace(" ", "").equals("")) {
			
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('학원 정보를 정확히 입력해 주세요.');history.back();</script>");
			writer.close();
			return;
		}
		
		
		
		AcademyDTO dto = new AcademyDTO();
		dto.setAcademySeq(Integer.parseInt(academySeq));
		dto.setAcademyName(academyName);
		dto.setAcademyLocation(academyLocation);
		dto.setAcademyTel(academyTel);
		dto.setAcademyStar(Integer.parseInt(academyStar));
		
		AcademyDAO dao = new AcademyDAO();
		
		int result = dao.editAcademy(dto);
		
		if (result == 1) {
			//성공
			
			resp.sendRedirect("/jr/academy/admin/detail.do?seq=" + academySeq);
		} else {
			//실패
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
	}
}