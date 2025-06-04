package mvc.model;

import java.io.*;
import java.net.*;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class KakaoPayService {

	public String kakaoPayReady(HttpServletRequest request) {
	    try {
	        URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "KakaoAK [6cdf1903db5982e39f60deec0ce19d2d]");
	        conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	        conn.setDoOutput(true);

	        String params = "cid=TC0ONETIME" +
	                "&partner_order_id=partner_order_id" +
	                "&partner_user_id=partner_user_id" +
	                "&item_name=테스트상품" +
	                "&quantity=1" +
	                "&total_amount=1000" +
	                "&vat_amount=100" +
	                "&tax_free_amount=0" +
	                "&approval_url=http://localhost:8080/hobbyMe2/kakaoPaySuccess.do" +
	                "&cancel_url=http://localhost:8080/hobbyMe2/kakaoPayCancel.do" +
	                "&fail_url=http://localhost:8080/hobbyMe2/kakaoPayFail.do";

	        OutputStream output = conn.getOutputStream();
	        output.write(params.getBytes());
	        output.flush();

	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        StringBuilder sb = new StringBuilder();
	        String line;

	        while ((line = br.readLine()) != null) {
	            sb.append(line);
	        }

	        br.close();

	        // JSON 파싱 없이 간단 처리 (실제 사용 시 JSON 파서 권장)
	        String response = sb.toString();
	        int urlIndex = response.indexOf("\"next_redirect_pc_url\":\"");
	        int start = urlIndex + 25;
	        int end = response.indexOf("\"", start);
	        String redirectUrl = response.substring(start, end).replace("\\", "");

	        // Extract the TID (Transaction ID) and save it in the session
	        int tidIndex = response.indexOf("\"tid\":\"");
	        int tidStart = tidIndex + 7;
	        int tidEnd = response.indexOf("\"", tidStart);
	        String tid = response.substring(tidStart, tidEnd);

	        // Save tid in the session to use it later
	        request.getSession().setAttribute("tid", tid);

	        return redirectUrl;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return "/error.jsp";
	}

    
    
	public String approvePayment(HttpServletRequest request, String pg_token) {
	    String apiUrl = "https://kapi.kakao.com/v1/payment/approve";
	    HttpURLConnection conn = null;
	    String jsonResponse = "";

	    try {
	        String tid = (String) request.getSession().getAttribute("tid"); // 세션에서 tid 꺼냄

	        URL url = new URL(apiUrl);
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "KakaoAK [cd8580d59ce2dd5b8c71bde30f3cb16e]");
	        conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	        conn.setDoOutput(true);

	        String params = "cid=TC0ONETIME" +
	                "&tid=" + tid +
	                "&partner_order_id=partner_order_id" +
	                "&partner_user_id=partner_user_id" +
	                "&pg_token=" + pg_token;

	        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
	        writer.write(params);
	        writer.flush();

	        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	        }
	        jsonResponse = sb.toString();
	        reader.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) conn.disconnect();
	    }

	    return jsonResponse;
	}

}
