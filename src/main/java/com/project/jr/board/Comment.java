package com.project.jr.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.project.jr.board.model.BoardDTO;
import com.project.jr.board.model.CommentDTO;
import com.project.jr.board.repository.BoardDAO;

@WebServlet("/board/comment.do")
public class Comment extends HttpServlet {

	
    /**
     * HTTP GET 요청을 처리하여 댓글 목록을 조회하고 JSON 형식으로 반환
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	
        //Comment.java

        //1. 데이터 가져오기(bseq)
        //2. DB 작업 > select
        //3. 목록 반환 > JSON 반환

        //1.
    	
    	String boardSeq=req.getParameter("bseq");
        int seq =Integer.parseInt(boardSeq);
        System.out.println(boardSeq);
        
        
        //2.
        BoardDAO dao = new BoardDAO();

        ArrayList<CommentDTO> clist = dao.listComment(seq);

        System.out.println(clist.toString());
        
        //3.
        JSONArray arr = new JSONArray(); //=ArrayList

        for(CommentDTO dto : clist){
            //CommentDTO 1개 > JSONObject 1개
            JSONObject obj = new JSONObject();

            obj.put("seq", dto.getCommentSeq());
            obj.put("content", dto.getCommentContent());
            obj.put("id", dto.getId());
            obj.put("regdate", dto.getCommentWDate());
            obj.put("bseq", dto.getBoardSeq());
          

            arr.add(obj);
        }//for


        resp.setContentType("application/json");
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter writer = resp.getWriter();
        writer.write(arr.toString());//댓글 목록
        writer.close();
    }
    /**
     * HTTP POST 요청을 처리하여 댓글을 작성
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 데이터 가져오기(content, bseq)
        //2. 댓글 작성자 아이디 ? > 인증 티켓
        //3. DB작업 > insert
        //4. 피드백 > ajax

        HttpSession session = req.getSession();
        //1.
        String content = req.getParameter("content");
        String bseq = req.getParameter("bseq");


        //2.
        String id = session.getAttribute("id").toString();

        //3.
        BoardDAO dao = new BoardDAO();

        CommentDTO dto = new CommentDTO();
        dto.setCommentContent(content);
        dto.setBoardSeq(Integer.parseInt(bseq));
        dto.setId(id);

//        int result = dao.addCommnet(dto);

//        //3.
//        resp.setContentType("application/json");
//
//        JSONObject obj = new JSONObject();
//        obj.put("result", result);
//
//        PrintWriter writer = resp.getWriter();
//        writer.write(obj.toString());
//        writer.close();
//    }
    }
}

