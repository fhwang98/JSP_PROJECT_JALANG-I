<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<html xmlns:th="http://www.thymeleaf.org">


<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>자격증</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="<%=request.getContextPath()%>/resources/img/favicon.ico"
	rel="icon">
<link
	href="<%=request.getContextPath()%>/resources/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/vendor/aos/aos.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="<%=request.getContextPath()%>/resources/css/main.css"
	rel="stylesheet">

<!-- =======================================================
  * Template Name: Logis
  * Updated: Sep 18 2023 with Bootstrap v5.3.2
  * Template URL: https://bootstrapmade.com/logis-bootstrap-logistics-website-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
<style>
</style>

<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
<title>Board List</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--부트스트랩 css 추가-->
<link rel="stylesheet" href="/css/lib/bootstrap.min.css">
</head>

<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<div class="breadcrumbs">
      <div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/backgroundImg2.png');">
        <div class="container position-relative">
          <div class="row d-flex justify-content-center">
            <div class="col-lg-6 text-center">
              <h2>게시판</h2>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="index.html">게시판 상세</a></li>
          </ol>
        </div>
      </nav>
    </div><!-- End Breadcrumbs -->
	<!-- main -->


	<div class="container">
		<%-- <c:forEach items="${list}" var="dto1"> --%>
		<h1>Board View.</h1>

		<div class="mb-3">
			<label class="form-label">Title.</label> <input type="text"
				class="form-control" name="boardTitle" readonly
				value="${dto.boardTitle}">
		</div>

		<div class="mb-3">
			<label class="form-label">Content</label>
			<textarea class="form-control" rows="5" name="boardContent" readonly>${dto.boardContent}</textarea>
		</div>

		<div class="mb-3">
			<label class="form-label">Writer.</label> <input type="text"
				class="form-control" name="id" value="${dto.id}">
		</div>

		<button type="button" class="btn btn-success"
			onclick="javascript:location.href='/jr/board/boardlist.do'">Previous</button>
		<button type="button" class="btn btn-success"
			onclick="javascript:location.href='/jr/board/edit.do'">수정하기</button>


		<table id="list-comment">

			<div id="comm">
				<div class="card">
					<form>
						<input type="hidden" id="boardID" value="${board.id}" />
						<div class="card-body">
							<textarea id="reply-content" class="form-control" rows="1"></textarea>
						</div>
						<div class="card-footer">
							<button type="button" id="btn-reply-save" class="btn btn-primary">등록</button>
						</div>
					</form>
				</div>


				<div class="card">
					<div class="card-header">댓글 리스트 &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp; &emsp;
					&emsp; 아이디</div>
					<ul id="reply--box" class="list-group">

						<li id="reply--1"class="list-group-item d-flex justify-content-between">
						<div>
						</div>
						<!-- <div>댓글내용</div>
				<div class="d-flex">
					<div class="">작성자</div>
					<button class="badge">삭제</button>
				</div> -->
						</li>

					</ul>
				</div>
			</div>

		</table>


		<%--  </c:forEach> --%>
	</div>











	<!--부트스트랩 js, jquery 추가-->
	<script src="/js/lib/jquery.min.js"></script>
	<script src="/js/lib/bootstrap.min.js"></script>



	<!-- /main -->

	<!-- ======= Footer ======= -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
	<!-- End Footer -->

	<a href="#"
		class="scroll-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<div id="preloader"></div>

	<%@ include file="/WEB-INF/views/inc/ad.jsp"%>
	<%@ include file="/WEB-INF/views/inc/side.jsp"%>


	<Script>
 load();
  

 

  
  
  function load() { 
		
		$.ajax({
			type: 'GET',
			url: '/jr/board/comment.do',
			data: 'bseq=${dto.boardSeq}',
			dataType: 'json',
			success: function(result) {
				//result == 댓글 목록
				
				$('#reply--1 > div').html(''); //기존 내용 삭제
				
				$(result).each((index, item) => {
					
					console.log(item);
					//alert();
					let temp = `
						<tr>
							<td width="800">
								<div>
									<div>\${item.content}</div>
									
								</div>
							</td>
							<td>
							  	<div>\${item.id}</div>
						`;
				 		
					if (item.id == '${id}') {
					temp += `
							  	<c:if test="${not empty id}">
								<div>
									<button type="button" class="edit" onclick="editComment(\${item.seq});">수정</button>
									<button type="button" class="del" onclick="delComment(\${item.seq});">삭제</button>
								</div>					
								</c:if>
						`;
					}
						
					temp += `
							</td>
						</tr>								
						
					`;
					
					$('#reply--1 > div').append(temp);
					
					 
				});
				
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		});
		
	}
  
  </Script>


</body>

</html>