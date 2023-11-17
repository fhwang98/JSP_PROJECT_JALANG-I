<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>자격증 일정 관리 페이지</title>
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

  table {
  border-collapse: collapse;
  border-spacing: 0;
}
section.notice {
  padding: 0;
  margin-top: 10px;
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

body {
  caret-color: transparent;
}

#middlebar .search-window {
  padding: 15px 0;
  background-color: #F3F6FC;
  border-top: 1px solid #101D34;
}
#middlebar .search-window .search-wrap {
  position: relative;
/*   padding-right: 124px; */
  margin: 0 auto;
  width: 80%;
  max-width: 564px;
}
#middlebar .search-window .search-wrap input {
  height: 40px;
  width: 100%;
  font-size: 14px;
  padding: 7px 14px;
  border: 1px solid #101D34;
}
#middlebar .search-window .search-wrap input:focus {
  border-color: #333;
  outline: 0;
  border-width: 1px;
}
#middlebar .search-window .search-wrap .btn {
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
  border-bottom: 1px solid #101D34;
  margin-top: 10px;
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

.board-table .th-decacccount {
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
}
.blind {
  position: absolute;
  overflow: hidden;
  clip: rect(0 0 0 0);
  margin: -1px;
  width: 1px;
  height: 1px;
}

#pagebar {
      text-align: center;
      margin-bottom: 15px;
      color: #0E1D34;
      font-size: 16px;
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

#board-list > div > div.button-group {
	padding-left: 980px;
}

#middlebar > nav > div > div > form > div {
	display: flex;
}
  
  
  
  </style>
  
 <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
  </head>

  <body>

  <%@ include file="/WEB-INF/views/inc/header.jsp" %>

  <!-- main -->

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs" id=middlebar>
      <div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/backgroundImg2.png');">
        <div class="container position-relative">
          <div class="row d-flex justify-content-center">
            <div class="col-lg-6 text-center">
              <h2>자격증 일정 관리</h2>
              <p></p>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="index.html">관리 메뉴</a></li>
            <li>자격증 일정 관리</li>
          </ol>

          <div class="search-window">
                <form id="search-form" action="/jr/crt/admin/crtadminlist.do" method="GET">
                    <div class="search-wrap">
                        <label for="search" class="blind">공지사항 내용 검색</label>
                        <select name="column">
							<option value="crtName">자격증</option>
							<option value="agency">시행기관</option>
							<option value="crtType">자격증분류</option>
						</select>
                        <input id="search" type="text" name="word" placeholder="검색어를 입력해주세요." value="">
                        <button type="submit" class="btn btn-dark">검색</button>
                    </div>                                                                                              
                </form>
            </div>
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
        	<div class="button-group">
				<button class="button-79" role="button" onclick="location.href='/jr/crt/admin/crtschadminadd.do';">등록하기</button>
			</div>
            <table class="board-table">
                <thead>
                	<!-- 번호, 자격증시험명, 회차, 시행기관, 유형, 접수시작일, 시험일을 출력한다. -->
                    <th scope="col" class="th-num">번호</th>
                    <th scope="col" class="th-username">자격증시험명</th>
                    <th scope="col" class="th-username">자격증명</th>
                    <th scope="col" class="th-id">회차</th>
                    <th scope="col" class="th-startdate">시행기관</th>                                     
                    <th scope="col" class="th-decacccount">유형</th>                                     
                    <th scope="col" class="th-decacccount">접수시작일</th>                                  
                    <th scope="col" class="th-decacccount">시험일</th>                                  
                </tr>
                </thead>
				<tbody>
						<c:forEach items="${list}"  var="dto" varStatus="status">
        				<tr>
        					<td>${dto.crtSchSeq}</td>
        					
        					
            				<td><a href="/jr/crt/admin/crtschadmindetail.do?crtSchSeq=${dto.crtSchSeq}">${dto.crtTestName}</td> 
            				<td>${dto.crtName}</td>
            				<td>${dto.round}</td>
            				<td>${dto.agency}</td>
            				<td>${dto.crtTestType}</td>
            				<td>${dto.testRcEndDate}</td>
            				<td>${dto.testStartDate}</td>
        				</tr>
    				</c:forEach>
				</tbody>
            </table>
            
            <div id="pagebar">${pagebar}</div>
            
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
  
	<c:if test="${map.search == 'y'}">
	$('select[name=column]').val('${map.column}');
	$('input[name=word]').val('${map.word}');
	</c:if>
  
  $('#selPage').val(${nowPage});
  
  </Script>


</body>

</html>