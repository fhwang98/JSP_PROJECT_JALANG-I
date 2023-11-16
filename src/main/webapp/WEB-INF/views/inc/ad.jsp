<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <style>
  	
  	#ad {
  		position: fixed;
  		width: 150px;
	    top: 290px; 
	    right: 0; 
	    background-color: white;
	    border: 1px solid #000;
  	}
  	
  	#ad img{
  		width: 150px;
  		background-size: cover;
  		align : center;
  	} 
  	
  	#adText{
  		text-align : center;
  		font-weight : bold;
  		font-style: oblique;
  		text-decoration: underline;
  	}
  	
  </style>
  
  <div id="ad">
  	<div><img alt="" src="<%=request.getContextPath() %>/resources/img/add01.jpg"></div>
  	<p id=adText>Visit a site</p>
  
  </div>
  
  
  <script>
  console.log(window.location.href);

  $(document).ready(function() {
	    // 초기 로드 시와 창 크기 변경 시에 함수를 실행
	    adjustAdVisibility();

	    // 창 크기 변경 이벤트를 모니터링
	    $(window).on("resize", function() {
	        adjustAdVisibility();
	    });

	    function adjustAdVisibility() {
	        var windowWidth = $(window).width();

	        
	        
	        if (windowWidth <= 1500) {
	            // id="ad"인 div 태그 숨김 또는 제거
	            $("#ad").hide();
	            // 또는 $("#ad").remove();
	        } else {
	            // 창의 너비가 1700px 이상이거나 URL이 "http://localhost:8090/jr/index.do"와 일치하면 id="ad"인 div 태그 다시 표시
	            $("#ad").show();
	        }
	    }
	});
  
  
  

  </script>