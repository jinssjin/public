package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

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

        if (command.equals("/reservationViewAction.do")) { // 선택된 예약 글 가져오기
            requestReservationView(request);
            RequestDispatcher rd = request.getRequestDispatcher("/reservationView.do");
            rd.forward(request, response);
        }else if (command.equals("/reservationView.do")) { // 예약글 페이지 출력
            RequestDispatcher rd = request.getRequestDispatcher("./reservation/reservation2.jsp");
            rd.forward(request, response);
        }
       
}
    
    // 선택된 글 상세 페이지 가져오기
    public void requestReservationView(HttpServletRequest request) {
        BoardDAO dao = BoardDAO.getInstance();

        int post_num = Integer.parseInt(request.getParameter("post_num"));
        int pageNum = 1;

        // pageNum 예외 처리
        if (request.getParameter("pageNum") != null) {
            try {
                pageNum = Integer.parseInt(request.getParameter("pageNum"));
            } catch (NumberFormatException e) {
                pageNum = 1;
            }
        }

        BoardDTO board = dao.getBoardByNum(post_num);

        request.setAttribute("post_num", post_num);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("board", board); // ✅ board라는 이름으로 전달해야 JSP에서 받음
    }