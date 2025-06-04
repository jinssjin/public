<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="model.BoardDTO"%>
<%@ page import="model.LoginDTO"%>

<%
    BoardDTO board = (BoardDTO) request.getAttribute("board");
    LoginDTO login = (LoginDTO) request.getSession().getAttribute("user");
    String pageStr = (String) request.getAttribute("page");
    int nowPage = 1;
    if (pageStr != null) {
        try {
            nowPage = Integer.parseInt(pageStr);
        } catch (NumberFormatException e) {
            nowPage = 1; // fallback
        }
    }
    System.out.println("Current Page: " + nowPage);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<style>
    
</style>
</head>
<body>
    <jsp:include page="/WEB-INF/header.jsp" />
    
    <div class="container py-4">
        <div class="row mb-3 align-items-center">
            <div class="col-sm-2 label-col">제목</div>
            <div class="col-sm-10"><h3>${board.boardTitle}</h3></div>
        </div>

        <div class="row mb-3 align-items-center">
            <div class="col-sm-2 label-col">작성자</div>
            <div class="col-sm-10">${board.boardWriter}</div>
        </div>

        <div class="row mb-3 align-items-center">
            <div class="col-sm-2 label-col">작성일</div>
            <div class="col-sm-10">${board.boardDate}</div>
        </div>

        <div class="row mb-3">
            <div class="col-sm-2 label-col">내용</div>
            <div class="col-sm-10">
                <div class="content-box"><span style="font-size:20px;">${board.boardContent}</span></div>
            </div>
        </div>

        <div class="mb-3">
            <c:if test="${login != null && login.userId == board.boardWriter}">
                <a href="BoardUpdate.do?num=${board.boardNo}&page=${nowPage}" class="btn btn-success me-2">
                    수정
                </a>
                <a href="BoardDeleteAction.do?num=${board.boardNo}&pageNum=${nowPage}" 
                   class="btn btn-danger" 
                   onclick="return confirm('정말 삭제하시겠습니까?');">
                   삭제
                </a>
            </c:if>
            <a href="BoardListAction.do?pageNum=${nowPage}" class="btn btn-primary">목록</a>
        </div>
    </div>

    <jsp:include page="/WEB-INF/footer.jsp" />
</body>
</html>
