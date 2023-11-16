package com.project.jr.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.book.repository.BookDAO;

@WebServlet("/book/booklike.do")
public class BookLike extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");
		
		BookDAO dao = new BookDAO();
		
		int result = dao.updateLike(seq);
		
		if (result == 1) {
			PrintWriter writer = resp.getWriter();
			writer.write(result);
			writer.close();
		} else {
			PrintWriter writer = resp.getWriter();
			writer.print("<script>alert('failed');history.back();</script>");
			writer.close();
			
		}
	}

}
