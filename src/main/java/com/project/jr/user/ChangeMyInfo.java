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
 * 사용자 정보를 변경하는 서블릿입니다.
 * 
 * Servlet implementation class ChangeMyInfo
 * This servlet handles the changing of user information.
 * 
 * @author hyunbin
 *
 */
@WebServlet("/user/changemyinfo.do")
public class ChangeMyInfo extends HttpServlet {

	/**
	 * 사용자 정보 변경 페이지로의 GET 요청을 처리합니다.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/changemyinfo.jsp");
		dispatcher.forward(req, resp);

	}
	
	/**
	 * 사용자 정보를 업데이트하는 POST 요청을 처리합니다.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 가져오기
		try {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String name = req.getParameter("name");
			String birthDate = req.getParameter("birthDate");
			String sex = req.getParameter("sex");
			String eMail = req.getParameter("eMail");
			String phoneNum1 = req.getParameter("phoneNum1");
			String phoneNum2 = req.getParameter("phoneNum2");
			String phoneNum3 = req.getParameter("phoneNum3");
			String phoneNum = phoneNum1 + "-" + phoneNum2 + "-" + phoneNum3;
			String joinDate = req.getParameter("joinDate");
			String userStatus = req.getParameter("userStatus");
			
			UserDAO uDao=new UserDAO();
			UserDTO uDto=new UserDTO();
			uDto.setId(id);
			uDto.setPw(pw);
			uDto.setName(name);
			uDto.setBirthDate(birthDate);
			uDto.setSex(sex);
			uDto.setEMail(eMail);
			uDto.setPhoneNum(phoneNum);
			uDto.setJoinDate(joinDate);
			uDto.setUserStatus(2);
			
			// UserDTO userResult = uDao.signup(uDto);
			
			int result = uDao.signup(uDto);
			
			if(result == 1) {
				resp.sendRedirect("/jr/user/signup.do");
			}
			
		} catch(Exception e) {
			// 업데이트 과정에서 예외가 발생하면 스택 트레이스를 출력합니다.
			e.printStackTrace();
		}
		
		// 0 또는 에러
		PrintWriter writer = resp.getWriter();
		writer.print("<script>alert('failed');history.back();</script>");
		writer.close();
		
	}

}
