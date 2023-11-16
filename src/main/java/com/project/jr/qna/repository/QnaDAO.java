package com.project.jr.qna.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.jr.main.DBUtil;
import com.project.jr.qna.model.QnaDTO;

public class QnaDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public QnaDAO() {
		this.conn = DBUtil.open();
	}

	public ArrayList<QnaDTO> getRecentQna() {
		
		try {
			
			String sql = "SELECT * FROM (SELECT t.*, rownum AS rnum FROM (SELECT q.*, a.answerseq FROM tblqna q LEFT OUTER JOIN tblanswer a ON q.qnaseq = a.qnaseq ORDER BY q.qnawritedate DESC) t) WHERE rnum BETWEEN 1 AND 5";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			ArrayList<QnaDTO> list = new ArrayList<QnaDTO>();
			
			while (rs.next()) {
				
				QnaDTO dto = new QnaDTO();
				
				dto.setQnaSeq(rs.getInt("qnaSeq"));
				dto.setAnswerSeq(rs.getInt("answerSeq"));
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
	
}
