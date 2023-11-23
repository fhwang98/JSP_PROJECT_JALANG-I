package com.project.jr.academy.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.academy.repository.AcademyDAO;

/**
 * 관리자 학원 관리 페이지 - 학원 정보를 삭제하는 요청을 처리하는 서블릿
 * @author eugene
 *
 */
@WebServlet("/academy/admin/del.do")
public class Del extends HttpServlet {

	/**
	 * 학원 정보 삭제 페이지 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Del.java

		String seq = req.getParameter("seq");
		AcademyDAO dao = new AcademyDAO();
		
		int result = dao.delAcademy(seq);
		
		
		
		if (result == 1) {
			//성공
			resp.sendRedirect("/jr/academy/admin/list.do");
			
		} else {
			//실패
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
	}
}