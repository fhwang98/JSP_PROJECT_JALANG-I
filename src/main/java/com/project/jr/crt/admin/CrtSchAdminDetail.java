package com.project.jr.crt.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtSchAdminDTO;
import com.project.jr.crt.repository.CrtSchAdminDAO;

/**
 * 서블릿 구현 클래스인 CrtSchAdminDetail
 * @author 이도훈
 * 이 서블릿은 관리자 인터페이스에서 (CRT) 스케줄 세부 정보를 표시하는 요청을 처리합니다.
 */
@WebServlet("/crt/admin/crtschadmindetail.do")
public class CrtSchAdminDetail extends HttpServlet {
    

    /**
     * GET 요청을 처리하여 (CRT) 스케줄 세부 정보를 표시합니다.
     *
     * @param req  요청 매개변수를 포함하는 HttpServletRequest 객체
     * @param resp 응답을 전송하기 위한 HttpServletResponse 객체
     * @throws ServletException 서블릿에 오류가 있는 경우
     * @throws IOException      I/O 작업에 오류가 있는 경우
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청에서 CRT 스케줄 시퀀스 매개변수를 추출합니다.
        String crtSchSeq = req.getParameter("crtSchSeq");

        // CrtSchAdminDAO 인스턴스를 생성합니다.
        CrtSchAdminDAO dao = new CrtSchAdminDAO();

        // CrtSchAdminDTO를 사용하여 CRT 스케줄 세부 정보를 검색합니다.
        CrtSchAdminDTO dto = dao.detail(crtSchSeq);

        // 날짜 정보를 자르기 위해 처리합니다.
        String testRcStartDate = dto.getTestRcStartDate();
        dto.setTestRcStartDate(testRcStartDate.substring(0, 10));

        String testRcEndDate = dto.getTestRcEndDate();
        dto.setTestRcEndDate(testRcEndDate.substring(0, 10));

        String testStartDate = dto.getTestStartDate();
        dto.setTestStartDate(testStartDate.substring(0, 10));

        String testEndDate = dto.getTestEndDate();
        dto.setTestEndDate(testEndDate.substring(0, 10));

        String passday = dto.getPassDay();
        dto.setPassDay(passday.substring(0, 10));

        // 세부 정보를 요청 속성으로 설정합니다.
        req.setAttribute("dto", dto);

        // JSP 페이지로 포워딩합니다.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crtschadmindetail.jsp");
        dispatcher.forward(req, resp);
    }
}
