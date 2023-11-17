<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>자랑이</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="<%=request.getContextPath() %>/resources/img/favicon.ico" rel="icon">
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
	.teltext {
		display: flex;
	}
	
	.teltext > span{
		margin: 10px 10px;
	}
  </style>
  
  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
  </head>

  <body>

  <%@ include file="/WEB-INF/views/inc/header.jsp" %>

  <!-- main -->
	<!-- ======= Breadcrumbs ======= -->
		<div class="breadcrumbs">
			<div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/backgroundImg2.png');">
				<div class="container position-relative">
					<div class="row d-flex justify-content-center">
						<div class="col-lg-6 text-center">
							<h2>아이디찾기</h2>
						</div>
					</div>
				</div>
			</div>
			<nav>
				<div class="container">
					<ol>
						<li><a href="/jr/index.do">Home</a></li>
						<li>아이디찾기</li>
					</ol>
				</div>
			</nav>
		</div>
		<!-- End Breadcrumbs -->
  		
  		
  		<!-- ======= Get a Quote Section ======= -->
		<section id="get-a-quote" class="get-a-quote">

			<div class="container" data-aos="fade-up">

				<div class="row g-0" style="display: flex; justify-content: center;">

					<%-- <div class="col-lg-5 quote-bg" style="background-image: url(<%=request.getContextPath() %>/resources/img/quote-bg.jpg);"></div> --%>

					<div class="col-lg-7" style="width: 500px;">
						<div class="row align-items-center justify-content-between">
		                	<a class="navbar-brand h1 text-center">
		                    	<span class="text-dark h4">아이디찾기</span>                 
		                	</a>
	            		</div>
						<form action="/jr/user/finduserid.do" method="POST">
		                	<div class="form-group">
			               		<label for="name" class="form-label mt-4">이름</label>
			                    <input type="text" name="name" class="form-control" id="name" aria-describedby="idHelp" placeholder="이름">
			                </div>
							<div class="form-group">
			               		<label for="phoneNum" class="form-label mt-4">핸드폰번호</label>
			               		<div class="teltext">
				                    <input type="text" name="phoneNum1" class="form-control" id="phoneNum1" aria-describedby="emailHelp" value="010" required>
				                    <span> - </span>
				                    <input type="text" name="phoneNum2" class="form-control" id="phoneNum2" aria-describedby="emailHelp" placeholder="가운데 자리" required>
				                    <span> - </span>
				                    <input type="text" name="phoneNum3" class="form-control" id="phoneNum3" aria-describedby="emailHelp" placeholder="마지막 자리" required>
			               		<!-- 
			               		</div>
			                      휴대폰 번호를 입력하세요.
							    </div> 
							    -->
							    </div>
						    </div>
							<br>
							<div class="d-grid gap-2">
			                    <button type="submit" class="btn btn-primary btn-lg">아이디 찾기</button>
			                </div>
						</form>
					</div>
				</div>
			</div>
		</section>
		<!-- End Get a Quote Section -->
  
  
  

	<!-- /main -->
	
	<!-- ======= Footer ======= -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp" %>
	<!-- End Footer -->
	
	<a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>
	
	<div id="preloader"></div>
	
	<%-- 
	<%@ include file="/WEB-INF/views/inc/ad.jsp" %>
	<%@ include file="/WEB-INF/views/inc/side.jsp" %> 
	--%>
	
	<Script>
		
	</Script>


</body>

</html>