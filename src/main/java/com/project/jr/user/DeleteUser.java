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

@WebServlet("/user/deleteuser.do")
public class DeleteUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/views/user/deleteuser.jsp");
		dispacher.forward(req, resp);

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//회원 탈퇴
		//- delete(X)
		//- update(O)
		
		//1.
		String id = req.getSession().getAttribute("id").toString();
		
		//2.
		UserDAO dao = new UserDAO();
		
		int result = dao.unregister(id);
		
		//3.
		if (result == 1) {
			
			//회원 탈퇴 + 로그아웃
			req.getSession().removeAttribute("id");
			req.getSession().removeAttribute("name");
			req.getSession().removeAttribute("lv");
			
			resp.sendRedirect("/index.do");
			
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}

	}
	
	

}
