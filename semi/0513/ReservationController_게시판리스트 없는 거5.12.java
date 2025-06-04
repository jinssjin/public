package mvc.controller;

import java.io.IOException;
import java.util.*;
import mvc.model.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import mvc.model.BoardDAO;
import mvc.model.BoardDTO;

public class ReservationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static final int LISTCOUNT = 5;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String RequestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = RequestURI.substring(contextPath.length());

        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");

        if (command.equals("/ReservationAction.do")) { // 예약하기 페이지로 돌아가기
            requestReservationInfo(request); // 예약 상세 정보 다시 로드
            RequestDispatcher rd = request.getRequestDispatcher("./reservation/reservation.jsp");
            rd.forward(request, response);
        } else if (command.equals("/paymentAction.do")) {
            requestReservationInfo(request); // 예약 정보 다시 불러오기
            RequestDispatcher rd = request.getRequestDispatcher("./reservation/payment.jsp");
            rd.forward(request, response);
        } else if (command.equals("/kakaoPayReady.do")) {  
            RequestDispatcher rd = request.getRequestDispatcher("./reservation/kakaoPay.jsp"); //카카오 결제 준비 로직 호출
            rd.forward(request, response);
        } else if (command.equals("/reservationDeleteAction.do")) { // 예약 취소하기 
            requestReservationDelete(request);
            RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
            rd.forward(request, response);
        } 
        
        
//        else if (command.equals("/kakaoPaySuccess.do")) {
//            // 결제 성공 처리
//            RequestDispatcher rd = request.getRequestDispatcher("./reservation/kakaoPaySuccess.jsp");
//            rd.forward(request, response);
//        } else if (command.equals("/kakaoPayCancel.do")) {
//            // 결제 취소 처리
//            RequestDispatcher rd = request.getRequestDispatcher("./reservation/kakaoPayCancel.jsp");
//            rd.forward(request, response);
//        } else if (command.equals("/kakaoPayFail.do")) {
//            // 결제 실패 처리
//            RequestDispatcher rd = request.getRequestDispatcher("./reservation/kakaoPayFail.jsp");
//            rd.forward(request, response);
//        }
        
        
//        else if (command.equals("/kakaoPaySuccess.do")) {
//            String pg_token = request.getParameter("pg_token");
//
//            // 카카오페이 결제 승인
//            KakaoPayService payService = new KakaoPayService();
//            String resultJson = payService.approvePayment(pg_token);
//
//            request.setAttribute("paymentResult", resultJson);
//
//            RequestDispatcher rd = request.getRequestDispatcher("./reservation/kakaoPaySuccess.jsp");
//            rd.forward(request, response);
//        }
        

    }

    
 // 예약 정보 상세 조회
    public void requestReservationInfo(HttpServletRequest request) {
        try {
            int post_num = Integer.parseInt(request.getParameter("post_num"));
            BoardDAO dao = BoardDAO.getInstance();
            BoardDTO reservationInfo = dao.getBoardByNum(post_num);  // post_num으로 sql에서 셀렉한 BoardDTO board
            
            String title, end_date, location, people, price, thumbnail;
            
            request.setAttribute("title", title);
            request.setAttribute("end_date", end_date);
            request.setAttribute("location", location);
            request.setAttribute("people", people);
            request.setAttribute("price", price);
            request.setAttribute("thumbnail", thumbnail);
            request.setAttribute("reservationInfo", reservationInfo);
            
            
    }

    // 선택된 예약 삭제하기
    public void requestReservationDelete(HttpServletRequest request) {
        int post_num = Integer.parseInt(request.getParameter("post_num"));
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));

        BoardDAO dao = BoardDAO.getInstance();
        dao.deleteBoard(post_num);
    }
}
