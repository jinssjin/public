<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="model.BoardDTO" %>
<%@ page import="model.LoginDTO" %>
<%
    BoardDTO board = (BoardDTO) request.getAttribute("board");
    int num = (Integer) request.getAttribute("num");
    String pageStr = (String) request.getAttribute("page");
    int nowPage = 1;
    if (pageStr != null) {
        try {
            nowPage = Integer.parseInt(pageStr);
        } catch (NumberFormatException e) {
            nowPage = 1; // fallback
        }
    }

    LoginDTO login = (LoginDTO) session.getAttribute("user");
    String sessionId = (login != null) ? login.getUserId() : null;
%>
<c:set var="userId" value="<%=sessionId%>" />
<c:set var="sessionId" value="<%=sessionId%>" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 수정</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp" />

<div class="container py-4">
    <form action="./BoardUpdateAction.do" method="post">
        <input type="hidden" name="num" value="<%=board.getBoardNo()%>">
        <div class="mb-3 row">
            <label class="col-sm-2 control-label">제목</label>
            <div class="col-sm-5">
                <input name="title" class="form-control" value="<%=board.getBoardTitle()%>">
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 control-label">내용</label>
            <div class="col-sm-8">
                <textarea name="content" class="form-control" cols="50" rows="5"><%=board.getBoardContent()%></textarea>
            </div>
        </div>
        <div class="mb-3 row">
            <div class="col-sm-offset-2 col-sm-10">
                <c:if test="${sessionId == board.boardWriter}">
                    <input type="submit" class="btn btn-success" value="수정">
                    <a href="./BoardDeleteAction.do?num=<%=board.getBoardNo()%>&pageNum=<%=nowPage%>" class="btn btn-danger">삭제</a>
                </c:if>
                <a href="./BoardListAction.do?pageNum=<%=nowPage%>" class="btn btn-primary">목록으로</a>
            </div>
        </div>
    </form>
</div>

<jsp:include page="/WEB-INF/footer.jsp" />
</body>
</html>
