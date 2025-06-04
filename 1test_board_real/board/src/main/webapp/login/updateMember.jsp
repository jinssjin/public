<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.LoginDTO" %>
<%
    LoginDTO user = (LoginDTO) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원정보 수정</title>
    <link rel="stylesheet" href="../resources/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">회원정보 수정</h2>

    <form action="updateMemberAction.do" method="post">
        <!-- 히든 필드로 아이디와 비밀번호 전달 -->
        <input type="hidden" name="userId" value="<%= user.getUserId() %>">
        <input type="hidden" name="password" value="<%= user.getPassword() %>">

        <div class="mb-3">
            <label class="form-label">아이디 : </label>
            <input type="text" class="form-control" value="<%= user.getUserId() %>" disabled>

        </div>

        <div class="mb-3">
            <label class="form-label">비밀번호 : </label>
            <p class="form-control-plaintext">********</p>
        </div>

        <div class="mb-3">
            <label for="name" class="form-label">이름 : </label>
            <input type="text" class="form-control" id="name" name="name" value="<%= user.getUserName() %>">
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">이메일 주소 : </label>
            <input type="text" class="form-control" id="email" name="email" value="<%= user.getUserEmail() %>">
        </div>

        <div class="mb-3">
            <label for="phone" class="form-label">전화번호 : </label>
            <input type="text" class="form-control" id="phone" name="phone" value="<%= user.getUserPhone() %>">
        </div>

        <div class="mb-3">
            <label for="address" class="form-label">집 주소 : </label>
            <input type="text" class="form-control" id="address" name="address" value="<%= user.getUserAddress() %>">
        </div>

        <button type="submit" class="btn btn-primary">수정하기</button>
        <a href="../index.jsp" class="btn btn-secondary">취소</a>
    </form>
</div>
</body>
</html>
