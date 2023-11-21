package com.project.jr.academy.model;


import lombok.Data;


/**
 * AcademyDTO는 학원 및 교육 정보를 담기 위한 데이터 클래스입니다.
 * @author 이슬아
 */
@Data
public class AcademyDTO {

    /** 학원 일련번호 */
    private int academySeq;

    /** 학원 이름 */
    private String academyName;

    /** 학원 위치 */
    private String academyLocation;

    /** 학원 번호 */
    private String academyTel;

    /** 학원 평점 */
    private int academyStar;

    /** 교육 일련번호 */
    private int academyEduSeq;

    /** 교육 담당자 일련번호 */
    private int crtSeq;

    /** 교육명 */
    private String eduName;

    /** 교육 모집 시작일 */
    private String eduRcStartDate;

    /** 교육 모집 종료일 */
    private String eduRcEndDate;

    /** 교육 시작일 */
    private String eduStartDate;

    /** 교육 종료일 */
    private String eduEndDate;

    /** 교육 링크 */
    private String eduLink;

    /** 자격증명 */
    private String crtName;

    /** 학원 평점을 별표로 표현한 문자열 */
    private String academyStarS;
}
