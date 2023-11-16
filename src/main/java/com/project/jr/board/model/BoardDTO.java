package com.project.jr.board.model;


public class BoardDTO {

	
	private int boardSeq;
	private String boardTitle;
	private String id;
	private String boardContent;
	private String boardWriteDate;
	private String boardLike;
	private String boardHits;
	private String boardReprort;
	private String boardType;
	private String boardIsBoardShow;
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
		return boardReprort;
	}
	public void setBoardReprort(String boardReprort) {
		this.boardReprort = boardReprort;
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
