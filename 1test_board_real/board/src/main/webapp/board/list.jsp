<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="model.BoardDTO"%>
<%@ page import="model.LoginDTO" %>

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
<title>게시글 목록</title>
</head>
<body>
    <jsp:include page="/WEB-INF/header.jsp" />

    <div class="container mt-4">
        <h2>게시판 목록</h2>
        <p>전체 게시글 수: <strong>${total_record}</strong></p>

        <table class="table table-bordered table-hover">
            <thead class="table-light">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="board" items="${boardlist}">
                    <tr>
                        <td>${board.boardNo}</td>
                        <td>
                            <a href="BoardView.do?num=${board.boardNo}&pageNum=${pageNum}">
    							${board.boardTitle}
							</a>
                        </td>
                        <td>${board.boardWriter}</td>
                        <td>${board.boardDate}</td>
                    </tr>
                </c:forEach>
                <c:if test="${empty boardlist}">
                    <tr>
                        <td colspan="4" class="text-center">등록된 게시글이 없습니다.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>

        <!-- 페이징 -->
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <c:set var="currentPage" value="${pageNum}" />
                <c:set var="lastPage" value="${total_page}" />

                <c:if test="${currentPage > 1}">
                    <li class="page-item">
                        <a class="page-link" href="BoardListAction.do?pageNum=${currentPage - 1}">이전</a>
                    </li>
                </c:if>

                <c:forEach begin="1" end="${lastPage}" var="i">
                    <li class="page-item ${i == currentPage ? 'active' : ''}">
                        <a class="page-link" href="BoardListAction.do?pageNum=${i}">${i}</a>
                    </li>
                </c:forEach>

                <c:if test="${currentPage < lastPage}">
                    <li class="page-item">
                        <a class="page-link" href="BoardListAction.do?pageNum=${currentPage + 1}">다음</a>
                    </li>
                </c:if>
            </ul>
        </nav>

        <div class="text-center">
            <a href="boardWriteForm.do?pageNum=${pageNum}" class="btn btn-primary">글쓰기</a>
        </div>
    </div>

    <jsp:include page="/WEB-INF/footer.jsp" />
</body>
</html>