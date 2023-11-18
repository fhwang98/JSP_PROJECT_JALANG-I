package com.project.jr.crt.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.project.jr.crt.repository.CrtDAO;

/**
 * 나의자격증 검색 autocomlet 클래스
 *
 */
@WebServlet("/crt/mypage/search.do")
public class Search extends HttpServlet {

	/**
	 * 나의자격증 검색 autocomlete JSON 출력 doGet 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String searchWord = req.getParameter("crtName");
		//String searchWord = "항공";
		
		//System.out.println(searchWord);
		
		CrtDAO dao=new CrtDAO();
		
		ArrayList<String> list=dao.search(searchWord);
		
		//System.out.println(list.toString());
		//JSONArray result
		
		JSONArray arr=new JSONArray();
		
		for(String s : list) {
			
			arr.add(s);
		}
		
		
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter writer=resp.getWriter();
		
		writer.print(arr.toString());
		
		writer.close();
		
		
		
		

	}

}
