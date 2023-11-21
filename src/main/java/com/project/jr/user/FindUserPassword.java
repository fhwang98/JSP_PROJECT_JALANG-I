package com.project.jr.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.user.model.UserDTO;
import com.project.jr.user.repository.UserDAO;

/**
 * 사용자 비밀번호 찾기를 처리하는 서블릿입니다.
 * 
 * Servlet implementation class FindUserPassword
 * This servlet handles finding user passwords.
 * 
 * @author hyunbin
 */
@WebServlet("/user/finduserpassword.do")
public class FindUserPassword extends HttpServlet {

	/**
	 * 사용자 비밀번호 찾기 페이지로의 GET 요청을 처리합니다.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/finduserpassword.jsp");
		dispatcher.forward(req, resp);

	}	

}
