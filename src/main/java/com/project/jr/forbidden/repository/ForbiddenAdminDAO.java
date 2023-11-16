package com.project.jr.forbidden.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.jr.crt.model.CrtDTO;
import com.project.jr.forbidden.model.ForbiddenAdminDTO;
import com.project.jr.main.DBUtil;

public class ForbiddenAdminDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public ForbiddenAdminDAO() {
		this.conn = DBUtil.open();
	}

	public ArrayList<ForbiddenAdminDTO> list() {
		
		 try {							
		    									
											
		        String sql = "SELECT * FROM tblforbidden order by forbiddenSeq desc";						
		        									
		        									
		        stat = conn.createStatement();									
		        rs = stat.executeQuery(sql);									
		        									
		        ArrayList<ForbiddenAdminDTO> list = new ArrayList<ForbiddenAdminDTO>();									
		        									
		        while (rs.next()) {									
		        									
		        	ForbiddenAdminDTO dto = new ForbiddenAdminDTO();									
		            									
		            dto.setForbiddenSeq(rs.getInt("forbiddenSeq"));									
		            dto.setForbidden(rs.getString("forbidden"));
		            									
		            list.add(dto);									
		        }									
		        									
		        return list;									
		        									
		    } catch (Exception e) {									
		        e.printStackTrace();									
		    }
		
		return null;
	}

	public int add(ForbiddenAdminDTO dto) {

		try {

			String sql = "INSERT INTO tblForbidden(forbiddenSeq, forbidden) values (forbiddenSeq.nextVal, ?)";

			pstat = conn.prepareStatement(sql);
	        pstat.setString(1, dto.getForbidden());
			
			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int del(String forbiddenSeq) {
		
		try {

			String sql = "delete from tblForbidden where forbiddenSeq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, forbiddenSeq);

			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ForbiddenAdminDTO detail(String forbiddenSeq) {

		try {
	         
	         String sql = "select * from tblForbidden where forbiddenSeq = ?";
	         
	         pstat = conn.prepareStatement(sql);
	         pstat.setString(1, forbiddenSeq);
	         
	         rs = pstat.executeQuery();
	         
	         ForbiddenAdminDTO dto = new ForbiddenAdminDTO();
	         
	        
	         if(rs.next()) {
	        	 
	        	 dto.setForbiddenSeq(rs.getInt("forbiddenSeq"));
	        	 dto.setForbidden(rs.getString("forbidden"));


	            return dto;
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
		return null;
	}
	
}
