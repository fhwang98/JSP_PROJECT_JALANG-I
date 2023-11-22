package com.project.jr.crt.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.project.jr.crt.model.CrtSchAdminDTO;
import com.project.jr.main.DBUtil;

/**
 * @author 이도훈
 * Certificate (CRT) 시행 관리자 DAO 클래스입니다.
 */
public class CrtSchAdminDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * 생성자: 데이터베이스 연결을 수행합니다.
     */
    public CrtSchAdminDAO() {
        this.conn = DBUtil.open();
    }

    /**
     * Certificate (CRT) 시행 정보 목록을 가져옵니다.
     *
     * @param map 검색 조건 및 페이징 정보를 담은 HashMap
     * @return Certificate (CRT) 시행 정보 목록(ArrayList)
     */
    public ArrayList<CrtSchAdminDTO> list(HashMap<String, String> map) {

        int begin = Integer.parseInt(map.get("begin"));
        int end = Integer.parseInt(map.get("end"));

        try {

            String where = "";

            if (map.get("search").equals("y")) {
                where = String.format("where %s like '%%%s%%'",
                        map.get("column"),
                        map.get("word"));
            }

            String sql = String.format("SELECT * FROM (SELECT u.*, rownum as rnum FROM vwCrtSchDetails u %s) where rnum between %s and %s", where, map.get("begin"), map.get("end"));

            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            ArrayList<CrtSchAdminDTO> list = new ArrayList<CrtSchAdminDTO>();

            while (rs.next()) {

                //번호, 자격증시험명, 회차, 시행기관, 유형, 접수시작일, 시험일을 출력한다.

                CrtSchAdminDTO dto = new CrtSchAdminDTO();

                dto.setCrtSchSeq(rs.getInt("crtSchSeq"));
                dto.setCrtTestName(rs.getString("crtTestName"));
                dto.setCrtName(rs.getString("crtName"));
                dto.setRound(rs.getString("round"));
                dto.setAgency(rs.getString("agency"));
                dto.setCrtTestType(rs.getString("crtTestType"));
                dto.setTestRcEndDate(rs.getString("testRcEndDate"));
                dto.setTestStartDate(rs.getString("testStartDate"));

                list.add(dto);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Certificate (CRT) 시행 정보의 총 개수를 반환합니다.
     *
     * @return Certificate (CRT) 시행 정보의 총 개수
     */
    public int getTotalCount() {

        try {

            String sql = "SELECT count(*) as cnt FROM vwCrtSchDetails";

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
     * Certificate (CRT) 시행 상세 정보를 가져옵니다.
     *
     * @param crtSchSeq Certificate (CRT) 시행 일련번호
     * @return Certificate (CRT) 시행 상세 정보(CrtSchAdminDTO)
     */
    public CrtSchAdminDTO detail(String crtSchSeq) {

        try {

            String sql = "select * from vwCrtSchDetails where crtSchSeq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, crtSchSeq);

            rs = pstat.executeQuery();

            CrtSchAdminDTO dto = new CrtSchAdminDTO();

            if (rs.next()) {

                //자격증시험명, 회차, 시행기관, 접수시작날짜, 접수종료날짜, 시험일, 합격자발표일을 출력한다.
                dto.setCrtSchSeq(rs.getInt("crtSchSeq"));
                dto.setCrtTestName(rs.getString("crtTestName"));
                dto.setRound(rs.getString("round"));
                dto.setAgency(rs.getString("agency"));
                dto.setTestRcStartDate(rs.getString("testRcStartDate"));
                dto.setTestRcEndDate(rs.getString("testRcEndDate"));
                dto.setTestStartDate(rs.getString("testStartDate"));
                dto.setTestEndDate(rs.getString("testEndDate"));
                dto.setPassDay(rs.getString("passDay"));
                dto.setCrtSchSeq(rs.getInt("crtSchSeq"));
                dto.setCrtName(rs.getString("crtName"));

                return dto;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Certificate (CRT) 시행 정보를 수정합니다.
     *
     * @param dto 수정할 Certificate (CRT) 시행 정보(CrtSchAdminDTO)
     * @return 데이터베이스에 적용된 행의 수
     */
    public int edit(CrtSchAdminDTO dto) {

        try {

            String sql = "UPDATE tblCrtSch SET round = ?, testRcStartDate = ?, testRcEndDate = ?, testStartDate = ?, testEndDate = ?, passDay = ? WHERE crtSchSeq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getRound());
            pstat.setString(2, dto.getTestRcStartDate());
            pstat.setString(3, dto.getTestRcEndDate());
            pstat.setString(4, dto.getTestStartDate());
            pstat.setString(5, dto.getTestEndDate());
            pstat.setString(6, dto.getPassDay());
            pstat.setInt(7, dto.getCrtSchSeq());

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
