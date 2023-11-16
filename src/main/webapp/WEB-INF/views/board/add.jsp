<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<html xmlns:th="http://www.thymeleaf.org">


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
	
  
  
  </style>
  
  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
    <title>Board List</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <!--부트스트랩 css 추가-->
        <link rel="stylesheet" href="/css/lib/bootstrap.min.css">
  </head>

  <body>

  <%@ include file="/WEB-INF/views/inc/header.jsp" %>

  <!-- main -->

		
        <div class="container">
		
            <h1>Board add</h1>
            
            <form method="POST" action="/jr/board/add.do">
              <div class="mb-3">
                    <label class="form-label">Title</label>
                    <input type="text" class="form-control" name="title" id="title">
                </div>
                <div class="mb-3">
                    <label class="form-label">Content</label>
                    <textarea class="form-control" rows="5" name="content" id="content"></textarea>
                </div>
                <div class="mb-3">
                    <label class="form-label">Writer</label>
                    <input type="text" class="form-control" name="id" id="id">
                </div>
                <button type="button" class="btn btn-success" onclick="javascript:location.href='/jr/board/boardlist'">Previous</button>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
      
        <!--부트스트랩 js, jquery 추가-->
        <script src="/js/lib/jquery.min.js"></script>
        <script src="/js/lib/bootstrap.min.js"></script>
   

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