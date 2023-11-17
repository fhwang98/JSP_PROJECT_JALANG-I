<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <style>
  	
  	#side {
  		transform: translate;
  		position: fixed;
  		width: 200px;
	    top: 297px; 
	    left: 0; 
	    padding: 2px;
  	}
  	
  	.icon {
  		width : 25px;
  		height : 25px;
  		margin-right : 10px;
  	}
  	
  	.accordion-button{
  		text-align : center;
  		font-weight : bold;
  		font-size : 12px;
  		font-family: "Segoe UI";
  	}
  	
  	
  	.accordion-body > code {
  		font-weight : bold;
  		font-size : 15px;
  		font-family: "Segoe UI";
  		color : gray;
  	}
  	
  	
  
  	
  </style>
  
  <div id="side">
  	<div class="accordion" id="accordionExample">
 	 <div class="accordion-item">
	    <h2 class="accordion-header">
	      <button id="btn1" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
	      <img class="icon" alt="" src="<%=request.getContextPath() %>/resources/img/icon1.png">
	        자격증 조회
	      </button>
	    </h2>
	    <div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionExample" >
	      <div class="accordion-body" onclick="location.href='index.html'">
	        <strong>1.</strong> 
	        <code>자격증 조회</code>
	      </div>
	    </div>
	  </div>
	  
	  <div class="accordion-item">
	    <h2 class="accordion-header">
	      <button id="btn2" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
	        <img class="icon" alt="" src="<%=request.getContextPath() %>/resources/img/icon2.png">
	        자격증 추천
	      </button>
	    </h2>
	    <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
	      <div class="accordion-body">
			<strong>1.</strong> 
	        <code>자격증추천</code>
	      </div>
	    </div>
	  </div>
	  
	  <div class="accordion-item">
	    <h2 class="accordion-header">
	      <button id="btn3" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
	        <img class="icon" alt="" src="<%=request.getContextPath() %>/resources/img/icon3.png">
	        교재 조회 및 맞춤 추천
	      </button>
	    </h2>
	    <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
	      <div class="accordion-body">
	        <strong>1.</strong> 
	        <code>교재조회</code>
	      </div>
	    </div>
	  </div>
	  
	  <div class="accordion-item">
	    <h2 class="accordion-header">
	      <button  id="btn4" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse4" aria-expanded="false" aria-controls="collapse4">
	        <img class="icon" alt="" src="<%=request.getContextPath() %>/resources/img/icon4.png">
	        학원 및 우리동네 학원
	      </button>
	    </h2>
	    <div id="collapse4" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
	      <div class="accordion-body">
	      	<strong>1.</strong> 
	        <code>학원 조회</code>
	        <br>
	        <strong>2.</strong> 
	        <code>우리동네학원</code>
	      </div>
	    </div>
	  </div>
	
  	<div class="accordion-item">
	    <h2 class="accordion-header">
	      <button id="btn5" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse5" aria-expanded="false" aria-controls="collapse5">
	        <img class="icon" alt="" src="<%=request.getContextPath() %>/resources/img/icon5.png">
	        직업 정보
	      </button>
	    </h2>
	    <div id="collapse5" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
	      <div class="accordion-body">
	      	<strong>1.</strong> 
	        <code>직업정보조회</code>
	      </div>
	    </div>
	  </div>
	  
  	  <div class="accordion-item">
	    <h2 class="accordion-header">
	      <button id="btn6" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse6" aria-expanded="false" aria-controls="collapse6">
	        <img class="icon" alt="" src="<%=request.getContextPath() %>/resources/img/icon6.png">
	        자유 게시판
	      </button>
	    </h2>
	    <div id="collapse6" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
	      <div class="accordion-body">
	      	<strong>1.</strong> 
	        <code>자유게시판</code>
	        	        <br>
	        <strong>2.</strong> 
	        <code>FAQ</code>
	        
	      </div>
	    </div>
	  </div>
	 </div>
  </div>
  
  
  <script>

  $(document).ready(function() {
	    // 초기 로드 시와 창 크기 변경 시에 함수를 실행
	    sideBar();
	    expend();

	    // 창 크기 변경 이벤트를 모니터링
	    $(window).on("resize", function() {
	    	sideBar();
	    });

	    function sideBar() {
	        var windowWidth = $(window).width();
	        const currentURL = window.location.href;
	        

	        
	        
	        if (windowWidth <= 1500 || currentURL == "http://localhost:8090/jr/index.do") {
	            // id="ad"인 div 태그 숨김 또는 제거
	            $("#side").hide();
	            // 또는 $("#ad").remove();
	        } else {
	            // 창의 너비가 1700px 이상이거나 URL이 "http://localhost:8090/jr/index.do"와 일치하면 id="ad"인 div 태그 다시 표시
	            $("#side").show();
	        }
	    }
	    //URL로 이동하면 해당 navigation expended 
	    function expend() {
	    	var currentUrl = window.location.href;
	    	
	    	/* if(currentUrl.startsWith("http://localhost:8090/jr/certificate/")){
	    		
	    		if(currentUrl.startsWith("http://localhost:8090/jr/certificate/rec/")){
	    			$('#btn2').click();
	    		}else{
	    			$('#btn1').click();
	    		}

	    	  	
	    	}  */
	    	if(currentUrl.startsWith("http://localhost:8090/jr/crt/crtlist.do")){
	    		$('#btn1').click();
	    	}
	    	
	    	if(currentUrl.startsWith("http://localhost:8090/jr/crt/crtrec.do")){
	    		$('#btn2').click();
	    	}
	    	
	    	if(currentUrl.startsWith("http://localhost:8090/jr/book")){
	    		$('#btn3').click();
	    	}
	    	
	    	if(currentUrl.startsWith("http://localhost:8090/jr/academy")){
	    		$('#btn4').click();
	    	}
	    	
	    	if(currentUrl.startsWith("http://localhost:8090/jr/job")){
	    		$('#btn5').click();
	    	}
	    	
	    	if(currentUrl.startsWith("http://localhost:8090/jr/board")){
	    		$('#btn6').click();
	    	}
	    	
	    	
	    	
	    }
	});
  
  

  </script>