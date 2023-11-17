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

  <!-- Google Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <!-- <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
 -->
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&family=Nanum+Myeongjo:wght@800&family=Noto+Serif+KR:wght@500;600&display=swap" rel="stylesheet">

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
	
  
  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
  <script src="https://kit.fontawesome.com/1f653a59f2.js" crossorigin="anonymous"></script>
  
  
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
  
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/crtschlist.css" >
  
  <style>

        
				
		
    </style>
    
</head>

<body>

  <%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
  <!-- ======= <main id="main"> 여기부터 집어넣기 ======= -->
  
    <main id="main">
    

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs">
      <div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/backgroundImg2.png');">
        <div class="container position-relative">
          <div class="row d-flex justify-content-center">
            <div class="col-lg-6 text-center">
              <h2>자격증 시험 일정 조회</h2>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="/jr/index.do">Home</a></li>
            <li><a href="/jr/crt/crtschlist.do">자격증 시험 일정 조회</a></li>
          </ol>
          <hr>
          
          <div class="searcharea">
          <h1>자격증 시험 검색</h1>
          
          <form action="/jr/crt/crtschlist.do" method="get" id="search" class="row row-cols-lg-auto g-3 align-items-center" onsubmit="return validateDates()">
          	<div id="crtName">
		        <label for="certificationName">자격증명:</label>
		        <input type="text" id="crtNameText" name="word" placeholder="자격증명을 입력해주세요" >
		        <div id="crtBtn">
		        	<img src="/jr/resources/img/searchBtn.png">
		        </div>
			</div>
			
			<div>	
			
			<div class="search-container">
				<table id="searchTable">
					<tr>
						<td class="serach-width">시험 접수 시작일  ~  시험 접수 종료일</td>
						<td class="serach-width">
						<input type="text" name="daterange" id="daterange1" class="search-input" value="" autocomplete="off"  placeholder="날짜를 선택해주세요">
						<input type="hidden" name="hiddenRcStartDate" id="hiddenRcStartDate" value="">
						<input type="hidden" name="hiddenRcEndDate" id="hiddenRcEndDate" value="">
						</td>
					</tr>
					<tr>
						<td class="serach-width">시험 시작일  ~  시험 종료일</td>
						<td class="serach-width">
						<input type="text" name="daterange" id="daterange2" class="search-input" value="" autocomplete="off" placeholder="날짜를 선택해주세요">
						<input type="hidden" name="hiddenStartDate" id="hiddenStartDate" value="">
						<input type="hidden" name="hiddenEndDate" id="hiddenEndDate" value="">
						</td>
					</tr>
				</table>
				<div class="btn-bx">
					<input type="submit" value="검색">
					<button id="clear-btn"><i class="fa-solid fa-eraser"></i>초기화</button>
				</div>
			</div>
			</div>		
		    </form>
		    </div>
          
        </div>
      </nav>
    </div><!-- End Breadcrumbs -->
	

	<!------------------------------작업--------------------------------------->
	<div>
		<section style="padding-top: 10px">
			<ul class="crt_list">
			<div class="total">
				<c:if test="${map.search=='n'}">
					<p>전체 결과 총 ${totalCount}건</p>
				</c:if>
				<c:if test="${map.search=='y'}">
					<p>검색 결과 총 ${totalCount}건</p>
				</c:if>
			</div>
				<c:forEach items="${list}" var="dto">
				<li>
					<div class="inner">
						<div class="bx">
							<div class="inner_bx">
							<div class="title_inner">
								<a href="/jr/crt/crtdetail.do?seq=${dto.crtSeq}" class="title" data-layer="detail_view_pop">${dto.crtSchName}</a>
								<div class="day">D-${dto.dday}</div>
							</div>
							<div class="info_inner">
								<dl class="crt_info_list">
									<dd class="crtType">분류 : ${dto.crtctg}자격&nbsp;&nbsp;|</dd>
									<dd class="crtagency">시행기관 : ${dto.agency}</dd>
								</dl>
								<dl class="crt_info_list">
									<dd class="difficulty">시험 접수 기간 : ${dto.testRcStartDate} ~ ${dto.testRcEndDate}</dd>
								</dl>
								<dl class="crt_info_list">
									<dd class="difficulty">시험 일 : ${dto.testStartDate}</dd>
								</dl>
							</div>
							</div>
							<button type="button" class="agencytogo" onclick="window.open('${dto.agencyURL}');">
							    <span><i class="fa-regular fa-hand-point-up"></i>시행기관 바로가기</span>
							</button>

						</div>
						
					</div>
				</li>
				</c:forEach>
				
				<!-- 페이지바 -->
				
			</ul>
			<div id="pagebar">${pagebar}</div>
		</section>
	</div>
		<section id="get-a-quote" class="get-a-quote">
		</section>


  </main><!-- End #main -->
  
  
  
  <!-- ======= </main> 까지 집어넣기 ======= -->
  
  <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
  

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>

  <%@ include file="/WEB-INF/views/inc/ad.jsp" %>
  <%@ include file="/WEB-INF/views/inc/side.jsp" %>

  <Script>
   
   $('input[name="daterange"]').click(function(event){
	   event.preventDefault();
	   $('input[name="daterange"]').data('daterangepicker').show();
	});
  
  	
  	$('#selPage').val(${nowPage});
  	
  	$(document).ready(function () {
         $('#daterange1').daterangepicker({
             autoUpdateInput: false,
             locale: {
                 cancelLabel: 'Clear'
             }
         });

         $('#daterange1').on('apply.daterangepicker', function (ev, picker) {
             $(this).val(picker.startDate.format('YYYY-MM-DD') + ' - ' + picker.endDate.format('YYYY-MM-DD'));
             $('#hiddenRcStartDate').val(picker.startDate.format('YYYY-MM-DD'));
             $('#hiddenRcEndDate').val(picker.endDate.format('YYYY-MM-DD'));
         });

         $('#daterange1').on('cancel.daterangepicker', function () {
             $(this).val('');
             $('#hiddenRcStartDate').val('');
             $('#hiddenRcEndDate').val('');
         });
         $('#daterange2').daterangepicker({
             autoUpdateInput: false,
             locale: {
                 cancelLabel: 'Clear'
             }
         });

         $('#daterange2').on('apply.daterangepicker', function (ev, picker) {
             $(this).val(picker.startDate.format('YYYY-MM-DD') + ' - ' + picker.endDate.format('YYYY-MM-DD'));
             $('#hiddenStartDate').val(picker.startDate.format('YYYY-MM-DD'));
             $('#hiddenEndDate').val(picker.endDate.format('YYYY-MM-DD'));
         });

         $('#daterange2').on('cancel.daterangepicker', function () {
             $(this).val('');
             $('#hiddenStartDate').val('');
             $('#hiddenEndDate').val('');
         });
         
         $('#clear-btn').click(function() {        	 
        	 $('#crtNameText').val('');
        	 $('#daterange1').val('');
             $('#daterange2').val('');
        	 $('#hiddenStartDate').val('');
             $('#hiddenEndDate').val('');
        	 
         });
     });
  	

  	<c:if test="${map.search == 'y'}">
  	$('input[name=word]').val('${map.word}');
  	$('select[name=hiddenStartDate]').val('${map.hiddenStartDate}');
  	$('select[name=hiddenEndDate]').val('${map.hiddenEndDate}');
  	</c:if>
  </Script>


</body>

</html>