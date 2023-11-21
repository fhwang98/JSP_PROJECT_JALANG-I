package com.project.jr.qna.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.jr.main.DBUtil;
import com.project.jr.qna.model.QnaDTO;

/**
 * 문의 DAO
 * @author eugene
 *
 */

/**
 * 
 * @author oseunghyeon
 * QnaDAO 클래스는 Q&A 데이터베이스와의 상호작용을 담당하는 DAO 클래스
 * Q&A 글 목록 조회, 최신 문의글 조회, 내가 작성한 Q&A 목록 조회 등의 기능이 구현되어 있다.
 * 
 */



public class QnaDAO {

	
	
		private Connection conn;
		private Statement stat;
		private PreparedStatement pstat;
		private ResultSet rs;
		
		/**
		 * 문의 DAO 생성자
		 */
		public QnaDAO() {
			this.conn = DBUtil.open();
			
		
	}

		   /**
	     * Q&A 글 목록을 조회하는 메서드
	     * 
	     * @return Q&A 글 목록
	     */

		public ArrayList<QnaDTO> getList() {
			
			
			try {
				
				String seq="select qnaseq , id , qnatitle , qnacontent , attachfile , to_char(qnawritedate,'yyyy-mm-dd') AS qnawritedate from tblQna";
				
				stat=conn.createStatement();
				rs=stat.executeQuery(seq);
				
				ArrayList<QnaDTO> result=new ArrayList<QnaDTO>();
			
				while(rs.next()) {
					
					
					QnaDTO dto= new QnaDTO();
					
					dto.setQnaSeq(rs.getString("qnaSeq"));
					dto.setId(rs.getString("id"));
					dto.setQnaTitle(rs.getString("qnaTitle"));
					dto.setQnaContent(rs.getString("qnaContent"));
					dto.setAttachFile(rs.getString("attachFile"));
					dto.setQnaWriteDate(rs.getString("qnaWriteDate"));
					
					
					result.add(dto);
				}
				
				return result;
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return null;
		}


/**
 * 관리자 메인 페이지 - 최신 문의글을 조회하는 메소드
 * @return
 */
public ArrayList<QnaDTO> getRecentQna() {
		
		try {
			
			String sql = "SELECT * FROM (SELECT t.*, rownum AS rnum FROM (SELECT q.*, a.answerseq FROM tblqna q LEFT OUTER JOIN tblanswer a ON q.qnaseq = a.qnaseq ORDER BY q.qnawritedate DESC) t) WHERE rnum BETWEEN 1 AND 5";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			ArrayList<QnaDTO> list = new ArrayList<QnaDTO>();
			
			while (rs.next()) {
				
				QnaDTO dto = new QnaDTO();
				
				dto.setQnaSeqint(rs.getInt("qnaSeq"));
				dto.setAnswerSeqint(rs.getInt("answerSeq"));
				dto.setId(rs.getString("id"));
				dto.setQnaTitle(rs.getString("qnaTitle"));
				dto.setQnaWriteDate(rs.getString("qnaWriteDate"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("QnaDAO.getRecentQna()");
			e.printStackTrace();
		}
		
		return null;
	}
/**
 * 내가 작성한 Q&A 목록을 조회하는 메서드
 * @return 내가 작성한 Q&A 목록
 */
		public ArrayList<QnaDTO> getMyQnaList(String id) {
			try {

				String sql = "select qnaTitle, qnaContent,id,qnaSeq from tblQna where id = ?";

				pstat = conn.prepareStatement(sql);
				pstat.setString(1, id);

				rs = pstat.executeQuery();	

				ArrayList<QnaDTO> list = new ArrayList<QnaDTO>();

				while (rs.next()) {

					QnaDTO dto = new QnaDTO();

					dto.setId(rs.getString("id"));
					dto.setQnaTitle(rs.getString("qnaTitle"));
					dto.setQnaContent(rs.getString("qnaContent"));
					dto.setQnaSeq(rs.getString("qnaSeq"));

					list.add(dto);
				}	

				return list;

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		

}
