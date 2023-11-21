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
 * 사용자 비밀번호 찾기 결과를 처리하는 서블릿입니다.
 * 
 * Servlet implementation class FindUserPasswordResult
 * This servlet handles the result of finding user passwords.
 * 
 * @author hyunbin
 */
@WebServlet("/user/finduserpasswordresult.do")
public class FindUserPasswordResult extends HttpServlet {

	/**
	 * 사용자 비밀번호 찾기 결과를 POST 요청으로 처리합니다.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 사용자 아이디와 이름을 가져옵니다.
		String id = req.getParameter("id");		
		String name = req.getParameter("name");
		
		// 요청 속성에 이름과 아이디를 설정하여 변경 페이지로 포워딩합니다.
		req.setAttribute("name", name);
		req.setAttribute("id", id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/changepassword.jsp");
		dispatcher.forward(req, resp);

	}

}
