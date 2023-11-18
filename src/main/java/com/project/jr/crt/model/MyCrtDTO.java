package com.project.jr.crt.model;

import lombok.Data;
import lombok.ToString;

/**
 * 나의 자격증 DTO
 *
 */

@Data
@ToString
public class MyCrtDTO {
	private int myCrtSeq;
	private String id;
	private int crtSeq;
	private String getDate;
	private String regdate;
	
	private String crtName;
	private String expiration;
	
}
