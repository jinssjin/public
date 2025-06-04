<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="model.BoardDTO"%>
<%@ page import="model.LoginDTO"%>

<%
	BoardDTO board = (BoardDTO) request.getAttribute("board");
	LoginDTO login = (LoginDTO) request.getAttribute("login");
	int num = ((Integer) request.getAttribute("num")).intValue();
	int nowPage = ((Integer) request.getAttribute("page")).intValue();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 내용</title>
</head>
<body>
	<jsp:include page="/WEB-INF/header.jsp" />
	
	<div class="container py-4">
		<form action="./BoardWriteAction.do" method="post">
			<div class="mb-3 row">
				<label class="col-sm-2 control-label" >제목</label>
			</div>
			<div class="col-sm-5">
				<input name="subject" class="form-control"	value=" <%=board.getBoardTitle()%>" >
			</div>
		
			<div class="mb-3 row">
				<label class="col-sm-2 control-label" >내용</label>
			<div class="col-sm-8" style="word-break: break-all;">
				<textarea name="content" class="form-control" cols="50" rows="5"> <%=board.getBoardContent()%></textarea>
			</div>
		</div>
		</form>
	</div>
	
	<div class="mb-3 row">
		<div class="col-sm-offset-2 col-sm-10 ">
			<c:set var="userId" value="<%=login.getUserId()%>" />
			<c:if test="${sessionId==userId}">
				<p>
					<a	href="./BoardDeleteAction.do?num=<%=board.getBoardNo()%>&pageNum=<%=nowPage%>"	class="btn btn-danger"> 삭제</a> 
					<input type="submit" class="btn btn-success" value="수정 ">
			</c:if>
			<a href="./BoardListAction.do?pageNum=<%=nowPage%>" class="btn btn-primary"> 목록으로</a>
		</div>
	</div>
	</div>
	<jsp:include page="/WEB-INF/footer.jsp" />
	
	
	</div>
	
	
</body>
</html>