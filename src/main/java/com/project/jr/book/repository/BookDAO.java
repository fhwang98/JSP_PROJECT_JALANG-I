package com.project.jr.book.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.project.jr.book.model.BookDTO;
import com.project.jr.main.DBUtil;

/**
 * 도서 관련 데이터베이스 액세스 객체 클래스
 * @author 이슬아
 */
public class BookDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * BookDAO 생성자
     */
    public BookDAO() {
        this.conn = DBUtil.open();
    }

    /**
     * 도서 목록 조회 메서드
     *
     * @param map 검색 조건 및 페이징을 위한 매개변수를 담은 HashMap
     * @return 도서 목록을 담은 ArrayList
     */
    public ArrayList<BookDTO> list(HashMap<String, String> map) {
        try {
            String where = "";

            if (map.get("search").equals("y")) {
                where = String.format("where b.bookName %s like '%%%s%%'", map.get("word"));
            }

            String sql = String.format("select * from (select \r\n"
                    + "    b.*,\r\n"
                    + "    c.crtName,\r\n"
                    + "    rownum as rnum\r\n"
                    + "from tblCrtByBook bb \r\n"
                    + "    inner join tblBook b \r\n"
                    + "        on bb.bookSeq = b.bookSeq\r\n"
                    + "            inner join tblCrt c\r\n"
                    + "                on bb.crtSeq = c.crtSeq %s) where rnum between %s and %s",
                    where,
                    map.get("begin"),
                    map.get("end"));

            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            ArrayList<BookDTO> list = new ArrayList<BookDTO>();

            while (rs.next()) {
                BookDTO dto = new BookDTO();
                dto.setBookseq(rs.getInt("bookSeq"));
                dto.setBookname(rs.getString("bookName"));
                dto.setPublisher(rs.getString("publisher"));
                dto.setPrice(rs.getInt("price"));
                dto.setPbDate(rs.getString("pbDate"));
                dto.setAuthor(rs.getString("author"));
                dto.setBookLike(rs.getInt("bookLike"));
                dto.setLv(rs.getInt("lv"));
                dto.setBookImg(rs.getString("bookImg"));
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
     * 전체 도서 수 조회 메서드
     *
     * @return 전체 도서 수
     */
    public int getTotalCount() {
        try {
            String sql = "select count(*) as cnt from tblBook";
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
     * 도서 상세 정보 조회 메서드
     *
     * @param seq 도서 시퀀스
     * @return 도서 정보를 담은 BookDTO 객체
     */
    public BookDTO bookinfo(String seq) {
        try {
            String sql = "select * from vwbookInfo where bookseq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            rs = pstat.executeQuery();

            if (rs.next()) {
                BookDTO dto = new BookDTO();
                dto.setBookseq(rs.getInt("bookSeq"));
                dto.setBookname(rs.getString("bookName"));
                dto.setPublisher(rs.getString("publisher"));
                dto.setPrice(rs.getInt("price"));
                dto.setPbDate(rs.getString("pbDate"));
                dto.setAuthor(rs.getString("author"));
                dto.setBookLike(rs.getInt("booklike"));
                dto.setLv(rs.getInt("lv"));
                dto.setBookImg(rs.getNString("bookImg"));
                return dto;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 도서 목차 조회 메서드
     *
     * @param seq 도서 시퀀스
     * @return 도서 목차를 담은 ArrayList
     */
    public ArrayList<BookDTO> booklist(String seq) {
        try {
            String sql = "select * from vwbooklist where bookseq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);

            rs = pstat.executeQuery();

            ArrayList<BookDTO> list = new ArrayList<BookDTO>();

            while (rs.next()) {
                BookDTO dto = new BookDTO();
                dto.setListNum(rs.getInt("listnum"));
                dto.setList(rs.getString("list"));
                dto.setTitleStep(rs.getInt("titlestep"));
                list.add(dto);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 도서 좋아요 수 업데이트 메서드
     *
     * @param seq 도서 시퀀스
     * @return 업데이트 결과 (1: 성공, 0: 실패)
     */
    public int updateLike(String seq) {
        try {
            String sql = "update tblbook set BOOKLIKE = (select BOOKLIKE from tblbook where bookseq = ?)+1 where bookseq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);
            pstat.setString(2, seq);

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 도서 목차에서 도서 시퀀스에 해당하는 목차 인덱스 리스트 조회 메서드
     *
     * @param bookseq 도서 시퀀스
     * @return 도서 목차 인덱스 리스트
     */
    public ArrayList<String> getbookindexlist(String bookseq) {
        try {
            String sql = "select indexseq from tblindex where bookseq = ? and titlestep = 0";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, bookseq);

            rs = pstat.executeQuery();

            ArrayList<String> list = new ArrayList<String>();

            while (rs.next()) {
                list.add(rs.getString("indexseq"));
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 도서 좋아요 수 상위 3개 도서 조회 메서드
     *
     * @return 도서 정보를 담은 HashMap의 ArrayList
     */
    public ArrayList<HashMap<String, String>> getLikeTop() {
        try {
            String sql = "SELECT * FROM (SELECT a.*, rownum AS rnum FROM (SELECT bookname, booklike FROM tblbook ORDER BY booklike DESC) a) WHERE rnum BETWEEN 1 AND 3";

            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

            while (rs.next()) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("bookName", rs.getString("bookName"));
                map.put("bookLike", rs.getString("bookLike"));
                list.add(map);
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 사용자가 도서를 학습 진도에 추가하는 메서드
     *
     * @param seq   사용자 시퀀스
     * @param index 목차 인덱스
     * @return 추가 결과 (1: 성공, 0: 실패)
     */
    public int insertbook(String seq, String index) {
        try {
            String sql = "insert into tblbookprgbyuser (bookprcbyuserseq, id, indexseq, learncheck) values((select max(bookprcbyuserseq) from tblbookprgbyuser)+1, ?, ?, 0)";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seq);
            pstat.setString(2, index);

            return pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

}