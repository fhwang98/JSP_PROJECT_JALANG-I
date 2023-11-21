package com.project.jr.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.board.model.BoardDTO;
import com.project.jr.board.repository.BoardDAO;

	
/**
 * @author oseunghyeon
 * 게시글 상세 정보를 조회하는 서블릿 클래
 */
	@WebServlet("/board/boarddetail.do")
	
	public class BoardDetail extends HttpServlet {

		
		  /**
	     * HTTP GET 요청을 처리하여 게시글의 상세 정보를 조회합니다.
	     */
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			
			String boardSeq = req.getParameter("boardSeq");
			
			//ArrayList<BoardDTO> list=new ArrayList<BoardDTO>(); 
			
			BoardDAO dao=new BoardDAO();
			
			BoardDTO dto =dao.getDetail(boardSeq);
			
			req.setAttribute("dto", dto);
			System.out.println(boardSeq);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/boarddetail.jsp");
			dispatcher.forward(req, resp);


	}
}

	
	
	
	