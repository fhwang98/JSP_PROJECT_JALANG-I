package com.project.jr.crt.model;

import lombok.Data;
/**
 * 자격증 조회 상세페이지 - 관련 교재 좋아요순 DTO
 * @author HSG
 *
 */
@Data
public class CrtBookLikeDescDTO {
	private int crtseq;
	private int bookseq;
	private String bookname;
	private int booklike;
	private String bookimg;
}

