<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	href="<%=request.getContextPath() %>/css/crtdetail.css">
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.0/chart.min.js"></script>
<script type="text/javascript" src="jscript/graph.js"></script>
 -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
	
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
				<h1>${dto.crtName}</h1>
				<div>
					<button class="action_btn" onclick="location.href='/jr/crt/crtlikesubmit.do?crtseq=${dto.crtSeq}&fromlike=${fromlike}&crtname=${crtname}&crtctg=${crtctg}&agency=${agency}'">
					<!-- <button class="action_btn"> -->
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
				<span>${dto.agency} | ${dto.crtctg}자격</span>
			</div>
			<hr>
			<div class="container">
				<ul class="nav nav-tabs tabMenu2">
				  <li class="nav-item" >
				    <a class="nav-link active" aria-current="page" href="#">홈</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" href="/jr/crt/crtboardlist.do?crtseq=${dto.crtSeq}&crtName=${dto.crtName}&agency=${dto.agency}&crtctg=${dto.crtctg}">자격증 후기</a>
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

			<!-- ======= About Us Section ======= -->
			<section id="about" class="about">
				<div class="container">

					<div class="row gy-4">
						<div id="counter"
							class="col-lg-5 position-relative align-self-start order-lg-last order-first boxshadow rounded">
							<div class="counter">
								<div class="container">
									<div class="row gy-3">
										<!-- <div class="col-lg-3 col-md-6"> -->
										<div class="col-6">
											<div class="counter-item text-center w-100">
												<span data-purecounter-start="0" data-purecounter-end="${cprdto.starein18}"
													data-purecounter-duration="1" class="purecounter"></span>
												<p>2022년 누적응시자(명)</p>
											</div>
										</div>
										<!-- End Stats Item -->
										<div class="col-6">
											<div class="counter-item text-center w-100">
												<span data-purecounter-start="0" data-purecounter-end="${passmap.passRate}"
													data-purecounter-duration="0.5" class="purecounter"></span>
												<p>2022년 합격률(%)</p>
											</div>
										</div>
										<!-- End Stats Item -->

									</div>
								</div>
							</div>

						</div>

						<div class="col-lg-7 content order-last order-lg-first boxshadow rounded" id="info">
							<h3>개요</h3>
							<p>${dto.crtInfo}</p>
						</div>
					</div>

				</div>
			</section>
			<!-- End About Us Section -->

			<div class="cards container ">
				<div class="card accodion-box">
					<div class="card-header">
						난이도
						<button id="mytooltip-btn" type="button" class="btn btn-secondary" data-bs-toggle="tooltip" data-bs-placement="top" title="합격률에 따라 난이도가 설정됩니다.">
  <i id="mytooltip-i" class="fa-solid fa-circle-info"></i>
</button> 
					</div>
					<div class="card-body">
						<h5 class="card-content">${dto.difficultyS}</h5>
					</div>
				</div>
				<div class="card accodion-box">
					<div class="card-header">자격증 유효기간</div>
					<div class="card-body">
						<h5 class="card-content">${dto.expiration}</h5>
					</div>
				</div>
				<div class="card accodion-box">
					<div class="card-header">정기시험유무</div>
					<div class="card-body">
						<h5 class="card-content">${dto.isRoutineS}</h5>
					</div>
				</div>
				<div class="card accodion-box">
					<div class="card-header">좋아요 수</div>
					<div class="card-body">
						<h5 class="card-content">${dto.likeCntS}</h5>
					</div>
				</div>
			</div>


			<div class="crtInfo">
				<!-- ======= Frequently Asked Questions Section ======= -->
				<div class="faq">
					<div class="container">
						<div class="accodion-box">
							<div class="section-header">
								<% String crtname = (String)session.getAttribute("crtname"); %>
								<h2>ABOUT '<%=crtname %>'</h2>

							</div>

							<div class="row justify-content-center" data-aos-delay="200">
								<div class="col-lg-10">

									<div class="accordion accordion-flush" id="infolist">


										<div class="accordion-item">
											<h3 class="accordion-header">
												<button
													class="accordion-button collapsed accordion-button-size"
													type="button" data-bs-toggle="collapse"
													data-bs-target="#info-content-1">
													<i class="bi bi-question-circle question-icon"></i> 응시자격
												</button>
											</h3>
											<div id="info-content-1" class="accordion-collapse collapse"
												data-bs-parent="#faqlist">
												<div class="accordion-body accordion-body-size">
													<div>${dto.qualificationCate}</div>
													<div>${dto.qualification}</div>
												</div>
											</div>
										</div>
										<!-- # Faq item-->

										<div class="accordion-item">
											<h3 class="accordion-header">
												<button class="accordion-button collapsed" type="button"
													data-bs-toggle="collapse" data-bs-target="#info-content-4">
													<i class="bi bi-question-circle question-icon"></i> 응시료
												</button>
											</h3>
											<div id="info-content-4" class="accordion-collapse collapse"
												data-bs-parent="#faqlist">
												<div class="accordion-body accordion-body-size">
													<i class="bi bi-question-circle question-icon"></i>
													<div>
														<ul>
															<c:forEach items="${paylist}" var="item">
																<c:if test="${item.crtTestTypeSeq == 1}">
																	<li>필기:&nbsp;${item.exampay}원</li>
																</c:if>
																<c:if test="${item.crtTestTypeSeq == 2}">
																	<li>실기:&nbsp;${item.exampay}원</li>
																</c:if>
															</c:forEach>
														
														</ul>
													</div>
												</div>
											</div>
										</div>
										
										<!-- # Faq item-->
										<div class="accordion-item">
											<h3 class="accordion-header">
												<button class="accordion-button collapsed" type="button"
													data-bs-toggle="collapse" data-bs-target="#info-content-6">
													<i class="bi bi-question-circle question-icon"></i> 시험과목
												</button>
											</h3>
											<div id="info-content-6" class="accordion-collapse collapse"
												data-bs-parent="#faqlist">
												<div class="accordion-body accordion-body-size">
													<i class="bi bi-question-circle question-icon"></i>
													<div>
														<ul>
															<c:forEach items="${schlist}" var="item" varStatus="status">
																<c:if test="${item.crtTestTypeSeq == 1}">
																	<li>필기:&nbsp;${item.testSubject}원 (${status.count })</li>
																</c:if>
																<c:if test="${item.crtTestTypeSeq == 2}">
																	<li>실기:&nbsp;${item.testSubject}원 (${status.count })</li>
																</c:if>
															</c:forEach>
														
														</ul>
													</div>
												</div>
											</div>
										</div>
										
										<!-- # Faq item-->
										<div class="accordion-item">
											<h3 class="accordion-header">
												<button class="accordion-button collapsed" type="button"
													data-bs-toggle="collapse" data-bs-target="#info-content-7">
													<i class="bi bi-question-circle question-icon"></i> 문제형식
												</button>
											</h3>
											<div id="info-content-7" class="accordion-collapse collapse"
												data-bs-parent="#faqlist">
												<div class="accordion-body accordion-body-size">
													<i class="bi bi-question-circle question-icon"></i>
													<div>
														<ul>
															<c:forEach items="${schlist}" var="item">
																<c:if test="${item.crtTestTypeSeq == 1}">
																	<li>필기:&nbsp;${item.questionType}</li>
																</c:if>
																<c:if test="${item.crtTestTypeSeq == 2}">
																	<li>실기:&nbsp;${item.questionType}</li>
																</c:if>
															</c:forEach>
														
														</ul>
													</div>
												</div>
											</div>
										</div>
										
										<!-- # Faq item-->
										<div class="accordion-item">
											<h3 class="accordion-header">
												<button class="accordion-button collapsed" type="button"
													data-bs-toggle="collapse" data-bs-target="#info-content-8">
													<i class="bi bi-question-circle question-icon"></i> 문제수 및 시험시간
												</button>
											</h3>
											<div id="info-content-8" class="accordion-collapse collapse"
												data-bs-parent="#faqlist">
												<div class="accordion-body accordion-body-size">
													<i class="bi bi-question-circle question-icon"></i>
													<div>
														<ul>
															<c:forEach items="${schlist}" var="item">
																<c:if test="${item.crtTestTypeSeq == 1}">
																	<li>필기:&nbsp;${item.qustionNum}문제, ${item.testTime}</li>
																</c:if>
																<c:if test="${item.crtTestTypeSeq == 2}">
																	<li>실기:&nbsp;${item.qustionNum}문제, ${item.testTime}</li>
																</c:if>
															</c:forEach>
														
														</ul>
													</div>
												</div>
											</div>
										</div>
										
										<!-- # Faq item-->
										<div class="accordion-item">
											<h3 class="accordion-header">
												<button class="accordion-button collapsed" type="button"
													data-bs-toggle="collapse" data-bs-target="#info-content-11">
													<i class="bi bi-question-circle question-icon"></i> 합격기준
												</button>
											</h3>
											<div id="info-content-11" class="accordion-collapse collapse"
												data-bs-parent="#faqlist">
												<div class="accordion-body accordion-body-size">
													<i class="bi bi-question-circle question-icon"></i>
													<div>
														<ul>
															<c:forEach items="${schlist}" var="item">
																<c:if test="${item.crtTestTypeSeq == 1}">
																	<li>필기: ${item.passLine}문제</li>
																</c:if>
																<c:if test="${item.crtTestTypeSeq == 2}">
																	<li>실기:&nbsp;${item.passLine}문제</li>
																</c:if>
															</c:forEach>
														
														</ul>
													</div>
												</div>
											</div>
										</div>
										
										
										<!-- # Faq item-->
										<div class="accordion-item">
											<h3 class="accordion-header">
												<button class="accordion-button collapsed" type="button"
													data-bs-toggle="collapse" data-bs-target="#info-content-9">
													<i class="bi bi-question-circle question-icon"></i> 시험별 유효기간
												</button>
											</h3>
											<div id="info-content-9" class="accordion-collapse collapse"
												data-bs-parent="#faqlist">
												<div class="accordion-body accordion-body-size">
													<i class="bi bi-question-circle question-icon"></i>
													<div>
														<ul>
															<c:forEach items="${schlist}" var="item">
																<c:if test="${item.crtTestTypeSeq == 1}">
																	<li>필기:&nbsp;합격일 기준 ${item.expiryDate}이내이며 이 기간 내에 실기시험 접수가 가능합니다.</li>
																</c:if>
															</c:forEach>
														
														</ul>
													</div>
												</div>
											</div>
										</div>
										
										
										
										
										
										
										<div class="accordion-item">
											<h3 class="accordion-header">
												<button class="accordion-button collapsed" type="button"
													data-bs-toggle="collapse" data-bs-target="#info-content-2">
													<i class="bi bi-question-circle question-icon"></i> 최신 자격증
													시험 일정
												</button>
											</h3>
											<div id="info-content-2" class="accordion-collapse collapse"
												data-bs-parent="#faqlist">
												<div class="accordion-body accordion-body-size">
													<div>
														<ul>
															<c:forEach items="${daylist}" var="item" begin="0" end="1">
															<li>${item.crtSchName}&nbsp;(시험접수일:&nbsp;${item.testRcStartDate})</li>
															</c:forEach>
														</ul>
													</div>
												</div>
											</div>
										</div>
										<!-- # Faq item-->
										
										<!-- # Faq item-->
										<div class="accordion-item">
											<h3 class="accordion-header">
												<button class="accordion-button collapsed" type="button"
													data-bs-toggle="collapse" data-bs-target="#info-content-5">
													<i class="bi bi-question-circle question-icon"></i> 관련 직무내용
												</button>
											</h3>
											<div id="info-content-5" class="accordion-collapse collapse"
												data-bs-parent="#faqlist">
												<div class="accordion-body accordion-body-size">
													<i class="bi bi-question-circle question-icon"></i>
													<div>${dto.jobDesc}</div>
												</div>
											</div>
										</div>
										<!-- # Faq item-->

									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- End Frequently Asked Questions Section -->
			</div>

			<div class="crtqna">
				<!-- ======= Frequently Asked Questions Section ======= -->
				<div id="faq" class="faq">
					<div class="container">
						<div class="accodion-box">
							<div class="section-header">
								<h2>자주 묻는 질문</h2>

							</div>

							<div class="row justify-content-center" data-aos-delay="200">
								<div class="col-lg-10">

									<div class="accordion accordion-flush" id="faqlist">
										<c:choose>
											<c:when test="${not empty faqlist}">
												<c:forEach items="${faqlist}" var="item" varStatus="status">
												<div class="accordion-item">
													<h3 class="accordion-header">
														<button class="accordion-button collapsed" type="button"
															data-bs-toggle="collapse" data-bs-target="#faq-content-${status.count}">
															<i class="bi bi-question-circle question-icon"></i> 
															${item.crtfaqtitle}
														</button>
													</h3>
													<div id="faq-content-${status.count}" class="accordion-collapse collapse"
														data-bs-parent="#faqlist">
														<div class="accordion-body accordion-body-size">${item.crtfaqcontent}</div>
													</div>
												</div>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<div class="faq-result-empty">
														<img src="<%=request.getContextPath() %>/resources/img/expert.png">
														<p>자주 묻는 질문! FAQ를 확인해보세요! 자격증 전문가가 늘 대기 중입니다.</p>
												</div>
											</c:otherwise>
										</c:choose>
										
										<!-- # Faq item-->
 									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- End Frequently Asked Questions Section -->
			</div>
			
			
			<div class="container">
				<section class="">
					<div class="section-header accodion-box">
						<h2> 연도 별 <%=crtname %> 합격자 추이</h2>
						<canvas id="line-chart" width="200" height="100"></canvas>
					</div>
				</section>
			</div>
			
			<div class="container">
					<div class="section-header accodion-box">
						<h2><%=crtname %> 교재 추천</h2>
						
						<div id="book-width" class="card book-flex" >
						<c:choose>
						<c:when test="${not empty booklist}">
						<c:forEach items="${booklist}" var="item" begin="0" end="2" varStatus="status">
							<div class="bookimg">
							  <a href="/jr/crt/crtlist.do"><img src="${item.bookimg}" class="card-img-top" ></a>
							  <div class="card-body">
							  	
							    <p class="card-title"><a href="/jr/crt/crtlist.do">${item.bookname}</a></p>
							    <p class="card-text">❤좋아요 : ${item.booklike }</p>
							  </div>
						  	</div>
						</c:forEach>
						</c:when>
						<c:otherwise>
							<div class="faq-result-empty">
														<img src="<%=request.getContextPath() %>/resources/img/expert.png">
														<p>데이터를 준비 중입니다.</p>
												</div>
						</c:otherwise>
						</c:choose>
						</div>
						
					</div>
			</div>
			
			<div class="container">
				<section>
					<div class="section-header accodion-box">
						<h2><%=crtname %> 학원 추천</h2>
							<div class="academy-flex">
							
							<c:forEach items="${academylist}" var="item" begin="0" end="2" varStatus="status">
							<div class="card" onclick="window.open('${item.eduLink}');">
							  <div class="card-header" style="font-size:20px;">
							    ${item.academyName} <small>(평점:${item.academyStar})</small>
							  </div>
							  <div class="card-body">
							    <p class="card-title">${item.eduName}</p>
							    <div class="academy-bottom">
							    <p class="card-text">모집기간 : ${item.eduRcStartDate} ~ ${item.eduRcEndDate}</p>
							    <p class="card-text">교육기간 : ${item.eduStartDate} ~ ${item.eduEndDate}</p>
							  	</div>
							  </div>
							</div>
							</c:forEach>
							</div>
					</div>
				</section>
			</div>

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
	
	$('#message').on("click" , function() {
		alert("스터디 모집 기간이 아닙니다.");
	});
	
	
	
	new Chart(document.getElementById("line-chart"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [${cprdto.starein18},${cprdto.starein19},${cprdto.starein20},${cprdto.starein21},${cprdto.starein22}],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [${cprdto.passin18},${cprdto.passin19},${cprdto.passin20},${cprdto.passin21},${cprdto.passin22}],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	
	
	
 	 $('.liketoggle').click(function() {
 		 
 		var currentClass = $(this).hasClass("fa-regular") ? "fa-regular" : "fa-solid";
		
 		// 토글하여 반대 클래스를 적용합니다.
       var newClass = currentClass === "fa-regular" ? "fa-solid" : "fa-regular";

       // 버튼의 클래스를 변경하여 색상을 토글합니다.
       $(this).removeClass(currentClass).addClass(newClass);
 		 
 	 });
 	 
 	/* /jr/crt/crtlikesubmit.do?crtseq=${dto.crtSeq}&fromlike=${fromlike} */
 	/*
 	 $('.action_btn').click(function() {
 		$.ajax({
 			type: 'POST',
 			url: '/jr/crt/crtlikesubmit.do',
 			data: {
 				crtseq: ${dto.crtSeq},
 				fromlike: ${fromlike},
 				crtctg: ${dto.crtctg},
 				crtName: ${crtname},
 				agency: ${dto.agency}
 			},
 			dataType: 'json',
 			success: function(result) {
 				if (result.result == 1) {
	 				alert("my자격증 좋아요 추가되었습니다.");
	 				location.href = '/jr/crt/crtdetail.do?seq=${crtseq}';	
 				}
 			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
 		}); 
 	 });
 	*/
 	 
 	
 	$('#counter').height($('#info').height());
 	 
	
 	 </Script>
</body>

</html>