package com.project.jr.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 사용자 및 관리자 로그아웃을 처리하는 서블릿입니다.
 * 
 * Servlet implementation class Logout
 * This servlet handles user and admin logout.
 * 
 * @author hyunbin
 */
@WebServlet("/user/logout.do")
public class Logout extends HttpServlet {

	/**
	 * 사용자 및 관리자 로그아웃을 GET 요청으로 처리합니다.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 인증 티켓 제거
		req.getSession().removeAttribute("id");
		req.getSession().removeAttribute("name");
		req.getSession().removeAttribute("lv");
		
		resp.sendRedirect("/jr/index.do");
		
	}

}
