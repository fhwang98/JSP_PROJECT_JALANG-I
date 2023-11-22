package com.project.jr.crt.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.repository.CrtTestDAO;

/**
 * 서블릿 구현 클래스인 CrtTestAdminDel
 * @author 이도훈
 * 이 서블릿은 관리자 인터페이스에서 Certificate (CRT) 시험 정보를 삭제하는 요청을 처리합니다.
 */
@WebServlet("/crt/admin/crttestadmindel.do")
public class CrtTestAdminDel extends HttpServlet {

    /**
     * GET 요청을 처리하여 (CRT) 시험 정보 삭제 페이지로 이동합니다.
     *
     * @param req  요청 매개변수를 포함하는 HttpServletRequest 객체
     * @param resp 응답을 전송하기 위한 HttpServletResponse 객체
     * @throws ServletException 서블릿에 오류가 있는 경우
     * @throws IOException      I/O 작업에 오류가 있는 경우
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청 파라미터에서 삭제할 CRT 시험 정보의 일련번호를 가져옵니다.
        String crttestSeq = req.getParameter("crttestSeq");
        
        // 요청에 CRT 시험 일련번호를 속성으로 추가합니다.
        req.setAttribute("crttestSeq", crttestSeq);
        
        // (CRT) 시험 정보 삭제 페이지로 이동합니다.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crttestadmindel.jsp");
        dispatcher.forward(req, resp);
    }
    
    /**
     * POST 요청을 처리하여 (CRT) 시험 정보를 삭제합니다.
     *
     * @param req  요청 매개변수를 포함하는 HttpServletRequest 객체
     * @param resp 응답을 전송하기 위한 HttpServletResponse 객체
     * @throws ServletException 서블릿에 오류가 있는 경우
     * @throws IOException      I/O 작업에 오류가 있는 경우
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청 파라미터의 문자 인코딩을 UTF-8로 설정합니다.
        req.setCharacterEncoding("UTF-8");
        
        // 요청 파라미터에서 삭제할 CRT 시험 정보의 일련번호를 가져옵니다.
        String crttestSeq = req.getParameter("crttestSeq");
        
        // CrtTestDAO 인스턴스를 생성합니다.
        CrtTestDAO dao = new CrtTestDAO();
        
        // CRT 시험 정보를 삭제하고 결과를 확인합니다.
        int result = dao.del(crttestSeq);
        
        // 결과에 따라 리다이렉트 또는 실패 알림을 처리합니다.
        if (result == 1) {
            // 삭제 성공 시, 시험 목록 페이지로 리다이렉트합니다.
            resp.sendRedirect("/jr/crt/admin/crttestadminlist.do");
        } else {
            // 삭제 실패 시, 알림창을 띄우고 이전 페이지로 이동합니다.
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('failed.');history.back();</script>");
            writer.close();
        }
    }
}
