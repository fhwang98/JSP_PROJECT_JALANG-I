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
 * 사용자 삭제를 처리하는 서블릿입니다.
 * 
 * Servlet implementation class DeleteUser
 * This servlet handles user deletion.
 * 
 * @author hyunbin
 */
@WebServlet("/user/deleteuser.do")
public class DeleteUser extends HttpServlet {

	/**
	 * 사용자 삭제 페이지로의 GET 요청을 처리합니다.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/deleteuser.jsp");
		dispatcher.forward(req, resp);

	}
	
	/**
	 * 사용자 삭제를 처리하는 POST 요청을 처리합니다.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 회원 탈퇴
		// - delete(X)
		// - update(O)
		
		// 1. 세션에서 사용자 아이디를 가져옵니다.
		String id = req.getSession().getAttribute("id").toString();
		
		// 2. UserDAO 객체를 생성합니다.
		UserDAO dao = new UserDAO();
		
		// 3. 사용자 삭제를 시도하고 결과를 확인합니다.
		int result = dao.unregister(id);
		
		// 4. 삭제가 성공적으로 이루어지면 세션에서 사용자 정보를 제거하고 로그아웃 후 홈페이지로 이동합니다.
		if (result == 1) {
			// 회원 탈퇴 + 로그아웃
			req.getSession().removeAttribute("id");
			req.getSession().removeAttribute("name");
			req.getSession().removeAttribute("lv");
			
			resp.sendRedirect("/index.do");
			
		} else {
			// 삭제가 실패하면 경고창을 띄우고 이전 페이지로 되돌아갑니다.
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}

	}

}
