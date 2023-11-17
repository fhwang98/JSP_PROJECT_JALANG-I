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
  
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/crtlist.css" >
  
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
              <h2>자격증 조회</h2>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="/jr/index.do">Home</a></li>
            <li><a href="/jr/crt/crtlist.do">자격증 조회</a></li>
          </ol>
          <hr>
          
          <div class="searcharea">
          <h1>자격증 검색</h1>
          
          <form action="/jr/crt/crtlist.do" method="get" id="search" class="row row-cols-lg-auto g-3 align-items-center">
          	<div id="crtName">
		        <label for="certificationName">자격증명:</label>
		        <input type="text" id="crtNameText" name="word" placeholder="자격증명을 입력해주세요" >
		        <div id="crtBtn">
		        	<img src="/jr/resources/img/searchBtn.png">
		        </div>
			</div>
			
			<div>	
			<table id="searchTable">
				<tr>
					<th>자격증 분류</th>
					<th>시행기관</th>
					<th>난이도</th>
					<th></th>
				</tr>
				<tr>
					<td>
						<select id="crtctg" name="crtctg">
				            <option value="default">분류</option>
				            <option value="국가">국가</option>
				            <option value="민간">민간</option>
				            <option value="어학">어학</option>
		        		</select>
					</td>
					<td>
						<select id="agency" name="agency">
				            <option value="default">시행기관</option>
				            <c:forEach items="${agencyList}" var="dto">
				            <option value="${dto.agency}">${dto.agency}</option>
							</c:forEach>
				        </select>
					</td>
					<td>
						<select id="difficulty" name="difficulty">
				            <option value="default">난이도</option>
				            <option value="1">★</option>
				            <option value="2">★★</option>
				            <option value="3">★★★</option>
				            <option value="4">★★★★</option>
				            <option value="5">★★★★★</option>
				            <!-- 다른 난이도 옵션들 추가 -->
				        </select>
					</td>
					<td>
						<input type="submit" value="검색">
					
					</td>
				</tr>
			
			
			</table>
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
								<a href="/jr/crt/crtdetail.do?seq=${dto.crtSeq}&search=${map.search}&word=${map.word}" class="title" data-layer="detail_view_pop" title="정보처리기사">${dto.crtName}</a>
							</div>
							<div class="info_inner">
								<dl class="crt_info_list">
									<dd class="crtType">분류 : ${dto.crtctg}자격&nbsp;&nbsp;|</dd>
									<dd class="crtagency">시행기관 : ${dto.agency}자격&nbsp;&nbsp;|</dd>
									<dd class="difficulty">난이도 : ${dto.difficulty}&nbsp;&nbsp;|</dd>
									<dd class="totalCnt">누적 좋아요 : ${dto.likeCnt}</dd>
								</dl>
								<!-- 
								<dl class="crt_info_list">
									<dd class="crtSch">최신 일정명 : 국가기술자격 기사(2023년도 제4회) 실기(면접)</dd>
								</dl>
								 -->
							</div>
							</div>
							<%-- <button class="action_btn" onclick="location.href='/jr/crt/crtlikesubmit.do?crtseq=${dto.crtSeq}'"> --%>
							<button class="action_btn" onclick="location.href='/jr/crt/crtlikesubmit.do?crtseq=${dto.crtSeq}&fromlike=${fromlike}'"> 
								<c:if test="${dto.crtlike == 0}">
								<i class="fa-regular fa-heart liketoggle"></i>
								</c:if>
								<c:if test="${dto.crtlike > 0}">
								<i class="fa-solid fa-heart liketoggle"></i>
								</c:if>
							</button>
							<%-- <button class="action_btn" onclick="location.href='/jr/crt/crtlikesubmit.do?crtseq=${dto.crtSeq}'"><i class="fa-regular fa-heart"></i></button> --%>
						</div>
						
					</div>
				</li>
				</c:forEach>
				
				<!-- 페이지바 -->
				<div id="pagebar">${pagebar}</div>
				
			</ul>
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
  	
  
  	<c:if test="${map.search == 'y'}">
  	$('input[name=word]').val('${map.word}');
  	$('select[name=crtctg]').val('${map.crtctg}');
  	$('select[name=agency]').val('${map.agency}');
  	$('select[name=difficulty]').val('${map.difficulty}');
  	</c:if>
  	
  	$('#selPage').val(${nowPage});
  	
  	
  	 $('.liketoggle').click(function() {
  		 
  		var currentClass = $(this).hasClass("fa-regular") ? "fa-regular" : "fa-solid";
		
  		// 토글하여 반대 클래스를 적용합니다.
        var newClass = currentClass === "fa-regular" ? "fa-solid" : "fa-regular";

        // 버튼의 클래스를 변경하여 색상을 토글합니다.
        $(this).removeClass(currentClass).addClass(newClass);
  		 
  	 });
  	 /* 
  	 $('.action_btn').click(function() {
  		
  		var userId = ${map.id};
        var crtSeq = ${dto.crtSeq};

        if (userId === "" || userId === null) {
            alert("로그인이 필요한 서비스입니다.");
        } else {
            location.href = '/jr/crt/crtlikesubmit.do?crtseq=' + ${crtSeq};
        }
  		 
  		 
  	 });
  	  */
  	 
  	
  </Script>


</body>

</html>