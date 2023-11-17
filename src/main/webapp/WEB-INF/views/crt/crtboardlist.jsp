<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>자랑이</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="<%=request.getContextPath() %>/resources/img/favicon.ico"
	rel="icon">

<!-- Google Fonts -->
<!--  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
 -->

<!-- Vendor CSS Files -->
<link
	href="<%=request.getContextPath() %>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/resources/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/resources/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/resources/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/vendor/aos/aos.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="<%=request.getContextPath() %>/resources/css/main.css"
	rel="stylesheet">

<!-- =======================================================
  * Template Name: Logis
  * Updated: Sep 18 2023 with Bootstrap v5.3.2
  * Template URL: https://bootstrapmade.com/logis-bootstrap-logistics-website-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->

<%@ include file="/WEB-INF/views/inc/asset.jsp"%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/crtboardlist.css">
	
</head>

<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp"%>

	<!-- main -->
	<div class="breadcrumbs">
		<div class="page-header d-flex align-items-center"
			style="background-image: url('<%=request.getContextPath() %>/resources/img/backgroundImg.png');">
			<div class="container position-relative">
				<div class="row d-flex justify-content-center">
					<div class="col-lg-6 text-center"></div>
				</div>
			</div>
		</div>
	</div>
	<div>

		<div id="wrapper ">
			<div class="crtTitle container">
				<div>
					<a href="/jr/crt/crtlist.do" class="listBtn"><img
						src="<%=request.getContextPath() %>/resources/img/logo.png"></a>
				</div>
				<h1>${crtName}</h1>
				<div>
					<!-- <button class="action_btn "><i class="fa-regular fa-heart liketoggle"></i></button> -->
					<button class="action_btn" onclick="location.href='/jr/crt/crtlikesubmit.do?crtseq=${dto.crtSeq}&fromlike=${fromlike}&crtnmae=${crtName}&crtctg=${crtctg}&agency=${agency}'">
						<c:if test="${dto.crtlike == 0}">
							<i class="fa-regular fa-heart liketoggle"></i>
						</c:if>
						<c:if test="${dto.crtlike > 0}">
							<i class="fa-solid fa-heart liketoggle"></i>
						</c:if>
					</button>
				</div>
			</div>
			<div class="row crtagency container">
				<span>${agency} | ${crtctg}자격</span>
			</div>
			<hr>
			<div class="container">
				<ul class="nav nav-tabs tabMenu2">
				  <li class="nav-item" >
				    <a class="nav-link" aria-current="page" href="/jr/crt/crtdetail.do?seq=${crtseq}">홈</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link active" href="#">자격증 후기</a>
				  </li>
				  <li class="nav-item">
				  
				  <c:choose>
					<c:when test="${not empty testdaylist}">
				   	 <a class="nav-link" href="/jr/study/studyapply.do?crtseq=${dto.crtSeq}&crtName=${dto.crtName}&agency=${dto.agency}&crtctg=${dto.crtctg}">스터디 신청</a>
				  	</c:when>
				  	<c:otherwise>
				   	 <a class="nav-link" href="#!" id="message">스터디 신청</a>
				  	 </c:otherwise>
				  </c:choose>
				  
				  </li>
				</ul>
			</div>
		
		<!-- board list area -->
		<div>
		
    <section id="board-list">
        <div class="container">
            <table class="board-table">
                <thead>
                <tr>
                    <th scope="col" class="th-num">번호</th>
                    <th scope="col" class="th-subject">제목</th>
                    <th scope="col" class="th-id">작성자</th>                                     
                    <th scope="col" class="th-date">작성일</th>                                                           
                    <th scope="col" class="th-hits">조회수</th>                                                           
                    <th scope="col" class="th-like">좋아요</th>                                                           
                </tr>
                </thead>
            <tbody>
            <!-- 
            dto.private int crtBoardSeq;
				private String crtBoardTitle;
				private String crtBoardContent;
				private String id;
				private int crtSeq;
				private String crtboardWriteDate;
				private int crtboardLike;
				private int crtboardReport;
				private int crtboardHits;
				private int iscrtBoardShow;
             -->
            	<c:forEach items="${list}" var="item" varStatus="status">
            	
            	<tr>         	
            		<td>${fn:length(list) -status.index}</td>
            		<%-- <td>${status.count}</td> --%>
            		<td>
            			<%-- <a href="/jr/crt/crtdetail.do?crtSeq=${item.crtSeq}">${item.crtBoardTitle}</a> --%>
            			<a href="/jr/crt/crtboarddetail.do?crtboardseq=${item.crtBoardSeq}&crtname=${crtName}&crtseq=${crtseq}">${item.crtBoardTitle}</a>
            			<!-- 댓글 수 --> 
						<c:if test="${item.ccnt > 0}">
						<span class="comment-count">${item.ccnt}</span>
						</c:if>
						
						<!-- 새로운 글 마크 -->
						<c:if test="${item.isnew == 1}">
						<span class="is-new">new</span>
						</c:if>
            			
            		</td>
            		<td>${item.id}</td>
            		<td>${item.crtboardWriteDate}</td>
            		<td>${item.crtboardHits}</td>
            		<td>${item.crtboardLike}</td>
            	</tr>
            	
            	</c:forEach>
            </tbody>
            </table>
        </div>
        <div id="pagebar">${pagebar}</div>
    </section>
		</div>
		
		
		

		<!-- /main -->

		<!-- ======= Footer ======= -->
		<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
		<!-- End Footer -->

		<a href="#"
			class="scroll-top d-flex align-items-center justify-content-center"><i
			class="bi bi-arrow-up-short"></i></a>

		<div id="preloader"></div>

		<%@ include file="/WEB-INF/views/inc/ad.jsp"%>
		<%@ include file="/WEB-INF/views/inc/side.jsp"%>

	<Script>
	$('.liketoggle').click(function() {
		 
 		var currentClass = $(this).hasClass("fa-regular") ? "fa-regular" : "fa-solid";
		
 		// 토글하여 반대 클래스를 적용합니다.
       var newClass = currentClass === "fa-regular" ? "fa-solid" : "fa-regular";

       // 버튼의 클래스를 변경하여 색상을 토글합니다.
       $(this).removeClass(currentClass).addClass(newClass);
 		 
 	 });
	
	$('#message').on("click" , function() {
		alert("스터디 모집 기간이 아닙니다.");
	});
	
 	 </Script>
</body>

</html>