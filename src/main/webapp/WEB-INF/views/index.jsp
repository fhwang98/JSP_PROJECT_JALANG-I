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
  
  <!-- NiceAdmin CSS File -->
<link href="<%=request.getContextPath() %>/resources/css/style.css"
	rel="stylesheet">
  <style>

    ul {
   		list-style:none;
 	 }
 	 
    li {
   		float: left;
 	 }
 	 .d-day {
 	 	position: absolute;
	    left: 20px;
	    top: 15px;
	    display: block;
	    width: 40px;
	    height: 20px;
	    line-height: 19px;
	    text-align: center;
	    font-size: 10px;
	    font-weight: 400;
	    color: #fff;
	    background: #9c57f5;
	    border-radius: 10px;
 	 }
 	 
 	 .info {
 	 	width: 100%;
 	 }
 	 
 	 /* 
 	 .card {
 	 	position: relative;
 	 	left: 0;
 	 	top: 0;
 	 }
 	  */
 	 
 	 .hide {
 	 	display:none;
 	 	/* position: absolute;
 	 	background-color: white;
 	 	width: 200px;
 	 	height: 100px;
 	 	top: 150px;
 	 	z-index: 10; */
 	 }
 	 
 	 
 	 /* .card:hover .hide {
 	 	display:block;
 
 	 } */
  
  
  	#banner > img {
  		cursor: pointer;
  		object-fit: cover;
  		width: 45%;
  		height: 100%;
  	}
  
  </style>
  
  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
</head>

<body>

  <%@ include file="/WEB-INF/views/inc/header.jsp" %>

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="hero d-flex align-items-center">
    <div class="container">
      <div class="row gy-4 d-flex justify-content-around">
        <div class="col-lg-6 order-2 order-lg-1 d-flex flex-column justify-content-center">
          <h2 data-aos="fade-up">자격증, 자랑이와!</h2>

          <form action="/jr/crt/crtlist.do" method="get" class="form-search d-flex align-items-stretch mb-3" data-aos="fade-up" data-aos-delay="200">
            <input type="text" name="word" class="form-control" placeholder="자격증을 검색해보세요">
            <input type="hidden" name="crtctg" class="form-control" placeholder="자격증을 검색해보세요">
            <input type="hidden" name="agency" class="form-control" placeholder="자격증을 검색해보세요">
            <input type="hidden" name="difficulty" class="form-control" placeholder="자격증을 검색해보세요">
            <button type="submit" class="btn btn-primary">Search</button>
          </form>

          
        </div>

        <div id="banner" style="text-align: center;" class="col-lg-5 order-1 order-lg-2 hero-img" data-aos="zoom-out">
        
        
        <img alt="" src="<%=request.getContextPath() %>/resources/img/bookbanner.png" onclick="location.href='/jr/book/booklist.do'">
        &nbsp;&nbsp;&nbsp;&nbsp;
        <img alt="" src="<%=request.getContextPath() %>/resources/img/crtbanner.png" onclick="location.href='/jr/crt/crtrec.do'">
        
          <%-- <img src="<%=request.getContextPath() %>/resources/img/hero-img.svg" class="img-fluid mb-3 mb-lg-0" alt=""> --%>
        </div>

      </div>
    </div>
    
    
  </section><!-- End Hero Section -->

  

  <main id="main" class="main" style="margin-top: 0; padding: 0;">
  
    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs">
      
      <nav>
        <div class="container">
          <ol>
            <li>자격증 TOP 100</li>
          </ol>
        </div>
      </nav>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Featured Services Section ======= -->
    <section id="featured-services" class="featured-services" style="padding: 30px 0;">
      </div>
      <div class="container">
        <div class="row gy-4" style="align-items: flex-start;">


		<c:forEach items="${ clist }" var="dto">
		  <div class="col-lg-3 col-md-4">
		  <div class="card service-item d-flex" data-aos="fade-up" data-aos-delay="200" style="padding:20px;">
		      
		      <c:if test="${dto.ddDay >= 0 }">
              <div class="d-day">D-${ dto.ddDay }</div>
              </c:if>
              <h4 class="title" style="font-size: 1.1rem; padding-top:20px;">${ dto.crtName }</h4>
              <div class="description">
				<table class="info">
					<tbody>
						<tr>
							<th>시행기관</th>
							<td>${ dto.agency }</td>
						</tr>
						<tr>
							<th>시험일</th>
							<td>${ dto.testStartDate }</td>
						</tr>
					</tbody>
				</table>
								</div>
              <div class="hide description">
              <hr>
              <table class="info" style="margin-bottom:10px;">
					<tbody>
						<tr>
							<th>시험명</th>
							<td>${ dto.round }</td>
						</tr>
						<tr>
							<th>접수일</th>
							<td>${ dto.testRcStartDate }</td>
						</tr>
					</tbody>
				</table>
              <a href="/jr/crt/crtdetail.do?seq=${ dto.crtSeq }" class="readmore stretched-link"><span>자격증 상세보기</span><i class="bi bi-arrow-right"></i></a>
              </div>
              </div>
          </div>
          
          
          </c:forEach>
		
		
		
        </div>
      </div>
      
    </section><!-- End Featured Services Section -->

    <!-- ======= About Us Section ======= -->
    

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
  <!-- End Footer -->

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>
  
  <%@ include file="/WEB-INF/views/inc/ad.jsp" %>
  <%@ include file="/WEB-INF/views/inc/side.jsp" %>
  
  <script>
  
/*   
  	$('.card').mouseover(function() {
  		$(event.currentTarget).find('.hide').show();
  	});
 */
 
 $('.card').mouseover(function(event) {
	  $(event.currentTarget).find('.hide').show();
	});

	$('.card').mouseout(function(event) {
	  $(event.currentTarget).find('.hide').hide();
	});

  
  </script>

</body>

</html>