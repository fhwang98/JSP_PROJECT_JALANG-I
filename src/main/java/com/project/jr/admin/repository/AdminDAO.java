package com.project.jr.admin.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.project.jr.admin.model.AdminDTO;
import com.project.jr.main.DBUtil;

public class AdminDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public AdminDAO() {
		this.conn = DBUtil.open();
	}

	public AdminDTO login(AdminDTO dto) {
		try {
			
			String sql = "select * from tblAdminInfo where adminInfoId = ? and adminInfoPw = ?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, dto.getAdminInfoId());
			pstat.setString(2, dto.getAdminInfoPw());
			
			rs=pstat.executeQuery();
			
			
			if(rs.next()) {
				
				AdminDTO result=new AdminDTO();
				result.setAdminInfoId(rs.getString("adminInfoId"));
				result.setAdminInfoPw(rs.getString("adminInfoPw"));
				result.setAdminInfoMail(rs.getString("adminInfoMail"));
				result.setAdminInfoPN(rs.getString("adminInfoPN"));
				
				
				return result;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}
