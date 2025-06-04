<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<style>
	.navbarheader{background-color: #87CEEB !important;}
</style>
    <meta charset="UTF-8">
    <title>Header</title>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
<nav class="navbar navbarheader navbar-expand-lg navbar-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><i class="fa-solid fa-futbol"></i></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                data-bs-target="#navbarNav" aria-controls="navbarNav" 
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse justify-content-between" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/board/board/BoardListAction.do">게시판</a>
                </li>
            </ul>
            
            <ul class="navbar-nav">
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
					    <li class="nav-item">
					        <span class="navbar-text me-3">
					            ${sessionScope.user.userName}님 환영합니다
					        </span>
					    </li>
					    <li class="nav-item">
					        <a class="nav-link" href="/board/login/logout.do">로그아웃</a>
					    </li>
					    <li class="nav-item">
					        <a class="nav-link" href="/board/login/deleteMember.do" 
					           onclick="return confirm('정말 회원탈퇴 하시겠습니까?');">회원탈퇴</a>
					    </li>
					</c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="/board/login/login.jsp">로그인</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/board/login/signUp.do">회원가입</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>



</body>
</html>
    
    
