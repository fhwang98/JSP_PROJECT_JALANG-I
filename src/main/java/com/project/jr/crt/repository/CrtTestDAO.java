package com.project.jr.crt.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.project.jr.crt.model.CrtTestDTO;
import com.project.jr.main.DBUtil;

public class CrtTestDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public CrtTestDAO() {
		this.conn = DBUtil.open();
	}
	
	/**
	 * 자격증 조회 - 시험 정보 조회 JDBC
	 * @param crtSeq
	 * @return
	 */
	public CrtTestDTO detail(String crtSeq) {
		
		try {
	         
	         String sql = "select * from vwCrtDetails where crtSeq = ?";
	         
	         pstat = conn.prepareStatement(sql);
	         pstat.setString(1, crtSeq);
	         
	         rs = pstat.executeQuery();
	         
	         CrtTestDTO dto = new CrtTestDTO();
	         
	        
	         if(rs.next()) {
	        	 
	        	 dto.setCrtTestSeq(rs.getString("crtTestSeq"));
	        	 dto.setCrtTestName(rs.getString("crtTestName"));
	        	 dto.setCrtSeq(rs.getString("crtSeq"));
	        	 dto.setCrtTestTypeSeq(rs.getString("crtTestTypeSeq"));
	        	 dto.setExamPay(rs.getString("examPay"));
	        	 dto.setExpiryDate(rs.getString("expiryDate"));
	        	 dto.setPassLine(rs.getString("passLine"));
	        	 dto.setTestSubject(rs.getString("testSubject"));
	        	 dto.setQuestionType(rs.getString("questionType"));
	        	 dto.setQustionNum(rs.getString("qustionNum"));
	        	 dto.setTestTime(rs.getString("testTime"));
	        	 dto.setTestType(rs.getString("testType"));

	            return dto;
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		return null;
	}
	
	public int edit(CrtTestDTO dto) {
		
		try {

			String sql = "UPDATE tblCrtTest SET crtTestName = ?, crtSeq = ?, crtTestTypeSeq = ?, examPay = ?, expiryDate = ?, passLine = ?, testSubject = ?, questionType = ?, qustionNum = ?, testTime = ? WHERE crtTestSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getCrtTestName());
			pstat.setString(2, dto.getCrtSeq());
			pstat.setString(3, dto.getCrtTestTypeSeq());
			pstat.setString(4, dto.getExamPay());
			pstat.setString(5, dto.getExpiryDate());
			pstat.setString(6, dto.getPassLine());
			pstat.setString(7, dto.getTestSubject());
			pstat.setString(8, dto.getQuestionType());
			pstat.setString(9, dto.getQustionNum());
			pstat.setString(10, dto.getTestTime());
			pstat.setString(11, dto.getCrtTestSeq());
			
			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<CrtTestDTO> list(HashMap<String, String> map) {
		
		int begin = Integer.parseInt(map.get("begin"));				
		int end = Integer.parseInt(map.get("end"));	
		
		try {
	    	
			
	        String sql = String.format("SELECT * FROM (SELECT u.*, rownum as rnum FROM vwCrtTestDetails u) where rnum between %s and %s",map.get("begin"), map.get("end"));
	        
	        stat = conn.createStatement();
	        rs = stat.executeQuery(sql);
	        
	        ArrayList<CrtTestDTO> list = new ArrayList<CrtTestDTO>();
	        
	        while (rs.next()) {
	        	
	            CrtTestDTO dto = new CrtTestDTO();
	            
	            dto.setCrtTestSeq(rs.getString("crtTestSeq"));
	            dto.setCrtTestName(rs.getString("crtTestName"));
	            dto.setCrtSeq(rs.getString("crtSeq"));
	            dto.setCrtTestTypeSeq(rs.getString("crtTestTypeSeq"));
	            dto.setExamPay(rs.getString("examPay"));
	            dto.setExpiryDate(rs.getString("expiryDate"));
	            dto.setPassLine(rs.getString("passLine"));
	            dto.setTestSubject(rs.getString("testSubject"));
	            dto.setQuestionType(rs.getString("questionType"));
	            dto.setQustionNum(rs.getString("qustionNum"));
	            dto.setTestTime(rs.getString("testTime"));
	            dto.setCrtName(rs.getString("crtName"));
	            dto.setTestType(rs.getString("testType"));

	            
	            list.add(dto);
	        }
	        
	        return list;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		return null;
	}
	
	public int getTotalCount() {						
		
		try {					
							
			String sql = "SELECT count(*) as cnt FROM vwCrtTestDetails";				
							
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);				
							
			if (rs.next()) {				
							
				return rs.getInt("cnt");			
			}				
							
		} catch (Exception e) {					
			e.printStackTrace();				
		}					
							
		return 0;					
	}

	public int add(CrtTestDTO dto) {

		try {

			String sql = "INSERT INTO tblCrtTest (crtTestSeq, crtTestName, crtSeq, crtTestTypeSeq, examPay, expiryDate, passLine, testSubject, questionType, qustionNum, testTime) VALUES (crtTestSeq.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);
	        pstat.setString(1, dto.getCrtTestName());
	        pstat.setString(2, dto.getCrtSeq());
	        pstat.setString(3, dto.getCrtTestTypeSeq());
	        pstat.setString(4, dto.getExamPay());
	        pstat.setString(5, dto.getExpiryDate());
	        pstat.setString(6, dto.getPassLine());
	        pstat.setString(7, dto.getTestSubject());
	        pstat.setString(8, dto.getQuestionType());
	        pstat.setString(9, dto.getQustionNum());
	        pstat.setString(10, dto.getTestTime());

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int del(String crttestSeq) {

		try {

			String sql = "delete from tblCrttest where crttestSeq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, crttestSeq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}	


}
