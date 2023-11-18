package com.project.jr.crt.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.repository.CrtDAO;

/**
 * 나의자격증 추가 클래스
 *
 */
@WebServlet("/crt/mypage/add.do")
public class Add extends HttpServlet {

	/**
	 * 나의자격증 추가 jsp 실행 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String searchWord = req.getParameter("crtName");
		
		
		
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/mypage/add.jsp");
		dispatcher.forward(req, resp);

	}

	/**
	 * 나의자격증 추가 dB처리 결과 doPost
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id=req.getSession().getAttribute("id").toString();
		
		String crtName=req.getParameter("crtName");
		
		String date=req.getParameter("date");
	
		//System.out.println(crtName + " " + date);
	
		
		CrtDAO dao=new CrtDAO();
		
		int crtSeq=dao.crtNameCh(crtName);
		//System.out.println(crtName);
		//System.out.println(crtSeq);
		
		int result=dao.setMyCrt(id, crtSeq, date);
		
		if (result == 1) {
			
			resp.sendRedirect("/jr/crt/mypage/list.do");
			
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
	
	}
}
