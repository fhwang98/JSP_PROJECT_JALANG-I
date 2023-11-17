<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

  <!-- Custom Styles -->
<style >
/*
    body {
      font-family: 'Open Sans', sans-serif;
      background-color: #f8f9fa;
      color: #495057;
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }
*/
    #tbl-list {
      width: 100%;
      border-collapse: collapse;
      margin-top: 30px;
      text-align: center;
    }

    #tbl-list td {
      border: 1px solid #dee2e6;
      padding: 15px;
      text-align: left;
    }

    .list-heading {
      font-size: 24px;
      font-weight: bold;
      margin-bottom: 20px;
    }

    .search-form {
      margin-top: 20px;
      margin-bottom: 40px;
    }

    .search-form input {
      width: 70%;
      padding: 10px;
      border: 1px solid #007bff;
      border-radius: 5px;
    }

    .search-form button {
      padding: 10px 20px;
      margin-left: 10px;
      background-color: #007bff;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    #pagebar {
      margin-top: 30px;
    }

    .breadcrumbs {
      background-size: cover;
      background-position: center;
      color: #fff;
      text-align: center;
    }
    
    .custom-row{
    	
    	background-color:#eaf7ff;
    }

    .breadcrumbs h2 {
      font-size: 32px;
      font-weight: bold;
    }

    .breadcrumbs p {
      font-size: 18px;
    }

    .breadcrumbs nav {
      margin-top: 20px;
    }

    .breadcrumbs ol {
      list-style: none;
      padding: 0;
      margin: 0;
    }

    .breadcrumbs ol li {
      display: inline;
      margin-right: 10px;
    }

    .breadcrumbs ol li a {
      color: #fff;
      text-decoration: none;
      font-weight: bold;
    }

    .form-search {
      display: flex;
      align-items: stretch;
      margin-bottom: 20px;
    }

    .dropdown {
      margin-right: 10px;
    }

    .dropdown-toggle {
      background-color: #007bff;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    .form-search input, .form-search button {
      border-radius: 5px;
    }

    #main {
      padding: 40px 0;
    }

    .container {
      position: relative;
    }

    .list img {
      max-width: 100%;
      height: auto;
      border-radius: 5px;
    }
    #tbl-list th{
    
    width: 410px;
    border-right: 1px solid #495057;
}
    
    .academyname {
    	font-size: 30px;
    	font-weight: bold;
    }
    a {
    color: black;
    text-decoration: none;
}

.eduname {
	font-size: 20px;	
}

.crtname{
	font-size: 30px;
	background-color: #f4f6fb;
	border: 1px solid white;
	
}

        #pagebar-container {
            text-align: center;
            color: black;
        }
	#tbl-list > tbody > tr:nth-child(1) > th {
		border-radius: 30px;
		border: 1px solid white;
	}
	
.search{
	display: flex;
	padding-left: 38%;
}
.form-control{
	width: 200px;
}
#column{
	padding-top: 5px;
}
</style>

  <%@ include file="/WEB-INF/views/inc/asset.jsp" %>
  
  
  </head>

  <body>

  <%@ include file="/WEB-INF/views/inc/header.jsp" %>

  <!-- main -->

    
  <main id="main" >

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs" style="position: relative; top: -35px;">
      <div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/backgroundImg2.png');">
        <div class="container position-relative">
          <div class="row d-flex justify-content-center">
            <div class="col-lg-6 text-center">
              <h2>학원 조회</h2>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="/jr/index.do" style="color: #333333;">Home</a></li>
            <li>학원 조회</li>
          </ol>
          			<div class="search">
					<form action="/jr/academy/academylist.do"
						class="form-search d-flex align-items-stretch mb-3"
						data-aos="fade-up" data-aos-delay="200" method="GET">
						<select id="column" name="column">
							<option value="academyName">학원명</option>
							<option value="crtName">자격증</option>
							<option value="eduName">교육명</option>
						</select>
						 <input type="text" name="word" class="form-control"
							placeholder="검색해보세요">
						<input type="submit" class="btn btn-primary" value="검색하기">
					</form>
				</div>
					
				
      </nav>

      
    </div><!-- End Breadcrumbs -->
    <form action="#" class="form-search d-flex align-items-stretch mb-3" data-aos="fade-up" data-aos-delay="200">
</form>
    


      <div class="container" data-aos="fade-up">

     
<section class="list">
    <c:forEach items="${list}" var="dto">
        <table id="tbl-list" border="1">
            <tr>
                <th  class="custom-row" rowspan="6">
                    <a href="${dto.eduLink}" target="_blank">
                        <div class="academyname">${dto.academyName}</div>
                        <div>${dto.academyLocation}</div>
                        <div>${dto.academyTel}</div>
                    </a>
                </th>
                <td class="crtname">${dto.crtName}<br><div class="eduname">${dto.eduName}</div></td>
            </tr>
            <tr>
                <td>모집일: ${dto.eduRcStartDate}~${dto.eduRcEndDate}</td>
            </tr>
            <tr>
                <td>교육일: ${dto.eduStartDate}~${dto.eduEndDate}</td>
            </tr>
            <tr>
                <td>학원평점: ${dto.academyStarS}</td>
            </tr>
            <!-- Additional rows if needed -->
            <!-- <tr>
                <td>13</td>
            </tr>
            <tr>
                <td>13</td>
            </tr> -->
        </table>
    </c:forEach>
</section>



      <!-- 페이지바 표시 -->
  		 <div id="pagebar-container">
      		  <div id="pagebar">${pagebar}</div>
   		 </div>
    </div>
  </main><!-- End #main -->

  <!-- Footer -->
  <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
  <!-- End Footer -->

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>
  
  <%@ include file="/WEB-INF/views/inc/ad.jsp" %>
  <%@ include file="/WEB-INF/views/inc/side.jsp" %>
 
 
   <Script>
  
  <c:if test="${map.search == 'y'}">
  	$('select[name=column]').val('${map.column}');
	$('input[name=word]').val('${map.word}');  
  </c:if>
  </Script>


</body>

</html>