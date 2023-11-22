package com.project.jr.faq.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.faq.model.FAQDTO;
import com.project.jr.faq.repository.FAQAdminDAO;

/**
 * @author 이도훈
 * FAQ 정보를 수정하는 서블릿 클래스입니다.
 */
@WebServlet("/faq/admin/faqadminedit.do")
public class FAQAdminedit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 수정할 FAQ의 일련번호를 파라미터에서 가져옵니다.
        String faqSeq = req.getParameter("Seq");

        // FAQ 관리 DAO 객체 생성
        FAQAdminDAO dao = new FAQAdminDAO();

        // 해당 FAQ의 상세 정보를 조회합니다.
        FAQDTO dto = dao.detail(faqSeq);

        // 조회한 FAQ 정보를 request 속성에 설정합니다.
        req.setAttribute("dto", dto);

        // FAQ 수정 페이지로 이동합니다.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/faq/admin/faqadminedit.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 요청된 데이터의 문자 인코딩을 UTF-8로 설정합니다.
        req.setCharacterEncoding("UTF-8");

        // 수정할 FAQ의 일련번호, 제목, 내용을 파라미터에서 가져옵니다.
        String faqSeq = req.getParameter("faqSeq");
        String faqTitle = req.getParameter("faqtitle");
        String faqContent = req.getParameter("faqContent");

        // FAQ 관리 DAO 객체 생성
        FAQAdminDAO dao = new FAQAdminDAO();

        // 수정할 FAQ 정보를 DTO에 설정합니다.
        FAQDTO dto = new FAQDTO();
        dto.setFaqSeq(faqSeq);
        dto.setFaqTitle(faqTitle);
        dto.setFaqContent(faqContent);

        // FAQ 정보를 수정합니다.
        int result = dao.edit(dto);

        if (result == 1) {
            // 수정이 성공하면 수정된 FAQ의 상세 페이지로 이동합니다.
            resp.sendRedirect("/jr/faq/admin/faqadmindetail.do?Seq=" + faqSeq);
        } else {
            // 수정이 실패하면 경고창을 띄우고 이전 페이지로 돌아갑니다.
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('failed');history.back();</script>");
            writer.close();
        }
    }
}
