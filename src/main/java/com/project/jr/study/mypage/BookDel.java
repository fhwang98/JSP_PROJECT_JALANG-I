package com.project.jr.study.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.study.repository.StudyDAO;

/**
 * 스터디 교재 삭제 클래스
 * @author sujin
 *
 */
@WebServlet("/study/mypage/book/del.do")
public class BookDel extends HttpServlet {

	/**
	 * 스터디 교재 삭제 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id=req.getSession().getAttribute("id").toString();
		
		int seq=Integer.parseInt(req.getParameter("seq"));
//		System.out.println(seq);
		
		StudyDAO dao=new StudyDAO();
		
		int result=dao.delBook(id, seq);
		
		//System.out.println("리저트결과 "+result);
		
		if (result == 0) {
			
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
			
		} else {
			resp.sendRedirect("/jr/study/mypage/book/list.do");
		}

	}

}
