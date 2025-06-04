package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.LoginDAO;
import model.LoginDTO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.BoardDAO;
import model.BoardDTO;

public class LoginController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   static final int LISTCOUNT = 5; 

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
   }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	
	  request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      String RequestURI = request.getRequestURI();
      String contextPath = request.getContextPath();
      String command = RequestURI.substring(contextPath.length());

      System.out.println("command = " + command);
   
      if (command.equals("/login/loginAction.do")) {  // 로그인
    	  checkLogin(request,response);
      }else if(command.equals("/login/signUp.do")) {  // 회원가입폼
    	  RequestDispatcher rd = request.getRequestDispatcher("/login/signup.jsp");
    	  rd.forward(request, response);
      }else if(command.equals("/login/signUpAction.do")) {  // 회원가입
    	  createId(request,response);
      }else if (command.equals("/login/updateMember.do")) {  // 회원정보 수정폼 불러오기
    	  	requestUpdateMember(request);
    	  	RequestDispatcher rd = request.getRequestDispatcher("/login/updateMember.jsp");
			rd.forward(request, response);
      }else if (command.equals("/login/updateMemberAction.do")) {  // 회원정보 수정
    	  	updateUserById(request,response);
    	  	response.sendRedirect(request.getContextPath() + "/index");
      }else if (command.equals("/login/logout.do")) {  // 로그아웃
    	    logout(request, response);
    	    RequestDispatcher rd = request.getRequestDispatcher("/login/logout.jsp");
    	    rd.forward(request, response);
      }else if (command.equals("/login/deleteMember.do")) {  // 회원탈퇴
    	    deleteAccount(request, response);
      
    	    		// 게시판 관련
      }else if (command.equals("/board/BoardView.do")) {  // 게시판 상세보기
    	  	serchBoardById(request);
		  	RequestDispatcher rd = request.getRequestDispatcher("/board/view.jsp");
		  	rd.forward(request, response);
      }else if (command.equals("/board/boardWriteForm.do")) {  // 게시글 작성폼 불러오기
    	  	RequestDispatcher rd = request.getRequestDispatcher("/board/writeForm.jsp");
    	  	rd.forward(request, response);
      }else if (command.equals("/board/BoardWriteAction.do")) { // 게시글 작성폼 날리기
			requestBoardWrite(request);
			RequestDispatcher rd = request.getRequestDispatcher("/board/BoardListAction.do");
			rd.forward(request, response);
      }else if (command.equals("/board/BoardListAction.do")) {  // 게시글 리스트 보기
  	  		requestBoardList(request, response);
  	  		RequestDispatcher rd = request.getRequestDispatcher("/board/list.jsp");
  	  		rd.forward(request, response);
      }else if (command.equals("/board/BoardUpdate.do")) {  // 게시글 수정폼 불러오기
    	  	serchBoardById(request);
	  		RequestDispatcher rd = request.getRequestDispatcher("/board/updateBoardForm.jsp");
	  		rd.forward(request, response);
      }else if (command.equals("/board/BoardUpdateAction.do")) {  // 게시글 수정하기
	  		updateBoard(request);
	  		RequestDispatcher rd = request.getRequestDispatcher("/board/BoardView.do");
	  		rd.forward(request, response);
      }else if (command.equals("/board/BoardDeleteAction.do")) {  // 게시글 삭제하기
	  		deleteBoard(request,response);
	  		return;
      }
   }
  // 메서드 영역
      
  // 로그인 체크 메서드
  public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

  // login.jsp에서 form으로 받아온 아이디와 패스워드
  String userId = request.getParameter("userId");
  String password = request.getParameter("password");
  
  // LoginDTO 객체를 생성해서 받아온 아이디와 패스워드를 넣어주고 
  LoginDTO loginDto = new LoginDTO();
  loginDto.setUserId(userId);
  loginDto.setPassword(password);
  
  // 로그인 체크 매서드로 확인 (참값 혹은 거짓)
  LoginDAO loginDao = LoginDAO.getInstance();
  boolean isValid = loginDao.loginCheck(loginDto);
  
  // 세션에 유저 정보 저장
  if (isValid) {
      HttpSession session = request.getSession();
      LoginDAO dao = LoginDAO.getInstance();
      LoginDTO user = dao.getUserById(userId); // userId로 사용자 정보 조회하는 메서드 필요
      session.setAttribute("user", user);
      response.sendRedirect("./success.jsp");
  } else {
      response.sendRedirect("./fail.jsp");
  }
}
  
  // 회원가입
  public void createId(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    String userId = request.getParameter("userId");
	    String password = request.getParameter("password");
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    String address = request.getParameter("address");

	   
	    LoginDTO dto = new LoginDTO();
	    dto.setUserId(userId);
	    dto.setPassword(password);
	    dto.setUserName(name);
	    dto.setUserEmail(email);
	    dto.setUserPhone(phone);
	    dto.setUserAddress(address);

	    LoginDAO dao = LoginDAO.getInstance();
	    boolean result = dao.createId(dto);

	    if (result) {
	        response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>");
	        out.println("alert('회원가입에 성공하였습니다.');");
	        out.println("location.href='" + request.getContextPath() + "/index.jsp';");
	        out.println("</script>");
	        out.close();
	    } else {
	        response.sendRedirect(request.getContextPath() + "/login/signUpFail.jsp");
	    }
	}

  
  // 멤버 업데이트
  public void requestUpdateMember(HttpServletRequest request) {
	  	String sessionId = (String) request.getSession().getAttribute("sessionId");
		LoginDTO user = LoginDAO.getInstance().getUserById(sessionId);
		request.setAttribute("user", user);
  }
  
  public void updateUserById(HttpServletRequest request, HttpServletResponse response)
	        throws IOException {
	    String userId = request.getParameter("userId");
	    String password = request.getParameter("password");
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    String address = request.getParameter("address");

	    LoginDTO dto = new LoginDTO();
	    dto.setUserId(userId);
	    dto.setPassword(password);
	    dto.setUserName(name);
	    dto.setUserEmail(email);
	    dto.setUserPhone(phone);
	    dto.setUserAddress(address);

	    LoginDAO dao = LoginDAO.getInstance();
	    boolean result = dao.updateUser(dto); // 이 메서드도 DAO에 구현 필요
	    
	    if (result) {
	        response.sendRedirect(request.getContextPath() + "/index.jsp");
	    } else {
	        response.sendRedirect(request.getContextPath() + "/login/updateFail.jsp");
	    }
	}
  
  public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    HttpSession session = request.getSession(false);  // 현재 세션이 없으면 null 반환
	    
	    if (session != null) {
	    	LoginDTO user = (LoginDTO) session.getAttribute("user");
	    	String userName = user.getUserName();
	    	request.setAttribute("userName", userName);
	        session.invalidate(); // 세션 무효화
	    }    
	}
  
  public void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  LoginDTO session = (LoginDTO) request.getSession().getAttribute("user");
	  String sessionId = session.getUserId();

	    if (sessionId != null) {
	        LoginDAO dao = LoginDAO.getInstance();
	        boolean result = dao.deleteUserById(sessionId);

	        if (result) {
	            // 세션 종료
	            HttpSession session1 = request.getSession(false);
	            if (session1 != null) session1.invalidate();

	            // 탈퇴 성공 페이지로 이동
	            response.sendRedirect(request.getContextPath() + "/login/deleteIdSuccess.jsp");
	        } else {
	            // 실패 시 알림 또는 에러 페이지로 이동
	            response.sendRedirect(request.getContextPath() + "/login/deleteIdFail.jsp");
	        }
	    } else {
	        response.sendRedirect(request.getContextPath() + "/login/login.jsp");
	    }
	}

  
      
      public void requestBoardList(HttpServletRequest request, HttpServletResponse response) throws IOException {
          LoginDTO session = (LoginDTO) request.getSession().getAttribute("user");
          if (session == null) {
              // 로그인 안 된 상태
              response.sendRedirect("login.jsp");  // 로그인 페이지로 이동
              return;
          }

          String sessionId = session.getUserId();

          BoardDAO dao = BoardDAO.getInstance();
          ArrayList<BoardDTO> boardlist;

          int pageNum = 1;
          int limit = LISTCOUNT;

          if (request.getParameter("pageNum") != null) {
              try {
                  pageNum = Integer.parseInt(request.getParameter("pageNum"));
              } catch (NumberFormatException e) {
                  pageNum = 1;
              }
          }

          String items = request.getParameter("items");
          String text = request.getParameter("text");
          String sort = request.getParameter("sort");

          // 게시글 목록 및 개수 가져오기
          int total_record = dao.getListCount(items, text);
          boardlist = dao.getBoardList(pageNum, limit, items, text, sort);

          int total_page = (total_record / limit) + (total_record % limit == 0 ? 0 : 1);

          request.setAttribute("pageNum", pageNum);
          request.setAttribute("total_page", total_page);
          request.setAttribute("total_record", total_record);
          request.setAttribute("boardlist", boardlist);
      }
   
  
	public void requestBoardWrite(HttpServletRequest request) {
	    try {
	        String title = request.getParameter("title");
	        String content = request.getParameter("content");
	       
	        LoginDTO user = (LoginDTO) request.getSession().getAttribute("user");
	        if (user == null) {
	            throw new IllegalStateException("로그인 상태가 아닙니다.");
	        }
	        String writer = user.getUserId();
	        
	        
	        BoardDAO dao = BoardDAO.getInstance();
	       	
	        BoardDTO board = new BoardDTO();
	        board.setBoardTitle(title);
	        board.setBoardContent(content);
	        board.setBoardWriter(writer);
	        board.setValid("Y");
	
	        dao.insertBoard(board);
	
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void serchBoardById(HttpServletRequest request) {
		String pageNum = request.getParameter("pageNum");
	    if (pageNum == null || pageNum.isEmpty()) {
	        pageNum = "1";
	    }
		System.out.println("pageNum = " + pageNum);
		HttpSession session = request.getSession(false);
	    if (session != null) {
	        LoginDTO loginUser = (LoginDTO) session.getAttribute("user");
	        request.setAttribute("login", loginUser);
	    } else {
	        request.setAttribute("login", null);
	    }
		
		String numStr = request.getParameter("num");
	    if (numStr == null || numStr.isEmpty()) {
	        request.setAttribute("errorMsg", "게시글 번호가 없습니다.");
	        return;
	    }
	    
	    

	    try {
	        int num = Integer.parseInt(numStr);

	        BoardDAO dao = BoardDAO.getInstance();
	        BoardDTO board = dao.getBoardByNo(num);

	        if (board == null) {
	            request.setAttribute("errorMsg", "존재하지 않는 게시글입니다.");
	        } else {
	            request.setAttribute("board", board);
	            request.setAttribute("page", pageNum);
	        }
	    } catch (NumberFormatException e) {
	        request.setAttribute("errorMsg", "잘못된 게시글 번호입니다.");
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("errorMsg", "게시글 조회 중 오류가 발생했습니다.");
	    }
	    
	}
	
	public void updateBoard(HttpServletRequest request) {
		String numStr = request.getParameter("num");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		if (numStr == null || numStr.isEmpty()) {
			request.setAttribute("errorMsg", "게시글 번호가 없습니다.");
			return;
		}

		try {
			int num = Integer.parseInt(numStr);
			BoardDAO dao = BoardDAO.getInstance();
			BoardDTO board = new BoardDTO();
			board.setBoardNo(num);
			board.setBoardTitle(title);
			board.setBoardContent(content);

			boolean result = dao.updateBoard(board);
			if (result) {
				request.setAttribute("successMsg", "게시글이 성공적으로 수정되었습니다.");
			} else {
				request.setAttribute("errorMsg", "게시글 수정에 실패했습니다.");
			}
		} catch (NumberFormatException e) {
			request.setAttribute("errorMsg", "잘못된 게시글 번호입니다.");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "게시글 수정 중 오류가 발생했습니다.");
		}
	}
	
	public void deleteBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        int boardNo = Integer.parseInt(request.getParameter("num")); // "num"으로 받아야 함
	        String pageNum = request.getParameter("pageNum"); // 페이지 번호도 같이 받음
	        request.setAttribute("pageNum", pageNum);

	        BoardDAO dao = BoardDAO.getInstance();
	        boolean success = dao.deleteBoard(boardNo);

	        if (success) {
	        	response.sendRedirect(request.getContextPath() + "/board/BoardListAction.do?pageNum=" + pageNum);
	            return;
	        } else {
	            request.setAttribute("error", "게시글 삭제에 실패했습니다.");
	            RequestDispatcher rd = request.getRequestDispatcher("BoardError.jsp");
	            rd.forward(request, response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", "예외 발생: " + e.getMessage());
	        RequestDispatcher rd = request.getRequestDispatcher("BoardError.jsp");
	        rd.forward(request, response);
	    }
	}

}
