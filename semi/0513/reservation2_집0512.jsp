<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="mvc.model.BoardDTO"%>
<%@ page import="java.util.List"%>
<%
    String sessionId = (String) session.getAttribute("sessionId");
    BoardDTO board = (BoardDTO) request.getAttribute("board");
    int post_num = ((Integer) request.getAttribute("post_num")).intValue();
    int pageNum = ((Integer) request.getAttribute("pageNum")).intValue();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>클래스 예약하기</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <script type="text/javascript">
        function confirmDelete() {
            return confirm("예약을 취소하시겠습니까?");
        }
    </script>
</head>
<body>
    <jsp:include page="/WEB-INF/view/common/header.jsp" />

    <div class="main-container">
        <div class="content-wrap board-detail py-5" style="margin-top: 80px;">
            <div class="container">
                <h2 class="mb-4"><i class="fa-solid fa-check-to-slot"></i> 클래스 예약하기</h2>

                <!-- 게시글이 없을 경우 -->
                <c:if test="${empty board}">
                    <div class="alert alert-warning">
                        요청하신 게시글을 찾을 수 없습니다.
                        <div class="mt-3">
                            <button class="btn btn-secondary" onclick="history.back();">돌아가기</button>
                        </div>
                    </div>
                </c:if>

                <!-- 게시글이 있을 경우 -->
                <c:if test="${not empty board}">
                    <div class="card shadow-sm mb-5">
                        <div class="card-header bg-light">
                            <img src="images/${board.thumbnail}" class="mb-0" style="max-width: 120px; height: auto;">
                            <h3 class="mb-0">${board.title}</h3>
                        </div>
                        <div class="card-body">
                            <h4 class="post-content">${board.location}</h4>
                            <h5 class="post-content">${board.end_date}</h5>
                        </div>
                        <div class="card-footer d-flex justify-content-between align-items-center">
                            <div class="like-area">
                                <!-- 좋아요 영역 (필요시 추가) -->
                            </div>
                            <div class="btn-group">
                                <c:if test="${sessionId == board.user_id}">
                                    <a href="BoardUpdateForm.do?post_num=${board.post_num}&pageNum=${pageNum}" class="btn btn-outline-primary btn-sm">수정</a>
                                    <a href="BoardDeleteAction.do?post_num=${board.post_num}&pageNum=${pageNum}" class="btn btn-outline-danger btn-sm" onclick="return confirmDelete()">삭제</a>
                                </c:if>
                            </div>
                        </div>
                    </div>



                    <!-- 하단 버튼 -->
                    <div class="d-flex justify-content-between">
                        <a href="BoardListAction.do?pageNum=${pageNum}" class="btn btn-secondary">목록</a>
                        <a href="./reservationAction.do?post_num=${board.post_num}&pageNum=1" class="btn btn-warning">예약하기</a>
                        <c:if test="${not empty sessionId}">
                            <a href="BoardWriteForm.do" class="btn btn-success">글쓰기</a>
                        </c:if>
                    </div>
                </c:if>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/view/common/footer.jsp" />

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const likeButton = document.querySelector('.like-icon');
            if (likeButton) {
                likeButton.addEventListener('click', function() {
                    if ("${sessionId}" === "") {
                        alert("로그인 후 이용 가능합니다.");
                        return;
                    }

                    fetch('BoardLikeAction.do', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded',
                        },
                        body: 'boardNum=${board.post_num}'
                    })
                    .then(response => response.json())
                    .then(data => {
                        document.querySelector('.count').textContent = data.likeCount;
                        likeButton.style.color = data.userLiked ? 'red' : 'gray';
                    })
                    .catch(error => console.error('Error:', error));
                });
            }
        });
    </script>
</body>
</html>
