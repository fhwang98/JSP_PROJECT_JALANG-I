<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Logis Bootstrap Template - Index</title>
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
<style>
</style>

<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
<script src="https://kit.fontawesome.com/1f653a59f2.js" crossorigin="anonymous"></script>
  

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/studyapply.css">


</head>

<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp"%>

	<!-- main -->
	<div class="breadcrumbs">
		<div class="page-header d-flex align-items-center"
			style="background-image: url('<%=request.getContextPath() %>/resources/img/backgroundImg.jpeg');">
<!--  -->			style="background-image: url('<%=request.getContextPath() %>/resources/img/page-header.jpg');">
			<div class="container position-relative">
				<div class="row d-flex justify-content-center">
					<div class="col-lg-6 text-center"></div>
				</div>
			</div>
		</div>
	</div>
	<div>

		<div id="wrapper">
			<div class="crtTitle">
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
				    <a class="nav-link " aria-current="page" href="/jr/crt/crtdetail.do?seq=${crtseq}">홈</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" href="/jr/crt/crtboardlist.do?crtseq=${crtseq}&crtName=${crtName}&agency=${agency}&crtctg=${crtctg}">자격증 후기</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link active" href="#">스터디 신청</a>
				  </li>
				</ul>
			</div>

	<div class="container">
		<section>
			<div class="apply-header">
				<h2>스터디 신청하기</h2>
				<h5>입력하신 현재 나의 상황에 맞춰 비슷한 유형의 팀원을 시스템이 자동으로 매칭합니다.</h5>
				<hr>
				<!-- <i class="fa-light fa-circle-info"></i> -->
				<div class="info-img">
					<img src="<%=request.getContextPath() %>/resources/img/info.png">
					<p>&nbsp;스터디 신청 기간은 시험일 기준 <span class="point">100일전부터 30일전까지</span> 신청 가능합니다.</p>
				</div>
				<div class="info-img">
					<img src="<%=request.getContextPath() %>/resources/img/info.png">
					<p>&nbsp;스터디 신청현황에 따라 <span class="point">매칭 시간은 1~3일정도</span> 걸릴 수 있습니다.</p>
				</div>
				<div class="info-img">
					<img src="<%=request.getContextPath() %>/resources/img/info.png">
					<p>&nbsp;스터디 활동 기간은 <span class="point">매칭 후부터 합격자 발표일 기준으로 7일 후까지</span>입니다.</p>
				</div>
				<div class="info-img">
					<img src="<%=request.getContextPath() %>/resources/img/info.png">
					<p>&nbsp;스터디 정원은 <span class="point">4명</span>입니다.</p>
				</div>
			</div>
			<section class="form-center">
				<form action="/jr/study/studyapply.do" method="post" class="apply-form" >
			 	  <h3>「스터디 신청 폼」</h3>
				  <span class="form-semititle">스터디 모집중인 자격증 시험 목록</span>
				  <hr>
				  <div class="col-md ">
				    <div class="form-floating">
				      <select class="form-select" id="select-crtsch" name="select-crtsch">
				        
				        <c:choose>
					        <c:when test="${not empty list}">
						        <c:forEach items="${list}" var="dto">
						        	<option value="${dto.crtsch}">${dto.year}년 ${dto.schName} 시험(시험일: ${dto.day})</option>
						        </c:forEach>
					        </c:when>
					        <c:otherwise>
					        	<option value="0" selected>모집중인 시험 목록이 없습니다.</option>
				      		</c:otherwise>
				      	</c:choose>  
				      </select>
				      
				      
				      <label for="floatingSelectGrid">Recruiting List</label>
				    </div>
				    
				    <span class="form-semititle">현재 나의 상황</span>
				    <hr>
				      <p>선호하는 공부 시간대</p>
				    <div class="form-floating">
				      <select class="form-select" id="floatingSelectGrid" name="select-time">
				        <option value="0" selected>오전</option>
				        <option value="1">오후</option>
				        <option value="2">종일</option>
				      </select>
				      <label for="floatingSelectGrid">Preferred Time Zone</label>
				    </div>
				      <p>선호하는 공부 요일</p>
				    <div class="form-floating">
				      <select class="form-select" id="floatingSelectGrid" name="select-day">
				        <option value="0" selected>평일</option>
				        <option value="1">주말</option>
				      </select>
				      <label for="floatingSelectGrid">Preferred day of the week</label>
				    </div>
				      <p>자격증 관련 전공 여부</p>
				    <div class="form-floating">
				      <select class="form-select" id="floatingSelectGrid" name="select-major">
				        <option value="0" selected>비전공</option>
				        <option value="1">전공</option>
				      </select>
				      <label for="floatingSelectGrid">Major whether or not</label>
				    </div>
				  </div>
				  <div class="col-12">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
				      <label class="form-check-label" for="invalidCheck">
				        위 스터디 안내를 습득하였으며 이에 동의합니다.
				      </label>
				      <div class="invalid-feedback">
				        위 스터디 안내를 습득하였으며 이에 동의합니다.
				      </div>
				    </div>
				  </div>
				  <div>
				    <button class="btn btn-primary" type="submit">신청</button>
				  </div>
				  
				  <input type="hidden" name="crtseq" value="${crtseq}">
				</form>
			
			</section>
	
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
		
		$('#flexCheckChecked').click (function() {
			if ($('#flexCheckChecked').checked) {
				$('#applybtn').disabled = false;
			} else {
				$('#applybtn').disabled = true;
			}
		});
		
		$('#applybtn').on("click", function() {
			if ($('#select-crtsch').val() === "0") {
				alert("신청 실패하였습니다.");
			}
		});
		
		
	  	 $('.liketoggle').click(function() {
	  		 
	  		var currentClass = $(this).hasClass("fa-regular") ? "fa-regular" : "fa-solid";
			
	  		// 토글하여 반대 클래스를 적용합니다.
	        var newClass = currentClass === "fa-regular" ? "fa-solid" : "fa-regular";
	
	        // 버튼의 클래스를 변경하여 색상을 토글합니다.
	        $(this).removeClass(currentClass).addClass(newClass);
	  		 
	  	 });
  	 
		
  		</Script>
</body>

</html>