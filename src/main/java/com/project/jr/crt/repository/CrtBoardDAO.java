package com.project.jr.crt.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.project.jr.crt.model.CrtBoardDTO;
import com.project.jr.main.DBUtil;

public class CrtBoardDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public CrtBoardDAO() {
		this.conn = DBUtil.open();
	}
/*
	public ArrayList<CrtBoardDTO> list(String crtseq) {
		
		try {
			
			String sql = "select * from vwCrtBoard where crtseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, crtseq);
			
			rs = pstat.executeQuery();	
			
			ArrayList<CrtBoardDTO> list = new ArrayList<CrtBoardDTO>();
			
			while (rs.next()) {
				
				CrtBoardDTO dto = new CrtBoardDTO();
				
				dto.setCrtBoardSeq(rs.getInt("crtboardseq"));
				dto.setCrtSeq(rs.getInt("crtseq"));
				dto.setCrtBoardTitle(rs.getString("crtboardtitle"));
				dto.setCrtBoardContent(rs.getString("crtboardcontent"));
				dto.setId(rs.getString("id"));
				dto.setCrtboardHits(rs.getInt("crtboardHits"));
				dto.setCrtboardLike(rs.getInt("crtboardlike"));
				dto.setCrtboardReport(rs.getInt("crtboardreport"));
				dto.setCrtboardWriteDate(rs.getString("crtboardWriteDate"));
				dto.setIscrtBoardShow(rs.getInt("iscrtBoardShow"));
				dto.setCcnt(rs.getInt("ccnt"));
				dto.setIsnew(rs.getInt("isnew"));
				
				list.add(dto);
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
*/
	public ArrayList<CrtBoardDTO> list(HashMap<String, String> map) {
		
		try {
			
			String sql = String.format("select * from (select a.*, rownum as rnum from vwcrtBoard a where crtseq = %s) "
					+ "where iscrtBoardShow =1 and rnum between %s and %s"
					, map.get("crtseq")
					, map.get("begin")
					, map.get("end"));
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<CrtBoardDTO> list = new ArrayList<CrtBoardDTO>();
			System.out.println(sql);
			
			while (rs.next()) {

				CrtBoardDTO dto = new CrtBoardDTO();
				
				dto.setCrtBoardSeq(rs.getInt("crtboardseq"));
				dto.setCrtSeq(rs.getInt("crtseq"));
				dto.setCrtBoardTitle(rs.getString("crtboardtitle"));
				dto.setCrtBoardContent(rs.getString("crtboardcontent"));
				dto.setId(rs.getString("id"));
				dto.setCrtboardHits(rs.getInt("crtboardHits"));
				dto.setCrtboardLike(rs.getInt("crtboardlike"));
				dto.setCrtboardReport(rs.getInt("crtboardreport"));
				dto.setCrtboardWriteDate(rs.getString("crtboardWriteDate"));
				dto.setIscrtBoardShow(rs.getInt("iscrtBoardShow"));
				dto.setCcnt(rs.getInt("ccnt"));
				dto.setIsnew(rs.getInt("isnew"));
				
				list.add(dto);
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int getTotalCount(String crtseq) {
		
		try {
			
			String sql = "select count(*) as cnt from vwcrtboard where crtseq =?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, crtseq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	public void updateReadcount(String crtboardseq) {
		
		try {

			String sql = "update tblcrtboard set crtboardHits = crtboardHits + 1 where crtboardseq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, crtboardseq);

			pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public CrtBoardDTO get(String crtboardseq) {

		try {
			
			String sql = "select * from vwCrtBoard where crtboardseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, crtboardseq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				CrtBoardDTO dto = new CrtBoardDTO();
				
				dto.setCrtBoardTitle(rs.getString("crtBoardTitle"));
				dto.setCrtBoardContent(rs.getString("crtBoardContent"));
				dto.setId(rs.getString("id"));
				dto.setCrtSeq(rs.getInt("crtSeq"));
				dto.setCrtboardWriteDate(rs.getString("crtboardWriteDate"));
				dto.setCrtboardLike(rs.getInt("crtboardLike"));
				dto.setCrtboardReport(rs.getInt("crtboardReport"));
				dto.setCrtboardHits(rs.getInt("crtboardHits"));
				dto.setIscrtBoardShow(rs.getInt("iscrtBoardShow"));
				dto.setIsnew(rs.getInt("isnew"));
				dto.setCcnt(rs.getInt("ccnt"));
				
				return dto;
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
}
