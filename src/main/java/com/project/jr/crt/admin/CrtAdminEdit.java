package com.project.jr.crt.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtDTO;
import com.project.jr.crt.repository.CrtAdminDAO;

/**
 * 서블릿 구현 클래스인 CrtAdminEdit
 *
 * 이 서블릿은 관리자 인터페이스에서 Certificate (CRT) 세부 정보를 편집하는 요청을 처리합니다.
 * 기존 CRT 세부 정보를 검색하여 편집하고 CRT 정보를 업데이트하기 위해 제출된 폼 데이터를 처리합니다.
 */
@WebServlet("/crt/admin/crtadminedit.do")
public class CrtAdminEdit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * GET 요청을 처리하여 관리자 인터페이스에서 (CRT) 세부 정보를 편집하는 폼을 표시합니다.
     * @author 이도훈
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청에서 CRT 시퀀스 매개변수를 검색합니다.
        String crtSeq = req.getParameter("crtSeq");

        // 데이터베이스와 상호 작용하기 위해 CrtAdminDAO의 인스턴스를 생성합니다.
        CrtAdminDAO dao = new CrtAdminDAO();

        // 편집을 위해 기존 CRT 세부 정보를 검색합니다.
        CrtDTO dto = dao.detail(crtSeq);

        // JSP 페이지에서 사용할 수 있도록 기존 CRT 세부 정보를 요청 속성으로 설정합니다.
        req.setAttribute("dto", dto);

        // 요청을 CRT 관리자 편집 JSP 페이지로 전달합니다.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crtadminedit.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * POST 요청을 처리하여 관리자 인터페이스에서 (CRT) 세부 정보를 업데이트하는 폼 제출을 처리합니다.
     * 
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 폼 데이터의 문자 인코딩을 설정합니다.
        req.setCharacterEncoding("UTF-8");

        // CRT 세부 정보 업데이트를 위한 폼 데이터를 검색합니다.
        String crtName = req.getParameter("crtName");
        String crtTypeSeq = req.getParameter("crtTypeSeq");
        String expiration = req.getParameter("expiration");
        String agencySeq = req.getParameter("agencySeq");
        String isRoutine = req.getParameter("isRoutine");
        String difficulty = req.getParameter("difficulty");
        String likeCnt = req.getParameter("likeCnt");
        String qualificationCate = req.getParameter("qualificationCate");
        String qualification = req.getParameter("qualification");
        String crtInfo = req.getParameter("crtInfo");
        String totalCnt = req.getParameter("totalCnt");
        String jobDesc = req.getParameter("jobDesc");
        String crtSeq = req.getParameter("crtSeq");

        // 데이터베이스와 상호 작용하기 위해 CrtAdminDAO의 인스턴스를 생성합니다.
        CrtAdminDAO dao = new CrtAdminDAO();

        // 업데이트된 CRT 세부 정보를 가진 CrtDTO 객체를 생성합니다.
        CrtDTO dto = new CrtDTO();
        dto.setCrtSeq(Integer.parseInt(crtSeq));
        dto.setCrtName(crtName);
        dto.setCrtTypeSeq(Integer.parseInt(crtTypeSeq));
        dto.setExpiration(expiration);
        dto.setAgencySeq(Integer.parseInt(agencySeq));
        dto.setIsRoutine(Integer.parseInt(isRoutine));
        dto.setDifficulty(Integer.parseInt(difficulty));
        dto.setLikeCnt(Integer.parseInt(likeCnt));
        dto.setQualificationCate(qualificationCate);
        dto.setQualification(qualification);
        dto.setCrtInfo(crtInfo);
        dto.setTotalCnt(Integer.parseInt(totalCnt));
        dto.setJobDesc(jobDesc);

        // CRT 세부 정보를 업데이트하고 결과를 확인합니다.
        int result = dao.edit(dto);

        // 결과에 따라 적절한 처리를 수행합니다.
        if (result == 1) {
            // 업데이트가 성공하면 해당 CRT 세부 정보를 보여주는 페이지로 이동합니다.
            resp.sendRedirect("/jr/crt/admin/crtadmindetail.do?crtSeq=" + crtSeq);
        } else {
            // 업데이트가 실패하면 경고창을 띄우고 이전 페이지로 이동합니다.
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('failed');history.back();</script>");
            writer.close();
        }
    }
}
