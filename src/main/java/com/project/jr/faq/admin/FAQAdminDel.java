package com.project.jr.faq.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.faq.repository.FAQAdminDAO;

/**
 * @author 이도훈
 * FAQ 정보를 삭제하는 서블릿 클래스입니다.
 */
@WebServlet("/faq/admin/faqadmindel.do")
public class FAQAdminDel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 삭제할 FAQ의 일련번호를 파라미터에서 가져옵니다.
        String faqSeq = req.getParameter("Seq");

        // FAQ 일련번호를 request 속성에 설정합니다.
        req.setAttribute("faqSeq", faqSeq);

        // FAQ 삭제 페이지로 이동합니다.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/faq/admin/faqadmindel.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 한글 처리
        req.setCharacterEncoding("UTF-8");

        // 삭제할 FAQ의 일련번호를 파라미터에서 가져옵니다.
        String faqSeq = req.getParameter("faqSeq");

        // FAQ 관리 DAO 객체 생성
        FAQAdminDAO dao = new FAQAdminDAO();

        // FAQ 삭제 수행
        int result = dao.del(faqSeq);

        if (result == 1) {
            // 삭제 성공 시 FAQ 목록 페이지로 이동합니다.
            resp.sendRedirect("/jr/faq/admin/faqadminlist.do");
        } else {
            // 삭제 실패 시 경고창을 띄우고 이전 페이지로 돌아갑니다.
            System.out.println(faqSeq);
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('failed.');history.back();</script>");
            writer.close();
        }
    }
}
