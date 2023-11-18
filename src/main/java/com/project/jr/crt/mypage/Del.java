package com.project.jr.crt.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.repository.CrtDAO;

/**
 * 나의자격증 삭제 클래스
 *
 */
@WebServlet("/crt/mypage/del.do")
public class Del extends HttpServlet {

	/**
	 * 나의자격증 삭제 처리 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int seq=Integer.parseInt(req.getParameter("seq"));
		
		CrtDAO dao=new CrtDAO();
		
		int result=dao.delMyCrt(seq);
		
		if (result == 0) {
			
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
			
		} else {
			resp.sendRedirect("/jr/crt/mypage/list.do");
		}
		
		
		
		
	}

}
