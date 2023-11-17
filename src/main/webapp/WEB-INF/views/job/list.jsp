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
  
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/joblist.css" >
  
  <style>
	.form-control {
		width: 250px;
	}
	
	.inner {
  		background-color: #f2f2f2;
  		border-radius: 10px;
	}
     
    .inner div{
		padding: 5px;
		color: #333333;
	}
     
    .row h3{
		margin-top: 20px;
	}		
       
	.bx-menu div:first-child{
		text-align: left;
	}		
		
	.bx-menu div:nth-child(3){
		text-align: right;
		padding-right: 30px;
	}
	
	.bx-menu div:last-child{
		text-align: left;
	}
	
	#main > div:nth-child(2) > section div.col-sm-3 {
		padding-top: 20px;
		color: #333333;
		font-size: 20px;
	}			
	
  </style>
    
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
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
              <h2>직업 조회</h2>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="/jr/index.do">Home</a></li>
            <li><a href="/jr/crt/crtlist.do">직업 조회</a></li>
          </ol>
          <hr>
          
          <div class="searcharea">
          <h1>직업 검색</h1>
          
          <form action="/jr/job/list.do" method="get" id="search" class="row row-cols-lg-auto g-3 align-items-center">
			
			<div>	
			<table id="searchTable">
				<tr>
					<th>직업군</th>
					<th>검색</th>
					<th></th>
				</tr>
				<tr>
					
					<td>
						<select id="agency" name="seq">
							
				            <option value="default">직업군</option>
				            
				            <c:forEach items="${gList}" var="dto"> 
				            <option value="${dto.jobgroupSeq}">${dto.jobgroupName}</option> 
							</c:forEach> 
				        
				        </select>
					</td>
					<td>
						<input type="text" name="jobName" class="form-control" autofocus id="jobN">
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
					<p>전체 결과 총 ${totalCount}건</p>
			</div>
				<c:forEach items="${list}" var="dto">
				<li>
					<div class="inner">
						
						<div class="bx">
							<div class="container">
							  <div class="row">
							    <div class="col-sm-3">
							      <a href="/jr/job/detail.do?seq=${dto.jobSeq }" class="title" data-layer="detail_view_pop" title="정보처리기사"><b>${dto.jobName }</b></a>
							    </div>
							    <div class="col-sm-9">
							      <div class="row bx-menu" >
							        <div class="col-4 col-sm-4">
							          <img src="/jr/resources/img/mo.svg"> 평균 연봉 : ${dto.salary }만원 대
							        </div>
							        <div class="col-4 col-sm-4">
							          <img src="/jr/resources/img/future.svg"> 전망 : ${dto.prospect }
							        </div>
							        <div class="col-4 col-sm-4">
							          <img src="/jr/resources/img/idea.svg"> 발전가능성 : ${dto.dvlPossibility }
							        </div>
							        <div class="col-4 col-sm-12">
							          ${dto.keyTask }
							        </div>
							      </div>
							    </div>
							  </div>
							</div>
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
  	
  	/* <c:if test="${map.search == 'y'}">
  	$('input[name=word]').val('${map.word}');
  	</c:if> */
  	
  	$(function () {
		$("#jobN").keyup(function(event) {
			
			$.ajax({
	   			url:"/jr/job/search.do"
	   			,dataType:"json"
	   			,type:"get"
	   			,data: {
					
	   				jobName: $("#jobN").val(),
	   				jobgroupName: $("#agency").val()
					
				}
	   			,cache:false 
	   			,success:function(result){ 
	   				console.log(result);
	   				$( "#jobN" ).autocomplete({
	   			      source: result 
	   			    });
	   			}
			    ,error: function(a,b,c) {
					console.log(a,b,c)
				}
	   		});//ajax
			
			
		}); //keyup
	});
  	 
  	 
  	
  </Script>


</body>

</html>