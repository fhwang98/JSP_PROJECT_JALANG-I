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

@WebServlet("/user/signup.do")
public class SignUp extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/signup.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//id pw name birthDate sex eMail phoneNum joinDate userStatus 
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
			
			//UserDTO userResult = uDao.signup(uDto);
			
			int result = uDao.signup(uDto);
			
			if(result == 1) {
				resp.sendRedirect("/jr/index.do");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//0또는 에러 
		PrintWriter writer = resp.getWriter();
		writer.print("<script>alert('failed');history.back();</script>");
		writer.close();

	}

}
