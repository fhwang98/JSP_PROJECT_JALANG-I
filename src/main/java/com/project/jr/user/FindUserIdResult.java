package com.project.jr.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 사용자 아이디 찾기 결과 페이지로의 요청을 처리하는 서블릿입니다.
 * 
 * Servlet implementation class FindUserIdResult
 * This servlet handles requests for the user ID retrieval result page.
 * 
 * @author hyunbin
 */
@WebServlet("/user/finduseridresult.do")
public class FindUserIdResult extends HttpServlet {

	/**
	 * 사용자 아이디 찾기 결과 페이지로의 GET 요청을 처리합니다.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/finduseridresult.jsp");
		dispatcher.forward(req, resp);

	}

}
