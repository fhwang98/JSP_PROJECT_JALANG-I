package com.project.jr.academy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.project.jr.academy.model.AcademyDTO;
import com.project.jr.academy.model.AcademyEduDTO;
import com.project.jr.main.DBUtil;

/**
 * AcademyDAO는 학원과 관련된 데이터베이스 처리를 담당하는 클래스입니다.
 * @author 이슬아
 */
public class AcademyDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * AcademyDAO의 생성자입니다. 데이터베이스 연결을 수행합니다.
     */
    public AcademyDAO() {
        this.conn = DBUtil.open();
    }

    /**
     * 학원 목록을 가져오는 메서드입니다.
     *
     * @param map 검색 조건을 담고 있는 HashMap 객체
     * @return 학원 목록을 담은 ArrayList 객체
     */
    public ArrayList<AcademyDTO> list(HashMap<String, String> map) {
        try {
            String where = "";

            if (map.get("search").equals("y")) {
                where = String.format("where academyName like '%%%s%%'", map.get("word"));
            }

            String sql = String.format(
                    "select * from(select a.*, rownum as rnum from vwAcademyList a %s )where rnum between %s and %s ",
                    where, map.get("begin"), map.get("end"));

            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            ArrayList<AcademyDTO> list = new ArrayList<AcademyDTO>();

            while (rs.next()) {
                AcademyDTO dto = new AcademyDTO();

                dto.setAcademySeq(rs.getInt("academySeq"));
                dto.setAcademyName(rs.getString("academyName"));
                dto.setAcademyLocation(rs.getString("academyLocation"));
                dto.setAcademyTel(rs.getString("academyTel"));
                dto.setAcademyStar(rs.getInt("academyStar"));
                dto.setAcademyEduSeq(rs.getInt("academyEduSeq"));
                dto.setEduName(rs.getString("eduName"));
                dto.setEduRcStartDate(rs.getString("eduRcStartDate"));
                dto.setEduRcEndDate(rs.getString("eduRcEndDate"));
                dto.setEduStartDate(rs.getString("eduStartDate"));
                dto.setEduEndDate(rs.getString("eduEndDate"));
                dto.setEduLink(rs.getString("eduLink"));
                dto.setCrtSeq(rs.getInt("crtSeq"));
                dto.setCrtName(rs.getString("crtName"));

                list.add(dto);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

	/**
	 * 관리자 학원 관리 페이지 - 검색 여부 map을 인자로 받아 전체 학원 수를 반환하는 메소드 
	 * @param map
	 * @return
	 */
    public int getTotalCount() {

        try {

            String sql = "select count(*) as cnt from vwAcademyList";

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

    /**
     * 관리자 학원 관리 페이지 - seq를 인자로 받아 해당 번호의 학원 정보를 반환하는 메소드
     * @param seq
     * @return
     */
    public AcademyDTO get(String seq) {
        try {

            String sql = "SELECT * FROM tblAcademy WHERE academySeq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            rs = pstat.executeQuery();

            if (rs.next()) {

                AcademyDTO dto = new AcademyDTO();

                dto.setAcademySeq(rs.getInt("academySeq"));
                dto.setAcademyName(rs.getString("academyName"));
                dto.setAcademyLocation(rs.getString("academyLocation"));
                dto.setAcademyTel(rs.getString("academyTel"));
                dto.setAcademyStar(rs.getInt("academyStar"));

                return dto;
            }

        } catch (Exception e) {
            System.out.println("AcademyDAO.get()");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 학원의 교육 목록을 가져오는 메서드입니다.
     *
     * @param seq 학원 일련번호
     * @return 학원의 교육 목록을 담은 ArrayList 객체
     */
    public ArrayList<AcademyEduDTO> getEduList(String seq) {

        try {

            String sql = "SELECT edu.*, (SELECT crtName FROM tblCrt WHERE crtSeq = edu.crtSeq ) AS crtName FROM tblAcademyEdu edu WHERE academySeq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            rs = pstat.executeQuery();

            ArrayList<AcademyEduDTO> list = new ArrayList<AcademyEduDTO>();

            while (rs.next()) {

                AcademyEduDTO dto = new AcademyEduDTO();

                dto.setAcademyEduSeq(rs.getInt("academyEduSeq"));
                dto.setAcademySeq(rs.getInt("academySeq"));
                dto.setCrtSeq(rs.getInt("crtSeq"));
                dto.setCrtName(rs.getString("crtName"));
                dto.setEduName(rs.getString("eduName"));
                dto.setEduLink(rs.getString("eduLink"));
                dto.setEduRcStartDate(rs.getString("eduRcStartDate"));
                dto.setEduRcEndDate(rs.getString("eduRcEndDate"));
                dto.setEduStartDate(rs.getString("eduStartDate"));
                dto.setEduEndDate(rs.getString("eduEndDate"));

                list.add(dto);
            }

            return list;

        } catch (Exception e) {
            System.out.println("AcademyDAO.getEduList()");
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 검색 조건에 따른 전체 학원 수를 가져오는 메서드입니다.
     *
     * @param map 검색 조건을 담고 있는 HashMap 객체
     * @return 검색 조건에 따른 전체 학원 수
     */
    public int getTotalCount(HashMap<String, String> map) {
        try {
            String sql = "";

            if (map.get("search").equals("n")) {

                sql = "SELECT count(*) AS cnt FROM tblAcademy";

            } else {
                sql = String.format("SELECT count(*) AS cnt FROM tblAcademy WHERE %s LIKE '%%%s%%'", map.get("column"),
                        map.get("word"));
            }

            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            if (rs.next()) {

                return rs.getInt("cnt");

            }

        } catch (Exception e) {
            System.out.println("AcademyDAO.getTotalCount()");
            e.printStackTrace();
        }
        return 0;
    }
	
	/**
	 * 관리자 학원 관리 페이지 - 검색 여부 map을 인자로 받아 학원 목록을 반환하는 메소드
	 * @param map
	 * @return
	 */
	public ArrayList<AcademyDTO> getAdminList(HashMap<String, String> map) {

		try {

			String where = "";
			
			if (map.get("search").equals("y")) {
				where = String.format("WHERE %s LIKE '%%%s%%'", map.get("column"), map.get("word"));
			}
			
			
			String sql = String.format(
					"SELECT * FROM (SELECT a.*, rownum AS rnum FROM tblAcademy a %s) WHERE rnum BETWEEN %s AND %s",
					where, map.get("begin"), map.get("end"));

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			ArrayList<AcademyDTO> list = new ArrayList<AcademyDTO>();

			while (rs.next()) {

				AcademyDTO dto = new AcademyDTO();

				dto.setAcademySeq(rs.getInt("academySeq"));
				dto.setAcademyName(rs.getString("academyName"));
				dto.setAcademyLocation(rs.getString("academyLocation"));
				dto.setAcademyTel(rs.getString("academyTel"));
				dto.setAcademyStar(rs.getInt("academyStar"));

				list.add(dto);
			}

			return list;

		} catch (Exception e) {
			System.out.println("AcademyDAO.list()");
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 관리자 학원 관리 페이지 - 학원을 DB에 추가하는 메소드
	 * @param dto 
	 * @return
	 */
	public int addAcademy(AcademyDTO dto) {
		
		try {
			String sql = "INSERT INTO tblacademy (academyseq, academyname, academylocation, academytel, academystar) VALUES ((SELECT max(academyseq) FROM tblacademy) + 1 , ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getAcademyName());
			pstat.setString(2, dto.getAcademyLocation());
			pstat.setString(3, dto.getAcademyTel());
			pstat.setInt(4, dto.getAcademyStar());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("AcademyDAO.addAcademy()");
			e.printStackTrace();
		}
		
		
		return 0;
	}

	/**
	 * 관리자 학원 관리 페이지 - 마지막 학원 seq를 반환하는 메소드
	 * @return
	 */
	public String getLastSeq() {
		
		try {

			String sql = "SELECT max(academyseq) AS seq FROM tblacademy";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			if (rs.next()) {
				return rs.getString("seq");
			}

		} catch (Exception e) {
			System.out.println("AcademyDAO.getLastSeq()");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 관리자 학원 페이지 - 학원 정보를 삭제하는 메소드
	 * @param seq
	 * @return
	 */
	public int delAcademy(String seq) {
		
		try {
			//academySeq가 seq인 academyEdu들을 먼저 삭제
			String sql = "DELETE FROM tblAcademyEdu WHERE academySeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			pstat.executeUpdate();

			//삭제 후 academy 삭제
			sql = "DELETE FROM tblAcademy WHERE academySeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("AcademyDAO.delAcademy()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 관리자 학원 관리 페이지 - 학원 정보를 수정하는 메소드
	 * @param dto
	 * @return
	 */
	public int editAcademy(AcademyDTO dto) {
		
		try {
			String sql = "UPDATE tblAcademy SET academyName = ? , academyLocation = ?, academyTel = ?, academyStar = ? WHERE academySeq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getAcademyName());
			pstat.setString(2, dto.getAcademyLocation());
			pstat.setString(3, dto.getAcademyTel());
			pstat.setInt(4, dto.getAcademyStar());
			pstat.setInt(5, dto.getAcademySeq());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("AcademyDAO.editAcademy()");
			e.printStackTrace();
		}
		
		return 0;
	}
	

   



}