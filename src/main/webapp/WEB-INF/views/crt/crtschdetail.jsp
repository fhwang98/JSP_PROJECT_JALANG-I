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
					<a href="/jr/crt/crtschlist.do" class="listBtn"><img
						src="<%=request.getContextPath() %>/resources/img/logo.png"></a>
				</div>
				<h1>${dto.crtSchName}</h1>
			<button class="action_btn"></button>
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
						<div
							class="col-lg-5 position-relative align-self-start order-lg-last order-first boxshadow rounded">

						</div>

						<div class="col-lg-7 content order-last order-lg-first boxshadow rounded">
							<h3>개요</h3>
							<p>${dto.crtInfo}</p>
						</div>
					</div>

				</div>
			</section>
			<!-- End About Us Section -->

			<div class="cards container ">
				<div class="card accodion-box">
					<div class="card-header">응시료</div>
					<div class="card-body">
						<h5 class="card-content">${dto.examPay}</h5>
					</div>
				</div>
				<div class="card accodion-box">
					<div class="card-header">유효기간</div>
					<div class="card-body">
						<h5 class="card-content">${dto.expiryDate}</h5>
					</div>
				</div>
				<div class="card accodion-box">
					<div class="card-header">문항수</div>
					<div class="card-body">
						<h5 class="card-content">${dto.qustionNum}</h5>
					</div>
				</div>
				<div class="card accodion-box">
					<div class="card-header">시험시간</div>
					<div class="card-body">
						<h5 class="card-content">${dto.testTime}</h5>
					</div>
				</div>
			</div>
			
			<section class="accodion-box container">
				<table class="infotable">
					
					<tr>
						<th>시험과목</th>
						<td>소프트웨어 설계, 소프트웨어 개발, 데이터베이스 구축, 프로그래밍 언어 활용, 정보시스템 구축관리</td>
					</tr>
					<tr>
						<th>합격기준</th>
						<td>매 과목 100점을 만점으로 하여 40점 이상, 전 과목 평균 60점 이상</td>
					</tr>
					<tr>
						<th>문제형식</th>
						<td>객관식 4지 택일형</td>
					</tr>
					
				</table>
			
			
			</section>
			
			
			
			<div class="crtqna"> 
				<!-- ======= Frequently Asked Questions Section ======= -->
<!-- 
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
	-->		
				<!-- End Frequently Asked Questions Section -->
			</div>
			
			<div class="container">
				<section class="">
					<div class="section-header accodion-box">
						<% String crtname = (String)session.getAttribute("crtname"); %>
						<h2> 연도 별 <%=crtname %> 합격자 추이</h2>
						<canvas id="line-chart" width="200" height="100"></canvas>
					</div>
				</section>
			</div>
			
			<div class="container">
					<div class="section-header accodion-box">
						<h2><%=crtname %> 교재 추천</h2>
						
						<div id="book-width" class="card book-flex" >
						<c:forEach items="${booklist}" var="item" begin="0" end="2" varStatus="status">
							<div class="bookimg">
							  <a href="/jr/crt/crtlist.do"><img src="${item.bookimg}" class="card-img-top" ></a>
							  <div class="card-body">
							  	
							    <p class="card-title"><a href="/jr/crt/crtlist.do">${item.bookname}</a></p>
							    <p class="card-text">❤좋아요 : ${item.booklike }</p>
							  </div>
						  	</div>
						</c:forEach>
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
							  <div class="card-header">
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
	
	
 	 </Script>
</body>

</html>