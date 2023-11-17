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
	#bookcheck h5 {
  		margin-left: 10px;
  	}
  	#bookcheck h6 {
  		margin-left: 20px;
  	}
  	#bookcheck input {
  		margin-left: 30px;
  	}
  	#bookcheck button {
  		text-align: right;
  	}
  	#bookcheck div:first-child{
  		margin-bottom: 20px;
  	}
  	
  	#bookcheck div:last-child{
  		display: flex;
  		justify-content: flex-end;
  	}
  	#bookcheck .btn {
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
              <h2>교재 진척 상황</h2>
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
            <li>교재 상세</li>
          </ol>
        </div>
      </nav>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Pricing Section ======= -->
    <section id="pricing" class="pricing">
      <div class="container" data-aos="fade-up">
        <div class="row gy-2 pricing-item" data-aos="fade-up" data-aos-delay="100">
        
        
		
		
		
		
      	<div class="col-md-3" >
        	<img src="${img }" class="" alt="">
        </div>
        <div class="col-md-8">
            <div class="container text-center">
			  <div class="row row-cols-1">
			    <div class="col" style="height: 50px">
			    	<h3 style="text-align: left;">${name }</h3>
			    </div>
			    <div class="col">
			    	<h5 style="text-align: left;">진행 률</h5>
			    </div>
			    <div class="progress" style=" padding: 0;">
  					<div class="progress-bar progress-bar-striped bg-info progress-bar-animated" role="progressbar" style="width: ${count}%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">${count}%</div>
				</div>
				
				
			  </div>
			</div>
        </div>
        <div class="form-check" style="margin-top: 50px;">
        	<div id="bookcheck" style="margin-top: 50px; margin-left: 400px;">
        	
        	<!-- 반복될곳 -->
        	<c:forEach items="${list }" var="dto">
        	<div>
        		<c:if test="${dto.titleStep == 2}">
        		<h5><b>${dto.list }</b></h5>
        		</c:if>
        		
        		<c:if test="${dto.titleStep == 1}">
        		<h6>${dto.list }</h6>
        		</c:if>
        		
        		<c:if test="${dto.titleStep == 0}">
        		
        		<c:if test="${dto.learnCheck == 0}">
	 			<input class="form-check-input" type="checkbox" value="" id="${dto.list }" name="">
	 			</c:if>
	 			<c:if test="${dto.learnCheck == 1}">
	 			<input class="form-check-input" type="checkbox" value="" id="${dto.list }" name="" checked>
	 			</c:if>
	 			
	  			<label class="form-check-label" for="flexCheckDefault" >
	    			${dto.list }
	  			</label>
	  			</c:if>
  			</div>
  			</c:forEach>
  			<!-- /반복될곳 -->
  			<div>
  				<h5 style="padding-top: 20px; text-decoration: underline;">
  					<a class="btn btn-primary" href="/jr/study/mypage/book/list.do" role="button">돌아가기</a>
  				</h5>
  				<h5 style="padding-top: 20px; text-decoration: underline;">
  					<a class="btn btn-primary" href="/jr/study/mypage/book/del.do?seq=${seq }" role="button">삭제</a>
  				</h5>
			</div>
  			</div>
		</div>
        
        
        
          
        </div><!-- End Pricing Item -->

        </div>
        
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
  	$("#bookcheck input").change(function() {
  		console.log( $(this).prop("checked"));
  		console.log( $(this).attr("id"));
  		
  		$.ajax({
			type: 'POST',
			url: '/jr/study/mypage/book/detail.do',
			data: {
				list: $(this).attr("id"),
				learnCheck: $(this).prop("checked")
			},
			dataType: 'json',
			success: function(result) {
				
				if (result.result == 1) {
					//alert("변경 완료");
					//수정 완료 > <td>의 상태 > 원래대로 되돌리기
				} else {
					alert('failed');
				}
				
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		});
  		
  	});
  	
  	
  
  </Script>


</body>

</html>