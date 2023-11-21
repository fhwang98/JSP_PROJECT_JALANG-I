package com.project.jr.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.board.model.BoardDTO;
import com.project.jr.board.repository.BoardDAO;



/**
 * 
 * @author oseunghyeon
 * 게시글 추가를 처리하는 서블릿 클래스
 */

@WebServlet("/board/add.do")

public class Add extends HttpServlet{

	
    /**
     * HTTP GET 요청을 처리하여 게시글 추가 폼으로 이동합니다.
     */
	
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/add.jsp");
	dispatcher.forward(req, resp);

	}	

/**
 * HTTP POST 요청을 처리하여 게시글을 추가합니다.
 */
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	//AddOk.java 역할
	
	//1. 데이터 가져오기
	//2. DB 작업 > insert
	//3. 피드백
	
	HttpSession session = req.getSession();		
	
	//1.
	//req.setCharacterEncoding("UTF-8");
	
	//jsp의 어쩌구에서 가져와서 title에 집어 넣고 그 다음에 
	
	String title = req.getParameter("title");
	String content = req.getParameter("content");
//	String id = req.getParameter("id");
	//String boardLike = req.getParameter("boardLike");
	//String boardHits=req.getParameter("boardHits");
	//String boardSeq=req.getParameter("boardSeq");
	//String boardWriteDate=req.getParameter("boardWriteDate");
	
	//2.
	BoardDAO dao = new BoardDAO();		
	BoardDTO dto = new BoardDTO();
	
	dto.setBoardTitle(title);
	dto.setBoardContent(content);
	//dto.setBoardHits(boardHits);
	//dto.setBoardWriteDate(boardWriteDate);
	//dto.setBoardLike(boardLike);
	//dto.setId(id);
	
	
	dto.setId(session.getAttribute("id").toString());
	
	int result = dao.add(dto);
	
	//3.
	if (result == 1) {
		resp.sendRedirect("/jr/board/boardlist.do");
		
	} else {
		PrintWriter writer = resp.getWriter();
		writer.print("<script>alert('failed');history.back();</script>");
		writer.close();
	}
	
}
}
	

