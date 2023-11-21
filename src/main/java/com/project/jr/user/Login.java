package com.project.jr.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.admin.model.AdminDTO;
import com.project.jr.admin.repository.AdminDAO;
import com.project.jr.user.model.UserDTO;
import com.project.jr.user.repository.UserDAO;

/**
 * 사용자 및 관리자 로그인을 처리하는 서블릿입니다.
 * 
 * Servlet implementation class Login
 * This servlet handles user and admin login.
 * 
 * @author hyunbin
 */
@WebServlet("/user/login.do")
public class Login extends HttpServlet {

	/**
	 * 사용자 및 관리자 로그인 페이지로의 GET 요청을 처리합니다.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/login.jsp");
		dispatcher.forward(req, resp);

	}
	
	/**
	 * 사용자 및 관리자 로그인을 POST 요청으로 처리합니다.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		
		// 회원 DB 조회 
		UserDAO uDao=new UserDAO();
		UserDTO uDto=new UserDTO();
		uDto.setId(id);
		uDto.setPw(pw);
		UserDTO userResult=uDao.login(uDto);
		
		// 관리자 DB 조회
		AdminDAO aDao=new AdminDAO();
		AdminDTO aDto=new AdminDTO();
		aDto.setAdminInfoId(id);
		aDto.setAdminInfoPw(pw);
		AdminDTO adminResult=aDao.login(aDto);
		
		if (userResult != null) {						// 사용자 회원의 로그인 성공
			
			if(userResult.getUserStatus() == 1) {		// 활동 여부 확인(활동 중 회원)
				// 인증 티켓
				req.getSession().setAttribute("id", id); 
				req.getSession().setAttribute("name", userResult.getName());
				req.getSession().setAttribute("lv", 1);
				resp.sendRedirect("/jr/index.do");
				return;
			} else {									// 탈퇴 회원
				PrintWriter writer = resp.getWriter();
				writer.print("<script>alert('탈퇴한 회원입니다');history.back();</script>");
				writer.close();
				return;
			}
			
		} else if (adminResult != null) {				// 관리자 아이디로 로그인 성공
			
			// 인증 티켓
			req.getSession().setAttribute("id", id); 
			req.getSession().setAttribute("name", "관리자");
			req.getSession().setAttribute("lv", 2);
			resp.sendRedirect("/jr/admin/home.do");
			
		} else {// 로그인 실패
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
			
	}

}
