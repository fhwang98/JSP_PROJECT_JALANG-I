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

/**
 * 서블릿 클래스: BookLike
 * 도서에 대한 좋아요 수를 증가시키는 서블릿입니다.
 * @author 이슬아
 */
@WebServlet("/book/booklike.do")
public class BookLike extends HttpServlet {

    /**
     * HTTP GET 요청을 처리하는 메서드입니다.
     *
     * @param req  HttpServletRequest 객체
     * @param resp HttpServletResponse 객체
     * @throws ServletException 서블릿 예외
     * @throws IOException      IO 예외
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 사용자로부터 전달받은 도서 시퀀스
        String seq = req.getParameter("seq");

        // DAO 객체 생성
        BookDAO dao = new BookDAO();

        // 도서의 좋아요 수 업데이트
        int result = dao.updateLike(seq);

        // 결과에 따라 응답 처리
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






