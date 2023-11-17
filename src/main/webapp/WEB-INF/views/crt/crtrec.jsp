<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>자랑이</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="<%=request.getContextPath()%>/resources/img/favicon.ico"
	rel="icon">

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<!-- <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Inter:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
 -->
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&family=Nanum+Myeongjo:wght@800&family=Noto+Serif+KR:wght@500;600&display=swap"
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


<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
<script src="https://kit.fontawesome.com/1f653a59f2.js"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/crtrec.css">

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>


</head>

<body>

	<%@ include file="/WEB-INF/views/inc/header.jsp"%>

	<!-- main -->

	<div id="crtrec-wrap">

		<div class="back_title">
			<img
				src="<%=request.getContextPath()%>/resources/img/crtrec_back_title2.png">
		</div>
		<!-- 
		<div class="toggle-btn">
			<div class="btn-group" role="group"
				aria-label="Basic radio toggle button group">

				<input type="radio" class="btn-check" name="btnradio" id="btnradio1"
					autocomplete="off" checked> <label id="job-btn"
					class="btn btn-outline" for="btnradio1">직업별 추천</label> <input
					type="radio" class="btn-check" name="btnradio" id="btnradio2"
					autocomplete="off"> <label class="btn btn-outline"
					for="btnradio2">학과별 추천</label>

			</div>
		</div>
 -->
		<div class="container rank-table-flex">
			<c:forEach items="${jobGroupList}" var="item" begin="0" end="3">
			<table class="rank-table">
				<tr>
					<th>${item.jobgroupname}</th>
				</tr>
					<c:forEach items="${item.list}" var="dto">
				<tr>
					<td><a href="/jr/crt/crtdetail.do?seq=${dto.crtseq}">${dto.crtname}</a></td>
				</tr>
					</c:forEach>
			</table>
			</c:forEach>
		</div>
		<div class="tabMenu-bx">
			<ul class="nav2 nav-tabs2 tabMenu2">
				<c:forEach items="${jobGroupList}" var="item" begin="0" end="3" varStatus="status">
					<li id="tab-btn${status.index}" class="nav-item" onclick="changetab(${item.crtseq}, ${status.index});">
						<a class="nav-link2">${item.jobgroupname}</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="container-color">

			<c:forEach items="${jobGroupList}" var="item" begin="0" end="3" varStatus="status">
				<div class="container chartWrap">
					<div class="container tabMenu-chart-btn">
						<ul class="tabMenu-btn-ul">
							<c:forEach items="${item.list}" var="dto" varStatus="dtostatus">
								<%-- 
								<li><button class="chart-btn"
										onclick="changebtn(${status.index},${dtostatus.index});">${dto.crtname}
								</button></li>
								 --%>
								 <li><button type="button" class="btn btn-outline-light chart-btn"
								 onclick="changebtn(${status.index},${dtostatus.index});">${dto.crtname}</button></li>
							</c:forEach>
						</ul>
					</div>
					
					<c:forEach items="${item.list}" var="dto" varStatus="dtostatus">
						<div class="container chart-bx" id="chart-bx-${status.index}-${dtostatus.index}">
							<canvas id="line-chart-${status.index}-${dtostatus.index}" 
							width="200" height="100"></canvas>
						</div>
					</c:forEach>
					
				</div>
			</c:forEach>

		</div>

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
	load();
	
	function load() {
		$(".nav-tabs2 li:first-child a").addClass("active");

		$('.chartWrap').hide();
		$('.chartWrap').eq(0).show();
		
		$('.chart-bx').hide();
		$('.chart-bx').eq(0).show();
		
		
	}
	
	
	function changetab(seq, index) {
		console.log("changetab: " + seq + " " + index);
		
		$(".nav-tabs2 li").children().removeClass("active");
		$(event.target).addClass("active");
		
		$('.chartWrap').hide();
		$('.chartWrap').eq(index).show();
		
		$('.chart-bx').hide();
		//$('.chart-bx').eq(4).show();
		
		var id = "chart-bx-" + index + "-" +  seq;
		document.getElementById(id).style.display = "block";
	     
	}
	
	function changebtn(seq, index) {
		console.log("changebtn: " + seq + " " + index);
		$('.chart-bx').hide();
		//$('.chart-bx').eq(4).show();
		
		var id = "chart-bx-" + seq + "-" + index ;
		document.getElementById(id).style.display = "block";

	}
	
	
	new Chart(document.getElementById("line-chart-0-0"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [42773,53991,59744,71275,66467],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [21641,27076,35655,36205,33467],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-0-1"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [32776,37765,37582,43308,39054],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [21390,27567,26622,30886,25054],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-0-2"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [28723,31840,22604,25510,23279],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [16432,17433,13156,14150,14123],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-0-3"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [32776,37765,37582,43308,39054],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [7751,9426,7003,9753,8340],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-0-4"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [8123,11430,11074,10533,11533],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [4948,5755,5758,5875,6533],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-1-0"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [14086,15969,12412,15103,12671],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [6658,7298,5746,6877,6280],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-1-1"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [1350,2123,1563,2086,1910],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [586,867,637,879,815],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-1-2"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [366,431,456,561,536],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [144,145,186,219,210],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-1-3"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [706,720,704,1025,720],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [192,230,215,360,245],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-1-4"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [1350,2123,1563,2086,2021],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [586,867,637,879,787],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-2-0"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [44665,52845,43279,51640,48470],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [22976,30740,24820,32865,27208],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-2-1"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [32776,37765,37582,43308,39054],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [21390,27567,26622,30886,25054],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-2-2"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [32776,37765,37582,43308,39054],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [21390,27567,26622,30886,25054],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-2-3"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [41320,38343,19355,23838,20493],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [13474,13031,6084,7848,7175],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-2-4"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [22858,24710,15635,19350,16476],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [8213,9521,5157,6845,6183],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-3-0"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [42773,53991,59744,71275,66467],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [21641,27076,35655,36205,33467],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-3-1"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [32776,37765,37582,43308,39054
],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [21390,27567,26622,30886,25054],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-3-2"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [28723,31840,22604,25510,23279],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [16432,17433,13156,14150,14123],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-3-3"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [13771,16176,13333,17358,14340],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [7751,9426,7003,9753,8340],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });
	new Chart(document.getElementById("line-chart-3-4"), {
		  type: 'line',
		  data: {
		    labels: [2018,2019,2020,2021,2022],
		    datasets: [{ 
		        data: [8123,11430,11074,10533,11533],
		        label: "필기 응시자 수(단위 : 명)",
		        borderColor: "#3e95cd",
		        fill: false
		      }, { 
		        data: [4948,5755,5758,5875,6533],
		        label: "필기 합격자 수(단위 : 명)",
		        borderColor: "#8e5ea2",
		        fill: false
		      }
		    ]
		  },
		  options: {
              title: {
                  display: true,
                  text: '2018년~2022년 시험(필기) 합격자 추이',
                  fontSize: 14,
                  fontColor: '#333'
              },
              legend: {
                  display: true,
                  labels: {
                      fontColor: '#555'
                  }
              },
              scales: {
                  x: [{
                      ticks: {
                          fontColor: '#555', // X-axis ticks color
                          fontSize: 12      // X-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '년도',
                          fontColor: '#555',
                          fontSize: 14      // X-axis label font size
                      }
                  }],
                  y: [{
                      ticks: {
                          fontColor: '#555', // Y-axis ticks color
                          fontSize: 12      // Y-axis ticks font size
                      },
                      scaleLabel: {
                          display: true,
                          labelString: '수',
                          fontColor: '#555',
                          fontSize: 18      // Y-axis label font size
                      }
                  }]
              }
          }
      });

	
  
  </Script>


</body>

</html>