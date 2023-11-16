<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

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
  <style>

	section container{
		border-radius: 50px;
		/* border: 1px solid black;  */
	}
	#table th {
		background-color: #f2f2f2;
	}
	  
  	
  
  </style>
  
  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  
  
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.14/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.14/css/gijgo.min.css" rel="stylesheet" type="text/css" />
  
  
  
  </head>

  <body>

  <%@ include file="/WEB-INF/views/inc/header.jsp" %>

  <!-- main -->
  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs">
      <div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/page-header.jpg');">
        <div class="container position-relative">
          <div class="row d-flex justify-content-center">
            <div class="col-lg-6 text-center">
              <h2>My 자격증 추가</h2>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="index.html">마이페이지</a></li>
            <li>나의 자격증</li>
            <li>추가</li>
          </ol>
        </div>
      </nav>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Pricing Section ======= -->
    <section>
      <div class="container p-3 mb-2 bg-body-tertiary" data-aos="fade-up" style="width: 1000px">
        <div class="row gy-2 pricing-item" data-aos="fade-up" data-aos-delay="100">
        
        
        <div class="container text-center">
		  <div class="row">
		    <div class="col">
		      <h2>자격증 추가하기</h2>
		    </div>
		  </div>
		  
		  <div class="row">
		    
		    <div class="card shadow mb-4">
		    			<form method="POST" action="/jr/crt/mypage/add.do" id="form1">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="table">
                                    <thead >
                                        <tr>
                                            <th>자격증명</th>
                                            <th>취득일</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                        <tr>
                                            <td>
                                            	<input type="text" name="crtName" class="form-control" required autofocus id="crtN">
                                            </td>
                                            <td><input type="text" id="datepicker" name="date" class="form-control" placeholder="YYYY-MM-DD" required></td>
                                        </tr>
                                    </tbody>
                                    
                                </table>
                            </div>
                            <button class="btn btn-primary" type="submit">저장</button>
                        </div>
                        </form>
                    </div>
		  </div>
		  
		  <div class="row">
		  	
		  </div>
		</div>
		
			
		</div>
      </div><!-- End Pricing Item -->
	</section>

  </main><!-- End #main -->	
  
  
  
  

  <!-- /main -->

  <!-- ======= Footer ======= -->
  <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
  <!-- End Footer -->

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>
  
  <%@ include file="/WEB-INF/views/inc/ad.jsp" %>
  <%@ include file="/WEB-INF/views/inc/side.jsp" %>

  <Script>
    $(function () {
		$("#crtN").keyup(function(event) {
			//var params = $("#crtN").val(); //파라미터 자동으로 연결  searchWord=s
			console.log($("#crtN").val());
			
			$.ajax({
	   			url:"/jr/job/search.do"
	   			,dataType:"json"
	   			,type:"get"
	   			,data: {
					
	   				
	   				jobName: $("#crtN").val()
					
				}
	   			,cache:false 
	   			,success:function(result){  //["JAMES","JONES"]
	   				console.log(result);
	   				$( "#crtN" ).autocomplete({
	   			      source: result //검색한 값이 소스로 들어가도록
	   			    });
	   			}
			    ,error: function(a,b,c) {
					console.log(a,b,c)
				}
	   		});//ajax
			
			
		}); //keyup
	});
  
    $('#datepicker').datepicker({
    	format: 'yyyy-mm-dd',
        uiLibrary: 'bootstrap5'
    });
    
    
  </Script>


</body>

</html>