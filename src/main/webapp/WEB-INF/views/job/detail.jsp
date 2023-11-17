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
  
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/jobDetail.css" >
  
  <style>

  
  
  
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
              <h2>직업 상세</h2>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <ol>
            <li><a href="/jr/index.do">Home</a></li>
            <li><a href="/jr/crt/crtlist.do">직업 조회</a></li>
          	</ol>
          </ol>
        </div>
      </nav>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Pricing Section ======= -->
    <section>
      <div class="container" data-aos="fade-up">
        <div class="row gy-2 pricing-item" data-aos="fade-up" data-aos-delay="100">
        
			<div id="box">
				<div>
					<div>
						<h3><b>${dto.jobName }</b></h3>
					</div>
					<div>
						<img src="/jr/resources/img/mo.svg"> 평균 연봉 : ${dto.salary }만원 대
					</div>
					<div>
						<img src="/jr/resources/img/future.svg"> 전망 : ${dto.prospect }
					</div>
					<div>
						<img src="/jr/resources/img/idea.svg"> 발전가능성 : ${dto.dvlPossibility }
					</div>
				</div>		
				<div id="detail">
					<div>
						<h5> <img src="/jr/resources/img/disc.svg"> <b>직업군</b></h5>
					</div>
					<div>
						${dto.jobgroupName }
						<hr>
					</div>
					<div>
						<h5> <img src="/jr/resources/img/disc.svg"> <b>관련 학과 및 자격증</b></h5>
					</div>
					<div>
						${dto.departName } &#124; 
						<a href="#">${dto.crtName }</a>
						<hr>
					</div>
					<div>
						<h5> <img src="/jr/resources/img/disc.svg"> <b>적성 및 흥미</b></h5>
					</div>
					<div>
						${dto.aptitude }
						<hr>
					</div>
					<div>
						<h5> <img src="/jr/resources/img/disc.svg"> <b>하는일</b></h5>
					</div>
					<div>
						${dto.task }
					</div>
				</div>		
			</div>		
			<div class="text-center">
				<button type="button" class="btn btn-primary" id="back">돌아가기</button>
			</div>
			
			
		</div>
      </div><!-- End Pricing Item -->
	</section>

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
  	$("#back").click(function(){
  		history.back();
  	});
  
  </Script>


</body>

</html>