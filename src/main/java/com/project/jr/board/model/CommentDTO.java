package com.project.jr.board.model;

/**
 * 
 * @author oseunghyeon
 * 댓글 정보를 담는 데이터 전송 객체 (DTO) 클래스입니다.
 */
public class CommentDTO {
	
	private int commentSeq;
	private int boardSeq;
	private String id;
	private String commentContent;
	private String commentWDate;
	private String commentLike;
	private String commentReport;
	private String isCommentShow;
	public int getCommentSeq() {
		return commentSeq;
	}
	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
	}
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int bseq) {
		this.boardSeq = bseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentWDate() {
		return commentWDate;
	}
	public void setCommentWDate(String commentWDate) {
		this.commentWDate = commentWDate;
	}
	public String getCommentLike() {
		return commentLike;
	}
	public void setCommentLike(String commentLike) {
		this.commentLike = commentLike;
	}
	public String getCommentReport() {
		return commentReport;
	}
	public void setCommentReport(String commentReport) {
		this.commentReport = commentReport;
	}
	public String getIsCommentShow() {
		return isCommentShow;
	}
	public void setIsCommentShow(String isCommentShow) {
		this.isCommentShow = isCommentShow;
	}
	@Override
	public String toString() {
		return "CommentDTO [commentSeq=" + commentSeq + ", boardSeq=" + boardSeq + ", id=" + id + ", commentContent="
				+ commentContent + ", commentWDate=" + commentWDate + ", commentLike=" + commentLike
				+ ", commentReport=" + commentReport + ", isCommentShow=" + isCommentShow + "]";
	}
	
	
	

}
