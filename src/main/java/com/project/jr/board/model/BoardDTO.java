package com.project.jr.board.model;

import lombok.Data;

@Data
public class BoardDTO {

	private int boardSeq;
	private String boardTitle;
	private String boardContent;
	private String id;
	private String boardWriteDate;
	private String boardLike;
	private String boardReport;
	private String boardHits;
	private String boardType;
	private String isBoardShow;
	
}
