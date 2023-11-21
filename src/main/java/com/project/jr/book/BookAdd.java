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

/**
 * 서블릿 클래스: BookAdd
 * 사용자가 선택한 도서를 스터디에 추가하는 기능을 담당하는 서블릿입니다.
 * @author 이슬아
 */
@WebServlet("/book/bookadd.do")
public class BookAdd extends HttpServlet {

    /**
     * HTTP POST 요청을 처리하는 메서드입니다.
     *
     * @param req  HttpServletRequest 객체
     * @param resp HttpServletResponse 객체
     * @throws ServletException 서블릿 예외
     * @throws IOException      IO 예외
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 사용자로부터 전달받은 파라미터
        String seq = req.getParameter("seq");
        String bookseq = req.getParameter("bookseq");

        // DAO 객체 생성
        BookDAO dao = new BookDAO();

        // 결과값 초기화
        int result = 0;

        // 선택한 도서의 목차 index 조회
        ArrayList<String> indexseq = dao.getbookindexlist(bookseq);

        // 결과값 출력
        System.out.println(indexseq);
        System.out.println(indexseq.size());

        // 각 목차 index를 스터디에 추가
        for (String index : indexseq) {
            System.out.println(result);
            result = dao.insertbook(seq, index);
            if (result != 1) {
                // 실패 시 경고창 출력 후 이전 페이지로 이동
                PrintWriter writer = resp.getWriter();
                writer.print("<script>alert('failed');history.back();</script>");
                writer.close();
                break;
            }
        }

        // 결과값 전송
        PrintWriter writer = resp.getWriter();
        writer.write(result);
        writer.close();
    }
}