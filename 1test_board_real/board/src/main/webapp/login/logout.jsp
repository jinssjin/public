<%@ page contentType="text/html; charset=UTF-8" %>
<%
    // 세션에서 사용자 이름 가져오기
    String userName = (String) request.getAttribute("userName");
    if (userName == null) {
        userName = "이용자"; // 기본값
    }
%>
<!DOCTYPE html>
<html>
<head>
<title>로그아웃</title>
    <script type="text/javascript">
        alert("로그아웃되었습니다. <%= userName %>님, 다음에 만나요!");
        window.location.href = "../index.jsp";
    </script>
</head>
<body>
</body>
</html>
