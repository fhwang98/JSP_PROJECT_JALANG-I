<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>자격증 상세페이지</title>
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
  <link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/crtboarddetail.css">

  <!-- =======================================================
  * Template Name: Logis
  * Updated: Sep 18 2023 with Bootstrap v5.3.2
  * Template URL: https://bootstrapmade.com/logis-bootstrap-logistics-website-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  <style>


  
  </style>
  
  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
  </head>

  <body>

  <%@ include file="/WEB-INF/views/inc/header.jsp" %>

  <!-- main -->

  <main id="main"></main>

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs">
      <div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/page-header.jpg');">
        <div class="container position-relative">
          <div class="row d-flex justify-content-center">
            <div class="col-lg-6 text-center">
              <h2>자격증 후기 상세페이지</h2>
              <p></p>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="/jr/crt/crtdetail.do?seq=${crtseq}">${crtname}</a></li>
            <li>자격증 후기</li>
            <li>상세페이지</li>
          </ol>
        </div>
      </nav>
    </div><!-- End Breadcrumbs -->

	
<section class="notice">
  <div class="page-title">
        <div class="container">
        </div>
    </div>

    <!-- board seach area -->
    <div id="board-search">
        <div class="container">
                <form action="">
                </form>
        </div>
    </div>
  <!-- board list area -->
    <div id="board-list">
        <div class="container">
			<div class="title">
				<span>제목 : 오늘 시험 후기랍니다.</span>
			</div>
			<div class="author">
				<span>아이디 글씨작게</span>
			</div>
			<div class="date-hit">
				<span>2023-11-16</span>
				<span>조회수100</span>
			</div>
			<div class="content">
				<span>오늘은너무힘든날이었다오늘은너무힘든날이었다오늘은너무힘든날이었다오늘은너무힘든날이었다오늘은너무힘든날이었다오늘은너무힘든날이었다오늘은너무힘든날이었다오늘은너무힘든날이었다오늘은너무힘든날이었다오늘은너무힘든날이었다오늘은너무힘든날이었다오늘은너무힘든날이었다</span>
			</div>
			<div class="like-com">
				<button id="like-btn"><i class="fa-regular fa-heart"></i></button>
				<span class="like">좋아요 5</span>
				<i class="fa-solid fa-comment-dots"></i>
				<span class="com">댓글5</span>
			</div>
			<div class="comment">
				<span>수수깡</span>
				<span>저도 동감이요</span>
				<span>2023-11-16</span>
				<button>댓글달기</button>
			</div>
			<div>
			</div>


            
            <%-- 
            <div class="button-group">
			<button class="button-79" role="button" onclick="location.href='/jr/crt/admin/crtadminlist.do';">목록</button>
			<button class="button-79" role="button" onclick="location.href='/jr/crt/admin/crtadminedit.do?crtSeq=${dto.crtSeq}';">수정</button>
			<button class="button-79" role="button" onclick="location.href='/jr/crt/admin/crtadmindel.do?crtSeq=${dto.crtSeq}';">삭제</button>
			</div>
			 --%>
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
  

  <Script>
  
  
  </Script>


</body>

</html>