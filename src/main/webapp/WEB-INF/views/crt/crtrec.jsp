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
<link href="<%=request.getContextPath()%>/resources/img/favicon.ico"
	rel="icon">

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<!-- <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
 -->
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&family=Nanum+Myeongjo:wght@800&family=Noto+Serif+KR:wght@500;600&display=swap"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/vendor/aos/aos.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="<%=request.getContextPath()%>/resources/css/main.css"
	rel="stylesheet">

<!-- =======================================================
  * Template Name: Logis
  * Updated: Sep 18 2023 with Bootstrap v5.3.2
  * Template URL: https://bootstrapmade.com/logis-bootstrap-logistics-website-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->


<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
<script src="https://kit.fontawesome.com/1f653a59f2.js"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/crtrec.css">

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>


</head>

<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp"%>

	<!-- main -->
	<%-- 
  <div class="breadcrumbs">
      <div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/backgroundImg2.png');">
        <div class="container position-relative">
          <div class="row d-flex justify-content-center">
            <div class="col-lg-6 text-center">
            </div>
          </div>
        </div>
      </div>
   </div>
    --%>

	<div id="crtrec-wrap">

		<div class="back_title">
			<img
				src="<%=request.getContextPath()%>/resources/img/crtrec_back_title.png">
		</div>
		<div class="toggle-btn">
			<div class="btn-group" role="group"
				aria-label="Basic radio toggle button group">

				<input type="radio" class="btn-check" name="btnradio" id="btnradio1"
					autocomplete="off" checked> <label id="job-btn"
					class="btn btn-outline" for="btnradio1">직업별 추천</label> <input
					type="radio" class="btn-check" name="btnradio" id="btnradio2"
					autocomplete="off"> <label class="btn btn-outline"
					for="btnradio2">학과별 추천</label>

			</div>
		</div>

		<div class="container rank-table-flex">
			<c:forEach items="${jobGroupList}" var="item" begin="0" end="3">
			<table class="rank-table">
				<tr>
					<th>${item.jobgroupname}</th>
				</tr>
					<c:forEach items="${item.list}" var="dto">
				<tr>
					<td><a href="/jr/crt/crtdetail.do?seq=${dto.crtseq}">${dto.crtname}</a></td>
				</tr>
					</c:forEach>
			</table>
			</c:forEach>
		</div>
		<div class="tabMenu-bx">
			<ul class="nav2 nav-tabs2 tabMenu2">
				<c:forEach items="${jobGroupList}" var="item" begin="0" end="3">
					<li class="nav-item"><a class="nav-link2">${item.jobgroupname}</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="container-color">
			<div class="container chartWrap">
				<div class="container tabMenu-chart-btn">
					<ul class="tabMenu-btn-ul">
						<li><button class="chart-btn"></button></li>
					</ul>
				</div>

				<div class="container chart-bx">
					<canvas id="line-chart" width="200" height="100"></canvas>
				</div>
			</div>
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
  
	$(document).ready(function() {
	    // 페이지 로드 후 첫 번째 탭을 선택한 상태로 만듭니다.
	    $(".nav-tabs2 li:first-child a").addClass("active");

	    // 다른 탭을 클릭할 때 활성 클래스를 업데이트합니다.
	     $(".nav-tabs2 li").click(function() {
		      $(".nav-tabs2 li a").removeClass("active");
		      $(this).find("a").addClass("active");
		      
		      
		      
		      
		      
	  });
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