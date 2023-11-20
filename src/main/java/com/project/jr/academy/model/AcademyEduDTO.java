package com.project.jr.academy.model;

import lombok.Data;

/**
 * 학원 정보 내의 교육 정보 DTO
 * @author eugene
 *
 */
@Data
public class AcademyEduDTO {

	private int academySeq;
	private int academyEduSeq;
	private int crtSeq;
	private String crtName;
	private String eduName;
	private String eduRcStartDate;
	private String eduRcEndDate;
	private String eduStartDate;
	private String eduEndDate;
	private String eduLink;
	
}
