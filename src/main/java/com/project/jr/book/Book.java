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

/**
 * 서블릿 클래스: Book
 * 도서 목록을 조회하고 페이징 처리하는 서블릿입니다.
 * @author 이슬아
 */
@WebServlet("/book/booklist.do")
public class Book extends HttpServlet {

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

        // 세션에 seq 속성 추가
        HttpSession session = req.getSession();
        session.setAttribute("seq", "RvXc3eY");

        // 검색 관련 파라미터 설정
        String word = req.getParameter("word");
        String search = "n";  // 검색 중("y")인지 목록 보기("n")인지 구분

        if ((word == null) || (word.equals(""))) {
            search = "n";
        } else {
            search = "y";
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("word", word);
        map.put("search", search);

        // 페이징 관련 파라미터 설정
        int nowPage = 0;
        int totalCount = 0;
        int pageSize = 10;
        int totalPage = 0;
        int begin = 0;
        int end = 0;
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

        session.setAttribute("read", "n");

        // 도서 목록 조회
        BookDAO dao = new BookDAO();
        ArrayList<BookDTO> list = dao.list(map);

        // 총 게시물 수
        totalCount = dao.getTotalCount();
        totalPage = (int) Math.ceil((double) totalCount / pageSize);

        // 페이지 바 계산
        StringBuilder sb = new StringBuilder();

        int loop = 1;
        int n = ((nowPage - 1) / blockSize) * blockSize + 1;

        // 이전 페이지
        if (n == 1) {
            sb.append("<a href='#!'>[이전페이지]</a>");
        } else {
            sb.append(String.format("<a href='/jr/book/booklist.do?page=%d'>[이전페이지]</a>", n - 1));
        }

        // 페이지 번호
        while (!(loop > blockSize || n > totalPage)) {
            if (n == nowPage) {
                sb.append(String.format("<a href='#!' style='color:tomato; font-weight:bold;'>%d</a> ", n));
            } else {
                sb.append(String.format("<a href='/jr/book/booklist.do?page=%d'>%d</a>", n, n));
            }
            loop++;
            n++;
        }

        // 다음 페이지
        if (n > totalPage) {
            sb.append("<a href='#!'>[다음페이지]</a>");
        } else {
            sb.append(String.format("<a href='/jr/book/booklist.do?page=%d'>[다음페이지]</a>", n));
        }

        // 요청 속성 설정
        req.setAttribute("list", list);
        req.setAttribute("map", map);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("nowPage", nowPage);
        req.setAttribute("pagebar", sb.toString());

        // JSP로 포워딩
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/book/booklist.jsp");
        dispatcher.forward(req, resp);
    }
}


