<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="mvc.model.BoardDTO" %>

<%-- 로그인 체크: loginUser 없으면 로그인 페이지로 리다이렉트 --%>
<c:if test="${empty sessionScope.loginUser}">
    <c:redirect url="/login/login.jsp" />
</c:if>

<%-- board 객체가 없으면 에러 페이지로 이동 --%>
<c:if test="${empty requestScope.board}">
    <c:redirect url="errorPage.jsp" />
</c:if>

<c:set var="board" value="${requestScope.board}" />
<c:set var="loginUser" value="${sessionScope.loginUser}" />
<c:set var="pageNum" value="${param.pageNum}" />

<html>
<head>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <title>Reservation</title>

    <script type="text/javascript">
        function checkForm() {
            if ("${empty sessionScope.loginUser}") {
                alert("로그인 해주세요.");
                return false;
            }
            window.location.href = "./reservationAction.do";
        }
    </script>
</head>
<body>

    <div class="container py-4">
        <jsp:include page="/WEB-INF/view/common/header.jsp" />

        <div class="py-3 text-end">
            <c:choose>
                <c:when test="${not empty sessionScope.loginUser}">
                    <a href="javascript:void(0);" onclick="checkForm();" class="btn btn-primary">예약하기</a>
                </c:when>
                <c:otherwise>
                    <a href="login.jsp" class="btn btn-secondary">로그인 후 예약하기</a>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="p-5 mb-4 bg-body-tertiary rounded-3">
            <div class="container-fluid py-5">
                <h1 class="display-5 fw-bold">클래스 예약</h1>
                <p class="col-md-8 fs-4">Reservation</p>
            </div>
        </div>

        <div class="row align-items-md-stretch text-center">
            <form name="reservationClass"
                  action="reservationAction.do?post_num=${board.post_num}&pageNum=${pageNum}"
                  method="post">

                <!-- 썸네일 -->
                <div class="mb-3 row">
                    <div class="col-sm-3">
                        <img src="<c:url value='./images/${board.thumbnail}' />" alt="썸네일 이미지" class="img-fluid">
                    </div>
                </div>

                <!-- 제목 -->
                <div class="mb-3 row">
                    <div class="col-sm-5">
                        <h3>${board.title}</h3>
                    </div>
                </div>

                <!-- 클래스 일정 -->
                <div class="p-5 mb-4 bg-body-tertiary rounded-3">
                    <div class="container-fluid py-5">
                        <h3 class="display-5 fw-bold">클래스 일정</h3>
                        <p class="col-md-8 fs-4">ReservationInfo</p>
                    </div>
                </div>

                <!-- 위치정보 -->
                <div class="mb-3 row">
                    <label class="col-sm-2 control-label">모임장소</label>
                    <div class="col-sm-6">
                        <p>${board.location}</p>
                    </div>
                </div>

                <!-- 모임시간 -->
                <div class="mb-3 row">
                    <label class="col-sm-2 control-label">모임시간</label>
                    <div class="col-sm-4">
                        <p>${board.end_date}</p>
                    </div>
                </div>

                <!-- 결제자 정보 출력 -->
                <div class="mb-3 row">
                    <label class="col-sm-2 control-label">이름</label>
                    <div class="col-sm-6">
                        <p>${loginUser.name}</p>
                    </div>
                </div>

                <div class="mb-3 row">
                    <label class="col-sm-2 control-label">전화번호</label>
                    <div class="col-sm-6">
                        <p>${loginUser.phone}</p>
                    </div>
                </div>

                <div class="mb-3 row">
                    <label class="col-sm-2 control-label">주소</label>
                    <div class="col-sm-6">
                        <p>${loginUser.address}</p>
                    </div>
                </div>

                <!-- 예약 버튼 -->
                <div class="text-center mt-4">
                    <button type="submit" class="btn btn-success">예약하기</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
