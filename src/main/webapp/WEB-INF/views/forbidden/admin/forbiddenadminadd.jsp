<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>금지어 등록페이지</title>
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

  table {
  border-collapse: collapse;
  border-spacing: 0;
}
section.notice {
  padding: 0;
  margin-bottom: 80px;
}

.page-title {
  margin-bottom: 60px;
}
.page-title h3 {
  font-size: 28px;
  color: #333333;
  font-weight: 400;
  text-align: center;
}

#board-search .search-window {
  padding: 15px 0;
  background-color: #f9f7f9;
  border-top: 1px solid #101D34;
}
#board-search .search-window .search-wrap {
  position: relative;
/*   padding-right: 124px; */
  margin: 0 auto;
  width: 80%;
  max-width: 564px;
}
#board-search .search-window .search-wrap input {
  height: 40px;
  width: 100%;
  font-size: 14px;
  padding: 7px 14px;
  border: 1px solid #101D34;
}
#board-search .search-window .search-wrap input:focus {
  border-color: #333;
  outline: 0;
  border-width: 1px;
}
#board-search .search-window .search-wrap .btn {
  position: absolute;
  right: 0;
  top: 0;
  bottom: 0;
  width: 108px;
  padding: 0;
  font-size: 16px;
}

.board-table {
  font-size: 13px;
  width: 100%;
  border-top: 1px solid #101D34;
}

.board-table a {
  color: #333;
  display: inline-block;
  line-height: 1.4;
  word-break: break-all;
  vertical-align: middle;
}
.board-table a:hover {
  text-decoration: underline;
}
.board-table th {
  text-align: center;
  border-top: 1px solid #e7e7e7;
  border-bottom: 1px solid #e7e7e7;
}

.board-table td {
  text-align: center;
  border-top: 1px solid #e7e7e7;
  border-bottom: 1px solid #e7e7e7;
}

.board-table .th-num {
  width: 139px;
  text-align: center;
}

.board-table .th-username {
  width: 139px;
}

.board-table .th-startdate {
  width: 139px;
}

.board-table .th-reports {
  width: 139px;
}

.board-table .th-id {
  width: 139px;
}

.board-table th, .board-table td {
  padding: 14px 0;
}

.board-table tbody td {
  border-top: 1px solid #e7e7e7;
  text-align: center;
} 

.board-table tbody th {
  padding-left: 28px;
  padding-right: 14px;
  border-top: 1px solid #e7e7e7;
  text-align: left;
}

.board-table tbody th p{
  display: none;
}

.board-table tbody th {
	text-align: left;
	background-color: #F3F6FC;
	padding: 10;
	width: 200px;
}

body > div.breadcrumbs > div > div > div > div > h2 {
	width: 500px;
}

.btn {
  display: inline-block;
  padding: 0 30px;
  font-size: 15px;
  font-weight: 400;
  background: transparent;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  -ms-touch-action: manipulation;
  touch-action: manipulation;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  border: 1px solid transparent;
  text-transform: uppercase;
  -webkit-border-radius: 0;
  -moz-border-radius: 0;
  border-radius: 0;
  -webkit-transition: all 0.3s;
  -moz-transition: all 0.3s;
  -ms-transition: all 0.3s;
  -o-transition: all 0.3s;
  transition: all 0.3s;
}

.btn-dark {
  background: #101D34;
  color: #fff;
}

.btn-dark:hover, .btn-dark:focus {
  background: #373737;
  border-color: #373737;
  color: #fff;
}

/* reset */

* {
  list-style: none;
  text-decoration: none;
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
.clearfix:after {
  content: '';
  display: block;
  clear: both;
}
.container {
  width: 1100px;
  margin: 0 auto;
  width: 900px;
}
.blind {
  position: absolute;
  overflow: hidden;
  clip: rect(0 0 0 0);
  margin: -1px;
  width: 1px;
  height: 1px;
}

#board-list > div > table > tbody > tr > th {
	text-align: center;
}

#board-list > div > table > tbody > tr:nth-child(8) > td {
	text-align: left;
}

#board-list > div > table > tbody > tr:nth-child(9) > td {
	text-align: left;
}

.button-79 {
  backface-visibility: hidden;
  background: #0D42FF;
  border: 0;
  border-radius: .375rem;
  box-sizing: border-box;
  color: #fff;
  cursor: pointer;
  display: inline-block;
  font-family: Circular,Helvetica,sans-serif;
  font-size: 16px;
  font-weight: 700;
  letter-spacing: -.01em;
  line-height: 1.3;
  /* padding: 1rem 1.25rem; */
  position: relative;
  text-align: center;
  text-decoration: none;
  transform: translateZ(0) scale(1);
  transition: transform .2s;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  width: 90px;
  height: 40px;
  margin-left: 785px;
  margin-top: 10px;
  margin: 0 3px;
  
 }


.button-79:disabled {
  color: #787878;
  cursor: auto;
}

.button-79:not(:disabled):hover {
  transform: scale(1.05);
}

.button-79:not(:disabled):hover:active {
  transform: scale(1.05) translateY(.125rem);
}

.button-79:focus {
  outline: 0 solid transparent;
}

.button-79:focus:before {
  border-width: .125rem;
  content: "";
  left: calc(-1*.375rem);
  pointer-events: none;
  position: absolute;
  top: calc(-1*.375rem);
  transition: border-radius;
  user-select: none;
}

.button-79:focus:not(:focus-visible) {
  outline: 0 solid transparent;
}

.button-79:not(:disabled):active {
  transform: translateY(.125rem);
}

.button-group {
    margin-top: 10px; /* 버튼 그룹과 표 간의 간격 조정 */
    text-align: right;
}

.abc {
	width: 400px;
	height: 100px;
}

#board-list > div > form > table > tbody > tr:nth-child(9) > td > textarea {
	width: 650px;
	height: 150px;
}

#board-list > div > form > table > tbody > tr:nth-child(10) > td > textarea {
	width: 650px;
	height: 150px;
}

#board-list > div > form > table > tbody > tr:nth-child(11) > td > textarea {
	width: 650px;
	height: 150px;
}

#board-list > div > form > table > tbody > tr:nth-child(12) > td > textarea {
	width: 650px;
	height: 150px;
}

  
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
              <h2>금지어 등록페이지</h2>
              <p></p>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="index.html">관리 메뉴</a></li>
            <li>금지어 관리</li>
            <li>등록페이지</li>																																			
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
        </div>
    </div>
  <!-- board list area -->
    <div id="board-list">
        <div class="container">
        	<form method="POST" action="/jr/forbidden/admin/forbiddenadminadd.do">
            <table class="board-table">
				<tbody>        
				 <tr>
            		<th>금지어 </th>
            		<td><input type="text" name="forbidden" required value="${dto.forbidden}"></td>
         		</tr>
				</tbody>
            </table>
            
            
            <div class="button-group">
			<button class="button-79" role="button">등록하기</button>
			<button class="button-79" role="button" onclick="location.href='/jr/forbidden/admin/forbiddenadminlist.do';">돌아가기</button>
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
  

  <Script>
  

  
  </Script>


</body>

</html>