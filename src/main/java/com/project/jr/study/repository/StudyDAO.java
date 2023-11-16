package com.project.jr.study.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.project.jr.main.DBUtil;
import com.project.jr.study.model.StudyJoinDTO;

public class StudyDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public StudyDAO() {
		this.conn = DBUtil.open();
	}

	public int add(StudyJoinDTO dto) {
		
		try {
			
			String sql = "insert into tblStudyJoin(studyJoinSeq, id, crtSchSeq, timeOption, dayOption, majorOption, status) "
					+ "values (studyJoinSeq.nextVal, ?, ?, ?, ?, ?, 0)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setInt(2, dto.getCrtSchSeq());
			pstat.setInt(3, dto.getTimeOption());
			pstat.setInt(4, dto.getDayOption());
			pstat.setInt(5, dto.getMajorOption());
			
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
