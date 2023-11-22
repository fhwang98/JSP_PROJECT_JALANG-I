package com.project.jr.forbidden.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.jr.forbidden.model.ForbiddenAdminDTO;
import com.project.jr.main.DBUtil;

/**
 * @author 이도훈
 * ForbiddenAdminDAO 클래스는 금지어에 관련된 데이터베이스 액세스 기능을 담당합니다.
 */
public class ForbiddenAdminDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * ForbiddenAdminDAO의 생성자입니다. 데이터베이스 연결을 수행합니다.
     */
    public ForbiddenAdminDAO() {
        this.conn = DBUtil.open();
    }

    /**
     * 금지어 목록을 조회하는 메서드입니다.
     *
     * @return 금지어 목록을 담고 있는 ArrayList
     */
    public ArrayList<ForbiddenAdminDTO> list() {

        try {

            String sql = "SELECT * FROM tblforbidden ORDER BY forbiddenSeq DESC";

            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            ArrayList<ForbiddenAdminDTO> list = new ArrayList<>();

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

    /**
     * 금지어를 추가하는 메서드입니다.
     *
     * @param dto 추가할 금지어 정보를 담고 있는 ForbiddenAdminDTO 객체
     * @return 데이터베이스에 추가된 행 수
     */
    public int add(ForbiddenAdminDTO dto) {

        try {

            String sql = "INSERT INTO tblForbidden (forbiddenSeq, forbidden) VALUES (forbiddenSeq.nextVal, ?)";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getForbidden());

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 금지어를 삭제하는 메서드입니다.
     *
     * @param forbiddenSeq 삭제할 금지어의 고유 식별자
     * @return 데이터베이스에서 삭제된 행 수
     */
    public int del(String forbiddenSeq) {

        try {

            String sql = "DELETE FROM tblForbidden WHERE forbiddenSeq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, forbiddenSeq);

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 금지어 상세 정보를 조회하는 메서드입니다.
     *
     * @param forbiddenSeq 조회할 금지어의 고유 식별자
     * @return ForbiddenAdminDTO 객체, 금지어가 존재하지 않을 경우 null 반환
     */
    public ForbiddenAdminDTO detail(String forbiddenSeq) {

        try {

            String sql = "SELECT * FROM tblForbidden WHERE forbiddenSeq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, forbiddenSeq);

            rs = pstat.executeQuery();

            ForbiddenAdminDTO dto = new ForbiddenAdminDTO();

            if (rs.next()) {

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
