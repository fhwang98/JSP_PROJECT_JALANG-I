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

@WebServlet("/user/idcheck.do")
public class IdCheck extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/views/user/signup.jsp");
//		dispacher.forward(req, resp);
		
		//1. 데이터 가져오기 (id)
		//2. DB 작업 (중복 체크)
		//3. 결과 반환
		
		//1.
		String id = req.getParameter("id");
		
		//2. Data Access Object
		UserDAO dao = new UserDAO();
		
		int message = dao.check(id); //가능(0), 불가능(1)
		
		/*
		 * 데이터를 돌려받을 형태
			{
				result: 0
			}
		*/
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = resp.getWriter();
	
		writer.printf("{ \"message\": %d }", message);
				
		writer.close();
		
	}

}
