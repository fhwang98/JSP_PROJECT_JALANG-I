package com.project.jr.crt.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.jr.crt.model.CrtTestDTO;
import com.project.jr.crt.repository.CrtTestDAO;

/**
 * 서블릿 구현 클래스인 CrtTestAdminDetail
 * @author 이도훈
 * 이 서블릿은 관리자 인터페이스에서 (CRT) 시험 정보의 상세 내용을 조회하는 요청을 처리합니다.
 */
@WebServlet("/crt/admin/crttestadmindetail.do")
public class CrtTestAdminDetail extends HttpServlet {

    /**
     * GET 요청을 처리하여 (CRT) 시험 정보 상세 내용 페이지로 이동합니다.
     *
     * @param req  요청 매개변수를 포함하는 HttpServletRequest 객체
     * @param resp 응답을 전송하기 위한 HttpServletResponse 객체
     * @throws ServletException 서블릿에 오류가 있는 경우
     * @throws IOException      I/O 작업에 오류가 있는 경우
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 현재 세션을 가져옵니다.
        HttpSession session = req.getSession();

        // 요청 파라미터에서 (CRT) 시험 정보의 일련번호를 가져옵니다.
        String crtSeq = req.getParameter("crtSeq");

        // CrtTestDAO 인스턴스를 생성합니다.
        CrtTestDAO dao = new CrtTestDAO();

        // Certificate (CRT) 시험 정보의 상세 내용을 조회합니다.
        CrtTestDTO dto = dao.detail(crtSeq);

        // 조회된 정보를 요청 속성으로 추가합니다.
        req.setAttribute("dto", dto);

        // Certificate (CRT) 시험 정보 상세 내용 페이지로 이동합니다.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crttestadmindetail.jsp");
        dispatcher.forward(req, resp);
    }
}
