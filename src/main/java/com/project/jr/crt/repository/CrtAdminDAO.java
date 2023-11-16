package com.project.jr.crt.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.project.jr.crt.model.AgencyDTO;
import com.project.jr.crt.model.CrtAcademyDTO;
import com.project.jr.crt.model.CrtAdminDTO;
import com.project.jr.crt.model.CrtBookLikeDescDTO;
import com.project.jr.crt.model.CrtDTO;
import com.project.jr.crt.model.CrtFaqDTO;
import com.project.jr.crt.model.CrtLikeDTO;
import com.project.jr.crt.model.CrtPassRateDTO;
import com.project.jr.crt.model.CrtPayDTO;
import com.project.jr.crt.model.CrtSchDdayDTO;
import com.project.jr.main.DBUtil;

public class CrtAdminDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public CrtAdminDAO() {
		this.conn = DBUtil.open();
	}

	
	public int add(CrtDTO dto) {
	
		try {

			String sql = "INSERT INTO tblCrt(crtSeq,crtName,crtTypeSeq,expiration,agencySeq,isRoutine,difficulty,likeCnt,qualificationCate,qualification,crtInfo,totalCnt,jobDesc) values (crtSeq.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);
	        pstat.setString(1, dto.getCrtName());
	        pstat.setInt(2, dto.getCrtTypeSeq());
	        pstat.setString(3, dto.getExpiration());
	        pstat.setInt(4, dto.getAgencySeq());
	        pstat.setInt(5, dto.getIsRoutine());
	        pstat.setInt(6, dto.getDifficulty());
	        pstat.setInt(7, dto.getLikeCnt());
	        pstat.setString(8, dto.getQualificationCate());
	        pstat.setString(9, dto.getQualification());
	        pstat.setString(10, dto.getCrtInfo());
	        pstat.setInt(11, dto.getTotalCnt());
	        pstat.setString(12, dto.getJobDesc());
			
			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<CrtDTO> list(HashMap<String, String> map) {										
		
        int begin = Integer.parseInt(map.get("begin"));										
        int end = Integer.parseInt(map.get("end"));										
										
										
	    try {									
	    									
	    									
	    	String where = "";								
										
			if (map.get("search").equals("y")) {							
				where = String.format("where %s like '%%%s%%'"						
										, map.get("column")
										, map.get("word"));
			}							
	    									
										
	        String sql = String.format("SELECT * FROM (SELECT u.*, rownum as rnum FROM vwCrtDetails u %s) where rnum between %s and %s",where, map.get("begin"), map.get("end"));									
	        									
	        									
	        stat = conn.createStatement();									
	        rs = stat.executeQuery(sql);									
	        									
	        ArrayList<CrtDTO> list = new ArrayList<CrtDTO>();									
	        									
	        while (rs.next()) {									
	        									
	            CrtDTO dto = new CrtDTO();									
	            									
	            dto.setCrtSeq(rs.getInt("crtSeq"));									
	            dto.setCrtName(rs.getString("crtName"));									
	            dto.setCrtType(rs.getString("crtType"));									
	            dto.setAgencyName(rs.getString("agencyName"));									
	            dto.setLikeCnt(rs.getInt("likeCnt"));									
	            dto.setExamPay(rs.getString("examPay"));									
	            									
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
							
			String sql = "SELECT count(*) as cnt FROM vwCrtDetails";				
							
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


		public CrtDTO detail(String crtSeq) {
		
		try {
	         
	         String sql = "select * from vwCrtDetails where crtSeq = ?";
	         
	         pstat = conn.prepareStatement(sql);
	         pstat.setString(1, crtSeq);
	         
	         rs = pstat.executeQuery();
	         
	         CrtDTO dto = new CrtDTO();
	         
	        
	         if(rs.next()) {
	        	 
	        	 dto.setCrtSeq(rs.getInt("crtSeq"));
	        	 dto.setCrtName(rs.getString("crtName"));
	        	 dto.setCrtType(rs.getString("crtType"));
	        	 dto.setCrtTypeSeq(rs.getInt("crtTypeseq"));
	        	 dto.setAgencySeq(rs.getInt("agencySeq"));
	        	 dto.setExpiration(rs.getString("expiration"));
	        	 dto.setAgencyName(rs.getString("agencyName"));
	        	 dto.setIsRoutine(rs.getInt("isRoutine"));
	        	 dto.setDifficulty(rs.getInt("difficulty"));
	        	 dto.setQualificationCate(rs.getString("qualificationCate"));
	        	 dto.setQualification(rs.getString("qualification"));
	        	 dto.setCrtInfo(rs.getString("crtInfo"));
	        	 dto.setCrtTestName(rs.getString("crtTestName"));
	        	 dto.setExamPay(rs.getString("examPay"));
	        	 dto.setExpiryDate(rs.getString("expiryDate"));
	        	 dto.setPassLine(rs.getString("passLine"));
	        	 dto.setLikeCnt(rs.getInt("likeCnt"));
	        	 dto.setJobDesc(rs.getString("jobdesc"));
	        	 dto.setTotalCnt(rs.getInt("totalCnt"));

	            return dto;
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

		
		return null;
	}


		public int edit(CrtDTO dto) {
				
				try {
					
			        String sql = "UPDATE tblCrt SET crtName = ?, crtTypeSeq = ?, expiration = ?, agencySeq = ?, isRoutine = ?, difficulty = ?, likeCnt = ?, qualificationCate = ?, qualification = ?, crtInfo = ?, totalCnt = ?, jobDesc = ? WHERE crtSeq = ?";
			        
			        pstat = conn.prepareStatement(sql);
			        pstat.setString(1, dto.getCrtName());
			        pstat.setInt(2, dto.getCrtTypeSeq());
			        pstat.setString(3, dto.getExpiration());
			        pstat.setInt(4, dto.getAgencySeq());
			        pstat.setInt(5, dto.getIsRoutine());
			        pstat.setInt(6, dto.getDifficulty());
			        pstat.setInt(7, dto.getLikeCnt());
			        pstat.setString(8, dto.getQualificationCate());
			        pstat.setString(9, dto.getQualification());
			        pstat.setString(10, dto.getCrtInfo());
			        pstat.setInt(11, dto.getTotalCnt());
			        pstat.setString(12, dto.getJobDesc());
			        pstat.setInt(13, dto.getCrtSeq());
			        
			        return pstat.executeUpdate();
			        
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
				
				return 0;
			}


		public int del(String crtSeq) {

				try {

					String sql = "delete from tblCrt where crtSeq = ?";

					pstat = conn.prepareStatement(sql);
					pstat.setString(1, crtSeq);

					return pstat.executeUpdate();

				} catch (Exception e) {
					e.printStackTrace();
				}

			return 0;
		}
					

}
