package com.project.jr.faq.model;

import lombok.Data;


/**
 * 
 * @author oseunghyeon
 /**
 * 자주 묻는 질문(FAQ) 정보를 담는 데이터 객체 클래스입니다.
 * 
 */

@Data
public class FAQDTO {
	

	private String faqSeq;
	private String faqTitle;
	private String faqContent;
	private String faqWriteDate;
	public String getFaqSeq() {
		return faqSeq;
	}
	public void setFaqSeq(String faqSeq) {
		this.faqSeq = faqSeq;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public String getFaqWriteDate() {
		return faqWriteDate;
	}
	public void setFaqWriteDate(String faqWriteDate) {
		this.faqWriteDate = faqWriteDate;
		
	}
	
	
	

}
