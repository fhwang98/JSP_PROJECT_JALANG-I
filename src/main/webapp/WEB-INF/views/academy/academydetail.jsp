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

   body {
      font-family: 'Arial', sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
    }

    header {
      background-color: #343a40;
      color: #fff;
      text-align: center;
      padding: 1em;
    }

    section {
      max-width: 800px;
      margin: 20px auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
      color: #333;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    th, td {
      border: 1px solid #ddd;
      padding: 10px;
      text-align: left;
    }

    th {
      background-color: #f2f2f2;
    }

    a {
      color: #007BFF;
      text-decoration: none;
    }

    a:hover {
      text-decoration: underline;
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
              <h2>학원 상세보기</h2>
              <p></p>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="index.html">Home</a></li>
            <li>학원 상세보기</li>
          </ol>
        </div>
      </nav>
    </div><!-- End Breadcrumbs -->

      <div class="container" data-aos="fade-up">
        <p>
        </p>
      </div>

   <header>
    <h1>${academyDTO.academyName}</h1>
  </header>

  <section>
    <h2>학원 정보</h2>
    <table>
      <tr>
        <th>학원 위치</th>
        <td>${academyDTO.academyLocation}</td>
      </tr>
      <tr>
        <th>학원 연락처</th>
        <td>${academyDTO.academyTel}</td>
      </tr>
      <tr>
        <th>학원 평점</th>
        <td>${academyDTO.academyStar}</td>
      </tr>
        <c:forEach items="${academyDTO.eduList}" var="eduDTO">
      <tr>
        <th>학원 링크</th>
      <td><a href="${eduDTO.eduLink}" target="_blank">${eduDTO.eduLink}</a></td>
      </tr>
	</c:forEach>    
    </table>
  </section>

  <section>
    <h2>교육 정보</h2>
    <table>
      <tr>
        <th>교육명</th>
        <th>모집 시작일</th>
        <th>모집 종료일</th>
        <th>교육 시작일</th>
        <th>교육 종료일</th>
      </tr>
      <c:forEach items="${academyDTO.eduList}" var="eduDTO">
        <tr>
          <td>${eduDTO.eduName}</td>
          <td>${eduDTO.eduRcStartDate}</td>
          <td>${eduDTO.eduRcEndDate}</td>
          <td>${eduDTO.eduStartDate}</td>
          <td>${eduDTO.eduEndDate}</td>
        </tr>
      </c:forEach>
    </table>
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
  
  
  </Script>


</body>

</html>