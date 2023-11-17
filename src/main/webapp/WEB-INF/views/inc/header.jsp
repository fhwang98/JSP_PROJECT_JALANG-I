<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- ======= Header ======= -->
<header id="header" class="header d-flex align-items-center fixed-top">
	
	
	<div class="container-fluid container-xl d-flex align-items-center justify-content-between">
		
		<a href="/jr/index.do" class="logo d-flex align-items-center"> <!-- Uncomment the line below if you also wish to use an image logo -->
			<img src="<%=request.getContextPath() %>/resources/img/jalangi.png" alt="">
			<!-- <h1>자랑이</h1> -->
		</a> 
		
		
			<i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i> 
			<i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>
		<nav id="navbar" class="navbar">
			
			<ul>
				<li class="dropdown">
					<a href="#">
						<span>자격증 조회</span> 
						<i class="bi bi-chevron-down dropdown-indicator"></i>
					</a>
					<ul>
						<li><a href="/jr/crt/crtlist.do">자격증 조회</a></li>
						<li><a href="/jr/crt/crtschlist.do">자격증 시험 일정 조회</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#">
						<span>자격증 추천</span> 
						<i class="bi bi-chevron-down dropdown-indicator"></i>
					</a>
					<ul>
						<li><a href="/jr/crt/crtrec.do">직업군 별 자격증 추천</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#">
						<span>교재 조회</span> 
						<i class="bi bi-chevron-down dropdown-indicator"></i>
					</a>
					<ul>
						<li><a href="/jr/book/booklist.do">교재 조회</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#">
						<span>학원 및 우리동네 학원</span> 
						<i class="bi bi-chevron-down dropdown-indicator"></i>
					</a>
					<ul>
						<li><a href="/jr/academy/academylist.do">학원 조회</a></li>
						<li><a href="#">우리동네 학원</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#">
						<span>직업 정보</span> 
						<i class="bi bi-chevron-down dropdown-indicator"></i>
					</a>
					<ul>
						<li><a href="/jr/job/list.do">직업 정보 조회</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#">
						<span>자유 게시판</span> 
						<i class="bi bi-chevron-down dropdown-indicator"></i>
					</a>
					<ul>
						<li><a href="/jr/board/boardlist.do">자유 게시판</a></li>
						<li><a href="/jr/faq.do">FAQ</a></li>
					</ul>
				</li>
				
				<c:if test="${lv == 1}">
				<li class="dropdown">
					<a href="#">
						<span>마이 메뉴</span> 
						<i class="bi bi-chevron-down dropdown-indicator"></i>
					</a>
					<ul>
						<li><a href="/jr/user/changemyinfo.do">개인정보 변경</a></li>
						<li><a href="/jr/study/mypage/list.do">나의 학습</a></li>
						<li><a href="/jr/crt/mypage/list.do">나의 자격증</a></li>
						<li><a href="/jr/qna/myqnalist.do">나의 문의</a></li>
						<li><a href="/jr/user/deleteuser.do">회원탈퇴</a></li>
					</ul>
				</li>
				</c:if>
				
				<c:if test="${lv == 2}">
				<li class="dropdown">
					<a href="#">
						<span>관리 메뉴</span> 
						<i class="bi bi-chevron-down dropdown-indicator"></i>
					</a>
					<ul>
						<li><a href="/jr/admin/home.do">관리자 홈</a></li>
						<li><a href="/jr/user/admin/useradminlist.do">회원 관리</a></li>
						<li><a href="/jr/crt/admin/crtadminlist.do">자격증 관리</a></li>
						<li><a href="/jr/crt/admin/crtschadminlist.do">자격증 시험 일정 관리</a></li>
						<li><a href="/jr/crt/admin/crttestadminlist.do">자격증 시험 관리</a></li>
						<li><a href="/jr/faq/admin/faqadminlist.do">FAQ</a></li>
						<li><a href="/jr/qna.do">회원 문의 관리</a></li>
						<li><a href="/jr/forbidden/admin/forbiddenadminlist.do">금지어 관리</a></li>
						<li><a href="/jr/academy/admin/list.do">학원 관리</a></li>

					</ul>
				</li>
				</c:if>
				
				<li class="dropdown">
					<a href="#" class="get-a-quote">
						<span>메뉴</span> 
					</a>
					<ul>
						<c:if test="${empty id}">
						<li><a href="/jr/user/login.do" class="active">로그인</a></li>
						<li><a href="/jr/user/signup.do" class="active">회원가입</a></li>
						</c:if>
						<c:if test="${not empty id}">
						<li></li>
						<li><a href="/jr/user/logout.do" class="active">로그아웃</a></li>
						</c:if>
						<li><a href="/jr/company/companyservice.do" class="active">기업 서비스</a></li>
					</ul>
					
				</li>
			</ul>
			
		</nav>
		
		<!-- .navbar -->

	</div>
</header>
<!-- End Header -->
<!-- End Header -->

  



