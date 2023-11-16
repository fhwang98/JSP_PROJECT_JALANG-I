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
  <link href="<%=request.getContextPath() %>/resources/img/jobgroup/job1.png" rel="icon">
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
<%@ include file="/WEB-INF/views/inc/ad.jsp" %>
<%@ include file="/WEB-INF/views/inc/side.jsp" %>
<%@ include file="/WEB-INF/views/inc/header.jsp" %>
  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
</head>
<body>

 <!-- ======= <main id="main"> 여기부터 집어넣기 ======= -->
  
    <main id="main">
    

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs">
      <div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/page-header.jpg');">
        <div class="container position-relative">
          <div class="row d-flex justify-content-center">
            <div class="col-lg-6 text-center">
              <h2>직업적성검사</h2>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="/jr/index.do">Home</a></li>
            <li>직업정보</li>
          </ol>
        </div>
      </nav>
      </div>
      
      <div style="background-image:url(<%=request.getContextPath()%>/resources/img/testImage/testmain.png);  width: 1200px; height:1000px; text-align:center;  background-size: cover; margin:auto;">
        </div>
    

	
        <%
        
        	int totalScore = (int)request.getAttribute("totalScore");
        	
        	String [] personalType = {"분석가","관리자","외교관","탐험가","연예인",}; 
            String totalType;
            if(totalScore>=40){
            	totalType = personalType[0];
            	 %>
            	 <div style="background-image:url(<%=request.getContextPath()%>/resources/img/testImage/test0.png); width: 1200px; height:1000px; text-align:center;  background-size: cover; margin:auto;" >
       			 </div>
            <%	
            }else if(totalScore>=40){
            	totalType = personalType[1];
            	%>
            	<div style="background-image:url(<%=request.getContextPath()%>/resources/img/testImage/test1.png); width: 1200px; height:1000px; text-align:center;  background-size: cover; margin:auto;" >
       			 </div>
            <%
            }else if(totalScore>=30){
            	totalType = personalType[2];
            	%>
            	<div style="background-image:url(<%=request.getContextPath()%>/resources/img/testImage/test2.png); width: 1200px; height:1000px; text-align:center;  background-size: cover; margin:auto;" >
       			 </div>
            	
             <%
            }else if(totalScore>=20){
            	totalType = personalType[3];
           
            %>
            <div style="background-image:url(<%=request.getContextPath()%>/resources/img/testImage/test3.png); width: 1200px; height:1000px; text-align:center;  background-size: cover; margin:auto;" >
       			 </div>
            <%
            }else if(totalScore>=10){
            	totalType = personalType[4];
            	
             %>
             <div style="background-image:url(<%=request.getContextPath()%>/resources/img/testImage/test4.png); width: 1200px; height:1000px; text-align:center;  background-size: cover; margin:auto;" >
             </div>
             <%
            }else {
            	totalType = "결과없음";
            }
            %>
        
        <div align="center">
            <h1>< 결과 ></h1>
            <h2>당신의 성격유형은 <%=totalType%>입니다.</h2>
            <form action="./index.jsp" method="post">
                <div style="text-align:center;">
		       <button type="submit" class="btn btn-primary btn-lg">다시하기</button>
		       </div>
            </form>
        </div>
 <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
  

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>

</main>
</body>
</html>