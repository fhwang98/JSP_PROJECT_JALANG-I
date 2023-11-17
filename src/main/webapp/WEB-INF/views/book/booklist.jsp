<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
  ins {
    text-decoration: none;
}
.form-search {
  display: flex; 
  justify-content: center; 
}
  
.form-search input {
  width: 400px; /* Reduced width */
}

.form-search button {
  width: 100px; /* Reduced width */
}
  
#product > section {
    padding: 16px;
    box-sizing: border-box;
}

.list {
  display: flex;
  justify-content: center;
} 

.thumb > img {
   padding-bottom: 10px; /* Reduced padding */
   width: 120px; /* Reduced width */
   height: 120px; /* Reduced height */
}

#tbl-list {
	width: 800px;
}

#tbl-list td {
	border-bottom: 1px solid black;
	height: 200px; /* Reduced height */
	padding: 10px;
}

#tbl-list td:nth-child(1) {
	width: 120px; /* Reduced width */
}

#tbl-list td:nth-child(2) {
	width: auto;
	text-align: left;
	vertical-align: middle;
}

#tbl-list td:nth-child(3) {
	width: 140px;
}

#tbl-list td:nth-child(4) {
	width: 200px;
}

.a{
	color: black;
	font-size: 16px;
}


.name{
	font-weight: bold;
	color: black;
	font-size: 20px;
}
.desc{
	font-weight: normal;
	color: black;
}

#pagebar-container {
    text-align: center;
    color: black;
}
        
        
#pagebar{
    color:black;
}

  
  </style>
  
  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
  </head>

  <body>

  <%@ include file="/WEB-INF/views/inc/header.jsp" %>

  <!-- main -->

    
  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs">
      <div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/backgroundImg2.png');">
        <div class="container position-relative">
          <div class="row d-flex justify-content-center">
            <div class="col-lg-6 text-center">
              <h2>교재 조회</h2>
              
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="index.html">Home</a></li>
            <li>교재 조회</li>
          </ol>
          
               <form action="/jr/book/booklist.do" class="form-search d-flex align-items-stretch mb-3" data-aos="fade-up" data-aos-delay="200" method="GET">
            <!-- <div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
    검색항목
  </button>
  <ul class="dropdown-menu dropdown-menu-dark">
    <li><a class="dropdown-item active" href="#">교재명</a></li>
    <li><a class="dropdown-item" href="#">출판사</a></li>
    <li><a class="dropdown-item" href="#">자격증</a></li>
    <li><a class="dropdown-item" href="#">난이도</a></li>
  </ul>
</div> -->
			
				<select id="column" name="column">
					<option value="bookname">교재명</option>
					<option value="publisher">출판사</option>
					<option value="crtname">자격증</option>
				</select>
            <input type="text" name="word" class="form-control" placeholder="교재를 검색해보세요">
            <button type="submit" class="btn btn-primary">Search</button>
     </form>
        </div>
      </nav>
      
    </div><!-- End Breadcrumbs -->
    
    


      <div class="container" data-aos="fade-up">

     
         <section class="list">

                <table id="tbl-list">
                	<c:forEach items="${list}" var="dto">
                    <tr>
                        <td><a href="#" class="thumb">
                            <img src="${dto.bookImg}" alt="상품이미지">
                        </a></td>
                        <td>
                            <a href="/jr/book/bookdetail.do?seq=${dto.bookseq}&search=${map.search}&word=${map.word}" class="name">${dto.bookname}</a>
                           	<br>
                            <a href="#" class="desc">${dto.author}</a>
                            <hr>
                            <a>${dto.crtName}</a>
                        </td>
                        <td>
                            <ul>	
                                <li><ins class="dis-price"></strong><fmt:formatNumber value="${dto.price}" pattern="#,##0"/>원</ins></li>
                            </ul>
                        </td>
                           
             
                    </tr>
                   </c:forEach>
                   
                  
                </table>
           </section>
   		 <div id="pagebar-container">
      		  <div id="pagebar">${pagebar}</div>
   		 </div>
       </div>
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
  
  <c:if test="${map.search == 'y'}">
	$('input[name=word]').val('$(map.word)');  
  </c:if>
  </Script>


</body>

</html>