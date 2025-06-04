<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>
    <jsp:include page="/WEB-INF/header.jsp" />

    <div class="container py-4">
        <form action="BoardWriteAction.do" method="post">
            <div class="mb-3 row">
                <label for="title" class="col-sm-2 col-form-label">제목</label>
                <div class="col-sm-5">
                    <input type="text" name="title" id="title" class="form-control" required>
                </div>
            </div>

            <div class="mb-3 row">
                <label for="content" class="col-sm-2 col-form-label">내용</label>
                <div class="col-sm-8">
                    <textarea name="content" id="content" class="form-control" cols="50" rows="5" required></textarea>
                </div>
            </div>

            <div class="mb-3 row">
                <div class="offset-sm-2 col-sm-10">
                    <input type="submit" class="btn btn-primary" value="등록">
                    <a href="./BoardListAction.do" class="btn btn-secondary">목록으로</a>
                </div>
            </div>
        </form>
    </div>

    <jsp:include page="/WEB-INF/footer.jsp" />
</body>
</html>
