<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"> <!-- 필요 시 경로 수정 -->
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">회원가입</h2>
    
    <form action="${pageContext.request.contextPath}/login/signUpAction.do" method="post">
        <div class="mb-3">
            <label for="userId" class="form-label">아이디 : </label>
            <input type="text" class="form-control" id="userId" name="userId" required>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">비밀번호 : </label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>

        <div class="mb-3">
            <label for="name" class="form-label">이름 : </label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        
        <div class="mb-3">
            <label for="email" class="form-label">이메일 주소 : </label>
            <input type="text" class="form-control" id="email" name="email">
        </div>
        
        <div class="mb-3">
            <label for="phone" class="form-label">전화번호 : </label>
            <input type="text" class="form-control" id="phone" name="phone">
        </div>
        
        <div class="mb-3">
            <label for="address" class="form-label">집 주소 : </label>
            <input type="text" class="form-control" id="address" name="address">
        </div>

        <button type="submit" class="btn btn-primary">가입하기</button>
        <a href="../index.jsp" class="btn btn-secondary">돌아가기</a>
    </form>
</div>
</body>
</html>
