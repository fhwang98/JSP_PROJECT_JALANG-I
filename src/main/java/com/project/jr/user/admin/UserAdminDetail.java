package com.project.jr.user.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.user.model.UserDTO;
import com.project.jr.user.repository.UserAdminDAO;

@WebServlet("/user/admin/useradmindetail.do")
public class UserAdminDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		UserAdminDAO dao = new UserAdminDAO();
		
		UserDTO dto  = dao.detail(id);
		
		req.setAttribute("dto", dto);
		
		//생년월일 날짜 자르기
		String birthdate = dto.getBirthDate();			
		dto.setBirthDate(birthdate.substring(0, 10));
		
		
		//가입일 날짜 자르기
		String joindate = dto.getJoinDate();			
		dto.setJoinDate(joindate.substring(0, 10));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/admin/useradmindetail.jsp");

		dispatcher.forward(req, resp);
	}
}
