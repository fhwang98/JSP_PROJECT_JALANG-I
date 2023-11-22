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

import com.project.jr.crt.model.CrtSchAdminDTO;
import com.project.jr.crt.repository.CrtSchAdminDAO;

/**
 * 서블릿 구현 클래스인 CrtSchAdminList
 * @author 이도훈
 * 이 서블릿은 관리자 인터페이스에서 Certificate (CRT) 스케줄 목록을 표시하는 요청을 처리합니다.
 */
@WebServlet("/crt/admin/crtschadminlist.do")
public class CrtSchAdminList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * GET 요청을 처리하여 Certificate (CRT) 스케줄 목록을 표시합니다.
     *
     * @param req  요청 매개변수를 포함하는 HttpServletRequest 객체
     * @param resp 응답을 전송하기 위한 HttpServletResponse 객체
     * @throws ServletException 서블릿에 오류가 있는 경우
     * @throws IOException      I/O 작업에 오류가 있는 경우
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청에서 검색 조건과 키워드를 추출합니다.
        String column = req.getParameter("column");
        String word = req.getParameter("word");
        String search = "n"; // 검색중("y"), 목록보기("n")
        String agency = req.getParameter("agency");
        String crtType = req.getParameter("crtType");

        // 검색 조건이 없거나 키워드가 없으면 목록보기 모드로 설정합니다.
        if ((column == null && word == null) || (column.equals("") && word.equals(""))) {
            search = "n";
        } else {
            search = "y";
        }

        // 검색 조건과 키워드, 검색 모드를 Map에 저장합니다.
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("column", column);
        map.put("word", word);
        map.put("search", search);
        map.put("agency", agency);
        map.put("crtType", crtType);

        // 페이징을 위한 변수들을 초기화합니다.
        int nowPage = 0;
        int totalCount = 0; // 총 게시물 수
        int pageSize = 30;
        int totalPage = 0;
        int begin = 0;
        int end = 0;
        int n = 0;
        int loop = 0;
        int blockSize = 10;

        // 현재 페이지 정보를 추출합니다.
        String page = req.getParameter("page");

        if (page == null || page.equals("")) {
            nowPage = 1;
        } else {
            nowPage = Integer.parseInt(page);
        }

        // 페이지에 따른 시작과 끝 번호를 계산합니다.
        begin = ((nowPage - 1) * pageSize) + 1;
        end = begin + pageSize - 1;

        map.put("begin", begin + "");
        map.put("end", end + "");

        // CrtSchAdminDAO 인스턴스를 생성합니다.
        CrtSchAdminDAO dao = new CrtSchAdminDAO();

        // CRT 스케줄 목록을 검색합니다.
        ArrayList<CrtSchAdminDTO> list = dao.list(map);

        // 총 게시물 수를 가져옵니다.
        totalCount = dao.getTotalCount();

        // 총 페이지 수를 계산합니다.
        totalPage = (int) Math.ceil((double) totalCount / pageSize);

        // 페이지 바를 생성합니다.
        StringBuilder sb = new StringBuilder();
        loop = 1; // 루프 변수(10바퀴)
        n = ((nowPage - 1) / blockSize) * blockSize + 1;

        // 이전 10페이지
        if (n == 1) {
            sb.append(String.format("<a href='#!'>[이전] </a>", blockSize));
        } else {
            sb.append(String.format("<a href='/jr/crt/admin/crtschadminlist.do?page=%d'>[이전] </a>", n - 1, blockSize));
        }

        // 페이지 바 숫자 표시 부분
        while (!(loop > blockSize || n > totalPage)) {
            if (n == nowPage) {
                sb.append(String.format(" <a href='#!' style='color:tomato;'>%d</a>", n));
            } else {
                sb.append(String.format(" <a href='/jr/crt/admin/crtschadminlist.do?page=%d'>%d</a>", n, n));
            }
            loop++;
            n++;
        }

        // 다음 10페이지
        if (n > totalPage) {
            sb.append(String.format("<a href='#!'> [다음]</a>", blockSize));
        } else {
            sb.append(String.format("<a href='/jr/crt/admin/crtschadminlist.do?page=%d'> [다음]</a>", n, blockSize));
        }

        // 요청 속성으로 데이터를 설정합니다.
        req.setAttribute("list", list);
        req.setAttribute("map", map);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("nowPage", nowPage);
        req.setAttribute("pagebar", sb.toString());

        // JSP 페이지로 포워딩합니다.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/crt/admin/crtschadminlist.jsp");
        dispatcher.forward(req, resp);
    }
}
