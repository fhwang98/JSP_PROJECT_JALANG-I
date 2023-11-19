package com.project.jr.crt.model;

import lombok.Data;
/**
 * 자격증 후기 게시판 DTO
 */
@Data
public class CrtBoardDTO {
	private int crtBoardSeq;
	private String crtBoardTitle;
	private String crtBoardContent;
	private String id;
	private int crtSeq;
	private String crtboardWriteDate;
	private int crtboardLike;
	private int crtboardReport;
	private int crtboardHits;
	private int iscrtBoardShow;
	
	private int isnew;
	private int ccnt;
}
