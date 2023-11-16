package com.project.jr.study.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.jr.main.DBUtil;
import com.project.jr.study.model.StudyBookDTO;
import com.project.jr.study.model.StudyDTO;
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
	
	public ArrayList<StudyBookDTO> getInfo(String id) {

		try {
			
			String sql = "select "
					+ "    *"
					+ "from tblBookprgByUser bp"
					+ "    inner join tblIndex i"
					+ "        on bp.indexSeq = i.indexSeq"
					+ "            inner join tblBook b"
					+ "                on i.bookSeq = b.bookSeq"
					+ "                    where bp.id = ?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs=pstat.executeQuery();
			
			ArrayList<StudyBookDTO> list=new ArrayList<StudyBookDTO>();
			
			while(rs.next()) {
				StudyBookDTO dto=new StudyBookDTO();
				
				dto.setBookName(rs.getString("bookName"));
				dto.setBookImg(rs.getString("bookImg"));
				dto.setBookSeq(rs.getInt("bookSeq"));
				dto.setList(rs.getString("list"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	public int totalCh(int seq) {

		try {

			String sql = "select count(*) as count from tblIndex where bookSeq = ? and titleStep = 0";

			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, seq);

			rs = pstat.executeQuery();

			
			if (rs.next()) {
				return rs.getInt("count");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

	public int progCh(String id) {

		try {

			String sql = "select \r\n"
					+ "    count(*) as count\r\n"
					+ "from tblBookprgByUser bp\r\n"
					+ "    inner join tblIndex i\r\n"
					+ "        on bp.indexSeq = i.indexSeq\r\n"
					+ "            inner join tblBook b\r\n"
					+ "                on i.bookSeq = b.bookSeq\r\n"
					+ "                    where bp.id = ? and bp.learnCheck = 1";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);

			rs = pstat.executeQuery();

			if (rs.next()) {
				return rs.getInt("count");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

	public ArrayList<StudyBookDTO> indexCh(String id, int seq) {

		try {
			
			String sql = "select \r\n"
					+ "    * \r\n"
					+ "from tblIndex i\r\n"
					+ "    left join (select * from tblBookprgByUser where id = ?) bp\r\n"
					+ "        on i.indexSeq = bp.indexSeq\r\n"
					+ "            where bookSeq = ? \r\n"
					+ "                ORDER BY listNum asc";
			
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, id);
			pstat.setInt(2, seq);
			
			rs=pstat.executeQuery();
			
			ArrayList<StudyBookDTO> list=new ArrayList<StudyBookDTO>();
			
			while(rs.next()) {
				StudyBookDTO dto=new StudyBookDTO();
				
				
				dto.setList(rs.getString("list"));
				dto.setTitleStep(rs.getInt("titleStep"));
				dto.setLearnCheck(rs.getInt("learnCheck"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	public int statusUp(String list, int status, String id) {

		
		try {

			String sql = "update vwBookStatus set learnCheck = ? where id=? and list=?";

			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, status);
			pstat.setString(2, id);
			pstat.setString(3, list);

			return pstat.executeUpdate();

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

	public int delBook(String id, int seq) {

		try {
			
			String sql = "delete from vwBookStatus where bookSeq = ? and id = ?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, seq);
			pstat.setString(2, id);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public StudyDTO getStudy(String id) {

		try {
			
			String sql = "select \r\n"
					+ "    * \r\n"
					+ "from tblStudyMember sm\r\n"
					+ "    inner join tblStudy s\r\n"
					+ "        on sm.studySeq = s.studySeq\r\n"
					+ "            where sm.id = ?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs=pstat.executeQuery();
			
			if(rs.next()) {
				StudyDTO dto=new StudyDTO();
				
				dto.setStudySeq(rs.getInt("studySeq"));
				dto.setStudyName(rs.getNString("studyName"));
				dto.setStudyStartDate(rs.getNString("studyStartDate"));
				dto.setStudyEndDate(rs.getNString("studyEndDate"));
				dto.setStudyMemberSeq(rs.getInt("studyMemberSeq"));
				dto.setId(rs.getNString("id"));
				dto.setStudyJoinSeq(rs.getInt("studyJoinSeq"));
				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	public String getCrtName(String id) {

		try {

			String sql = "select\r\n"
					+ "    *\r\n"
					+ "from tblStudyJoin sj\r\n"
					+ "    inner join tblCrtSch cs\r\n"
					+ "        on sj.crtSchSeq = cs.crtSchSeq\r\n"
					+ "            inner join tblCrtTest ct\r\n"
					+ "                on ct.crtTestSeq = cs.crtTestSeq\r\n"
					+ "                    where sj.status = 0 and sj.id = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);

			rs = pstat.executeQuery();

			if (rs.next()) {
				
				return rs.getString("crtTestName");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	public ArrayList<String> getNameList(int studySeq) {

		try {
			
			String sql = "select \r\n"
					+ "    * \r\n"
					+ "from tblStudyMember sm\r\n"
					+ "    inner join tblUserInfo u\r\n"
					+ "        on sm.id = u.id\r\n"
					+ "            where studySeq = ?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, studySeq);
			
			rs=pstat.executeQuery();
			
			ArrayList<String> list=new ArrayList<String>();
			
			while(rs.next()) {
				String name=rs.getString("name");
				
				list.add(name);
				
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}

	public int setToDo(int studySeq, String toDo, String completeDate, String id, String toDoComment) {

		try {
			
			String sql = "sql";
			
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, studySeq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

}
