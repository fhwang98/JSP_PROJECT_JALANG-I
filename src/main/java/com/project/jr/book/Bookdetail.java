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

/**
 * 서블릿 클래스: Bookdetail
 * 특정 도서의 상세 정보를 조회하고 해당 도서의 목차를 제공하는 서블릿입니다.
 * @author 이슬아
 */
@WebServlet("/book/bookdetail.do")
public class Bookdetail extends HttpServlet {

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

        // 도서 상세 정보 조회
        BookDTO dto = dao.bookinfo(seq);

        // 도서 목차 조회
        ArrayList<BookDTO> list = dao.booklist(seq);

        // 도서 목차의 난이도를 별표로 변환하여 설정
        for (BookDTO a : list) {
            int lv = dto.getLv();
            StringBuilder lvS = new StringBuilder();
            for (int i = 1; i <= lv; i++) {
                lvS.append("★");
            }
            dto.setLvS(lvS.toString());
        }

        // 요청 객체에 속성 설정
        req.setAttribute("dto", dto);
        req.setAttribute("list", list);

        // JSP로 포워딩
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/book/bookdetail.jsp");
        dispatcher.forward(req, resp);
    }
}