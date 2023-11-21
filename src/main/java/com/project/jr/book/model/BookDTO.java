package com.project.jr.book.model;

import lombok.Data;

/**
 * 도서 정보를 담는 DTO 클래스
 *  * @author 이슬아
 */

@Data
public class BookDTO {

    private int bookseq;
    private String bookname;
    private String publisher;
    private int price;
    private String pbDate;
    private String author;
    private int bookLike;
    private int lv;
    private String bookImg;

    private int indexSeq;
    private int listNum;
    private String list;
    private int titleStep;

    private int crtSeq;
    private String crtName;

    private String lvS;

}
