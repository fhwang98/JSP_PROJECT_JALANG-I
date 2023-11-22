package com.project.jr.crt.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.jr.crt.model.CrtTestDTO;
import com.project.jr.crt.repository.CrtTestDAO;

/**
 * 서블릿 구현 클래스인 CrtTestAdminList
 * @author 이도훈
 * 이 서블릿은 관리자 인터페이스에서 (CRT) 시험 목록을 조회하는 요청을 처리합니다.
 */
@WebServlet("/crt/admin/crttestadminlist.do")
public class CrtTestAdminList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * GET 요청을 처리하여 (CRT) 시험 목록 페이지로 이동합니다.
     *
     * @param req  요청 매개변수를 포함하는 HttpServletRequest 객체
     * @param resp 응답을 전송하기 위한 HttpServletResponse 객체
     * @throws ServletException 서블릿에 오류가 있는 경우
     * @throws IOException      I/O 작업에 오류가 있는 경우
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // HashMap을 사용하여 필요한 매개변수를 설정합니다.
        HashMap<String, String> map = new HashMap<>();

        // 페이징 관련 변수를 초기화합니다.
        int nowPage = 0;
        int totalCount = 0; // 총 게시물 수
        int pageSize = 30;
        int totalPage = 0;
        int begin = 0;
        int end = 0;
        int n = 0;
        int loop = 0;
        int blockSize = 10;

        // 페이지 번호를 가져옵니다.
        String page = req.getParameter("page");

        if (page == null || page.equals("")) {
            nowPage = 1;
        } else {
            nowPage = Integer.parseInt(page);
        }

        begin = ((nowPage - 1) * pageSize) + 1;
        end = begin + pageSize - 1;

        map.put("begin", begin + "");
        map.put("end", end + "");

        // CrtTestDAO 인스턴스를 생성합니다.
        CrtTestDAO dao = new CrtTestDAO();

        // CRT 시험 목록을 조회합니다.
        ArrayList<CrtTestDTO> list = dao.list(map);

        // 총 게시물 수를 조회합니다.
        totalCount = dao.getTotalCount();

        // 총 페이지 수를 계산합니다.
        totalPage = (int) Math.ceil((double) totalCount / pageSize);

        // 페이지 바를 생성합니다.
        StringBuilder sb = new StringBuilder();
        loop = 1; // 루프 변수(10바퀴)
        n = ((nowPage - 1) / blockSize) * blockSize + 1;

        if (n == 1) {
            sb.append(String.format("<a href='#!'>[이전] </a>", blockSize));
        } else {
            sb.append(String.format("<a href='/jr/crt/admin/crttestadminlist.do?page=%d'>[이전] </a>", n - 1, blockSize));
        }

        while (!(loop > blockSize || n > totalPage)) {
            if (n == nowPage) {
                sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a>", n));
            } else {
                sb.append(String.format(" <a href='/jr/crt/admin/crttestadminlist.do?page=%d'>%d</a>", n, n));
            }
            loop++;
            n++;
        }

        if (n > totalPage) {
            sb.append(String.format("<a href='#!'> [다음]</a>", blockSize));
        } else {
            sb.append(String.format("<a href='/jr/crt/admin/crttestadminlist.do?page=%d'> [다음]</a>", n, blockSize));
        }

        // 결과를 request 속성에 설정합니다.
        req.setAttribute("list", list);
        req.setAttribute("map", map);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("nowPage", nowPage);
        req.setAttribute("pagebar", sb.toString());

        // JSP 페이지로 포워딩합니다.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crttestadminlist.jsp");
        dispatcher.forward(req, resp);
    }
}
