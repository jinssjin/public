<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="mvc.model.BoardDTO"%>
<%@ page import="mvc.model.HobbyDTO"%>

<%
String sessionId = (String) session.getAttribute("sessionId");
BoardDTO reservationInfo = (BoardDTO) request.getAttribute("reservationInfo");
HobbyDTO loginUser = (HobbyDTO) request.getAttribute("loginUser");
int post_num = ((Integer) request.getAttribute("post_num")).intValue();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>클래스 예약</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

    <style>
        body {
            background-color: #f5f7fa;
            font-family: 'Noto Sans KR', sans-serif;
        }

        h1, h2 {
            font-weight: 700;
            color: #333;
        }

        .thumbnail-img {
            max-width: 100%;
            max-height: 300px;
            object-fit: cover;
            border-radius: 12px;
            box-shadow: 0 4px 16px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }

        .card-custom {
            background-color: #ffffff;
            border-radius: 16px;
            box-shadow: 0 4px 24px rgba(0, 0, 0, 0.06);
            padding: 30px;
            margin-bottom: 40px;
        }

        .price-text {
            color: #ff6b00;
            font-size: 2rem;
            font-weight: bold;
        }

        .btn-group-custom {
            text-align: center;
            margin-top: 20px;
        }

        .btn-warning {
            border-radius: 30px;
            padding: 10px 30px;
            font-weight: 600;
        }

        .btn-danger {
            border-radius: 30px;
            padding: 10px 30px;
            font-weight: 600;
            margin-left: 10px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>

</head>
<body>

    <jsp:include page="/WEB-INF/view/common/header.jsp" />

    <div class="container py-4">
        <div class="position-relative p-5 mb-4 rounded-3"
            style="overflow: hidden; background-color: #fefefe;">
            <!-- 배경 이미지 효과 -->
            <div style="position: absolute; top: 0; left: 0; right: 0; bottom: 0; background-image: url('./images/class_reservation.jpg'); background-size: cover; background-position: center; background-repeat: no-repeat; opacity: 0.2; z-index: 1;">
            </div>
            <!-- 실제 콘텐츠 -->
            <div class="container-fluid py-5 position-relative" style="z-index: 2;">
                <h1 class="display-5 fw-bold text-center">클래스 예약하기</h1>
            </div>
        </div>

        <div class="card-custom">
            <!-- 썸네일 -->
            <div class="text-center">
                <c:choose>
                    <c:when test="${not empty reservationInfo.thumbnail}">
                        <img src="${pageContext.request.contextPath}/uploads/${reservationInfo.thumbnail}"
                            class="thumbnail-img" alt="대표 이미지">
                    </c:when>
                    <c:otherwise>
                        <img src="${pageContext.request.contextPath}/uploads/default_thumb.jpg"
                            class="thumbnail-img" alt="기본 썸네일">
                    </c:otherwise>
                </c:choose>
            </div>

            <!-- 클래스 정보 테이블 -->
            <table>
                <tr>
                    <th>제목</th>
                    <td>${reservationInfo.title}</td>
                </tr>
                <tr>
                    <th>일정</th>
                    <td>${reservationInfo.reservation_date} ~ ${reservationInfo.end_date}</td>
                </tr>
                <tr>
                    <th>위치</th>
                    <td>${reservationInfo.location}</td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>${reservationInfo.content}</td>
                </tr>
                <tr>
                    <th>가격</th>
                    <td><span class="price-text">${reservationInfo.price}원</span></td>
                </tr>
            </table>

            <!-- 버튼 -->
            <div class="btn-group-custom">
                <form action="PaymentSaveAction.do" method="post">
                    <input type="hidden" name="post_num" value="<%=post_num%>">
                    <input type="submit" class="btn btn-warning" value="결제하기">
                    <button type="button" class="btn btn-danger" onclick="history.back()">나가기</button>
                </form>
            </div>
        </div>

    </div>

    <jsp:include page="/WEB-INF/view/common/footer.jsp" />
</body>
</html>
