package com.project.jr.academy.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.academy.model.AcademyDTO;
import com.project.jr.academy.repository.AcademyDAO;

/**
 * 관리자 학원 관리 페이지 - 학원 추가 페이지 서블릿
 * @author eugene
 *
 */
@WebServlet("/academy/admin/add.do")
public class Add extends HttpServlet {

	/**
	 * 학원 추가 페이지 요청을 처리하는 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Add.java

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/academy/admin/add.jsp");
		dispatcher.forward(req, resp);
	}
	
	/**
	 * 학원 추가 요청을 처리하는 doPost
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
		dto.setAcademyName(academyName);
		dto.setAcademyLocation(academyLocation);
		dto.setAcademyTel(academyTel);
		dto.setAcademyStar(Integer.parseInt(academyStar));
		
		AcademyDAO dao = new AcademyDAO();
		
		int result = dao.addAcademy(dto);
		
		if (result == 1) {
			//성공
			
			String seq = dao.getLastSeq();
			
			resp.sendRedirect("/jr/academy/admin/detail.do?seq=" + seq);
		} else {
			//실패
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
	}
}