package com.project.jr.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
 * @author oseunghyeon /** 게시글 목록을 조회하고 페이징 처리를 위한 서블릿 클래스
 */
@WebServlet("/board/boardlist.do")
public class BoardList extends HttpServlet {

	/**
	 * HTTP GET 요청을 처리하여 게시글 목록을 조회하고 페이징 처리를 수행
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		BoardDAO dao = new BoardDAO();
		HashMap<String, String> map = new HashMap<String, String>();
		
		String id = "";
		if (session.getAttribute("id") != null) {
			id = session.getAttribute("id").toString();
		}

		String column = req.getParameter("column");
		String word = req.getParameter("word");
		String search = "n"; // 검색중("y") 목록보기("n")

		if ((column == null && word == null) || (column.equals("") && word.equals(""))) {
			search = "n";
		} else {
			search = "y";
		}

		map.put("column", column);
		map.put("word", word);
		map.put("search", search);

		int nowPage = 0;
		int totalCount = dao.getTotalCount(map); // 총 게시물의 개수
		int pageSize = 10;
		int totalPage = (int) Math.ceil((double) totalCount / pageSize); // 총 페이지 개수
		int begin = 0;
		int end = 0;
		int n = 0;
		int loop = 0;
		int blockSize = 10;

		String page = req.getParameter("page");

		if (page == null || page.equals("")) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}

		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;

		map.put("begin", begin + "");
		map.put("end", end + "");

		//게시글 목록
		ArrayList<BoardDTO> list = dao.getList(map);

		
		
		//제목가공
		for (BoardDTO b : list) {
			if (b.getBoardTitle().length() > 20) {
				b.setBoardTitle(b.getBoardTitle().substring(0, 20) + "...");
			}
		}


		//조회수
		// 새로고침 방지
		session.setAttribute("read", "n");

		
		//페이징
		StringBuilder sb = new StringBuilder();

		loop = 1; // 루프 변수(10바
		// n = 1; //출력할 페이지 번호
		n = ((nowPage - 1) / blockSize) * blockSize + 1;

		// 이전 10페이지
		if (n == 1) {
			sb.append(" <a href='#!'>[이전]</a>");
		} else {

			if (map.get("search").equals("n")) {
				sb.append(String.format(" <a href='/jr/board/boardlist.do?page=%d'>[이전]</a>", n - 1));
			} else {
				sb.append(String.format(" <a href='/jr/board/boardlist.do?page=%d&column=%s&word=%s'>[이전]</a>",
						map.get("column"), map.get("word"), n - 1));
			}

		}

		while (!(loop > blockSize || n > totalPage)) {

			if (n == nowPage) {
				sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a>", n));
			} else {
				if (map.get("search").equals("n")) {

					sb.append(String.format(" <a href='/jr/board/boardlist.do?page=%d'>%d</a>", n, n));
				} else {
					
					sb.append(String.format(" <a href='/jr/board/boardlist.do?page=%d&column=%s&word=%s'>%d</a>", n,
							map.get("column"), map.get("word"), n));
				}
			}
			loop++;
			n++;

		}

		// 다음 10페이지
		if (n > totalPage) {
			sb.append(" <a href='#!'>[다음]</a>");
		} else {
			if (map.get("search").equals("n")) {
				sb.append(String.format(" <a href='/jr/board/boardlist.do?page=%d'>[다음]</a>", n));
			} else {
				sb.append(String.format(" <a href='/jr/board/boardlist.do?page=%d&column=%s&word=%s'>[다음]</a>",
						map.get("column"), map.get("word"), n));
			}
		}

		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);

		req.setAttribute("pageBar", sb.toString());

		req.setAttribute("map", map);
		req.setAttribute("list", list);
		req.setAttribute("id", id);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/boardlist.jsp");
		dispatcher.forward(req, resp);

	}

}
