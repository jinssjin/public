<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        .container1 {
            background-color: #ADD8E6;
            width: 100%;
            height: 100vh;
        }
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/header.jsp" />
    
    <div class="container1 text-white">
                    <c:choose>
    <c:when test="${not empty sessionScope.user}">
        <h1><i class="fa-solid fa-arrow-up"></i><i class="fa-solid fa-arrow-up"></i><i class="fa-solid fa-arrow-up"></i><i class="fa-solid fa-arrow-up"></i> 게시판 클릭</h1>
    </c:when>
    <c:otherwise>
        <!-- 로그인 안 했을 때 보여줄 내용 -->
        <h1>로그인 해주세요!</h1>
    </c:otherwise>
</c:choose>
      
    </div>
    
    <jsp:include page="/WEB-INF/footer.jsp" />
</body>
</html>

