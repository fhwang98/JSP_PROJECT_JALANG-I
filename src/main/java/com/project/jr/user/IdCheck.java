package com.project.jr.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.user.repository.UserDAO;

/**
 * 사용자 아이디 중복 확인을 처리하는 서블릿입니다.
 * 
 * Servlet implementation class IdCheck
 * This servlet handles user ID duplication check.
 * 
 * @author hyunbin
 */
@WebServlet("/user/idcheck.do")
public class IdCheck extends HttpServlet {

	/**
	 * 사용자 아이디 중복 확인을 POST 요청으로 처리합니다.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/views/user/signup.jsp");
//		dispacher.forward(req, resp);
		
		// 1. 데이터 가져오기 (id)
		// 2. DB 작업 (중복 체크)
		// 3. 결과 반환
		
		// 1.
		String id = req.getParameter("id");
		
		// 2. Data Access Object
		UserDAO dao = new UserDAO();
		
		// 중복 확인 메시지를 가져옵니다. (가능: 0, 불가능: 1)
		int message = dao.check(id);
		
		/*
		 * 데이터를 돌려받을 형태
			{
				message: 0
			}
		*/
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
	
		writer.printf("{ \"message\": %d }", message);
				
		writer.close();
		
	}

}
