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

  <!-- Google Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
    rel="stylesheet">

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
  <style>
    body {
      font-family: 'Arial', sans-serif;
      background-color: #f4f4f4;
      color: #333;
    }

    .book-details {
      /* max-width: 1000px;
      margin: auto;
      padding: 20px; */
      background-color: #fff;
      border: 1px solid #ddd;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .book-details img {
      max-width: 100%;
      height: auto;
      border-radius: 10px;
      margin-bottom: 15px;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
    }

    .book-title {
      font-size: 30px;
      font-weight: bold;
      margin-bottom: 50px;
      text-align: center;
      margin-top: 50px;
    }

    .book-info {
      display: flex;
      align-items: center;
      margin-bottom: 15px;
      text-align: left;
      justify-content: center;
    }

    .book-info img {
      margin-right: 20px;
      border-radius: 10px;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
    }

    .book-info table {
      /* width: 100%; */
      text-align: left;
      background-color: #fff;
      border-radius: 10px;
      padding: 15px;
    }

    .book-info th {
      padding-bottom: 8px;
    }

    .book-author,
    .book-publisher,
    .book-publish-date,
    .book-price,
    .book-like,
    .book-level {
      font-size: 14px;
      color: #666;
      margin-bottom: 8px;
    }

    .book-description {
      line-height: 1.6;
      margin-bottom: 15px;
    }

    .contents-table {
     /*  margin: auto; */
      text-align: left;
    }

    .contents-table td {
      background-color: #fff;
      padding: 10px;
      border-radius: 5px;
      margin-bottom: 10px;
    }

    .btn-check {
      display: none;
    }

    .btn-primary {
      background-color: #0E1D34;
      color: #fff;
      border: 1px solid #0E1D34;
      border-radius: 5px;
      padding: 8px 16px;
      cursor: pointer;
    }
    .table-list-hide {
    	display: none;
    }
    
      .book-description {
  /*  text-align: center; */
    margin: 20px;
  }
  
    h3 {
    color: #333;
    font-size: 24px;
    font-weight: bold;
    margin-bottom: 20px;
  }
  
    .table-list-num {
    border-bottom: 1px solid #ddd;
    padding: 10px;
    transition: background-color 0.3s;
  }
  
    .table-list-hide {
    display: none;
  }
  
  
  
    #more-view {
    padding: 10px 20px;
    font-size: 16px;
    font-weight: bold;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    cursor: pointer;
    background-color: #0E1D34;
    color: #fff;
    border: 1px solid #0E1D34;
    border-radius: 5px;
    transition: background-color 0.3s;
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
      <div class="page-header d-flex align-items-center"
        style="background-image: url('<%=request.getContextPath() %>/resources/img/backgroundImg2.png');">
        <div class="container position-relative">
          <div class="row d-flex justify-content-center">
            <div class="col-lg-6 text-center">
              <h2>교재 상세보기</h2>
              <p></p>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="index.html">Home</a></li>
            <li>교재 상세보기</li>
          </ol>
        </div>
      </nav>
    </div><!-- End Breadcrumbs -->

    <div class="book-details container">
      <div class="book-title">${dto.bookname}</div>
      <div class="book-info">
        <img src="${dto.bookImg}" alt="도서 이미지">
        <table class="contents-table">
          <tr>
            <td>
              <strong>저자: </strong> ${dto.author}
            </td>
          </tr>
          <tr>
            <td>
              <strong>출판사: </strong> ${dto.publisher}
            </td>
          </tr>
          <tr>
            <td>
              <strong>출판일: </strong> ${dto.pbDate}
            </td>
          </tr>
          <tr>
            <td>
              <strong>가격: </strong><fmt:formatNumber value="${dto.price}" pattern="#,##0" />원
            </td>
          </tr>
          <tr>
            <td>
              <strong>난이도: </strong> ${dto.lvS}
            </td>
          </tr>
          <tr>
            <td>
            	<div id="like-up">
	              <strong>좋아요 수:</strong> ${dto.bookLike}
            	</div>
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16" onclick="like(${dto.bookseq})">
				  <path onclick="like(${dto.bookseq})" fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
				</svg>	
              <br></br>
      <label class="btn btn-primary" for="btn-check" onclick="insertbook('${seq}','${dto.bookseq}');">등록하기</label>
            </td>
          </tr>
        </table>
      </div>

      <div class="book-description">
        
        <h3>목차</h3>
        <table class="contents-table">
          <c:forEach items="${list}" var="list">
          	<c:if test="${list.listNum <= 5 }">
	            <tr class="table-list-num">
	              <td>${list.listNum} - ${list.list}</td>
	            </tr>          	
          	</c:if>
          	<c:if test="${list.listNum > 5 }">
	            <tr class="table-list-num table-list-hide">
	              <td >${list.listNum} - ${list.list}</td>
	            </tr>          	
	         </c:if>
          	
          </c:forEach>
        </table>
       <input type="button" id="more-view" value="더보기">
    
      </div>


    </div>

  </main><!-- End #main -->

  <!-- /main -->

  <!-- ======= Footer ======= -->
  <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
  <!-- End Footer -->

  <a href="#" class="scroll-top d-flex align-items-center justify-content-center"><i
      class="bi bi-arrow-up-short"></i></a>

  <div id="preloader"></div>

  <%@ include file="/WEB-INF/views/inc/ad.jsp" %>
  <%@ include file="/WEB-INF/views/inc/side.jsp" %>

  <Script>
  function insertbook(seq,bookseq) {
	$.ajax({
		type:'POST',
		url:'/jr/book/bookadd.do',
		data: {
			seq: seq,
			bookseq: bookseq
		},
		dataType: 'json',
		success:function(result){
			alert('축하');
		},
		error:function(a,b,c){	
			console.log(a,b,c);
		}
	});
}
  function like(seq) {
	$.ajax({
		type:'get',
		url:'/jr/book/booklike.do',
		data:{
			seq : seq
		},
		dataType:'json',
		success:function(result) {
			alert(123);
			
		},
		error:function(a,b,c) {
			console.log(a,b,c);
		}
	});
}
	
	$("#more-view").click(function() {
		if (!$(".table-list-hide").is(":hidden")){
			$(".table-list-hide").slideUp();
			$("#more-view").val("더보기");
		}else {
			$(".table-list-hide").slideDown();
			$("#more-view").val("접기");
			$(".table-list-num").css('display','table');
			
		}
	});

  </Script>

</body>

</html>