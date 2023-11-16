package com.project.jr.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.jr.board.model.BoardDTO;
import com.project.jr.board.model.NoticeBoardDTO;
import com.project.jr.main.DBUtil;

public class BoardDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public BoardDAO() {
		this.conn = DBUtil.open();
	}

	public ArrayList<NoticeBoardDTO> getRecentNoticeList() {
		
		try {
			
			String sql = "SELECT * FROM (SELECT a.*, rownum AS rnum FROM tblNoticeBoard a ORDER BY noticeBoardWriteDate DESC) WHERE rnum BETWEEN 1 AND 5";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			ArrayList<NoticeBoardDTO> list = new ArrayList<NoticeBoardDTO>();
			
			while (rs.next()) {
				
				NoticeBoardDTO dto = new NoticeBoardDTO();
				
				dto.setNoticeBoardSeq(rs.getInt("noticeBoardSeq"));
				dto.setNoticeBoardTitle(rs.getString("noticeBoardTitle"));
				dto.setNoticeBoardContent(rs.getString("noticeBoardContent"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.getRecentList()");
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<BoardDTO> getRecentReportList() {
		
		try {
			
			String sql = "SELECT * FROM tblboard WHERE boardseq IN (SELECT boardseq FROM (SELECT b.*, rownum AS rnum FROM tblreportboard b ORDER BY reportboardseq DESC) WHERE rnum BETWEEN 1 AND 5)";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while (rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				
				dto.setBoardSeq(rs.getInt("boardSeq"));
				dto.setId(rs.getString("id"));
				dto.setBoardTitle(rs.getString("boardTitle"));
				dto.setBoardLike(rs.getString("boardLike"));
				dto.setBoardHits(rs.getString("boardHits"));
				dto.setBoardReport(rs.getString("boardReport"));
				dto.setBoardWriteDate(rs.getString("boardWriteDate"));
				dto.setIsBoardShow(rs.getString("isBoardShow"));
				
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.getRecentReportList()");
			e.printStackTrace();
		}
		
		return null;
	}
	
}
