package com.project.jr.faq.admin;

import java.io.IOException;

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
 * FAQ 정보를 상세히 조회하는 서블릿 클래스입니다.
 */
@WebServlet("/faq/admin/faqadmindetail.do")
public class FAQAdminDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 조회할 FAQ의 일련번호를 파라미터에서 가져옵니다.
        String faqSeq = req.getParameter("Seq");

        // FAQ 관리 DAO 객체 생성
        FAQAdminDAO dao = new FAQAdminDAO();

        // 해당 FAQ의 상세 정보를 조회합니다.
        FAQDTO dto = dao.detail(faqSeq);

        // FAQ 작성일자에서 날짜 부분만 추출하여 설정합니다.
        String regdate = dto.getFaqWriteDate();
        dto.setFaqWriteDate(regdate.substring(0, 10));

        // 조회한 FAQ 정보를 request 속성에 설정합니다.
        req.setAttribute("dto", dto);

        // FAQ 상세 조회 페이지로 이동합니다.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/faq/admin/faqadmindetail.jsp");
        dispatcher.forward(req, resp);
    }
}
