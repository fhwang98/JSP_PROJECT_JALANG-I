<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<!-- 교재 리스트  -->
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Logis Bootstrap Template - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="<%=request.getContextPath() %>/resources/img/favicon.png" rel="icon">
  <link href="<%=request.getContextPath() %>/resources/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="<%=request.getContextPath() %>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath() %>/resources/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="<%=request.getContextPath() %>/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath() %>/resources/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath() %>/resources/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath() %>/resources/vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="<%=request.getContextPath() %>/resources/css/main.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Logis
  * Updated: Sep 18 2023 with Bootstrap v5.3.2
  * Template URL: https://bootstrapmade.com/logis-bootstrap-logistics-website-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  <style>
	.container img {
		margin-left: 50px;
		width: 100px;
		height: 150px;
		object-fit: cover;
	}
  	#pricing .btn {
		margin-left: 10px; /* 버튼 사이의 간격 조절을 위한 마진 설정 (선택적) */
	}
  
  
  </style>
  
  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
  </head>

  <body>

  <%@ include file="/WEB-INF/views/inc/header.jsp" %>

  <!-- main -->

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs">
      <div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/backgroundImg2.png');">
        <div class="container position-relative">
          <div class="row d-flex justify-content-center">
            <div class="col-lg-6 text-center">
              <h2>교재 목록</h2>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="index.html">마이페이지</a></li>
            <li>나의 학습</li>
            <li>교재 목록</li>
          </ol>
        </div>
      </nav>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Pricing Section ======= -->
    <section id="pricing" class="pricing">
      <div class="container" data-aos="fade-up">
        <div class="row gy-2 pricing-item" data-aos="fade-up" data-aos-delay="100">
        
        
		<div class="d-flex" id="menu1">
		

  		
  		
		</div>
		<c:if test="${empty list}">
			<div class="col-md-12" >
				<h1>학습 중인 교재가 없습니다</h1>
			</div>
		</c:if>
		
		<c:if test="${not empty list}">
		<c:forEach items="${list}" var="dto">
      	<div class="col-md-3" >
        	<img src="${dto.bookImg }" class="" alt="">
        </div>
        <div class="col-md-8">
            <div class="container text-center">
			  <div class="row row-cols-1">
			    <div class="col" style="height: 50px">
			    	<h3 style="text-align: left;"><a href="/jr/study/mypage/book/detail.do?seq=${dto.bookSeq}&count=${dto.count }&name=${dto.bookName }&img=${dto.bookImg }">${dto.bookName }</a></h3>
			    </div>
			    <div class="col">
			    	<h5 style="text-align: left;">진행 률</h5>
			    </div>
			    <div class="progress" style=" padding: 0;">
  					<div class="progress-bar progress-bar-striped bg-info progress-bar-animated" role="progressbar" style="width: ${dto.count }%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">${dto.count }%</div>
				</div>
				</div>
			  </div>
		</div>
		
		<hr>
		</c:forEach>
		</c:if>
		
		
			
			
		</div>
        </div><!-- End Pricing Item -->
        <br>
        
	</section>
    
    

    <!-- ======= Horizontal Pricing Section ======= -->
    

  </main><!-- End #main -->
  
  
  

  <!-- /main -->

  <!-- ======= Footer ======= -->
  <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
  <!-- End Footer -->

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>
  
  <%@ include file="/WEB-INF/views/inc/ad.jsp" %>
  <%@ include file="/WEB-INF/views/inc/side.jsp" %>

  <Script>
  
  
  </Script>


</body>

</html>