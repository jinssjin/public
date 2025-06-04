<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>

<%
    String json = (String) request.getAttribute("paymentResult");

    JSONParser parser = new JSONParser();
    JSONObject obj = null;

    try {
        obj = (JSONObject) parser.parse(json);
    } catch (ParseException e) {
        out.println("JSON 파싱 에러: " + e.getMessage());
    }

    // 안전하게 파싱되었는지 확인 후 출력
    if (obj != null) {
        String tid = (String) obj.get("tid");
        String itemName = (String) obj.get("item_name");

        JSONObject amount = (JSONObject) obj.get("amount");
        long totalAmount = (amount != null && amount.get("total") != null) ? (Long) amount.get("total") : 0;
%>
<html>
<head><title>결제 성공</title></head>
<body>
    <h2>결제가 성공적으로 승인되었습니다!</h2>
    <p>결제 번호: <%= tid %></p>
    <p>상품명: <%= itemName %></p>
    <p>결제 금액: <%= totalAmount %>원</p>
    <a href="index.jsp">메인으로 돌아가기</a>
</body>
</html>
<%
    }
%>
