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
	.teltext {
		display: flex;
	}
	
	.teltext > span{
		margin: 10px 10px;
	}
  </style>
  
  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
  </head>

  <body>

  <%@ include file="/WEB-INF/views/inc/header.jsp" %>
	<main id="main">
		<!-- ======= Breadcrumbs ======= -->
		<div class="breadcrumbs">
			<div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/backgroundImg2.png');">
				<div class="container position-relative">
					<div class="row d-flex justify-content-center">
						<div class="col-lg-6 text-center">
							<h2>회원가입</h2>
						</div>
					</div>
				</div>
			</div>
			<nav>
				<div class="container">
					<ol>
						<li><a href="/jr/index.do">Home</a></li>
						<li>회원가입</li>
					</ol>
				</div>
			</nav>
		</div>
		<!-- End Breadcrumbs -->
		
		
		<!-- main -->
		<section id="get-a-quote" class="get-a-quote">
			<div class="container" data-aos="fade-up">
				<div class="row g-0" style="display: flex; justify-content: center;">
					<div class="col-lg-7" style="width: 500px;">
						<div class="row align-items-center justify-content-between">
		                	<a class="navbar-brand h1 text-center">
		                    	<span class="text-dark h4">회원가입</span>                 
		                	</a>
	            		</div>
						<form name="form" action="/jr/user/signup.do" method="POST">
						
		                	<div class="form-group">
			               		<label for="id" class="form-label mt-4">아이디</label>
			                    <input type="text" name="id" class="form-control" id="id" aria-describedby="idHelp" placeholder="4~16글자 영어와 숫자로만 입력해주세요" required>
			               		<button id="btn" type="button" class="btn btn-outline-primary">중복검사</button>
			               		<span id="result" style="color:red; margin-left:10px;"> </span>
			                </div>
			                
							<div class="form-group has-success">
								<label class="form-label mt-4" for="pw">비밀번호</label>
								<input type="password" name="pw" class="form-control" id="pw" placeholder="4~12글자 영어와 숫자로만 입력해주세요" required>
								<div class="valid-feedback"></div>
							</div>
			
							<div class="form-group has-danger">
								<label class="form-label mt-4" for="pw2">비밀번호 재확인</label> 
								<input type="password" name="pw2" class="form-control" id="pw2" placeholder="비밀번호를 다시 한번 입력해주세요" required>
							</div>
							
<!-- 비밀번호 확인 불일치 시 에러 메시지 -->
<!-- <div class="invalid-feedback" id="passwordMismatch">비밀번호가 일치하지 않습니다</div> -->
							
			                <div class="form-group">
			               		<label for="name" class="form-label mt-4">이름</label>
			                    <input type="text" name="name" class="form-control" id="name" aria-describedby="emailHelp" placeholder="이름" required>
			                </div>
			                
			                <div class="form-group">
			               		<label for="eMail" class="form-label mt-4">이메일</label>
			                    <input type="email" name="eMail" class="form-control" id="eMail" aria-describedby="emailHelp" placeholder="이메일" required>
			                </div>
			                
			                <div class="form-group">
			               		<label for="birthDate" class="form-label mt-4">생년월일</label>
			                    <input type="date" name="birthDate" class="form-control" id="birthDate" aria-describedby="emailHelp" placeholder="생일" required>
			                </div>
			                
						    <div class="form-group">
						      <label for="exampleSelect1" class="form-label mt-4">성별</label>
						      <select class="form-select" name="sex" id="exampleSelect1" required>
						        <option>남</option>
						        <option>여</option>
						      </select>
						    </div>
						    						   
 						    <div class="form-group">
			               		<label for="phoneNum" class="form-label mt-4">핸드폰번호</label>
			               		<div class="teltext">
				                    <input type="tel" name="phoneNum1" class="form-control" id="phoneNum1" aria-describedby="emailHelp" value="010" required>
				                    <span> - </span>
				                    <input type="tel" name="phoneNum2" class="form-control" id="phoneNum2" aria-describedby="emailHelp" placeholder="가운데 자리" required>
				                    <span> - </span>
				                    <input type="tel" name="phoneNum3" class="form-control" id="phoneNum3" aria-describedby="emailHelp" placeholder="마지막 자리" required>
			               		</div>
						    </div>
						    
						   	<br>
		
							<div class="form-check mb-3">
								<input type="checkbox" class="form-check-input" id="agreeform1" required> 
								<label class="form-check-label" for="validationFormCheck1">이용약관(필수)</label>
								<div class="invalid-feedback">회원가입을 하시려면 동의를 해주세요</div>
								<a class="icon-link icon-link-hover" data-bs-toggle="modal" data-bs-target="#essentialTermsofUse">
									상세 약관 
									<svg class="bi" aria-hidden="true">
										<use xlink:href="#arrow-right"></use>
									</svg>
								</a><br>
							</div>
							
							<div class="form-check">
								<input type="checkbox" class="form-check-input" id="agreeform2"> 
								<label class="form-check-label">이용약관(선택)</label>
								<a class="icon-link icon-link-hover" data-bs-toggle="modal" data-bs-target="#OptionalTermsofUse">
									상세 약관 
									<svg class="bi" aria-hidden="true">
										<use xlink:href="#arrow-right"></use>
									</svg>
								</a>
							</div>
		
		
							<!-- 회원가입 약관동의 -->
							<div class="form-group modal fade" id="essentialTermsofUse" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
									<div class="modal-content">
										<div class="modal-header">
											<h1 class="modal-title fs-5" id="staticBackdropLabel">필수 이용약관</h1>
											<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
		
										<div class="modal-body">essential</div>
		
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
											<button type="button" class="btn btn-primary" onclick="agreeTerms()">동의</button>
										</div>
									</div>
								</div>
							</div>
							<div class="modal fade" id="OptionalTermsofUse" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
									<div class="modal-content">
										<div class="modal-header">
											<h1 class="modal-title fs-5" id="staticBackdropLabel">선택 이용약관</h1>
											<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
		
										<div class="modal-body">optional</div>
		
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
											<button type="button" class="btn btn-primary" onclick="checkAgree()">동의</button>
										</div>
									</div>
								</div>
							</div>
			                
			                <br>
			                
							<div class="d-grid gap-2">
			                    <button type="button" class="btn btn-primary btn-lg" id="btn1">가입하기</button>
			                </div>
						</form>
					</div>
				</div>
			</div>
		</section>
		
		<!-- /main -->
		
	</main>



  <!-- ======= Footer ======= -->
  <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
  <!-- End Footer -->

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>
  
  <%-- <%@ include file="/WEB-INF/views/inc/ad.jsp" %>
  <%@ include file="/WEB-INF/views/inc/side.jsp" %> --%>

	<script>
	
		//아이디 중복 체크
		$('#btn').click(function(){
			$.ajax({
				type: 'POST',
				url: '/jr/user/idcheck.do',
				data: {
					id: $('#id').val()
				},
				dataType: 'json',
				success: function(result) {
					//alert(result.message); //가능(0), 불가능(1)
					
					if (result.message == 0) {
						$('#result').text('사용 가능한 아이디입니다.');
						$('#regBtn').prop('disalbed', false);
					}
					else {
						$('#result').text('이미 사용중인 아이디입니다.');
						$('#regBtn').prop('disalbed', true);
					}
				},
				errors: function(a,b,c) {
					console.log(a,b,c);
				}
			});
		});
		
		
		//버튼 이벤트 : 유효성검사
		document.getElementById('btn1').onclick = function() {
			if (checkAll()) {
				document.getElementById('btn1').form.submit();
			}
		};
		
		
		//회원가입 유효성검사
		function checkAll() {  
	   		if (!checkUserId(form.id.value)) {            
				return false;        
			} else if (!checkPassword(form.id.value, form.pw.value, form.pw2.value)) {            
				return false;        
			} else if (!checkMail(form.eMail.value)) {            
				return false;        
			} else if (!checkName(form.name.value)) {            
				return false;        
			}     
			return true;
		}
		
		// 공백확인 함수    
		function checkExistData(value, dataName) {        
			if (value == "") {            
				alert(dataName + " 입력해주세요!");            
				return false;        
			}        
			return true;    
		}
		
		//아이디 유효성검사 : 영어 대소문자 + 숫자 4~16자 
		function checkUserId(id) {        
			//Id가 입력되었는지 확인하기        
			if (!checkExistData(id, "아이디를")){            
				return false;  
			}	
			var idRegExp = /^([A-Z0-9a-z]){4,16}$/; //아이디 유효성 검사        
			if (!idRegExp.test(id)) {            
				alert("아이디는 영문 대소문자와 숫자 4~16자리로 입력해야합니다!");            
				form.id.value = "";            
				form.id.focus();            
				return false;        
			}        
			return true; //확인이 완료되었을 때    
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
			
		
		//이메일 유효성검사 : input type을 email로 설정해서 필요 없...을지도..
		function checkMail(eMail) {        
			//mail이 입력되었는지 확인하기        
			if (!checkExistData(eMail, "이메일을"))            
				return false;         
			var emailRegExp = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;        
			if (!emailRegExp.test(eMail)) {            
				alert("이메일 형식이 올바르지 않습니다!");            
				form.eMail.value = "";            
				form.eMail.focus();            
				return false;        
			}        
			return true; //확인이 완료되었을 때    
		}     
		
		
		//이름 유효성검사
		function checkName(name) {        
			if (!checkExistData(name, "이름을"))            
			return false;         
			
			var nameRegExp = /^[가-힣]{2,7}$/;        
			if (!nameRegExp.test(name)) {            
				alert("이름이 올바르지 않습니다.");            
				return false;        
			}        
			return true; //확인이 완료되었을 때    
		}
		
		
		
		
		// 필수약관 동의 버튼을 누를 때 실행되는 함수
	    function agreeTerms() {
	        // 체크박스의 상태를 변경 (체크됨)
	        document.getElementById('agreeform1').checked = true;
	
	        // 모달을 닫음
	        $('#essentialTermsofUse').modal('hide');
	    }
		
		
	 	// 선택약관 동의 버튼을 누를 때 실행되는 함수
	    function checkAgree() {
	        // 체크박스의 상태를 변경 (체크됨)
	        document.getElementById('agreeform2').checked = true;
	
	        // 모달을 닫음
	        $('#OptionalTermsofUse').modal('hide');
	    }
	</script>


</body>

</html>