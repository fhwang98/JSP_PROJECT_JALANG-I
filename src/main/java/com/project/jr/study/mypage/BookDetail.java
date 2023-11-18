package com.project.jr.study.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.project.jr.study.model.StudyBookDTO;
import com.project.jr.study.repository.StudyDAO;

/**
 * 스터디 교재 상세 클래스
 * @author sujin
 *
 */
@WebServlet("/study/mypage/book/detail.do")
public class BookDetail extends HttpServlet {

	/**
	 * 스터디 교재 상세 jsp 출력 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id=req.getSession().getAttribute("id").toString();
		
		int seq=Integer.parseInt(req.getParameter("seq"));
		String count=req.getParameter("count");
		String name=req.getParameter("name");
		String img=req.getParameter("img");
		
		req.setAttribute("seq", seq);
		req.setAttribute("count", count);
		req.setAttribute("name", name);
		req.setAttribute("img", img);
		
		StudyDAO dao=new StudyDAO();
		
		//System.out.println(id);
		//System.out.println(seq);
		
		ArrayList<StudyBookDTO> list=dao.indexCh(id, seq);
		
//		System.out.println(list.toString());
		
		req.setAttribute("list", list);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/study/mypage/book/detail.jsp");
		dispatcher.forward(req, resp);

	}
	
	/**
	 * 스터디 교재 진척률 JSON출력 doPost
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id=req.getSession().getAttribute("id").toString();
		String list=req.getParameter("list");
		String learnCheck=req.getParameter("learnCheck");
	
		int status=0;
		if(req.getParameter("learnCheck").equals("true")) {
			status=1;
		}else {
			status=0;
		}
		
		System.out.println(list + " " + learnCheck + " " + status);
	
		StudyDAO dao=new StudyDAO();
		
		int result=dao.statusUp(list, status, id);
		
		System.out.println(result);
		
		JSONObject obj = new JSONObject();
		obj.put("result", result);

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		PrintWriter writer = resp.getWriter();
		writer.print(obj.toString());
		writer.close();
	
	}

}
