<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KakaoPay 결제</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- 결제 버튼 -->
<button class="btn btn-primary" id="kakaoPayButton">KakaoPay로 결제하기</button>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script>
    document.getElementById('kakaoPayButton').addEventListener('click', function() {
        // 서버에서 결제 준비 요청 (kakaoPayReady.do) 후 반환된 redirectUrl로 이동
        fetch('<%= request.getContextPath() %>/kakaoPayReady.do', { method: 'POST' })
            .then(response => response.json())
            .then(data => {
                // KakaoPay 결제창으로 리디렉션
                window.location.href = data.redirectUrl; // 서버에서 받은 리디렉션 URL로 이동
            })
            .catch(error => {
                console.error('KakaoPay 결제 준비 중 오류 발생:', error);
            });
    });
</script>

</body>
</html>
