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

  
  </style>
  
  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
  </head>

  <body>

  	<%@ include file="/WEB-INF/views/inc/header.jsp" %>

  	<!-- main -->
  
  	<!-- ======= Breadcrumbs ======= -->
	<div class="breadcrumbs">
		<div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/backgroundImg2.png');">
			<div class="container position-relative">
				<div class="row d-flex justify-content-center">
					<div class="col-lg-6 text-center">
						<h2>비밀번호 재설정</h2>
					</div>
				</div>
			</div>
		</div>
		<nav>
			<div class="container">
				<ol>
					<li><a href="/jr/index.do">Home</a></li>
					<li>비밀번호 재설정</li>
				</ol>
			</div>
		</nav>
	</div>
	<!-- End Breadcrumbs -->
	
	<!-- ======= Get a Quote Section ======= -->
	<section id="get-a-quote" class="get-a-quote">

		<div class="container" data-aos="fade-up">

			<div class="row g-0" style="display: flex; justify-content: center;">
			
				<div class="col-lg-7" style="width: 500px;">
					<div class="row align-items-center justify-content-between">
	                	<a class="navbar-brand h1 text-center">
	                    	<span class="text-dark h4">비밀번호 재설정</span>                 
	                	</a>
            		</div>
				    
	                <form name="form" action="/jr/user/changepassword.do" method="POST">
	                	<div class="form-group">
		                	<div class="col-sm-10">
						    	<input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${name}">회원 비밀번호 변경
						    </div>
		                </div>
		                
		                <input type="hidden" name="id" value="${id}">
		                
						<div class="form-group has-success">
							<label class="form-label mt-4" for="pw">비밀번호</label>
							<input type="password" name="pw" class="form-control" id="pw" placeholder="4~12글자 영어와 숫자로만 입력해주세요" required>
							<div class="valid-feedback"></div>
						</div>
		
						<div class="form-group has-danger">
							<label class="form-label mt-4" for="pw2">비밀번호 재확인</label> 
							<input type="password" name="pw2" class="form-control" id="pw2" placeholder="비밀번호를 다시 한번 입력해주세요" required>
						</div>
						
						<br>
		                
						<div class="form-group" style="text-align:center;">
		               		<button type="submit" id="btn1" class="btn btn-outline-primary">비밀번호 재설정</button>
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
  
<%--   <%@ include file="/WEB-INF/views/inc/ad.jsp" %>
  <%@ include file="/WEB-INF/views/inc/side.jsp" %> --%>

  <script>
	
  	//버튼 이벤트 : 유효성검사
	document.getElementById('btn1').onclick = function() {
		if (checkAll()) {
			document.getElementById('btn1').form.submit();
		}
	};
  
	//회원가입 유효성검사
	function checkAll() {  
   		if (!checkPassword(form.id.value, form.pw.value, form.pw2.value)) {            
			return false;        
		}
	}
  
  
	// 공백확인 함수    
	function checkExistData(value, dataName) {        
		if (value == "") {            
			alert(dataName + " 입력해주세요!");            
			return false;        
		}        
		return true;    
	}
	
  
	//비밀번호 유효성검사 : 영어 대소문자 + 숫자 4~12자
	function checkPassword(id, pw, pw2) {        
			//비밀번호가 입력되었는지 확인하기        
			if (!checkExistData(pw, "비밀번호를"))            
				return false;        
			//비밀번호 확인이 입력되었는지 확인하기        
			if (!checkExistData(pw2, "비밀번호 확인을"))            
				return false;         
			var password1RegExp = /^([A-Za-z0-9]){4,12}$/; //비밀번호 유효성 검사        
			if (!password1RegExp.test(pw)) {            
				alert("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");            
				form.pw.value = "";            
				form.pw.focus();            
				return false;        
			}     
			
			//비밀번호와 비밀번호 확인이 맞지 않다면     
			if (pw != pw2) {            
				alert("두 비밀번호가 맞지 않습니다.");            
				form.pw.value = "";            
				form.pw2.value = "";            
				form.pw2.focus();            
				return false;        
			}         
			
			//아이디와 비밀번호가 같을 때        
			if (id == pw) {            
				alert("아이디와 비밀번호는 같을 수 없습니다!");            
				form.pw.value = "";            
				form.pw2.value = "";            
				form.pw2.focus();            
				return false;        
			}        
		return true; //확인이 완료되었을 때    
	}  
  </script>


</body>

</html>