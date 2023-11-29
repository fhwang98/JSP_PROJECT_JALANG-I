package com.project.jr.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.board.model.BoardDTO;
import com.project.jr.board.repository.BoardDAO;
import com.project.jr.forbidden.repository.ForbiddenDAO;



	/**
	 * 
	 * @author oseunghyeon
	 *
	 */
	@WebServlet("/board/edit.do")
	public class Edit extends HttpServlet {

		/**
	     * HTTP GET 요청을 처리하여 수정 폼을 보여준다.
	     */
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			//Edit.java
			String boardSeq = req.getParameter("boardSeq");
			
			BoardDAO dao = new BoardDAO();			
			BoardDTO dto = dao.getDetail(boardSeq);
			
			req.setAttribute("boardSeq", boardSeq);
			req.setAttribute("dto", dto);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/edit.jsp");
			dispatcher.forward(req, resp);
		}
		
		   /**
	     * HTTP POST 요청을 처리하여 게시글을 수정
	     */
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			//EditOk.java 역할
			
			String title = req.getParameter("boardTitle");
			String content = req.getParameter("boardContent");
			String seq = req.getParameter("boardSeq");
			
			//금지어 검사
			ForbiddenDAO fdao = new ForbiddenDAO();
			ArrayList<String> flist = fdao.list();
			for (String word : flist) {
				if (content.contains(word) || title.contains(word)) {
					resp.setCharacterEncoding("UTF-8");
					resp.setContentType("text/html; charset=UTF-8");
					
					PrintWriter writer = resp.getWriter();
					writer.print("<script>alert('\\'" + word + "\\'는 입력할 수 없는 단어입니다.');history.back();</script>");
					writer.close();
					return;
				}
			}
		
			//2.
			BoardDAO dao = new BoardDAO();
			BoardDTO dto = new BoardDTO();
			
			dto.setBoardSeq(Integer.parseInt(seq));
			dto.setBoardTitle(title);
			dto.setBoardContent(content); 
			
			int result = dao.editBoard(dto);
			
			//3.
			if (result == 1) {
					
				resp.sendRedirect("/jr/board/boarddetail.do?boardSeq=" + seq);
				
			} else {
				PrintWriter writer = resp.getWriter();
				writer.print("<script>alert('failed');history.back();</script>");
				writer.close();
			}
			
		}

	}
	
