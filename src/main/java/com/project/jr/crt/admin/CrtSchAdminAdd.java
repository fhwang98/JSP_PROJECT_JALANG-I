package com.project.jr.crt.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.crt.repository.CrtSchAdminDAO;

/**
 * 서블릿 구현 클래스인 CrtSchAdminAdd
 * @author 이도훈
 * 이 서블릿은 관리자 인터페이스에서 Certificate (CRT) 스케줄 추가 페이지로 이동하는 요청을 처리합니다.
 */
@WebServlet("/crt/admin/crtschadminadd.do")
public class CrtSchAdminAdd extends HttpServlet {
    

    /**
     * GET 요청을 처리하여 Certificate (CRT) 스케줄 추가 페이지로 이동합니다.
     *
     * @param req  요청 매개변수를 포함하는 HttpServletRequest 객체
     * @param resp 응답을 전송하기 위한 HttpServletResponse 객체
     * @throws ServletException 서블릿에 오류가 있는 경우
     * @throws IOException      I/O 작업에 오류가 있는 경우
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crtschadminadd.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하여 Certificate (CRT) 스케줄을 추가합니다.
     *
     * @param req  폼 데이터를 포함하는 HttpServletRequest 객체
     * @param resp 응답을 전송하기 위한 HttpServletResponse 객체
     * @throws ServletException 서블릿에 오류가 있는 경우
     * @throws IOException      I/O 작업에 오류가 있는 경우
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        // 세션 객체를 가져옵니다.
        HttpSession session = req.getSession();

        // CrtSchAdminDAO 인스턴스를 생성합니다.
        CrtSchAdminDAO dao = new CrtSchAdminDAO();

        // TODO: 폼 데이터 처리 및 CRT 스케줄 추가 로직을 구현하세요.
        // 예시: String crtName = req.getParameter("crtName");
        //       int agencySeq = Integer.parseInt(req.getParameter("agencySeq"));
        //       String scheduleDate = req.getParameter("scheduleDate");
        //       ... (폼 데이터 처리)

        // TODO: DAO를 사용하여 CRT 스케줄을 추가합니다.
        // 예시: int result = dao.addCrtSchedule(crtName, agencySeq, scheduleDate, ...);

        // TODO: 결과에 따라 적절한 처리를 수행합니다.
        // 예시: if (result == 1) {
        //          // 추가 성공 시
        //          resp.sendRedirect("/jr/crt/admin/crtschadmindetail.do?scheduleSeq=" + scheduleSeq);
        //      } else {
        //          // 추가 실패 시
        //          resp.sendRedirect("/jr/crt/admin/crtschadminadd.do");
        //      }
    }
}
