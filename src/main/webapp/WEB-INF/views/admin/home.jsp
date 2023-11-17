<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>자랑이</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="<%=request.getContextPath() %>/resources/img/favicon.ico"
	rel="icon">
<link
	href="<%=request.getContextPath() %>/resources/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="<%=request.getContextPath() %>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/resources/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/resources/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath() %>/resources/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/vendor/aos/aos.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="<%=request.getContextPath() %>/resources/css/main.css"
	rel="stylesheet">

<!-- =======================================================
  * Template Name: Logis
  * Updated: Sep 18 2023 with Bootstrap v5.3.2
  * Template URL: https://bootstrapmade.com/logis-bootstrap-logistics-website-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->


<!-- Google Fonts -->

<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">


<!-- Template Main CSS File -->
<link href="<%=request.getContextPath() %>/resources/css/style.css"
	rel="stylesheet">

<!-- =======================================================
  * Template Name: NiceAdmin
  * Updated: Sep 18 2023 with Bootstrap v5.3.2
  * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->

<!-- chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<style>
</style>

<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
</head>

<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp"%>
	<script>
  	$('.header').css('background-color', 'rgba(14, 29, 52, 0.9)');
  </script>

	<!-- main -->





	<main id="main" class="main" style="margin-top: 100px;">

		<div class="pagetitle">
			<h1>Admin</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="/jr/index.do">Home</a></li>
					<li class="breadcrumb-item active">Admin</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->

		<section class="section dashboard" style="padding-top: 0px;">
      <!-- 전체 div -->
			<div class="row">












				<!-- 한줄 : 자격증, 교재, 회원 -->
				<div class="row">




				<!-- 열 : 자격증, 교재 -->
				<div class="col-xl-10 col-md-8">
				<div class="row">





						<!-- 자격증 -->
						<div class="col-xl-6">
							<div class="card top-selling overflow-auto">

								<div class="filter">
									<a class="icon" href="/jr/crt/admin/crtadminlist.do"><i
										class="bi bi-three-dots"></i></a>
								</div>

								<div id="crt" class="card-body pb-0">
									<h5 class="card-title">
										자격증 <!-- <span>| Today</span> -->
									</h5>

									<table class="table table-borderless">
										<thead>
											<tr>
												<th scope="col">#</th>
												<th scope="col">제목</th>
												<th scope="col">좋아요</th>
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${crtlist }" var="crt" varStatus="status">
											<tr>
												<td>${status.count }</td>
												<td>${crt.crtName }</td>
												<td>${crt.likeCnt }</td>
											</tr>
											</c:forEach>
										</tbody>
									</table>

								</div>

							</div>
						</div>
						<!-- 자격증 -->



						<!-- 교재 -->
						<div class="col-xl-6">
							<div class="card top-selling overflow-auto">

								<div class="filter">
									<a class="icon" href="/jr/book/admin/list.do"><i
										class="bi bi-three-dots"></i></a>
								</div>

								<div class="card-body pb-0">
									<h5 class="card-title">
										교재 <!-- <span>| Today</span> -->
									</h5>

									<table class="table table-borderless">
										<thead>
											<tr>
												<th scope="col">#</th>
												<th scope="col">제목</th>
												<th scope="col">좋아요</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${booklist}" var="book" varStatus="status">
											<tr>
												<td>${status.count}</td>
												<td>${book.bookName}</td>
												<td>${book.bookLike }</td>
											</tr>
											</c:forEach>
										</tbody>
									</table>

								</div>

							</div>
						</div>
						<!-- 교재 -->
							


						<!-- 자격증. 교재 -->
						</div>
						</div>




<!-- Extra small (xs)
Small (sm)
Medium (md)
Large (lg)
Extra large (xl)
Extra extra large (xxl) -->
							
							
						<!-- 회원 -->
						<div class="col-xl-2 col-md-4">
							<div class="card info-card sales-card">

								<div class="filter">
									<a class="icon" href="/jr/user/admin/useradminlist.do"><i
										class="bi bi-three-dots"></i></a>
								</div>

								<div id="usr" class="card-body">
									<h5 class="card-title">
										회원 <!-- <span>| Today</span> -->
									</h5>
									<canvas id="myChart"></canvas>

								</div>

							</div>
						</div>


						<script>
const ctx = document.getElementById('myChart');

new Chart(ctx, {
type: 'pie',
data: {
labels: [
'일반',
'탈퇴',
'신규'
],
datasets: [{
label: 'My First Dataset',
data: [${userCnt.cntAll}, ${userCnt.cntDel}, ${userCnt.cntNew}],
backgroundColor: [
'rgb(255, 99, 132)',
'rgb(54, 162, 235)',
'rgb(255, 205, 86)'
],
hoverOffset: 4,
borderWidth: 0,
scaleBeginAtZero: true
}]
},
options: {

}
});
</script>

						<!-- 회원 -->





					</div>



        <!-- 한줄 : 문의, 신고, 공지사항 -->
				<div class="col-xxl-12 col-xl-12">
					<div class="row">

        <!-- 열: 문의, 신고 -->
        <div class="col-xxl-8">

				<!-- 문의 -->
				<div class="col-12">
					<div class="card recent-sales overflow-auto">

						<div class="filter">
							<a class="icon" href="/jr/qna.do"><i
								class="bi bi-three-dots"></i></a>
						</div>

						<div class="card-body">
							<h5 class="card-title">
								최신 문의 <!-- <span>| Today</span> -->
							</h5>

							<table class="table table-borderless datatable">
								<thead>
									<tr>
										<th scope="col">회원ID</th>
										<th scope="col">제목</th>
										<th scope="col">등록일</th>
										<th scope="col">답변</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${ qlist }" var="dto">
									<tr>
										<td>${ dto.id }</td>
										<!-- 링크 수정 필요 -->
										<td><a href="/jr/qna/admin/detail.do?seq=${ dto.qnaSeqint }" class="text-primary">${dto.qnaTitle }</a></td>
										<td>${dto.qnaWriteDate }</td>
										<c:if test="${ dto.answerSeqint != 0 }">
										<td><span class="badge bg-success">완료</span></td>
										</c:if>
										<c:if test="${ dto.answerSeqint == 0 }">
										<td><span class="badge bg-warning">대기</span></td>
										</c:if>
									</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>

					</div>
				</div>
				<!-- 문의 -->



				<!-- 신고 -->
				<div class="col-12">
					<div class="card recent-sales overflow-auto">

						<div class="filter">
							<a class="icon" href="/jr/board/admin/list.do"><i
								class="bi bi-three-dots"></i></a>
						</div>

						<div class="card-body">
							<h5 class="card-title">
								신고 게시판 <!-- <span>| Today</span> -->
							</h5>

							<table class="table table-borderless datatable">
								<thead>
									<tr>
										<th scope="col">회원ID</th>
										<th scope="col">제목</th>
										<th scope="col">등록일</th>
										<th scope="col">조회수</th>
										<th scope="col">신고수</th>
										<th scope="col">상태</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${ reportList }" var="dto">
									<tr>
										<td>${ dto.id }</td>
										<td><a href="/jr/board/notice/detail.do?seq=${ dto.boardSeq }" class="text-primary">${ dto.boardTitle }</a></td>
										<td>${ dto.boardWriteDate }</td>
										<td>${ dto.boardHits }</td>
										<td>${ dto.boardReport }</td>
										<c:if test="${ dto.isBoardShow == '1' }">
										<td><span class="badge bg-success">공개</span></td>
										</c:if>
										<c:if test="${ dto.isBoardShow == '0' }">
										<td><span class="badge bg-danger">비공개</span></td>
										</c:if>
									</tr>
									</c:forEach>
									
								</tbody>
							</table>

						</div>

					</div>
				</div>
				<!-- 신고 -->

</div>












<div class="col-xxl-4">

				<!-- News & Updates Traffic -->
				<div class="card">
					<div class="filter">
						<a class="icon" href="/jr/board/admin/list.do"><i
							class="bi bi-three-dots"></i></a>
					</div>

					<div class="card-body pb-0">
						<h5 class="card-title">
							공지사항 <!-- <span>| Recent</span> -->
						</h5>

						<div class="news">
							<!-- 반복문 위치 -->
							<c:forEach items="${noticeList}" var="dto" varStatus="status">
							<div class="post-item clearfix">
								<h4>
								<!-- 링크 수정해야함 -->
									<a href="/jr/board/admin/noticelist.do?seq=${ dto.noticeBoardSeq }">${ dto.noticeBoardTitle }</a>
								</h4>
								<p>${ dto.noticeBoardContent }</p>
							</div>
							</c:forEach>
							<!-- 반복문 위치 -->

						</div>
						<!-- End sidebar recent posts-->

					</div>
				</div>
				<!-- End News & Updates -->

      </div>


      </div>
    </div>


      <!-- 전체 div -->
			</div>
		</section>

	</main>
	<!-- End #main -->





















	<!-- /main -->

	<!-- ======= Footer ======= -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
	<!-- End Footer -->

	<a href="#"
		class="scroll-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<div id="preloader"></div>



	<Script>
  

  


  
  </Script>


</body>

</html>
