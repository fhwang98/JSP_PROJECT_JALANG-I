package com.project.jr.academy.model;


import lombok.Data;

/**
 * 학원 정보 DTO
 * @author eugene
 *
 */
@Data
public class AcademyDTO {

    private int academySeq;
    private String academyName; /*학원 이름*/
    private String academyLocation;/*학원 위치*/
    private String academyTel;/*학원 번호*/
    private int academyStar;/*학원 평점*/
    
    
    private int academyEduSeq; /*교육번호*/
    private int crtSeq;
    private String eduName; /*교육명*/
    private String eduRcStartDate; /*교육모집시작일*/
    private String eduRcEndDate;/*교육모집종료일*/
    private String eduStartDate;/*교육시작일*/
    private String eduEndDate;/*교육종료일*/
    private String eduLink;/*교육링크*/
    
    private String crtName; /*자격증명*/
    
    
    private String academyStarS;
    


}
