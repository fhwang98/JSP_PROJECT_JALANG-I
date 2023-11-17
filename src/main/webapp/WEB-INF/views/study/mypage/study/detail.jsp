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
  	.container div {
  		/* border: 1px solid black; */
  	}
  	
  	#pricing .btn {
		margin-left: 10px; /* 버튼 사이의 간격 조절을 위한 마진 설정 (선택적) */
	}
  	
  	#table div{
  		border: 1px solid #dddddd;
  		border-collapse: collapse;
  	}
  	
  	#menu {
  		background-color: #f2f2f2;
  	}
  	
  	
  	
  
  </style>
  
  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
  
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.14/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.14/css/gijgo.min.css" rel="stylesheet" type="text/css" />
  
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
              <h2>스터디</h2>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="index.html">마이페이지</a></li>
            <li>나의 학습</li>
            <li>스터디</li>
          </ol>
        </div>
      </nav>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Pricing Section ======= -->
    <section id="pricing" class="pricing">
      <div class="container" data-aos="fade-up">
        <div class="row gy-2 pricing-item" data-aos="fade-up" data-aos-delay="100">
        
        <!-- 시작 -->
		<div class="container">
			<div class="row">
			    <div class="col-12"><h2><b>${dto.studyName }</b></h2> &#91;${crtTestName }&#93; </div>
			    <div class="col-12">
			    스터디원 : 
			    <c:forEach items="${nameList }" var="name">
			    ${name} 
			    </c:forEach>
			    </div>
  			</div>
			
  			<div class="row">
    			<div class="col-6"><h2><span class="badge bg-secondary">스터디 일정</span></h2></div>
  			</div>
  			<div class="row" style="height: 400px;">
			    <div class="col-12" id="table">
			    
			    	<div class="row" id="menu">
			    		<div class="col-3">toDoList</div>
			    		<div class="col-3">완료 일</div>
			    		<div class="col-3">신청 자</div>
			    		<div class="col-3">메 모</div>
			    	</div>
			    	
			    	<!-- 내용반복 -->
			    	<c:forEach items="${list }" var="dto">
			    	<div class="row">
			    		<div class="col-3">${dto.toDo }</div>
			    		<div class="col-3">${dto.completeDate }</div>
			    		<div class="col-3">${dto.name }</div>
			    		<div class="col-3">${dto.toDoComment }</div>
			    	</div>
			    	</c:forEach>
			    	<!-- /내용반복 -->
			    	
			    	
			    </div>
			    <div class="col-12">
			    <form action="/jr/study/mypage/todoadd.do" method="POST">
			    	<div class="row" id="input">
			    		<div class="col-3"><input type="text" name="toDoList" class="form-control" placeholder="할일"></div>
			    		<div class="col-3"><input type="text" id="datepicker" name="date" class="form-control" placeholder="YYYY-MM-DD" required></div>
			    		<div class="col-3"><input type="text" name="name" disabled value="${name }" class="form-control"></div>
			    		<div class="col-3"><input type="text" name="memo" class="form-control" placeholder="메모"></div>
			    		<input type="hidden" name="studySeq" value="${dto.studySeq }">
			    	</div>
			    	
			    	<div class="row text-center" >
			    		<div class="col-12">
			    			<button type="submit" class="btn btn-secondary">할일 올리기</button>
			    		</div>
			    	</div>
			    </form>
			    </div>
  			</div>
  			
		</div>
		
		
		
		
		
		
		
		
		
		
		
		
		<!-- 끝 -->
			
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
	  $('#datepicker').datepicker({
	  	format: 'yyyy-mm-dd',
	      uiLibrary: 'bootstrap5'
	  });
  
  </Script>


</body>

</html>