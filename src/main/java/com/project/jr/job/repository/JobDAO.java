package com.project.jr.job.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.jr.job.model.GroupDTO;
import com.project.jr.job.model.JobDTO;
import com.project.jr.main.DBUtil;

public class JobDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public JobDAO() {
		this.conn = DBUtil.open();
	}

	/**
	 * 직업군 목록 출력 JDBC
	 * @return
	 */
	public ArrayList<GroupDTO> getGroup() {

		try {
			
			String sql = "select * from tblJobgroup";
			
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			ArrayList<GroupDTO> list=new ArrayList<GroupDTO>();
			
			while(rs.next()) {
				GroupDTO dto=new GroupDTO();
				
				dto.setJobgroupSeq(rs.getInt("jobgroupSeq"));
				dto.setJobgroupName(rs.getString("jobgroupName"));
				dto.setJobgroupImg(rs.getString("jobgroupImg"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	/**
	 * 직업 autocomplet JDBC
	 * @param searchWord 직업 검색어
	 * @param jobGroupSeq 직업군 seq
	 * @return
	 */
	public ArrayList<String> search(String searchWord, int jobGroupSeq) {

		try {
			//직업군 선택시 추가되는 조건
			String and="";
			
			if(jobGroupSeq != 0) {
				and="and jobGroupSeq="+jobGroupSeq;
			}
			
			String sql =String.format("select jobName from tblJob where regexp_like(jobName, ?, 'i') %s"
										, and);
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, searchWord);
			
			rs=pstat.executeQuery();
			
			ArrayList<String> list=new ArrayList<String>();
			
			while(rs.next()) {
				list.add(rs.getString("jobName"));
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 직업 목록 출력 JDBC
	 * @param begin 시작페이지
	 * @param end 끝페이지
	 * @param seq 직업군 seq
	 * @param jobName 직업 검색 이름
	 * @param searchN 직업 검색 유무
	 * @param searchG 직업군 검색 유무
	 * @return
	 */
	public ArrayList<JobDTO> getJobList(int begin, int end, int seq, String jobName, String searchN, String searchG) {

		try {
			String where = "";
			if(searchN.equals("y") && searchG.equals("y")) {
				where = String.format("where regexp_like(jobName, '%s', 'i') and jobgroupSeq = %d"
						, jobName, seq);
			}
			
			if(searchN.equals("y") && searchG.equals("n")) {
				where = String.format("where regexp_like(jobName, '%s', 'i')"
						, jobName);
			}
			
			if(searchN.equals("n") && searchG.equals("y")) {
				where = String.format("where jobgroupSeq = %d"
						, seq);
			}
			
			String sql = String.format("select * from(select jobSeq, jobgroupSeq, jobName, keyTask, salary, prospect, dvlPossibility, aptitude, task, rownum as rnum from tblJob %s)where rnum between %s and %s"
										, where
										, begin
										, end);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			System.out.println(sql);
			
			ArrayList<JobDTO> list=new ArrayList<JobDTO>();
			
			while(rs.next()) {
				JobDTO dto=new JobDTO();
				
				dto.setJobSeq(rs.getInt("jobSeq"));
				dto.setJobgroupSeq(rs.getInt("jobgroupSeq"));
				dto.setJobName(rs.getNString("jobName"));
				dto.setKeyTask(rs.getString("keyTask"));
				dto.setSalary(rs.getInt("salary"));
				dto.setProspect(rs.getString("prospect"));
				dto.setDvlPossibility(rs.getString("dvlPossibility"));
				dto.setAptitude(rs.getString("aptitude"));
				dto.setTask(rs.getString("task"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	/**
	 * 직업검색 카운트 JDBC
	 * @param seq 직업군 seq
	 * @param jobName 검색 직업 이름
	 * @param searchN 직업 검색 유무
	 * @param searchG 직업군 검색 유무
	 * @return
	 */
	public int getTotalCount(int seq, String jobName, String searchN, String searchG) {

		try {
			String where = "";
			
			if(searchN.equals("y") && searchG.equals("y")) {
				where = String.format("where regexp_like(jobName, '%s', 'i') and jobgroupSeq = %d"
						, jobName, seq);
			}
			
			if(searchN.equals("y") && searchG.equals("n")) {
				where = String.format("where regexp_like(jobName, '%s', 'i')"
						, jobName);
			}
			
			if(searchN.equals("n") && searchG.equals("y")) {
				where = String.format("where jobgroupSeq = %d"
						, seq);
			}
			

			String sql = String.format("select count(*) as count from tblJob %s"
										,where);

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			if (rs.next()) {
				return rs.getInt("count");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 직업상세 출력 JDBC
	 * @param seq 선택한 직업 seq
	 * @return
	 */
	public JobDTO job(int seq) {

		try {
			
			String sql = "select \r\n"
					+ "    *\r\n"
					+ "from tblJob j\r\n"
					+ "    inner join tblJobgroup jg\r\n"
					+ "        on j.jobgroupSeq = jg.jobgroupSeq\r\n"
					+ "            inner join tblDepartByJob dj\r\n"
					+ "                on dj.jobSeq = j.jobSeq\r\n"
					+ "                    inner join tblDepart d\r\n"
					+ "                        on d.departSeq = dj.departSeq\r\n"
					+ "                            inner join tblCrtByJob cj\r\n"
					+ "                                on cj.jobSeq = j.jobSeq\r\n"
					+ "                                    inner join tblCrt c\r\n"
					+ "                                        on c.crtSeq = cj.crtSeq\r\n"
					+ "                                            where j.jobSeq = ?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, seq);
			
			rs=pstat.executeQuery();
			
			if(rs.next()) {
				JobDTO dto=new JobDTO();
				
				dto.setJobSeq(rs.getInt("jobSeq"));
				dto.setJobgroupSeq(rs.getInt("jobgroupSeq"));
				dto.setJobName(rs.getNString("jobName"));
				dto.setKeyTask(rs.getString("keyTask"));
				dto.setSalary(rs.getInt("salary"));
				dto.setProspect(rs.getString("prospect"));
				dto.setDvlPossibility(rs.getString("dvlPossibility"));
				dto.setAptitude(rs.getString("aptitude"));
				dto.setTask(rs.getString("task"));
				
				dto.setDepartName(rs.getString("departName"));
				dto.setJobgroupName(rs.getString("jobgroupName"));
				dto.setJobgroupImg(rs.getString("jobgroupImg"));
				dto.setCrtName(rs.getString("crtName"));
				
				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	
	
}
