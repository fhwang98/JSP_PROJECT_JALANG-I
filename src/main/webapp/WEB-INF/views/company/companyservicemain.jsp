<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

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
		.buttondesign{
			float: right;
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
			<div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath()%>/resources/img/page-header.jpg');">
				<div class="container position-relative">
					<div class="row d-flex justify-content-center">
						<div class="col-lg-6 text-center">
							<h2>기업서비스</h2>
						</div>
					</div>
				</div>
			</div>
			<nav>
				<div class="container">
					<ol>
						<li><a href="/jr/index.do">Home</a></li>
						<li>기업서비스</li>
					</ol>
				</div>
			</nav>
		</div>
		<!-- End Breadcrumbs -->
		<section id="get-a-quote" class="get-a-quote">
			<div class="container" data-aos="fade-up">
				<div class="row g-0" style="display: flex; justify-content: center;">
					<div class="buttondesign">
						<button type="button" class="btn btn-outline-primary btn-lg" onclick="location.href='#'">서비스안내</button>
						<img src="ad3.png" class="d-block w-100" alt="...">
						<img src="<%=request.getContextPath() %>/ad3.png" style="width:500px; height:300px;">
						<button type="button" class="btn btn-outline-primary btn-lg" onclick="location.href='companyservice.jsp'">견적문의</button>
					</div>
				</div>
				<!-- <div id="carouselExampleIndicators" class="carousel slide">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="광고 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="광고 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="광고 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="/img/ad1.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="/img/ad2.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="/img/ad3.png" class="d-block w-100" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span> 
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span> 
						<span class="visually-hidden">Next</span>
					</button>
				</div> -->
			</div>
		</section>
	</main>

	<!-- /main -->

  <!-- ======= Footer ======= -->
  <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
  <!-- End Footer -->

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>
  
	  <%-- <%@ include file="/WEB-INF/views/inc/ad.jsp" %>
	  <%@ include file="/WEB-INF/views/inc/side.jsp" %> --%>

  <Script>
  
  
  </Script>


</body>

</html>