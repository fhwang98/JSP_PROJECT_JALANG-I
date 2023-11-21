package com.project.jr.board.model;

import lombok.Data;


/**
 * 
 * @author oseunghyeon
 
 * 게시글 정보를 담는 데이터 전송 객체 (DTO) 클래스
 * Board 테이블의 각 컬럼에 대응되는 멤버 변수들을 가지고 있
 */

@Data
public class BoardDTO {

	
	private int boardSeq;
	private String boardTitle;
	private String id;
	private String boardContent;
	private String boardWriteDate;
	private String boardLike;
	private String boardHits;
	private String boardReport;
	private String boardType;
	private String boardIsBoardShow;
	private String isBoardShow;
    private String ccnt;
	
	
	
	
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBoardWriteDate() {
		return boardWriteDate;
	}
	public void setBoardWriteDate(String boardWriteDate) {
		this.boardWriteDate = boardWriteDate;
	}
	public String getBoardLike() {
		return boardLike;
	}
	public void setBoardLike(String boardLike) {
		this.boardLike = boardLike;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardHits() {
		return boardHits;
	}
	public void setBoardHits(String boardHits) {
		this.boardHits = boardHits;
	}
	public String getBoardReprort() {
		return boardReport;
	}
	public void setBoardReprort(String boardReprort) {
		this.boardReport = boardReprort;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	public String getBoardIsBoardShow() {
		return boardIsBoardShow;
	}
	public void setBoardIsBoardShow(String boardIsBoardShow) {
		this.boardIsBoardShow = boardIsBoardShow;
	}
	
	
	
	
}
