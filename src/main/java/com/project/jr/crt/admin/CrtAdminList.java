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

import com.project.jr.crt.model.CrtDTO;
import com.project.jr.crt.repository.CrtAdminDAO;

/**
 * 서블릿 구현 클래스인 CrtAdminList
 *@author 이도훈
 * 이 서블릿은 관리자 인터페이스에서 (CRT) 목록을 표시하는 요청을 처리합니다.
 * 검색 조건 및 페이징 처리를 수행하여 적절한 데이터를 JSP 페이지로 전달합니다.
 */
@WebServlet("/crt/admin/crtadminlist.do")
public class CrtAdminList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * GET 요청을 처리하여 (CRT) 목록을 표시합니다.
     *
     * @param req  요청 매개변수를 포함하는 HttpServletRequest 객체
     * @param resp 응답을 전송하기 위한 HttpServletResponse 객체
     * @throws ServletException 서블릿에 오류가 있는 경우
     * @throws IOException I/O 작업에 오류가 있는 경우
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 검색 및 페이징을 위한 매개변수들을 추출합니다.
        String column = req.getParameter("column");
        String word = req.getParameter("word");
        String search = "n"; // 검색 중("y"), 목록 보기("n")
        String agency = req.getParameter("agency");
        String crtType = req.getParameter("crtType");

        // 검색 조건이 없거나 공백인 경우 목록 보기로 설정합니다.
        if ((column == null && word == null) || (column.equals("") && word.equals(""))) {
            search = "n";
        } else {
            search = "y";
        }

        String agencyColumn = "agency"; // 시행 기관 필드명
        String crtTypeColumn = "crtType"; // 자격증 분류 필드명

        HashMap<String, String> map = new HashMap<String, String>();

        map.put("column", column);
        map.put("word", word);
        map.put("search", search);
        map.put("agency", agency);
        map.put("crtType", crtType);

        // 페이징을 위한 변수들 초기화
        int nowPage = 0;
        int totalCount = 0; // 총 게시물 수
        int pageSize = 30;
        int totalPage = 0;
        int begin = 0;
        int end = 0;
        int n = 0;
        int loop = 0;
        int blockSize = 10;

        String page = req.getParameter("page");

        // 현재 페이지를 설정합니다.
        if (page == null || page.equals("")) {
            nowPage = 1;
        } else {
            nowPage = Integer.parseInt(page);
        }

        begin = ((nowPage - 1) * pageSize) + 1;
        end = begin + pageSize - 1;

        map.put("begin", begin + "");
        map.put("end", end + "");

        // CrtAdminDAO 인스턴스를 생성하여 목록을 가져옵니다.
        CrtAdminDAO dao = new CrtAdminDAO();
        ArrayList<CrtDTO> list = dao.list(map);

        // 총 게시물 수를 구합니다.
        totalCount = dao.getTotalCount();

        // 총 페이지 수를 계산합니다.
        totalPage = (int) Math.ceil((double) totalCount / pageSize);

        // 페이징을 위한 HTML 코드를 StringBuilder에 추가합니다.
        StringBuilder sb = new StringBuilder();
        loop = 1; // 루프 변수(10바퀴)
        n = ((nowPage - 1) / blockSize) * blockSize + 1;

        // 이전 10페이지
        if (n == 1) {
            sb.append(String.format("<a href='#!'>[이전%d] </a>", blockSize));
        } else {
            sb.append(String.format("<a href='/jr/crt/admin/crtadminlist.do?page=%d'>[이전%d] </a>", n - 1, blockSize));
        }

        // 페이지 번호를 생성합니다.
        while (!(loop > blockSize || n > totalPage)) {
            if (n == nowPage) {
                sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a>", n));
            } else {
                sb.append(String.format(" <a href='/jr/crt/admin/crtadminlist.do?page=%d'>%d</a>", n, n));
            }
            loop++;
            n++;
        }

        // 다음 10페이지
        if (n > totalPage) {
            sb.append(String.format("<a href='#!'> [다음%d]</a>", blockSize));
        } else {
            sb.append(String.format("<a href='/jr/crt/admin/crtadminlist.do?page=%d'> [다음%d]</a>", n, blockSize));
        }

        // JSP 페이지로 전달할 속성들을 설정합니다.
        req.setAttribute("list", list);
        req.setAttribute("map", map);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("nowPage", nowPage);
        req.setAttribute("pagebar", sb.toString());

        // JSP 페이지로 포워딩합니다.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crtadminlist.jsp");
        dispatcher.forward(req, resp);
    }
}
