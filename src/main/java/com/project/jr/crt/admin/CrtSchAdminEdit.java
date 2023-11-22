package com.project.jr.crt.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtSchAdminDTO;
import com.project.jr.crt.repository.CrtSchAdminDAO;

/**
 * 서블릿 구현 클래스인 CrtSchAdminEdit
 * @author 이도훈
 * 이 서블릿은 관리자 인터페이스에서 Certificate (CRT) 스케줄을 수정하는 요청을 처리합니다.
 */
@WebServlet("/crt/admin/crtschadminedit.do")
public class CrtSchAdminEdit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * GET 요청을 처리하여 Certificate (CRT) 스케줄 수정 페이지로 이동합니다.
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
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crtschadminedit.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하여 Certificate (CRT) 스케줄을 수정합니다.
     *
     * @param req  폼 데이터를 포함하는 HttpServletRequest 객체
     * @param resp 응답을 전송하기 위한 HttpServletResponse 객체
     * @throws ServletException 서블릿에 오류가 있는 경우
     * @throws IOException      I/O 작업에 오류가 있는 경우
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 폼 데이터를 추출합니다.
        String round = req.getParameter("round");
        String testRcStartDate = req.getParameter("testRcStartDate");
        String testRcEndDate = req.getParameter("testRcEndDate");
        String testStartDate = req.getParameter("testStartDate");
        String testEndDate = req.getParameter("testEndDate");
        String passDay = req.getParameter("passDay");
        String crtSchSeq = req.getParameter("crtSchSeq");

        // CrtSchAdminDAO 인스턴스를 생성합니다.
        CrtSchAdminDAO dao = new CrtSchAdminDAO();

        // CrtSchAdminDTO를 사용하여 CRT 스케줄을 수정합니다.
        CrtSchAdminDTO dto = new CrtSchAdminDTO();
        dto.setRound(round);
        dto.setTestRcStartDate(testRcStartDate);
        dto.setTestRcEndDate(testRcEndDate);
        dto.setTestStartDate(testStartDate);
        dto.setTestEndDate(testEndDate);
        dto.setPassDay(passDay);
        dto.setCrtSchSeq(Integer.parseInt(crtSchSeq));

        // 수정 결과를 확인합니다.
        int result = dao.edit(dto);

        if (result == 1) {
            // 수정 성공 시 세부 정보 페이지로 이동합니다.
            resp.sendRedirect("/jr/crt/admin/crtschadmindetail.do?crtSchSeq=" + crtSchSeq);
        } else {
            // 수정 실패 시 알림 메시지를 띄우고 이전 페이지로 돌아갑니다.
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('failed');history.back();</script>");
            writer.close();
        }
    }
}
