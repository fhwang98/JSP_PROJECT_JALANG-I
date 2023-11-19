package com.project.jr.crt;

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

import com.project.jr.crt.model.AgencyDTO;
import com.project.jr.crt.model.CrtDTO;
import com.project.jr.crt.model.CrtSchDdayDTO;
import com.project.jr.crt.repository.CrtDAO;
/**
 * 자격증 조회 클래스
 */
@WebServlet("/crt/crtlist.do")
public class CrtList extends HttpServlet {
	/**
	 * 자격증 조회 jsp 출력 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//CrtList.java
		
		//검색
		String word = req.getParameter("word");
		String crtctg = req.getParameter("crtctg");
		String agency = req.getParameter("agency");
		String difficulty = req.getParameter("difficulty");
				
		String search = "n";	//검색중("y"), 목록보기("n")
		
		System.out.printf("%s, %s, %s, %s", word, crtctg, agency, difficulty);
		if ((word == null && crtctg == null && agency == null && difficulty == null) 
				|| (word.equals("") && crtctg.equals("") && agency.equals("") && difficulty.equals(""))) {
			search = "n";
		} else {
			if (word.equals("") && crtctg.equals("default") && agency.equals("default") && difficulty.equals("default")) {
				search = "n";
			} else {
				search = "y";
			}
		}
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("word", word);
		map.put("crtctg", crtctg);
		map.put("agency", agency);
		map.put("difficulty", difficulty);
		map.put("search", search);
		
		//페이징
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수
		int pageSize = 10;		//한 페이지에서 출력할 게시물 수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//페이징 시작 위치
		int end = 0;			//페이지 끝 위치
		
		int blockSize = 10;
		
		String page = req.getParameter("page");
		
		if (page == null || page.equals("")) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		begin = ((nowPage -1) * pageSize) +1;
		end = begin + pageSize -1;
		
		map.put("begin", begin+ "");
		map.put("end", end+"");
		
		HttpSession session = req.getSession();
		
		session.setAttribute("read", "n");
		
		/* if (req.getSession().getAttribute("id") != null && ) */
		map.put("id",(String) req.getSession().getAttribute("id"));
		//목록 조회
		CrtDAO dao = new CrtDAO();
		
		
		ArrayList<CrtDTO> list = dao.list(map);
		ArrayList<AgencyDTO> agencyList = dao.agencylist();
		//ArrayList<CrtSchDdayDTO> schlist = dao.schddaylist();
		
		//총 게시물 수
		totalCount = dao.getTotalCount(map);
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		
		//페이지 바 계산하기
		StringBuilder sb = new StringBuilder();
		
		//이전, 다음 버튼
		int loop = 1;
		int n = ((nowPage-1) / blockSize) * blockSize + 1;
		
		//이전
		if (n==1) {
			sb.append(String.format("<a href='#!'>[이전 페이지]</a>"));
		} else {
			//sb.append(String.format("<a href='/jr/crt/crtlist.do?page=%d'>[이전페이지]</a>", n-1, blockSize));
			if (search.equals("n")) {
				sb.append(String.format("<a href='/jr/crt/crtlist.do?page=%d'>[이전페이지]</a>", n-1));
			} else {
				sb.append(String.format("<a href='/jr/crt/crtlist.do?word=%s&crtctg=%s&agency=%s&difficulty=%s&page=%d'>[이전페이지]</a>", word, crtctg, agency, difficulty, n-1));
			}
			
		}
		
		while(!(loop>blockSize || n>totalPage)) {
			if (n == nowPage) {
				sb.append(String.format(" <a href='#!' style='color:tomato; font-weight: bold;'>%d</a> ", n));
			} else {
				if (search.equals("n")) {
					sb.append(String.format("<a href='/jr/crt/crtlist.do?page=%d'>%d</a>", n, n));
				} else {
					sb.append(String.format("<a href='/jr/crt/crtlist.do?word=%s&crtctg=%s&agency=%s&difficulty=%s&page=%d'>%d</a>", word, crtctg, agency, difficulty, n, n));
				}
			}
			loop++;
			n++;
		}
		
		//다음
		if (n>totalPage) {
			sb.append(String.format("<a href='#!'>[다음 페이지]</a>"));
		} else {
			//sb.append(String.format(" <a href='/jr/crt/crtlist.do?page=%d'>[다음 페이지]</a>", n));		
			if (search.equals("n")) {
				sb.append(String.format("<a href='/jr/crt/crtlist.do?page=%d'>[다음페이지]</a>", n));
			} else {
				sb.append(String.format("<a href='/jr/crt/crtlist.do?word=%s&crtctg=%s&agency=%s&difficulty=%s&page=%d'>[다음페이지]</a>", word, crtctg, agency, difficulty, n));
			}
		}
		
		req.setAttribute("list", list);
		req.setAttribute("map", map);
		req.setAttribute("agencyList", agencyList);
		//req.setAttribute("schlist", schlist);
		
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);
		
		req.setAttribute("pagebar", sb.toString());
		
		String fromlike = "list";
		req.setAttribute("fromlike", fromlike);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/crtlist.jsp");
		dispatcher.forward(req, resp);

	}

}