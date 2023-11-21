package com.project.jr.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.user.model.UserDTO;
import com.project.jr.user.repository.UserDAO;

/**
 * 비밀번호 변경을 처리하는 서블릿입니다.
 * 
 * Servlet implementation class ChangePassword
 * This servlet handles password changes.
 * 
 * @author hyunbin
 */
@WebServlet("/user/changepassword.do")
public class ChangePassword extends HttpServlet {

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=utf-8");
//        
//        String name = req.getParameter("name");
//        String phoneNum1 = req.getParameter("phoneNum1");
//        String phoneNum2 = req.getParameter("phoneNum2");
//        String phoneNum3 = req.getParameter("phoneNum3");
//        String phoneNum = phoneNum1 + "-" + phoneNum2 + "-" + phoneNum3;
//		
//        //if (checked.equals("1")) {
//		UserDAO uDao = new UserDAO();
//	    UserDTO uDto = new UserDTO();
//	
//	    uDto.setName(name);
//	    uDto.setPhoneNum(phoneNum);
//	    
//	    UserDTO result = uDao.changePw(uDto);
//    
//	
//	
//	    if(result != null) {
//	    	req.getSession().setAttribute("name", name);
//	        req.getSession().setAttribute("phoneNum", phoneNum);
//	        req.getSession().setAttribute("id", result.getId());
//	        
//	        resp.sendRedirect("/jr/user/finduseridresult.do");	
//	    }else {
//	    	//0또는 에러 
//	    	PrintWriter writer = resp.getWriter();
//	    	writer.print("<script>alert('failed');history.back();</script>");
//	    	writer.close();
//	    }
//	    
//
//	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		System.out.println(id + " "+ pw);
		UserDAO uDao = new UserDAO();
		int result = uDao.changePw(id, pw);
		
		System.out.println(result);
		if(result == 1) {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('비밀번호 변경이 완료되었습니다.');location.href='/jr/index.do';</script>");
			writer.close();
			
		}else{
			//0또는 에러 
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}
		
		
	}

}
