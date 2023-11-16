package com.project.jr.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.book.repository.BookDAO;

@WebServlet("/book/bookadd.do")
public class BookAdd extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String seq = req.getParameter("seq");
		String bookseq = req.getParameter("bookseq");
		
		System.out.println("seq: " + seq);
		System.out.println("bookseq: " + bookseq);
		BookDAO dao = new BookDAO();
		
		int result = 0;
		
		ArrayList<String> indexseq = dao.getbookindexlist(bookseq);
		
		System.out.println(indexseq);
		System.out.println(indexseq.size());
		
		for (String index : indexseq) {
			System.out.println(result);
			result = dao.insertbook(seq, index);
			if (result != 1) {
				PrintWriter writer = resp.getWriter();
				writer.print("<script>alert('failed');history.back();</script>");
				writer.close();
				break;
			}
		}
		PrintWriter writer = resp.getWriter();
		writer.write(result);
		writer.close();
		

	}
	

}