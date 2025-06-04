<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="mvc.model.BoardDTO"%>

<%
	String sessionId = (String) session.getAttribute("sessionId"); // 세션에서 sessionId 가져오기
	BoardDTO reservationInfo = (BoardDTO) request.getAttribute("reservationInfo");
	int post_num = ((Integer) request.getAttribute("post_num")).intValue();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>게시글</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">


</head>
<body>

	<div class="container py-4">

		<jsp:include page="/WEB-INF/view/common/header.jsp" />
		<div class="position-relative p-5 mb-4 rounded-3" style="overflow: hidden;">

    <!-- 배경: 불투명한 이미지 ★썸네일 불러오기★ -->
    <div style="position: absolute; top: 0; left: 0; right: 0; bottom: 0; background-image: url('./images/class_reservation.jpg'); background-size: cover; background-position: center;
        background-repeat: no-repeat; opacity: 0.2; z-index: 1;
    ">
        </div>

    <!-- 실제 콘텐츠 -->
    <div class="container-fluid py-5 position-relative" style="z-index: 2;">
        <h1 class="display-5 fw-bold">클래스 예약하기</h1>
    </div>
    
	</div>
		
						<!-- 썸네일 ★썸네일 불러오기★-->
			<div class="mb-3 row">
			    <div class="col-sm-10">
			        <img src="/image/${reservation.thumbnail}" alt="썸네일 자리">
			    </div>
			</div>
			 
			<!-- 제목 -->
			<div class="mb-3 row">
			    <div class="col-sm-10">
			        <h2 style="margin-bottom:0;">${reservationInfo.title}</h2>
			        <p style="font-size:16px;">${reservationInfo.reservation_date} &#126  ${reservationInfo.end_date}&#44 ${reservationInfo.location}</p>
			    </div>
			</div>
			
			<!-- 내용 -->
			<div class="mb-3 row">
			    <div class="col-sm-10">
			        <p>${reservationInfo.content}</p>
			    </div>
			</div>
		
			<!-- 가격 -->
			<div class="mb-3 row">
			    <div class="col-sm-10">
			        <h1>${reservationInfo.price}원</h1>
			    </div>
			</div>
			
			<!-- 버튼 -->
			<div class="mb-3 row">
				<div class="col-sm-offset-2 col-sm-10">
					<form action="PaymentSaveAction.do" method="post">
						<input type="hidden" name="post_num" value="<%= post_num %>">
						<input type="submit" class="btn btn-warning" value="결제하기">
  						<button type="button" class="btn btn-danger" onclick="history.back()">나가기</button>
					</form>

				</div>
			</div>
		

		<jsp:include page="/WEB-INF/view/common/footer.jsp" />
	</div>

</body>
</html>
