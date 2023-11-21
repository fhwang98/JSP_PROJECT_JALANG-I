package com.project.jr.crt.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.project.jr.crt.model.AgencyDTO;
import com.project.jr.crt.model.CrtAcademyDTO;
import com.project.jr.crt.model.CrtBookLikeDescDTO;
import com.project.jr.crt.model.CrtDTO;
import com.project.jr.crt.model.CrtFaqDTO;
import com.project.jr.crt.model.CrtLikeDTO;
import com.project.jr.crt.model.CrtPassRateDTO;
import com.project.jr.crt.model.CrtPayDTO;
import com.project.jr.crt.model.CrtSchDdayDTO;
import com.project.jr.crt.model.MyCrtDTO;
import com.project.jr.main.DBUtil;

/**
 * 자격증 DAO
 *
 */
public class CrtDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	/**
	 * 자격증 DAO 생성자
	 */
	public CrtDAO() {
		this.conn = DBUtil.open();
	}
	
	/**
	 * 자격증 조회페이지 출력 JDBC
	 * @param map
	 * @return
	 */
	public ArrayList<CrtDTO> list(HashMap<String,String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("search").equals("y")) {
				
				if ((map.get("word") != null) || !(map.get("word").equals(""))) {
					where = String.format("where crtName like '%%%s%%'", map.get("word"));
				}
				if (!(map.get("crtctg").equals("default"))) {
					if (where.equals("")) {
						where = String.format("where crtctg like '%%%s%%'", map.get("crtctg"));
					}else {
						where += String.format(" and crtctg like '%%%s%%'", map.get("crtctg"));
					}
				}
				
				if (!(map.get("agency").equals("default"))) {
					if (where.equals("")) {
						where = String.format("where agency like '%%%s%%'", map.get("agency"));
					}else {
						where += String.format(" and agency like '%%%s%%'", map.get("agency"));
					}
				}
				
				if (!(map.get("difficulty").equals("default"))) {
					if (where.equals("")) {
						where = String.format("where difficulty = '%%%s%%'", map.get("difficulty"));
					}else {
						where += String.format(" and difficulty like '%%%s%%'", map.get("difficulty"));
					}
				}
				//System.out.println(where);
				
			}
//			String sql = String.format("select * from (select a.*, rownum as rnum from vwcrt a %s) where rnum between %s and %s"
//											, where
//											, map.get("begin")
//											, map.get("end"));
			
			String id = "";
			if (map.get("id") == null || map.get("id").equals("")) {
				System.out.println("no 로그인");
				
			} else {
				id = map.get("id");
			}
			
			
			String sql = String.format("select b.*, (select count(*) from tblcrtlike where crtseq = b.crtseq and id = '%s') as crtlike from (select a.*, rownum as rnum from vwcrt a %s) b where rnum between %s and %s"
					, id
					, where
					, map.get("begin")
					, map.get("end"));
			
			
			System.out.println(sql);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<CrtDTO> list = new ArrayList<CrtDTO>();
			
			while (rs.next()) {
				
				CrtDTO dto = new CrtDTO();
				
				dto.setCrtSeq(rs.getInt("crtseq"));
				dto.setCrtName(rs.getString("crtname"));
//				dto.setCrtTypeSeq(rs.getInt("crtTypeSeq"));
				dto.setExpiration(rs.getString("expiration"));
//				dto.setAgencySeq(rs.getInt("agencySeq"));
				dto.setIsRoutine(rs.getInt("isRoutine"));
				dto.setDifficulty(rs.getInt("difficulty"));
				dto.setLikeCnt(rs.getInt("likeCnt"));
				dto.setQualificationCate(rs.getString("qualificationCate"));
				dto.setQualification(rs.getString("qualification"));
				dto.setCrtInfo(rs.getString("crtInfo"));
				dto.setTotalCnt(rs.getInt("totalCnt"));
				dto.setJobDesc(rs.getString("jobDesc"));
				
				dto.setCrtctg(rs.getString("crtctg"));
				dto.setAgency(rs.getString("agency"));
				dto.setAgencyurl(rs.getString("agencyurl"));
				
				dto.setCrtlike(rs.getInt("crtlike"));
				
				list.add(dto);
			}	
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 자격증 조회 총 게시물 수 JDBC
	 * @param map
	 * @return
	 */
	public int getTotalCount(HashMap<String,String> map) {

		try {
			
			String sql = "";
			

			String where = "";
			
			if (map.get("search").equals("y")) {
				
				if ((map.get("word") != null) || !(map.get("word").equals(""))) {
					where = String.format("where crtName like '%%%s%%'", map.get("word"));
				}
				if (!(map.get("crtctg").equals("default"))) {
					if (where.equals("")) {
						where = String.format("where crtctg like '%%%s%%'", map.get("crtctg"));
					}else {
						where += String.format(" and crtctg like '%%%s%%'", map.get("crtctg"));
					}
				}
				
				if (!(map.get("agency").equals("default"))) {
					if (where.equals("")) {
						where = String.format("where agency like '%%%s%%'", map.get("agency"));
					}else {
						where += String.format(" and agency like '%%%s%%'", map.get("agency"));
					}
				}
				
				if (!(map.get("difficulty").equals("default"))) {
					if (where.equals("")) {
						where = String.format("where difficulty = '%%%s%%'", map.get("difficulty"));
					}else {
						where += String.format(" and difficulty like '%%%s%%'", map.get("difficulty"));
					}
				}
				
				sql = "select count(*) as cnt from tblCrt " + where;
				
			} else {
				sql = "select count(*) as cnt from tblCrt";
			}
			System.out.println(sql);

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
	 * 자격증 시행기관 조회 JDBC
	 * @return
	 */
	//agency 목록 가져오기
	public ArrayList<AgencyDTO> agencylist() {
		
		try {
			
			String sql = "select * from tblagency";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<AgencyDTO> list = new ArrayList<AgencyDTO>();
			
			while (rs.next()) {
				
				AgencyDTO dto = new AgencyDTO();
				
				dto.setAgency(rs.getString("agency"));
				dto.setAgencyurl(rs.getString("agencyurl"));
				dto.setAgencyseq(rs.getInt("agencyseq"));
				
				list.add(dto);
			}	
			return list;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 관리자 메인 페이지 - 좋아요 순으로 자격증 3개를 조회하는 메소드
	 * @return
	 */
	public ArrayList<HashMap<String, String>> getLikeTop() {
		
		try {
			
			String sql = "SELECT * FROM (SELECT a.*, rownum AS rnum FROM (SELECT crtname, likecnt FROM tblcrt ORDER BY likecnt DESC) a) WHERE rnum BETWEEN 1 AND 3";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
			
			while (rs.next()) {
				
				HashMap<String,String> map = new HashMap<String,String>();
				
				map.put("crtName", rs.getString("crtName"));
				map.put("likeCnt", rs.getString("likeCnt"));
				
				list.add(map);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("CrtDAO.getLikeTop()");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 자격증 상세조회 JDBC
	 * @param crtseq
	 * @param id
	 * @return
	 */
	public CrtDTO list(String crtseq, String id) {
		
		try {
			
			String sql = "";
			if (id == null|| id.equals("")) {
				sql = String.format("select * from vwcrt where crtseq = %s", crtseq);
			} else {
				sql = String.format("select (select count(*) from tblcrtlike where crtseq = b.crtseq and id = '%s') as crtlike, b.*  from vwcrt b where crtseq = %s", id, crtseq);
			}
			
			System.out.println("list : " + sql);
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				
				CrtDTO dto = new CrtDTO();
				
				dto.setCrtSeq(rs.getInt("crtseq"));
				dto.setCrtName(rs.getString("crtname"));
				dto.setExpiration(rs.getString("expiration"));
				dto.setIsRoutine(rs.getInt("isRoutine"));
				dto.setDifficulty(rs.getInt("difficulty"));
				dto.setLikeCnt(rs.getInt("likeCnt"));
				dto.setQualificationCate(rs.getString("qualificationCate"));
				dto.setQualification(rs.getString("qualification"));
				dto.setCrtInfo(rs.getString("crtInfo"));
				dto.setTotalCnt(rs.getInt("totalCnt"));
				dto.setJobDesc(rs.getString("jobDesc"));
				
				dto.setCrtctg(rs.getString("crtctg"));
				dto.setAgency(rs.getString("agency"));
				dto.setAgencyurl(rs.getString("agencyurl"));
				
				if (id == null) {
				} else {
					dto.setCrtlike(rs.getInt("crtlike"));
				}
				
				return dto;	
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 자격증 조회 상세페이지 - 최신 일정 조회용 JDBC
	 * @param crtseq
	 * @return
	 */
	public ArrayList<CrtSchDdayDTO> schddaylist(String crtseq) {
		
		try {
			
			String sql = "select * from vwCrtSchDday where crtseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, crtseq);
			
			rs = pstat.executeQuery();	
			
			ArrayList<CrtSchDdayDTO> list = new ArrayList<CrtSchDdayDTO>();
			
			while (rs.next()) {
				
				CrtSchDdayDTO dto = new CrtSchDdayDTO();
				
				dto.setCrtSeq(rs.getInt("crtseq"));
				dto.setCrtSchSeq(rs.getInt("crtschseq"));
				dto.setCrtSchName(rs.getString("crtschname"));
				dto.setTestRcStartDate(rs.getString("testrcstartdate"));
				dto.setTestRcEndDate(rs.getString("testrcenddate"));
				dto.setTestStartDate(rs.getString("teststartdate"));
				dto.setTestEndDate(rs.getString("testenddate"));
				dto.setTestRcDday(rs.getInt("rcdday"));
				dto.setTestDday(rs.getInt("dday"));
				
				list.add(dto);
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 자격증 조회 상세페이지 - 자주 묻는 질문 조회 JDBC
	 * @param crtseq
	 * @return
	 */
	public ArrayList<CrtFaqDTO> faqlist(String crtseq) {
		
		try {
			
			String sql = "select * from tblcrtfaq where crtseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, crtseq);
			
			rs = pstat.executeQuery();	
			
			ArrayList<CrtFaqDTO> list = new ArrayList<CrtFaqDTO>();
			
			while (rs.next()) {
				
				CrtFaqDTO dto = new CrtFaqDTO();
				
				dto.setCrtfaqseq(rs.getInt("crtfaqseq"));
				dto.setCrtfaqtitle(rs.getString("crtfaqtitle"));
				dto.setCrtfaqcontent(rs.getString("crtfaqcontent"));
				
				list.add(dto);
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 자격증 조회 상세페이지 - 관련 교재 좋아요순 조회 JDBC
	 * @param crtseq
	 * @return
	 */
	public ArrayList<CrtBookLikeDescDTO> booklist(String crtseq) {
		
		try {
			
			String sql = "select * from vwBookLikeDesc where crtseq=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, crtseq);
			
			rs = pstat.executeQuery();	
			
			ArrayList<CrtBookLikeDescDTO> list = new ArrayList<CrtBookLikeDescDTO>();
			
			while (rs.next()) {
				
				com.project.jr.crt.model.CrtBookLikeDescDTO dto = new com.project.jr.crt.model.CrtBookLikeDescDTO();
				
				dto.setCrtseq(rs.getInt("crtseq"));
				dto.setBookseq(rs.getInt("bookseq"));
				dto.setBookname(rs.getString("bookname"));
				dto.setBooklike(rs.getInt("booklike"));
				dto.setBookimg(rs.getString("bookimg"));
				
				list.add(dto);
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 자격증 조회 상세페이지 - 응시료 조회 JDBC
	 * @param crtseq
	 * @return
	 */
	public ArrayList<CrtPayDTO> paylist(String crtseq) {
		
		try {
			
			String sql = "select * from vwCrtPay where crtseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, crtseq);
			
			rs = pstat.executeQuery();	
			
			ArrayList<CrtPayDTO> list = new ArrayList<CrtPayDTO>();
			
			while (rs.next()) {
				
				CrtPayDTO dto = new CrtPayDTO();
				
				dto.setCrtseq(rs.getInt("crtseq"));
				dto.setCrtname(rs.getString("crtname"));
				dto.setCrtTestSeq(rs.getInt("crttestseq"));
				dto.setCrtTestName(rs.getString("crttestname"));
				dto.setCrtTestTypeSeq(rs.getInt("crttesttypeseq"));
				dto.setExampay(rs.getInt("exampay"));
				
				list.add(dto);
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 자격증 조회 상세페이지 - 합격률 조회 JDBC
	 * @param crtseq
	 * @return
	 */
	public CrtPassRateDTO passrate(String crtseq) {
		
		try {
			
			String sql = "select * from vwCrtPassRate where crtseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, crtseq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				CrtPassRateDTO dto = new CrtPassRateDTO();
				
				dto.setCrtseq(rs.getInt("crtseq"));
				dto.setCrtPassRateSeq(rs.getInt("crtpassrateseq"));
				dto.setStarein18(rs.getInt("Starein18"));
				dto.setStarein19(rs.getInt("Starein19"));
				dto.setStarein20(rs.getInt("Starein20"));
				dto.setStarein21(rs.getInt("Starein21"));
				dto.setStarein22(rs.getInt("Starein22"));
				dto.setPassin18(rs.getInt("Passin18"));	
				dto.setPassin19(rs.getInt("Passin19"));	
				dto.setPassin20(rs.getInt("Passin20"));	
				dto.setPassin21(rs.getInt("Passin21"));	
				dto.setPassin22(rs.getInt("Passin22"));	
				
				return dto;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 자격증 조회 상세페이지 - 관련 학원 조회 JDBC
	 * @param crtseq
	 * @return
	 */
	public ArrayList<CrtAcademyDTO> acamedylist(String crtseq) {
		
		try {
			
			String sql = "select * from vwCrtAcademy where crtseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, crtseq);
			
			rs = pstat.executeQuery();	
			
			ArrayList<CrtAcademyDTO> list = new ArrayList<CrtAcademyDTO>();
			
			while (rs.next()) {
				
				CrtAcademyDTO dto = new CrtAcademyDTO();
				
				dto.setCrtseq(rs.getInt("crtseq"));
				dto.setAcademyseq(rs.getInt("academyseq"));
				dto.setAcademyName(rs.getString("academyName"));
				dto.setAcademyStar(rs.getInt("academyStar"));
				dto.setAcademylocation(rs.getString("academylocation"));
				dto.setEduName(rs.getString("eduName"));
				dto.setEduRcStartDate(rs.getString("eduRcStartDate"));
				dto.setEduRcEndDate(rs.getString("eduRcEndDate"));
				dto.setEduStartDate(rs.getString("eduStartDate"));
				dto.setEduEndDate(rs.getString("eduEndDate"));
				dto.setEduLink(rs.getString("eduLink"));
				
				list.add(dto);
			}	
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 자격증 조회 상세페이지 - 좋아요 추가 JDBC
	 * @param dto
	 * @return
	 */
	public int addliked(CrtLikeDTO dto) {
		
		try {
			
			String sql = "insert into tblCrtLike (crtLikeSeq, crtSeq, id) values (crtLikeSeq.nextVal, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, dto.getCrtSeq());
			pstat.setString(2, dto.getId());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 자격증 조회 상세페이지 - 좋아요 확인 JDBC
	 * @param dto
	 * @return
	 */
	public int isliked(CrtLikeDTO dto) {
		
		try {
			
			String sql = "select * from tblCrtLike where crtseq = ? and id = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, dto.getCrtSeq());
			pstat.setString(2, dto.getId());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * 자격증 조회 상세페이지 - 좋아요 삭제 JDBC
	 * @param dto
	 * @return
	 */
	public int delliked(CrtLikeDTO dto) {

		try {
			
			String sql = "delete from tblCrtLike where crtseq = ? and id= ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, dto.getCrtSeq());
			pstat.setString(2, dto.getId());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 메인 페이지 - 응시자수 순으로 자격증 100개를 조회하는 메소드
	 * @return
	 */
	public ArrayList<CrtDTO> getTop100() {
		
		try {
			
			String sql = "SELECT * FROM vwcrttop";
				
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			ArrayList<CrtDTO> list = new ArrayList<CrtDTO>();
			
			while (rs.next()) {
				
				CrtDTO dto = new CrtDTO();
				
				dto.setCrtSeq(rs.getInt("crtseq"));
				dto.setCrtName(rs.getString("crtname"));
				dto.setAgency(rs.getString("agency"));
				dto.setTestRcStartDate(rs.getString("testrcstartdate"));
				dto.setTestStartDate(rs.getString("teststartdate"));
				dto.setRound(rs.getString("round"));
				dto.setDdDay(rs.getInt("dday"));
			
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("CrtDAO.getTop100()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 나의자격증 검색 autocomplet JDBC
	 * @param searchWord
	 * @return
	 */
	public ArrayList<String> search(String searchWord) {
		
		try {

			String sql = "select crtName from tblCrt where regexp_like(crtName, ?, 'i')";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, searchWord);

			rs = pstat.executeQuery();
			ArrayList<String> result=new ArrayList<String>();
			
			
			while (rs.next()) {
				
				String name=rs.getString("crtName");
				result.add(name);
				
			}
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		return null;
	}

	/**
	 * 자격증 시퀀스 출력 JDBC
	 * @param crtName 자격증이름
	 * @return
	 */
	public int crtNameCh(String crtName) {

		try {

			String sql = "select crtSeq from tblCrt where crtName = ? ";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, crtName);

			rs = pstat.executeQuery();

			if (rs.next()) {
				return rs.getInt("crtSeq");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 나의자격증 insert JDBC
	 * @param id 
	 * @param crtSeq
	 * @param date
	 * @return
	 */
	public int setMyCrt(String id, int crtSeq, String date) {

		try {
			
			String sql = "insert into tblMyCrt (myCrtSeq, id, crtSeq, getDate, regdate)\r\n"
					+ "		values (myCrtSeq.nextVal, ?, ?, ?, default)";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, id);
			pstat.setInt(2, crtSeq);
			pstat.setString(3, date);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

	/**
	 * 나의자격증 모든리스트 출력 JDBC
	 * @param id
	 * @return
	 */
	public ArrayList<MyCrtDTO> getMyCrt(String id) {

		try {
			
			String sql = "select \r\n"
					+ "    *\r\n"
					+ "from tblMyCrt mc\r\n"
					+ "    inner join tblCrt c\r\n"
					+ "        on mc.crtSeq = c.crtSeq\r\n"
					+ "            where mc.id=?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs=pstat.executeQuery();
			
			ArrayList<MyCrtDTO> list=new ArrayList<MyCrtDTO>();
			
			while(rs.next()) {
				MyCrtDTO dto=new MyCrtDTO();
				
				dto.setMyCrtSeq(rs.getInt("myCrtSeq"));
				dto.setCrtSeq(rs.getInt("crtSeq"));
				dto.setCrtName(rs.getString("crtName"));
				dto.setGetDate(rs.getString("getDate"));
				dto.setExpiration(rs.getString("expiration"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	/**
	 * 사용자의 id를 인자로 받아 나의 자격증 개수를 반환하는 메소드
	 * @param id
	 * @return
	 */
	public int getCount(String id) {

		try {

			String sql = "select count(*) as count from tblMyCrt where id=?";

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

	/**
	 * 나의자격증 삭제 JDBC
	 * @param seq 나의자격증 seq
	 * @return
	 */
	public int delMyCrt(int seq) {

		try {
			
			String sql = "delete from tblMyCrt where myCrtSeq = ?";
			
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return 0;
	}
	
	
	
	/**
	 * 자격증 조회/상세페이지 - 자격증 좋아요 추가 JDBC
	 * @param dto
	 * @return
	 */
	public int plusliked(CrtLikeDTO dto) {
		
		try {
			String sql = "update tblCrt set likecnt = likecnt+1 where crtseq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, dto.getCrtSeq());
			
			System.out.println("CrtDao pulsliked:" + sql);
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 자격증 조회/상세페이지 - 자격증 좋아요 삭제 JDBC
	 * @param dto
	 * @return
	 */
	public int minusliked(CrtLikeDTO dto) {
		
		try {

			String sql = String.format("update tblCrt set likecnt = likecnt - 1 where crtseq = '%s'", dto.getCrtSeq());
			System.out.println("CrtDao minusliked:" + sql);
			stat = conn.createStatement();

			return stat.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
