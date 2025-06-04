package mvc.controller;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.*;


public class KakaoPayReadyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        URL url = new URL("https://open-api.kakaopay.com/online/v1/payment/ready");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // 요청 설정
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "KakaoAK 6cdf1903db5982e39f60deec0ce19d2d"); // ★ 관리자 키 입력
        conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        conn.setDoOutput(true);

        // 파라미터 설정
        String params = "cid=TC0ONETIME" +
                        "&partner_order_id=1234" +
                        "&partner_user_id=testuser" +
                        "&item_name=테스트상품" +
                        "&quantity=1" +
                        "&total_amount=1000" +
                        "&vat_amount=100" +
                        "&tax_free_amount=0" +
                        "&approval_url=http://localhost:8080/hobbyMe2/approve.jsp" +
                        "&cancel_url=http://localhost:8080/hobbyMe2/cancel.jsp" +
                        "&fail_url=http://localhost:8080/hobbyMe2/fail.jsp";

        // 요청 전송
        try (OutputStream out = conn.getOutputStream()) {
            out.write(params.getBytes("UTF-8"));
        }

        // 응답 받기
        int responseCode = conn.getResponseCode();
        BufferedReader in;
        if (responseCode == 200) {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        String inputLine;
        StringBuilder responseBody = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            responseBody.append(inputLine);
        }
        in.close();

        // JSON 파싱을 위해 응답을 JSP에 전달
        request.setAttribute("kakaoPayResponse", responseBody.toString());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/paymentResult.jsp");
        dispatcher.forward(request, response);
    }
}
