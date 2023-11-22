package com.project.jr.faq.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.jr.faq.model.FAQDTO;
import com.project.jr.main.DBUtil;

/**
 * @author 이도훈
 * FAQ 데이터베이스 관련 작업을 수행하는 DAO 클래스입니다.
 */
public class FAQAdminDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * 생성자에서 데이터베이스 연결을 수행합니다.
     */
    public FAQAdminDAO() {
        this.conn = DBUtil.open();
    }

    /**
     * FAQ 목록을 조회하는 메서드입니다.
     * @return FAQDTO 객체를 담고 있는 ArrayList
     */
    public ArrayList<FAQDTO> list() {

        try {

            String sql = "select * from tblFaq";

            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            ArrayList<FAQDTO> list = new ArrayList<FAQDTO>();

            while (rs.next()) {

                FAQDTO dto = new FAQDTO();

                dto.setFaqSeq(rs.getString("faqSeq"));
                dto.setFaqTitle(rs.getString("faqtitle"));
                dto.setFaqContent(rs.getString("faqContent"));
                dto.setFaqWriteDate(rs.getString("faqWriteDate"));

                list.add(dto);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * FAQ 상세 정보를 조회하는 메서드입니다.
     * @param faqSeq 조회할 FAQ의 고유 번호
     * @return FAQDTO 객체
     */
    public FAQDTO detail(String faqSeq) {

        try {

            String sql = "select * from tblfaq where faqSeq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, faqSeq);

            rs = pstat.executeQuery();

            if (rs.next()) {

                FAQDTO dto = new FAQDTO();

                dto.setFaqSeq(rs.getString("faqSeq"));
                dto.setFaqTitle(rs.getString("faqtitle"));
                dto.setFaqContent(rs.getString("faqContent"));
                dto.setFaqWriteDate(rs.getString("faqWriteDate"));

                return dto;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * FAQ 정보를 수정하는 메서드입니다.
     * @param dto 수정할 FAQDTO 객체
     * @return 수정 성공 여부 (1: 성공, 0: 실패)
     */
    public int edit(FAQDTO dto) {

        try {

            String sql = "update tblfaq set faqtitle = ?, faqContent = ? where faqSeq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getFaqTitle());
            pstat.setString(2, dto.getFaqContent());
            pstat.setString(3, dto.getFaqSeq());

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * FAQ를 삭제하는 메서드입니다.
     * @param faqSeq 삭제할 FAQ의 고유 번호
     * @return 삭제 성공 여부 (1: 성공, 0: 실패)
     */
    public int del(String faqSeq) {

        try {

            String sql = "delete from tblfaq where faqSeq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, faqSeq);

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
