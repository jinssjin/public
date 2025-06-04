<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="mvc.model.BoardDTO"%>
<%@ page import="mvc.model.HobbyDTO"%>
<%@ page import="mvc.model.PaymentDTO"%>

<%
String sessionId = (String) session.getAttribute("sessionId");
BoardDTO reservationInfo = (BoardDTO) request.getAttribute("reservationInfo");
HobbyDTO loginUser = (HobbyDTO) request.getAttribute("loginUser");
PaymentDTO paymentInfo = (PaymentDTO)  request.getAttribute("paymentInfo");
int post_num = ((Integer) request.getAttribute("post_num")).intValue();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>클래스 예약</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <style>
        body {
            background-color: #f5f7fa;
            font-family: 'Noto Sans KR', sans-serif;
        }
        h1, h2 { font-weight: 700; color: #333; }
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
        .price-text.strike {
            text-decoration: line-through;
            color: #888;
            font-weight: normal;
        }
        .discounted-price {
            font-size: 2rem;
            font-weight: bold;
            color: #ff6b00;
        }
        .btn-group-custom {
            text-align: center;
            margin-top: 20px;
        }
        .btn-warning, .btn-danger {
            border-radius: 30px;
            padding: 10px 30px;
            font-weight: 600;
        }
        .btn-danger { margin-left: 10px; }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td { border: 1px solid #ddd; }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th { background-color: #f2f2f2; }
        .jump { padding: 40px; }

        #couponInfoTable {
            min-height: 80px;
            table-layout: fixed;
            width: 100%;
        }
        #couponInfoTable th, #couponInfoTable td {
            width: 50%;
            padding: 10px;
            vertical-align: middle;
        }
    </style>
</head>
<body>

<jsp:include page="/WEB-INF/view/common/header.jsp" />

<div class="container py-4">
    <div class="position-relative p-5 mb-4 rounded-3" style="overflow: hidden; background-color: #fefefe;">
        <div style="position: absolute; top: 0; left: 0; right: 0; bottom: 0;
                    background-image: url('${pageContext.request.contextPath}/images/class_reservation.jpg');
                    background-size: cover; background-position: center; background-repeat: no-repeat; opacity: 0.2; z-index: 1;"></div>
        <c:choose>
            <c:when test="${paymentInfo.state == 'F' or paymentInfo.state == 'W'}">
                <c:set var="reservationTitle" value="클래스 예약하기" />
            </c:when>
            <c:when test="${paymentInfo.state == 'C' or paymentInfo.state == 'S'}">
                <c:set var="reservationTitle" value="클래스 예약확인" />
            </c:when>
        </c:choose>
        <div class="container-fluid py-5 position-relative" style="z-index: 2;">
            <h1 class="display-5 fw-bold text-center">${reservationTitle}</h1>
        </div>
    </div>

    <div class="card-custom">
        <!-- 썸네일 -->
        <div class="text-center">
            <c:choose>
                <c:when test="${not empty reservationInfo.thumbnail}">
                    <img src="${pageContext.request.contextPath}/uploads/${reservationInfo.thumbnail}" class="thumbnail-img" alt="대표 이미지">
                </c:when>
                <c:otherwise>
                    <img src="${pageContext.request.contextPath}/uploads/default_thumb.jpg" class="thumbnail-img" alt="기본 썸네일">
                </c:otherwise>
            </c:choose>
        </div>

        <!-- 클래스 정보 -->
        <h3>클래스 예약정보</h3>
        <table>
            <tr><th>제목</th><td>${reservationInfo.title}</td></tr>
            <tr><th>일정</th><td>${reservationInfo.reservation_date} ~ ${reservationInfo.end_date}</td></tr>
            <tr><th>위치</th><td>${reservationInfo.location}</td></tr>
            <tr><th>내용</th><td>${reservationInfo.content}</td></tr>
            <tr>
                <th>가격</th>
                <td>
                    <span id="originalPriceText" class="price-text">${reservationInfo.price}원</span>
                    <span id="discountedPriceText" class="discounted-price d-none ms-2"></span>
                </td>
            </tr>
        </table>

        <span class="jump"></span>

        <!-- 참여자 정보 -->
        <h3>참여자 정보</h3>
        <table>
            <tr><th>이름</th><td>${loginUser.name}</td></tr>
            <tr><th>연락처</th><td>${loginUser.phone}</td></tr>
            <tr><th>이메일</th><td>${loginUser.email}</td></tr>
        </table>

        <!-- 결제 및 쿠폰 선택 -->
        <div class="btn-group-custom">
            <form action="PaymentAction.do" method="post">
                <input type="hidden" name="post_num" value="${post_num}" />
                <input type="hidden" name="name" value="${loginUser.name}" />
                <input type="hidden" name="price" id="originalPrice" value="${reservationInfo.price}" />

                <!-- 쿠폰 영역 -->
                <div class="mb-3" id="couponSection">
                    <h3>쿠폰 정보</h3>
                    <table id="couponInfoTable" class="table d-none">
                        <tr>
                            <th>쿠폰명</th>
                            <td id="couponNameCell">-</td>
                        </tr>
                        <tr>
                            <th>할인액</th>
                            <td id="couponDiscountCell">-</td>
                        </tr>
                    </table>

                    <!-- 서버 전송용 hidden input -->
                    <input type="hidden" id="couponName" name="couponName" value="">
                    <input type="hidden" id="couponDiscount" name="couponDiscount" value="0">
                    <input type="hidden" id="couponNum" name="couponNum" value="0">
                    <input type="hidden" id="usedPoint" name="usedPoint" value="0">
                    
                    
					<input type="hidden" name="post_num" value="${post_num}" />
					<input type="hidden" name="user_id" value="${sessionScope.sessionId}" />

                    <input type="hidden" id="finalPrice" class="form-control" readonly value="${reservationInfo.price}">
                    <input type="hidden" id="finalPriceValue" name="finalPrice" value="${reservationInfo.price}">

                    <button type="button" class="btn btn-sm btn-secondary mt-2" onclick="openCouponPopup()">쿠폰 선택</button>
                </div>

                <input type="submit" class="btn btn-warning" value="결제하기" />
                <button type="button" class="btn btn-danger" onclick="history.back()">나가기</button>
            </form>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/view/common/footer.jsp" />

<!-- ✅ JS 로직: 쿠폰 적용 -->
<script>
const get = (id) => document.getElementById(id);

function openCouponPopup() {
    const url = "<%=request.getContextPath()%>/CouponListPopup.do";
    const popupName = "couponPopup_" + new Date().getTime();
    window.open(url, popupName, "width=500,height=400,scrollbars=yes");
}

function applyCouponFromPopup(couponNum, couponName, value) {
    const originalPrice = parseInt(get("originalPrice").value);

    let discountAmount = 0;
    if (couponName === 'D') {
        discountAmount = Math.floor(originalPrice * value / 100);
    } else if (couponName === 'P') {
        discountAmount = value;
    }

    get("couponName").value = couponName;
    get("couponDiscount").value = discountAmount;
    get("couponNum").value = couponNum;

    get("couponNameCell").textType = couponName || "-";
    get("couponDiscountCell").textType = discountAmount > 0 ? discountAmount + "원" : "-";
    get("couponInfoTable").classList.toggle("d-none", discountAmount === 0);

    const finalPrice = Math.max(0, originalPrice - discountAmount);
    get("finalPrice").value = finalPrice + "원";
    get("finalPriceValue").value = finalPrice;

    get("originalPriceText").classList.toggle("strike", discountAmount > 0);
    get("discountedPriceText").classList.toggle("d-none", discountAmount === 0);
    get("discountedPriceText").textType = discountAmount > 0 ? finalPrice + "원" : "";
    get("usedPoint").value = discountPoint;

}
</script>


</body>
</html>
