package com.project.jr.crt.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.jr.crt.model.CrtRecDTO;
import com.project.jr.main.DBUtil;

public class CrtRecDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public CrtRecDAO() {
		this.conn = DBUtil.open();
	}
	
	
	/**
	 * 직업군 선별 JDBC
	 * @return
	 */
	public ArrayList<CrtRecDTO> jobgruoplist() {
		
		try {
			
			String sql = "select * from vwBestJobGroup";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<CrtRecDTO> list = new ArrayList<CrtRecDTO>();
			
			while (rs.next()) {
				
				CrtRecDTO dto = new CrtRecDTO();
				
				dto.setJobgroupname(rs.getString("jobgroupname"));
				dto.setJobgroupseq(rs.getInt("jobgroupseq"));
				
				list.add(dto);
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 직업군 별 자격증 합격률 조회 JDBC
	 * @param dto1
	 * @return
	 */
	public ArrayList<CrtRecDTO> passRateList(CrtRecDTO dto1) {
		
		try {
			
			String sql = "select * from vwPassRateByJobGroup where jobgroupname = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto1.getJobgroupname());
			
			rs = pstat.executeQuery();	
			
			ArrayList<CrtRecDTO> list = new ArrayList<CrtRecDTO>();
			
			while (rs.next()) {
				
				CrtRecDTO dto = new CrtRecDTO();
				dto.setJobgroupname(rs.getString("jobgroupname"));
				dto.setCrtname(rs.getString("crtname"));
				dto.setCrtseq(rs.getInt("crtseq"));
				dto.setS18(rs.getInt("s18"));
				dto.setS19(rs.getInt("s19"));
				dto.setS20(rs.getInt("s20"));
				dto.setS21(rs.getInt("s21"));
				dto.setS22(rs.getInt("s22"));
				dto.setPassIn18(rs.getInt("passin18"));
				dto.setPassIn19(rs.getInt("passin19"));
				dto.setPassIn20(rs.getInt("passin20"));
				dto.setPassIn21(rs.getInt("passin21"));
				dto.setPassIn22(rs.getInt("passin22"));
				
				list.add(dto);
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 직업군 별 자격증 4개 조회 JDBC
	 * @param jobgroupseq
	 * @return
	 */
	public ArrayList<CrtRecDTO> jobgruopSublist(int jobgroupseq) {
		
		try {
			
			String sql = "select * from vwPassRateByJobGroup where jobgroupseq = ? and rownum <= 5";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, jobgroupseq);
			
			rs = pstat.executeQuery();	
			
			ArrayList<CrtRecDTO> list = new ArrayList<CrtRecDTO>();
			
			while (rs.next()) {
				
				CrtRecDTO dto = new CrtRecDTO();
				
				dto.setCrtname(rs.getString("crtname"));
				dto.setCrtseq(rs.getInt("crtseq"));
				
				list.add(dto);
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
