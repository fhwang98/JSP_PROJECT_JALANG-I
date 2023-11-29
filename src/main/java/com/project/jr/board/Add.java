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
 * @author oseunghyeon 게시글 추가를 처리하는 서블릿 클래스
 */

@WebServlet("/board/add.do")

public class Add extends HttpServlet {

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

		HttpSession session = req.getSession();

		String id = session.getAttribute("id").toString();
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		
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
		
		
		// 2.
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();

		dto.setBoardTitle(title);
		dto.setBoardContent(content);
		dto.setId(id);

		int result = dao.add(dto);

		// 3.
		if (result == 1) {
			resp.sendRedirect("/jr/board/boardlist.do");

		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
		}

	}
}
