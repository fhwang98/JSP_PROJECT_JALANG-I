<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<html xmlns:th="http://www.thymeleaf.org">


<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>자랑이</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="<%=request.getContextPath()%>/resources/img/favicon.ico"
	rel="icon">
<link
	href="<%=request.getContextPath()%>/resources/img/apple-touch-icon.png"
	rel="apple-touch-icon">

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/vendor/aos/aos.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="<%=request.getContextPath()%>/resources/css/main.css"
	rel="stylesheet">

<!-- =======================================================
  * Template Name: Logis
  * Updated: Sep 18 2023 with Bootstrap v5.3.2
  * Template URL: https://bootstrapmade.com/logis-bootstrap-logistics-website-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
<style>

.board-title {
	margin: 10px;

}

.board-detail {
	font-size: 1rem;
	background-color: #F3F6FC;
	display: flex;
	justify-content: space-around;
	align-items: center;
	height: 50px;
	
}

.board-detail div {
	justify-content: space-around;
	display: flex;
	
}

.board-detail .detail-writer {
	width: 200px;
}

.board-detail .detail-date {
	width: 300px;
}

.board-detail .detail-hits, .detail-report {
	width: 150px;
}

.board-detail .name {
	font-weight: bold;
}

#board-content {
	font-size : 1rem;
	padding: 30px;
}

.comment-container {
	width: 70%;
	padding: 10px;
}

</style>

<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
</head>

<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp"%>

<div class="breadcrumbs">
      <div class="page-header d-flex align-items-center" style="background-image: url('<%=request.getContextPath() %>/resources/img/backgroundImg2.png');">
        <div class="container position-relative">
          <div class="row d-flex justify-content-center">
            <div class="col-lg-6 text-center">
              <h2>게시판</h2>
            </div>
          </div>
        </div>
      </div>
      <nav>
        <div class="container">
          <ol>
            <li><a href="index.html">게시판 상세</a></li>
          </ol>
        </div>
      </nav>
    </div><!-- End Breadcrumbs -->
	<!-- main -->


	<div class="container">
	
		<div class="board-title"><h1>${dto.boardTitle }</h1></div>
		<div class="board-detail">
			<div class="detail-writer">
				<div class="name">작성자</div>
				<div class="value">${dto.id }</div>
			</div>
			<div class="detail-date">
				<div class="name">작성일</div>
				<div class="value">${dto.boardWriteDate }</div>
			</div>
			<div class="detail-hits">
				<div class="name">조회수</div>
				<div class="value">${dto.boardHits }</div>
			</div>
			<div class="detail-report">
				<div class="name">신고수</div>
				<div class="value">${dto.boardReport }</div>
			</div>
		</div>
		<div id="board-content">${dto.boardContent }</div>
		

		<button type="button" class="btn btn-success"
			onclick="location.href='/jr/board/boardlist.do';">목록</button>
		<c:if test="${ id == dto.id }">
		<button type="button" class="btn btn-success"
			onclick="location.href='/jr/board/edit.do?boardSeq=${dto.boardSeq}';">수정</button>
		<button id="del-board" type="button" class="btn btn-success" >삭제</button>
			<script>
         	$('#del-board').click(function() {
         		if (confirm('삭제 후 되돌릴 수 없습니다. 삭제하시겠습니까?')) {
         			location.href='/jr/board/del.do?boardSeq=${dto.boardSeq}';
         		}
         	});
         </script>
		</c:if>

	

	</div>

	<div class="container comment-container" >
		<!-- 댓글 쓰기 -->
		<c:if test="${ not empty id }">
		<table id="add-comment">
			<tr>
				<td><input type="text" name="comment" id="new-comment"></td>
				<td><button type="button" class="comment" id="btnComment">댓글쓰기</button></td>
			</tr>
		</table>
		</c:if>
		
		<!-- 댓글 목록 -->
		<table id="list-comment">
		<tbody>
		
		</tbody>
		</table>
	
	</div>












	<!-- /main -->

	<!-- ======= Footer ======= -->
	<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
	<!-- End Footer -->

	<a href="#"
		class="scroll-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<div id="preloader"></div>

	<%@ include file="/WEB-INF/views/inc/ad.jsp"%>
	<%@ include file="/WEB-INF/views/inc/side.jsp"%>


	<Script>
	$('#btnComment').click(function() {
		
		if ($('#new-comment').val() == '') {
			alert('댓글을 입력해 주세요.');
			return false;
		}
		 $.ajax({
			type: 'POST',
			url: '/jr/board/comment.do',
			data: {
				bseq: ${dto.boardSeq},
				content: $('#new-comment').val()
			},
			dataType: 'json',
			success: function(result) {
				
				if(result.result) { 
					load(); // 목록 새로고침
					$('#new-comment').val('');
				} else {
					alert("\'" + result.word + "\'는 입력할 수 없는 단어입니다.");
				}
				
			},
			error: function(a, b, c) {
				console.log(a, b, c);
			}
		}); 
	});
	
  load();
  
  function load() { 
		
		$.ajax({
			type: 'GET',
			url: '/jr/board/comment.do',
			data: 'bseq=${dto.boardSeq}',
			dataType: 'json',
			success: function(result) {
				//result == 댓글 목록
				
				$('#list-comment tbody').html(''); //기존 내용 삭제
				
				$(result).each((index, item) => {
					
					//console.log(item);
					//alert();
					let temp = `
						<tr>
							<td width="800">
								<div>\${item.content}</div>									
							</td>
							<td>
							  	<div>\${item.id}</div>
						`;
				 		
					if (item.id == '${id}') {
					temp += `
						  	<c:if test="${not empty id}">
							<div>
								<button type="button" class="edit" onclick="editComment(\${item.seq});">수정</button>
								<button type="button" class="del" onclick="delComment(\${item.seq});">삭제</button>
							</div>					
							</c:if>
						`;
					}
						
					temp += `
							</td>
						</tr>								
						
					`;
					
					$('#list-comment tbody').append(temp);
					
					 
				});
				
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		});
	}
  
  function editComment(seq) {
	  
		//기존 댓글 내용 찾기
		let val = $(event.target).parent().parent().prev().children().eq(0).text();
		
		$('.edit-comment').remove();
		
		let temp = `
			<tr class="edit-comment">
			<td><input type="text" name="ecomment" id="ecomment" value="\${val}"></td>
			<td>
				<button type="button" class="edit" onclick="editCommentOk(\${seq});">완료</button>
				<button type="button" class="cancle" onclick="$('.edit-comment').remove();">취소</button>
			</td>
			</tr>
			`;
		$(event.target).parent().parent().parent().after(temp);
		$('.edit-comment').prev().html('');
	  
  }
  
  function editCommentOk(seq) {
		//alert($('#ecomment').val());
		//alert(seq);
		
		$.ajax({
			type: 'POST',
			url: '/jr/board/commentedit.do',
			data: {
				content: $('#ecomment').val(),
				seq: seq
			},
			datatype: 'json',
			success: function(result) {
				if (result.result) {
					load(); // 목록 새로고침
				} else {
					alert("\'" + result.word + "\'는 입력할 수 없는 단어입니다.");
				}
			},
			error: function(a, b, c) {
				console.log(a, b, c);
			}
		});
		
	}
  
  
  function delComment(seq) {
	  //alert(seq);
	  if (confirm('삭제 후 되돌릴 수 없습니다. 삭제하시겠습니까?')) {
			$.ajax({
				type: 'POST',
				url: '/jr/board/commentdel.do',
				data: 'seq=' + seq,
				dataType: 'json',
				success: function(result) {
					alert(result.result);
					if (result.result) {
						load(); // 목록 새로고침
					}
				},
				erroe: function(a, b, c) {
					console.log(a, b, c)
				}
			});
		}
  }
  
  </Script>


</body>

</html>