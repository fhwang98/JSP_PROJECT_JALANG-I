package com.project.jr.crt;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Auth {
public static boolean check(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		//String id = req.getParameter("id");
		
		//CrtDAO dao = new CrtDAO();
		
		/*
		if (!session.getAttribute("id").toString().equals(dto.getId()) ) {
			
			try {
				PrintWriter writer = resp.getWriter();
				writer.print("<script>alert('Auth failed');history.back();</script>");
				writer.close();
				
			} catch (Exception e) {
				System.out.println("Auth.check()");
				e.printStackTrace();
			}
			
			return true;
		}
		*/
		return false;
	}
}
