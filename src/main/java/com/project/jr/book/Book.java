package com.project.jr.book;

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

import com.project.jr.book.model.BookDTO;
import com.project.jr.book.repository.BookDAO;

@WebServlet("/book/booklist.do")
public class Book extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	/*	String bookname = req.getParameter("bookname");
		String publisher = req.getParameter("publisher");
		String price = req.getParameter("price");
		String author = req.getParameter("author");
	*/	
	
	//검색
	String word = req.getParameter("word");
	String search = "n";  //검색중("y") 목록보기("n")
	
	if (( word == null) || (word.equals(""))) {
		search="n";
	} else {
		search="y";
	}
	
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("word", word);
	map.put("search", search);
		
		
	//페이징
	int nowPage =0;
	int totalCount = 0;
	int pageSize =10;
	int totalPage =0;
	int begin =0;
	int end =0;
	
	int blockSize=10;
	
	String page = req.getParameter("page");
	
	if(page==null || page.equals("")) {
		nowPage =1;
	}else {
		nowPage = Integer.parseInt(page);
	}
	
	begin =((nowPage -1)* pageSize)+1;
	end = begin + pageSize -1;
		
	
	map.put("begin", begin+ "");
	map.put("end", end+"");
	
	HttpSession session = req.getSession();
	
	session.setAttribute("read", "n");
	
	//목록조회	
	BookDAO dao = new BookDAO();
	
	ArrayList<BookDTO> list = dao.list(map);
	
	
	
	
	//총게시물 수 
	totalCount = dao.getTotalCount();
	totalPage =  (int)Math.ceil((double)totalCount / pageSize);
	
	
	//페이지 바 계산하기
	StringBuilder sb = new StringBuilder();
	
	//이전,다음 버튼
	int loop =1;
	int n = ((nowPage-1)/blockSize) * blockSize +1;
	
	//이전 
	if (n==1) {
		sb.append("<a href='#!'>[이전페이지]</a>");
	}else {
		sb.append(String.format("<a href='/jr/book/booklist.do?page=%d'>[이전페이지]</a>", n-1));
	}
	
	while(!(loop>blockSize || n>totalPage)) {
		if(n == nowPage) {
			sb.append(String.format("<a href='#!' style='color:tomato; font-weight:bold;'>%d</a> ",n));
		} else {
			sb.append(String.format("<a href='/jr/book/booklist.do?page=%d'>%d</a>", n,n));
		}
		loop++;
		n++;
	}
	
	//다음
	if(n>totalPage) {
		sb.append("<a href='#!'>[다음페이지]</a>");
	}else {
		sb.append(String.format("<a href='/jr/book/booklist.do?page=%d'>[다음페이지]</a>",n));
	}
	
	req.setAttribute("list", list);
	req.setAttribute("map", map);
	
	req.setAttribute("totalCount", totalCount);
	req.setAttribute("totalPage", totalPage);
	req.setAttribute("nowPage", nowPage);
	
	req.setAttribute("pagebar", sb.toString());
	
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/book/booklist.jsp");
		dispatcher.forward(req, resp);
	}


}
