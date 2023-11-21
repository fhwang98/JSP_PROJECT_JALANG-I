package com.project.jr.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.project.jr.board.model.BoardDTO;
import com.project.jr.board.model.CommentDTO;
import com.project.jr.board.model.NoticeBoardDTO;
import com.project.jr.main.DBUtil;

/**
 * 게시판 DAO
 * @author eugene
 *
 */

/**
 * 
 * @author oseunghyeon
 *
 */
public class BoardDAO {
	
	
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	/**
	 * 게시판 DAO 생성자
	 */
	public BoardDAO() {
		this.conn = DBUtil.open();
	}
	
	/**
     * 게시판 목록을 조회하는 메서드입니다.
     *
     * @return 게시판 목록
     */
	public BoardDTO getBoard() {

		try {
			
			String seq="select * from tblBoard";
			
			stat=conn.createStatement();
			rs=stat.executeQuery(seq);
			
			
			if(rs.next()) {
				
				
				BoardDTO dto= new BoardDTO();
				
				dto.setBoardSeq(rs.getInt("boardSeq"));
				dto.setBoardTitle(rs.getString("boardTitle"));
				dto.setId(rs.getString("id"));
				dto.setBoardWriteDate(rs.getString("boardWriteDate"));
				dto.setBoardLike(rs.getString("boardlike"));
			    
			
				
				return dto;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		return null;
	}

	/**
     * 게시판 목록을 조회하는 메서드입니다.
     *
     * @return 게시판 목록
     */

	public ArrayList<BoardDTO> getList() {

		try {
			
			String seq="select * from tblBoard";
			
			stat=conn.createStatement();
			rs=stat.executeQuery(seq);
			
			ArrayList<BoardDTO> result=new ArrayList<BoardDTO>();
			
			while(rs.next()) {
				
				
				BoardDTO dto= new BoardDTO();
				
				dto.setBoardSeq(rs.getInt("boardSeq"));
				dto.setBoardTitle(rs.getString("boardTitle"));
				dto.setId(rs.getString("id"));
				dto.setBoardWriteDate(rs.getString("boardWriteDate"));
				dto.setBoardLike(rs.getString("boardLike"));
				dto.setBoardContent(rs.getString("boardContent"));
				dto.setBoardHits(rs.getString("boardHits"));			
				result.add(dto);
			}
			
			return result;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	 /**
     * 게시글 상세 정보를 조회하는 메서드입니다.
     * @return 조회된 게시글의 상세 정보
     */

	public BoardDTO getDetail(String boardSeq) {

		try {
			
			String sql = "select * from tblBoard where boardSeq = ?";
			
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, boardSeq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setBoardContent(rs.getString("boardcontent"));
				dto.setBoardLike(rs.getString("boardlike"));
				dto.setBoardSeq(rs.getInt("boardseq"));
				dto.setBoardTitle(rs.getString("boardtitle"));
				dto.setBoardWriteDate(rs.getString("boardwritedate"));
				dto.setId(rs.getString("id"));
				//dto.setBoardHits(rs.getString("boardHits"));
				
				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	/**
	 * 게시글을 추가하는 메서드입니다.
	 * @return 데이터베이스에 추가된 행의 수
	 */
	public int add(BoardDTO dto) {
		
		//queryParamNoReturn
				try {
					
					String sql = "insert into tblBoard (boardseq, boardtitle, boardContent,id, boardWriteDate, boardLike, boardReport, boardHits, boardType, isBoardShow)"
														+ "values (boardSeq.nextVal, ?, ?, ?, sysdate, 0, 0, 0, 0, 0)";
					
					System.out.println(sql);
					
					
					pstat = conn.prepareStatement(sql);
					pstat.setString(1, dto.getBoardTitle());
					pstat.setString(2, dto.getBoardContent());
					pstat.setString(3, dto.getId()); 
					
					return pstat.executeUpdate();

				} catch (Exception e) {
					e.printStackTrace();
				}
				
		return 0;
	}

	/**
	 * 게시글 수정을 위한 메서드입니다.
	 * @return 데이터베이스에 수정된 행의 수
	 */

	public BoardDTO getEdit(String id) {
		
	      try {
	            
	            String sql = "SELECT * FROM tblBoard where boardSeq = ?";
	            
	            pstat = conn.prepareStatement(sql);
	            pstat.setString(1, id);
	            
	            rs = pstat.executeQuery();
	            
	            
	            if(rs.next()) {
	               
	               BoardDTO dto = new BoardDTO();
	               
	               dto.setBoardSeq(rs.getInt("boardSeq"));
	               dto.setBoardTitle(rs.getString("BoardTitle"));
	               dto.setBoardContent(rs.getString("BoardContent"));
	               dto.setId(rs.getString("id"));
	               dto.setBoardWriteDate(rs.getString("WriteDate"));
	               dto.setBoardLike(rs.getString("boardLike"));
	               dto.setBoardReprort(rs.getString("baordReport"));
	               dto.setBoardHits(rs.getString("boardHits"));
	               dto.setBoardType(rs.getString("boardType"));
	               dto.setBoardIsBoardShow(rs.getString("boardIsboardShow"));
	               
	     
	         
	               return dto;
	            }
	            
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
		return null;
	}


	/**
	 * 게시글 수정을 위한 메서드입니다.
	 *
	 * @param dto 수정할 게시글의 정보가 담긴 BoardDTO 객체
	 * @return 데이터베이스에 수정된 행의 수
	 */
	public int editResult(BoardDTO dto) {
		

	      try {
	     String sql = "UPDATE tblBoard SET  boardSeq= 0, BoardTitle = ?, boardContent = ?, id = ?, "
	     		+ "boardWriteDate = 0, boardLike = 0, boardReport = 0, boardHits = 0, boardType = 0, isBoardShow = 0  WHERE id = ?";
		
	        pstat = conn.prepareStatement(sql);
	        
	        pstat.setString(1, dto.getBoardTitle());
	        pstat.setString(2, dto.getBoardContent());
	        pstat.setString(3, dto.getId());
	        pstat.setString(4, dto.getId());
	 
	           
	           return pstat.executeUpdate();
	      }
	      catch(Exception e) {
	    	  e.printStackTrace();
	      }
	     
		return 1;
	}


	/**
	 * 전체 게시글 수를 조회하는 메서드.
	 * @return 전체 게시글 수
	 */
	public void updateReadcount(String boardSeq) {

		
		try {
		String sql = "update tblBoard set BoardHits = boardHits +1 where boardSeq=?";
		
		pstat = conn.prepareStatement(sql);
		pstat.setString(1, boardSeq);
		
		pstat.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


/**
 *게시판 조회 하는 메서드
 * @param boardSeq
 * @return
 */

	public BoardDTO get(String boardSeq) {
	
		try {
			String sql="select tbl"
					+ "Board.*, (select id from tblUserInfo where id =tblBoard.id) as id from tblBoard where seq=?";
			
			pstat= conn.prepareStatement(sql);
			pstat.setString(1, sql);
			
			rs=pstat.executeQuery();
			
			if(rs.next()) {
				BoardDTO dto= new BoardDTO();
				
				dto.setBoardSeq(rs.getInt("boardSeq"));
				dto.setBoardTitle(rs.getString("title"));
				dto.setBoardContent(rs.getString(""));
				

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 전체 게시글 수를 조회하는 메서드.
	 *
	 * @return 전체 게시글 수
	 */
	
	public int getTotalCount() {
	      
	      try {

	         String sql = "select count(*) as cnt from tblboard";

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
	 * 페이징 처리를 위한 메서드.
	 *
	 * @param map 페이지 정보가 담긴 HashMap 객체
	 * @return 페이징 처리된 게시글 목록
	 */
	public ArrayList<BoardDTO> getList(HashMap<String, String> map) {
		
try {

	String sql = String.format("select * from (select b.*, rownum as rnum from (select * from tblBoard order by boardwritedate desc) b) where rnum between %s and %s"
															, map.get("begin")
															, map.get("end"));

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while (rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				
				dto.setBoardSeq(rs.getInt("boardSeq"));
				dto.setBoardTitle(rs.getString("boardTitle"));
				dto.setBoardHits(rs.getString("boardHits"));
				dto.setId(rs.getString("id"));
				dto.setBoardLike(rs.getString("boardLike"));
				dto.setBoardWriteDate(rs.getString("boardWriteDate"));
				
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 댓글 목록을 조회하는 메서드.
	 *
	 * @param boardSeq 조회할 게시글의 일련번호
	 * @return 댓글 목록
	 */

	public ArrayList<CommentDTO> listComment(int boardSeq) {
	
		try {
			
			String sql="select * from tblComment where boardSeq = ? order by boardSeq desc";
					
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, boardSeq);
			rs=pstat.executeQuery();
			
			
			ArrayList<CommentDTO> list=new ArrayList<CommentDTO>();
			
			while(rs.next()){
				CommentDTO dto = new CommentDTO();
				
				//System.out.println(rs.getString("commentContent"));
				dto.setCommentSeq(rs.getInt("commentSeq"));
				dto.setCommentContent(rs.getString("commentContent"));
				dto.setId(rs.getString("id"));
				dto.setBoardSeq(rs.getInt("boardSeq"));
				
				list.add(dto);
				
				
				
	
			}
			
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 관리자 메인 페이지 - 최신 공지사항 목록을 조회하는 메소드
	 * @return
	 */
public ArrayList<NoticeBoardDTO> getRecentNoticeList() {
		
		try {
			
			String sql = "SELECT * FROM (SELECT a.*, rownum AS rnum FROM tblNoticeBoard a ORDER BY noticeBoardWriteDate DESC) WHERE rnum BETWEEN 1 AND 5";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			ArrayList<NoticeBoardDTO> list = new ArrayList<NoticeBoardDTO>();
			
			while (rs.next()) {
				
				NoticeBoardDTO dto = new NoticeBoardDTO();
				
				dto.setNoticeBoardSeq(rs.getInt("noticeBoardSeq"));
				dto.setNoticeBoardTitle(rs.getString("noticeBoardTitle"));
				dto.setNoticeBoardContent(rs.getString("noticeBoardContent"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.getRecentList()");
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 관리자 메인 페이지 - 최신 신고글을 조회하는 메소드
	 * @return
	 */
	public ArrayList<BoardDTO> getRecentReportList() {
		
		try {
			
			String sql = "SELECT * FROM tblboard WHERE boardseq IN (SELECT boardseq FROM (SELECT b.*, rownum AS rnum FROM tblreportboard b ORDER BY reportboardseq DESC) WHERE rnum BETWEEN 1 AND 5)";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);	
			
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while (rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				
				dto.setBoardSeq(rs.getInt("boardSeq"));
				dto.setId(rs.getString("id"));
				dto.setBoardTitle(rs.getString("boardTitle"));
				dto.setBoardLike(rs.getString("boardLike"));
				dto.setBoardHits(rs.getString("boardHits"));
				dto.setBoardReport(rs.getString("boardReport"));
				dto.setBoardWriteDate(rs.getString("boardWriteDate"));
				dto.setIsBoardShow(rs.getString("isBoardShow"));
				
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.getRecentReportList()");
			e.printStackTrace();
		}
		
		return null;
	}

}
	     
