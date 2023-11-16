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
	div > button{
		text-align: center;
	}
  
  
  
  </style>
  
  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
  </head>

  <body>

  	<%@ include file="/WEB-INF/views/inc/header.jsp" %>

  	<!-- main -->
  
  	<!-- ======= Breadcrumbs ======= -->
	<div class="breadcrumbs">
		<div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getSession().getAttribute("id")%>/resources/img/page-header.jpg');">
			<div class="container position-relative">
				<div class="row d-flex justify-content-center">
					<div class="col-lg-6 text-center">
						<h2>비밀번호 재설정</h2>
					</div>
				</div>
			</div>
		</div>
		<nav>
			<div class="container">
				<ol>
					<li><a href="/jr/index.do">Home</a></li>
					<li>비밀번호 재설정</li>
				</ol>
			</div>
		</nav>
	</div>
	<!-- End Breadcrumbs -->
	
	<!-- ======= Get a Quote Section ======= -->
	<section id="get-a-quote" class="get-a-quote">

		<div class="container" data-aos="fade-up">

			<div class="row g-0" style="display: flex; justify-content: center;">
			
				<div class="col-lg-7" style="width: 500px;">
					<div class="row align-items-center justify-content-between">
	                	<a class="navbar-brand h1 text-center">
	                    	<span class="text-dark h4">비밀번호 재설정</span>                 
	                	</a>
            		</div>
					<br>
                	<form name="form" action="/jr/user/changepassword.do" method="POST">
	                 
						<div class="form-group has-success">
							<label class="form-label mt-4" for="pw">비밀번호</label>
							<input type="password" name="pw" class="form-control" id="pw" placeholder="4~12글자 영어와 숫자로만 입력해주세요" required>
							<div class="valid-feedback"></div>
						</div>
		
						<div class="form-group has-danger">
							<label class="form-label mt-4" for="pw2">비밀번호 확인</label> 
							<input type="password" name="pw2" class="form-control" id="pw2" placeholder="비밀번호를 다시 한번 입력해주세요" required>
						</div>
					
					</form>	                
				</div>
				
			</div>
			
		</div>
		
	</section>

  
  
  
  

  <!-- /main -->

  <!-- ======= Footer ======= -->
  <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
  <!-- End Footer -->

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>
  
<%--   <%@ include file="/WEB-INF/views/inc/ad.jsp" %>
  <%@ include file="/WEB-INF/views/inc/side.jsp" %> --%>

  <Script>
  
  
  </Script>


</body>

</html>