package com.project.jr.qna.model;

import lombok.Data;

@Data
public class QnaDTO {

	private int qnaSeq;
	private String id;
	private String qnaTitle;
	private String qnaContent;
	private String qnaWriteDate;
	private int answerSeq;
	
}
