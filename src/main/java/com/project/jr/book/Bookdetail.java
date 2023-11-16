package com.project.jr.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.academy.model.AcademyDTO;
import com.project.jr.book.model.BookDTO;
import com.project.jr.book.repository.BookDAO;

@WebServlet("/book/bookdetail.do")
public class Bookdetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");
		
		BookDAO dao = new BookDAO();
		
		BookDTO dto = dao.bookinfo(seq);
		
		req.setAttribute("dto", dto);
		
		ArrayList<BookDTO> list = dao.booklist(seq);
		
		
		
		req.setAttribute("list", list);
		
		for (BookDTO a : list) {
		    // ... (생략)

		    int lv = dto.getLv();
		    StringBuilder lvS = new StringBuilder();
		    for (int i = 1; i <= lv; i++) {
		    	lvS.append("★");
		    }
		    dto.setLvS(lvS.toString());
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/book/bookdetail.jsp");
		dispatcher.forward(req, resp);
		
		
		
		
		
		
		
	}
	
	
	

	

}


