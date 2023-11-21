package com.project.jr.qna.model;

import lombok.Data;



/**
 * 
 * @author oseunghyeon
 * QnaDTO 클래스는 Q&A 게시판의 데이터를 담는 모델 클래스
 * 각 변수는 데이터베이스의 컬럼과 매칭되어 해당 게시글의 정보를 저장
 * 
 */
@Data
public class QnaDTO {
	
	private int qnaSeqint;
	private int answerSeqint;
	private String qnaSeq;
	private String id;
	private String qnaTitle;
	private String qnaContent;
	private String attachFile;
	private String qnaWriteDate;
	
	
	
	
	public String getQnaSeq() {
		return qnaSeq;
	}
	public void setQnaSeq(String qnaSeq) {
		this.qnaSeq = qnaSeq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public String getAttachFile() {
		return attachFile;
	}
	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}
	public String getQnaWriteDate() {
		return qnaWriteDate;
	}
	public void setQnaWriteDate(String qnaWriteDate) {
		this.qnaWriteDate = qnaWriteDate;
	}
	
	
	
	

}
