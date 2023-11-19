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

import com.project.jr.crt.model.CrtAcademyDTO;
import com.project.jr.crt.model.CrtSchDTO;
import com.project.jr.crt.repository.CrtSchDAO;
/**
 * 자격증 시험 일정 조회 클래스
 */
@WebServlet("/crt/crtschlist.do")
public class CrtSchList extends HttpServlet {
	/**
	 * 자격증 시험 일정 조회 jsp 출력 doGet
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//CrtSchList.java
		
		String word = req.getParameter("word");
		String daterange = req.getParameter("daterange");
		String hiddenRcStartDate = req.getParameter("hiddenRcStartDate");
		String hiddenRcEndDate = req.getParameter("hiddenRcEndDate");
		String hiddenStartDate = req.getParameter("hiddenStartDate");
		String hiddenEndDate = req.getParameter("hiddenEndDate");
		
		System.out.println("CrtSchList: " + daterange + " hiddenEndDate:" + hiddenStartDate + " hiddenEndDate: " + hiddenEndDate);
		
		
		String search = "n";	//검색중("y"), 목록보기("n")
		/*
		System.out.printf("%s, %s, %s,%s, %s\n", word, testrcstartdate, testrcenddate, teststartdate, testenddate);
		if ((word == null && testrcstartdate == null && testrcenddate == null && teststartdate == null && testenddate == null) 
				|| (word.equals("") && testrcstartdate.equals("") && testrcenddate.equals("") && teststartdate.equals("") && testenddate.equals(""))) {
			search = "n";
		} else {
			search = "y";
		}
		*/
		
		if ((word==null && hiddenRcStartDate==null && hiddenRcEndDate==null && hiddenStartDate==null && hiddenEndDate==null) 
				|| word.equals("") && hiddenRcStartDate.equals("") && hiddenRcEndDate.equals("") && hiddenStartDate.equals("") && hiddenEndDate.equals("")) {
			search = "n";
			
		} else {
			search = "y";
		}
		System.out.println("CrtSchList: search " + search);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("word", word);
		map.put("search", search);
		map.put("hiddenRcStartDate", hiddenRcStartDate);
		map.put("hiddenRcEndDate", hiddenRcEndDate);
		map.put("hiddenStartDate", hiddenStartDate);
		map.put("hiddenEndDate", hiddenEndDate);
		
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
		
		
		CrtSchDAO dao = new CrtSchDAO();
		
		ArrayList<CrtSchDTO> list = dao.list(map);
		 
		// 총 게시물 수
		totalCount = dao.getTotalCount(map);
		totalPage = (int) Math.ceil((double) totalCount / pageSize);
		
		//페이지 바 계산하기
		StringBuilder sb = new StringBuilder();

		// 이전, 다음 버튼
		int loop = 1;
		int n = ((nowPage - 1) / blockSize) * blockSize + 1;

		// 이전
		if (n == 1) {
			sb.append(String.format("<a href='#!'>[이전 페이지]</a>"));
		} else {
			if (search.equals("n")) {
				sb.append(String.format("<a href='/jr/crt/crtschlist.do?page=%d'>[이전페이지]</a>", n - 1));
			} else {
				
				sb.append(String.format(
						"<a href='/jr/crt/crtschlist.do?word=%s&hiddenRcStartDate=%s&hiddenRcEndDate=%s&hiddenStartDate=%s&hiddenEndDate=%s&page=%d'>[이전페이지]</a>",
						word, hiddenRcStartDate, hiddenRcEndDate, hiddenStartDate, hiddenEndDate, n - 1));
				
			}
//sb.append(String.format("<a href='/jr/crt/crtlist.do?word=%s&crtctg=%s&agency=%s&difficulty=%s&page=%d'>[이전페이지]</a>", word, crtctg, agency, difficulty, n-1));
		}

		while(!(loop>blockSize || n>totalPage)) {
			if (n == nowPage) {
				sb.append(String.format(" <a href='#!' style='color:tomato; font-weight: bold;'>%d</a> ", n));
			} else {
				if (search.equals("n")) {
					sb.append(String.format("<a href='/jr/crt/crtschlist.do?page=%d'>%d</a>", n, n));
				} else {
					sb.append(String.format(
							"<a href='/jr/crt/crtschlist.do?word=%s&hiddenRcStartDate=%s&hiddenRcEndDate=%s&hiddenStartDate=%s&hiddenEndDate=%s&page=%d'>%d</a>",
							word, hiddenRcStartDate, hiddenRcEndDate, hiddenStartDate, hiddenEndDate, n, n));
					
					//sb.append(String.format("<a href='/jr/crt/crtlist.do?word=%s&crtctg=%s&agency=%s&difficulty=%s&page=%d'>%d</a>", word, crtctg, agency, difficulty, n, n));
				}
			}
			loop++;
			n++;
		}

		//다음
		if (n>totalPage) {
			sb.append(String.format("<a href='#!'>[다음 페이지]</a>"));
		} else {
			if (search.equals("n")) {
				sb.append(String.format("<a href='/jr/crt/crtschlist.do?page=%d'>[다음페이지]</a>", n));
			} else {
				sb.append(String.format(
						"<a href='/jr/crt/crtschlist.do?word=%s&hiddenRcStartDate=%s&hiddenRcEndDate=%s&hiddenStartDate=%s&hiddenEndDate=%s&page=%d'>[다음페이지]</a>",
						word, hiddenRcStartDate, hiddenRcEndDate, hiddenStartDate, hiddenEndDate, n));
				
				//sb.append(String.format("<a href='/jr/crt/crtlist.do?word=%s&crtctg=%s&agency=%s&difficulty=%s&page=%d'>[다음페이지]</a>", word, crtctg, agency, difficulty, n));
			}
		}
		
		//데이터 가공
		//날짜
		for (CrtSchDTO dto : list) {
			String TestRcStartDate = dto.getTestRcStartDate();
			String TestRcEndDate = dto.getTestRcEndDate();
			String TestStartDate = dto.getTestStartDate();
			String TestEndDate = dto.getTestEndDate();

			dto.setTestRcStartDate(TestRcStartDate.substring(0, 10));
			dto.setTestRcEndDate(TestRcEndDate.substring(0, 10));
			dto.setTestStartDate(TestStartDate.substring(0, 10));
			dto.setTestEndDate(TestEndDate.substring(0, 10));
		}
		
		
		
		
		req.setAttribute("list", list);
		req.setAttribute("map", map);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);
		
		req.setAttribute("pagebar", sb.toString());

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/crtschlist.jsp");
		dispatcher.forward(req, resp);

	}

}