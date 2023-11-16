<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    session.setAttribute("A", 0);
    session.setAttribute("B", 0);
    session.setAttribute("C", 0);
    session.setAttribute("D", 0);
    session.setAttribute("E", 0);
    session.setAttribute("F", 0);
    session.setAttribute("G", 0);
    session.setAttribute("H", 0);
%>
<!DOCTYPE html>

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Logis Bootstrap Template - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="<%=request.getContextPath() %>/resources/img/favicon.png" rel="icon">
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

  
  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
 <style>
            h1 {
                font-family: 맑은 고딕;
                font-size: 30px;
                text-align: center;
            }
            .answer {
                font-family: 맑은 고딕;
                font-size: 20px;
                text-align: center;
                margin-top : 30px;
            }
            
            [type="radio"] {
			  appearance: none;
			  border: max(2px, 0.1em) solid gray;
			  border-radius: 50%;
			  width: 50px;
			  height: 50px;
			  transition: border 0.5s ease-in-out;
			  margin : 10px;
			}
			
			[type="radio"]:checked {
			  border: 0.4em solid aqua;
			}
			
			[type="radio"]:focus-visible {
			  outline-offset: max(5px, 0.3em);
			  outline: max(5px, 0.3em) dotted lightblue;
			}
			
			[type="radio"]:hover {
			  box-shadow: 0 0 0 max(4px, 0.2em) lightgray;
			  cursor: pointer;
			}
			
			[type="radio"]:hover + span {
			  cursor: pointer;
			}
			
			fieldset {
			  display: flex;
			  justify-content: center;
			  border: none;
			  margin: 0;
			  padding: 40px 20px;
			}
			
			*,
			*::before,
			*::after {
			  box-sizing: border-box;
			}
			
			strong {
				 font-family: 맑은 고딕;
                font-size: 25px;
                text-align: center;
                margin : 16px;
			}
			
			hr {
			    background:#c19cf0;
			    height:3px;
			    border:0;
			}
			
			
			.page-header d-flex align-items-center {
				height : 800px;
			}
			
			
			
			

  </style>
</head>

<body>

  <%@ include file="/WEB-INF/views/inc/header.jsp" %>

  <!-- ======= <main id="main"> 여기부터 집어넣기 ======= -->
  
    <main id="main">
    

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs">
      <div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/page-header.jpg');">
        <div class="container position-relative">
          <div class="row d-flex justify-content-center">
            <div class="col-lg-6 text-center">
              <h2>직업적성검사</h2>
            </div>
          </div>
        </div>
      </div>
       <nav>
        <div class="container">
          <ol>
            <li><a href="/jr/index.do">Home</a></li>
            <li>직업정보</li>
          </ol>
        </div>
      </nav>
    </div><!-- End Breadcrumbs -->
   <%
    String []text = {"1.친한 사람이나 친구가 없는 모임에 가면 불편한 편이다.",
    		"2.평소에 침착하고 조용하다는 말을 자주 듣는다.",
    		"3.의견을 말하기에 앞서 신중히 생각하는 편이다.",
    		"4.사람들과 어울리는 것보다 혼자 있는 게 좋다.",
    		"5.상대방이 말할 때 끼어들지 않고 끝까지 잘 듣는 편이다.",
    		"6.말이 없어 주변 사람들이 답답해 할 때가 있다.",
    		"7.말을 할 때 제스쳐를 사용하면 어색한 편이다.",
    		"8.활동적인 취미 보다는 조용한 취미를 즐긴다.",
    		"9.단체 활동보다는 일대일 대화가 좋다.",
    		"10.생일에 친한 친구 한두 명이나 가족과 소박하게 지내는 것이 좋다.",
    		"11.물건을 살때 디자인 보다는 기능적 실효성을 중요하게 생각한다.",
    		"12.주변 사람들의 키, 나이 등 특징을 잘 기억한다.",
    		"13.새로운 환경에서 일하기 보다는 늘상 하던 일이 편안하다.",
    		"14.현실 감각보다는 상상력이 풍부한 편이다.",
    		"15.참을성 있고 꾸준하다는 말을 자주 듣는 편이다.",
    		"16.나는 심플하고 명확한 것을 선호하는 편이다.",
    		"17.확실하지 않은 가능성에 대해서 별로 듣고 싶지가 않다.",
    		"18.타인에게 내 자신을 드러내지 않는 편이다.",
    		"19.내가 좋아하는 영화는 보고 또 본다.",
    		"20.새로운 기술을 배우는 것 보다는 가지고 있는 기술을 사용하는 것이 좋다."};
   
    
   
   %>
   
   		<div style="background-image:url(<%=request.getContextPath()%>/resources/img/testpage_header.png); width: 100vw; height:800px; text-align:center;">
   		</div>
   		<br>
        <h1>자랑이 성향테스트</h1>
        <br>
        <form action="/jr/jobTestResult.do" method="post">
        <% 
		 for(int i=0; i<text.length; i++){
	 %>	
			 <h2 class="answer"><%=text[i] %></h2>
        <div align=center>
            	<fieldset>
            		<strong>비동의</strong>
  				
   					 <input type="radio" name="page<%= i %>" value="1" checked/>
    
  					 <input type="radio" name="page<%= i %>" value="2" />
   	
   					 <input type="radio" name="page<%= i %>" value="3"  />
  
   					 <input type="radio" name="page<%= i %>" value="4" />
    
   					 <input type="radio" name="page<%= i %>" value="5" />
   					 
   					 <strong>동의</strong>
   					 
    
  				</fieldset>
             
        </div>
        <hr>
	 <%
	 	}
	 %>
       <br>
       
       <div style="text-align:center;">
       <button type="submit" class="btn btn-primary btn-lg">결과보기</button>
       </div>
		</form>
  </main><!-- End #main -->
  
  
  
  
  
  <!-- ======= </main> 까지 집어넣기 ======= -->
  
  <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
  

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>

  <%@ include file="/WEB-INF/views/inc/ad.jsp" %>
  <%@ include file="/WEB-INF/views/inc/side.jsp" %>
  
  

  


</body>

</html>