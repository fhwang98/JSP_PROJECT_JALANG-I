package com.project.jr.crt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.crt.model.CrtBoardDTO;
import com.project.jr.crt.repository.CrtBoardDAO;
/**
 * 자격증 후기게시판 클래스
 */
@WebServlet("/crt/crtboardlist.do")
public class CrtBoardList extends HttpServlet {
	/**
	 * 자격증 후기게시판 jsp 출력 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//CrtBoardList.java
/*
		HttpSession session = req.getSession();
		
		if (session.getAttribute("id") == null) {
	         
	         resp.setContentType("text/html; charset=UTF-8");
	         
	         PrintWriter writer = resp.getWriter();
	         writer.print("<script>alert('로그인이 필요한 서비스입니다. 로그인 화면으로 이동합니다.');location.href='/jr/user/login.do';</script>");
	         return;
	    }
		*/
		HttpSession session = req.getSession();
		String crtseq = req.getParameter("crtseq");
		String crtName = req.getParameter("crtName");
		String agency = req.getParameter("agency");
		String crtctg = req.getParameter("crtctg");
		
		// 페이징
		int nowPage = 0; // 현재 페이지 번호
		int totalCount = 0; // 총 게시물 수
		int pageSize = 10; // 한 페이지에서 출력할 게시물 수
		int totalPage = 0; // 총 페이지 수
		int begin = 0; // 페이징 시작 위치
		int end = 0; // 페이지 끝 위치
		int blockSize = 10;
		
		String page = req.getParameter("page");
		
		
		if (page == null || page.equals("")) {
			//기본 페이지는 1페이지로 설정
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		//list.do?page=1 로 요청하면 DB에선 where rnum between 1 and 10 으로 처리해야한다.
		begin = ((nowPage -1) * pageSize) +1;
		end = begin + pageSize -1;
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("begin", begin+"");
		map.put("end",  end+"");
		
		
		//조회수를 한번만 증가하기 위해 조회 여부를 담는 티켓
		session.setAttribute("read", "n");
		
		CrtBoardDAO dao = new CrtBoardDAO();
		
		map.put("crtseq",  crtseq);
		ArrayList<CrtBoardDTO> list = dao.list(map);
		
		// 1.5 데이터 가공
		for (CrtBoardDTO dto : list) {

			// 제목 길이 자르기
			String title = dto.getCrtBoardTitle();

			if (title.length() > 25) {
				title = title.substring(0, 25) + "...";
			}

			// 사용자가 태그를 입력했을 때 비활성화 처리
			title = title.replace("<", "&lt;").replace(">", "&gt");

			dto.setCrtBoardTitle(title);
		}
		
		// 총 게시물 수
		totalCount = dao.getTotalCount(crtseq);
		totalPage = (int) Math.ceil((double) totalCount / pageSize);

		// 페이지 바 계산하기
		StringBuilder sb = new StringBuilder();
		
		
		// 이전 다음 버튼으로 페이지 수를 나열하는 방식
		int loop = 1; // 루프 변수(10바퀴)
		int n = ((nowPage - 1) / blockSize) * blockSize + 1;

		// [이전페이지]
		if (n == 1) {
			sb.append(" <a href='#!'>[이전페이지]</a>");
			// sb.append(String.format(" <a href='#!'>[다음페이지]</a>"));
		} else {
			sb.append(String.format(" <a href='/jr/crt/crtboardlist.do?crtseq=%s&page=%d'>[이전페이지]</a>", crtseq, n - 1));
		}

		while (!(loop > blockSize || n > totalPage)) {
			if (n == nowPage) {
				// 다시 자기를 눌렀을 때, 아무 반응이 없도록
				sb.append(String.format(" <a href='#!' style='color:tomato; font-weight: bold;'>%d</a> ", n));
			} else {
				sb.append(String.format(" <a href='/jr/crt/crtboardlist.do?crtseq=%s&page=%d'>%d</a> ",crtseq, n, n));
			}
			loop++;
			n++;
		}
		
		// [다음페이지]
		// 위에서 n값이 blockSize보다 1 큰 값이 들아가있다.
		// 마지막 페이지까지만 이동해야한다.
		if (n > totalPage) {
			sb.append(" <a href='#!'>[다음페이지]</a>");
		} else {
			sb.append(String.format(" <a href='/jr/crt/crtboardlist.do?crtseq=%s&page=%d'>[다음페이지]</a>", crtseq, n));
		}
		
		
		req.setAttribute("pagebar", sb.toString());

		
		

		req.setAttribute("crtseq", crtseq);
		req.setAttribute("crtName", crtName);
		req.setAttribute("agency", agency);
		req.setAttribute("crtctg", crtctg);
		req.setAttribute("list", list);
		req.setAttribute("map", map);
		
		String fromlike = "board";
		req.setAttribute("fromlike", fromlike);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/crtboardlist.jsp");
		dispatcher.forward(req, resp);

	}

}