package mvc.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvc.model.BoardDAO;
import mvc.model.BoardDTO;
import mvc.model.HobbyDAO;
import mvc.model.HobbyDTO;
import mvc.model.PaymentDAO;
import mvc.model.PaymentDTO;
import util.MailUtil;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final int LISTCOUNT = 5;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		if (command.equals("/downloadFile.do")) {
		    String fileName = request.getParameter("fileName");
		    if (fileName == null || fileName.trim().isEmpty()) {
			    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "파일명이 제공되지 않았습니다.");
			    return;
		    }
	
		    String UPLOAD_DIR = "/uploads";
		    String realPath = getServletContext().getRealPath(UPLOAD_DIR + File.separator + fileName);
		    File file = new File(realPath);
	
		    if (!file.exists()) {
			    response.sendError(HttpServletResponse.SC_NOT_FOUND, "파일을 찾을 수 없습니다.");
			    return;
		    }
	
		    String encodedFileName = URLEncoder.encode(file.getName(), "UTF-8").replaceAll("\\+", "%20");
		    response.setContentType("application/octet-stream");
		    response.setHeader("Content-Disposition", "attachment;filename=\"" + encodedFileName + "\"");
		    response.setContentLength((int) file.length());
	
		    try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		    BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream())) {
			    byte[] buffer = new byte[4096];
			    int len;
			    while ((len = in.read(buffer)) != -1) {
			    	out.write(buffer, 0, len);
			    }
		    }
		    return;
	    }
		// ========== 회원 관련 ==========
		if (command.equals("/login.do")) {
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			HobbyDAO dao = HobbyDAO.getInstance();
			boolean result = dao.validateUser(id, password);

			if (result) {
				// 로그인 성공 시 세션에 사용자 ID와 등급 저장
				request.getSession().setAttribute("sessionId", id);
				request.getSession().setAttribute("sessionClass", dao.getUserById(id).getClasses());
				// 인덱스 페이지로 리디렉션
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect(request.getContextPath() + "/login/login.jsp?error=1");
			}

		} else if (command.equals("/login_home.do")) {
			response.sendRedirect("login/login.jsp");
		} else if (command.equals("/signup.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("/login/signup.jsp");
			rd.forward(request, response);

		} else if (command.equals("/signupProcess.do")) {
			String str1 = request.getParameter("postcode");
			String str2 = request.getParameter("address");
			String str3 = request.getParameter("detailAddress");
			String address = String.join("/", str1, str2, str3);
			Date birthdate = Date.valueOf(request.getParameter("birthdate"));

			HobbyDTO dto = new HobbyDTO();
			dto.setUserId(request.getParameter("user_id"));
			dto.setPassword(request.getParameter("password"));
			dto.setName(request.getParameter("name"));
			dto.setEmail(request.getParameter("email"));
			dto.setPhone(request.getParameter("phone"));
			dto.setAddress(address);
			dto.setGender(request.getParameter("gender"));
			dto.setBirthdate(birthdate);
			dto.setClasses("U");

			HobbyDAO.getInstance().insertUser(dto);

			response.sendRedirect("login/login.jsp?msg=success");
		} else if (command.equals("/updateMember.do")) {
			String sessionId = (String) request.getSession().getAttribute("sessionId");
			HobbyDTO user = HobbyDAO.getInstance().getUserById(sessionId);
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("/login/updateMember.jsp");
			rd.forward(request, response);

		} else if (command.equals("/updateProcess.do")) {
			String address = String.join("/", request.getParameter("postcode"), request.getParameter("address"),
					request.getParameter("detailAddress"));
			Date birthdate = Date.valueOf(request.getParameter("birthdate"));

			HobbyDTO dto = new HobbyDTO();
			dto.setUserId(request.getParameter("user_id"));
			dto.setEmail(request.getParameter("email"));
			dto.setPhone(request.getParameter("phone"));
			dto.setAddress(address);
			dto.setGender(request.getParameter("gender"));
			dto.setBirthdate(birthdate);

			HobbyDAO.getInstance().updateUser(dto);

			response.sendRedirect("index.jsp");
		} else if (command.equals("/checkId.do")) {
			String userId = request.getParameter("user_id");
			HobbyDTO user = HobbyDAO.getInstance().getUserById(userId);
			if (user != null && user.getUserId().equals(userId)) {
				response.getWriter().write("duplicate");
			} else {
				response.getWriter().write("available");
			}
		} else if (command.equals("/checkEmail.do")) {
			String email = request.getParameter("email");
			HobbyDTO user = HobbyDAO.getInstance().getUserByEmail(email);
			if(user != null && user.getEmail().equals(email)) {
				response.getWriter().write("duplicate");
			} else {
				response.getWriter().write("available");
			}
		} else if (command.equals("/findId.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("/login/findId.jsp");
			rd.forward(request, response);
		} else if (command.equals("/findIdProcess.do")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");

			HobbyDAO dao = HobbyDAO.getInstance();
			String userId = dao.findUserIdByNameAndEmail(name, email);

			if (userId != null) {
				// URL 파라미터로 아이디 전달
				response.sendRedirect(
						request.getContextPath() + "/login/login.jsp?foundId=" + URLEncoder.encode(userId, "UTF-8"));
			} else {
				response.sendRedirect(request.getContextPath() + "/login/login.jsp?findError=1");
			}
		} else if (command.equals("/logout.do") || command.equals("/login/logout.do")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate(); // 세션 무효화
			}

			// 쿠키 삭제 처리
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("JSESSIONID".equals(cookie.getName())) {
						cookie.setValue(""); // 값 제거
						cookie.setMaxAge(0); // 유효기간 0 => 삭제
						cookie.setPath("/hobbyMe"); // 경로 일치 필요
						response.addCookie(cookie);
					}
				}
			}

			response.sendRedirect(request.getContextPath() + "/login/login.jsp");
		} else if (command.equals("/findPasswordProcess.do")) {
			String userId = request.getParameter("user_id");
			String email = request.getParameter("pw_email");

			HobbyDAO dao = HobbyDAO.getInstance();
			boolean exists = dao.checkUserIdAndEmail(userId, email);

			if (exists) {
				// 토큰 생성
				String token = UUID.randomUUID().toString();
				dao.deleteToken(userId);
				// 토큰을 DB에 저장 (user_id, token, 만료시간)
				dao.saveResetToken(userId, token);

				String link = "http://localhost:8080/hobbyMe/verifyToken.do?token=" + token;
				String subject = "HobbyMe 비밀번호 재설정 링크입니다.";
				String content = "아래 링크를 클릭하여 비밀번호를 재설정하세요:\n" + link;

				MailUtil.send(email, subject, content);

				response.sendRedirect(request.getContextPath() + "/login/login.jsp?msg=sent");
			} else {
				response.sendRedirect(request.getContextPath() + "/login/login.jsp?error=1");
			}
		} else if (command.equals("/verifyToken.do")) {
			String token = request.getParameter("token");
			String userId = HobbyDAO.getInstance().getUserIdByToken(token);

			if (userId != null) {
				HobbyDTO user = HobbyDAO.getInstance().getUserById(userId);
				String userPassword = user.getPassword();
				request.setAttribute("user_id", userId);
				request.setAttribute("pre_password", userPassword);
				RequestDispatcher rd = request.getRequestDispatcher("/login/resetPassword.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/login/login.jsp?error=token");
			}
		} else if (command.equals("/resetPasswordProcess.do")) {
			String userId = request.getParameter("user_id");
			String pw1 = request.getParameter("password");
			String pw2 = request.getParameter("confirm_password");
			HobbyDAO dao = HobbyDAO.getInstance();

			if (pw1.equals(pw2)) {
				HobbyDAO.getInstance().updatePassword(userId, pw1);
				dao.deleteToken(userId);
				response.sendRedirect(request.getContextPath() + "/login/login.jsp?reset=success");
			} else {
				response.sendRedirect("login/resetPassword.jsp?error=nomatch");
			}
		} else if(command.equals("/myPage.do")) {
			response.sendRedirect("login/myPage.jsp");
		} else if(command.equals("/hostApply.do")) {
			String sessionId = (String) request.getSession().getAttribute("sessionId");
			Boolean applyed = HobbyDAO.getInstance().checkApply(sessionId);
			if(applyed) {
				HobbyDTO applyUser = HobbyDAO.getInstance().getApplyById(sessionId);
				request.setAttribute("user", applyUser);
				RequestDispatcher rd = request.getRequestDispatcher("/login/applyed.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/login/apply.jsp");
			}
		} else if (command.equals("/apply.do")) {
				String sessionId = (String) request.getSession().getAttribute("sessionId");
			    // 파라미터 처리
				HobbyDTO dto = new HobbyDTO();
				String file = null;
				dto = HobbyDAO.getInstance().getUserById(sessionId);
				dto.setHostTitle(request.getParameter("title"));
				dto.setHostContent(request.getParameter("projectIdea"));
				if(request.getParameter("applyFile") != null) {
					file = request.getParameter("applyFile");
				}
				dto.setHostFile(file);
			    HobbyDAO.getInstance().insertApply(dto);

			    response.sendRedirect(request.getContextPath() + "/login/myPage.jsp?msg=success");
		} else if (command.equals("/BoardListAction.do")) {
			// ========== 게시판 관련 ==========
			requestBoardList(request);
			RequestDispatcher rd = request.getRequestDispatcher("./board/list.jsp");
			rd.forward(request, response);
		} else if (command.equals("/BoardWriteForm.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("./board/writeForm.jsp");
			rd.forward(request, response);

		} else if (command.equals("/BoardWriteAction.do")) {
			requestBoardWrite(request);
			RequestDispatcher rd = request.getRequestDispatcher("/BoardListAction.do");
			rd.forward(request, response);

		} else if (command.equals("/BoardViewAction.do")) {
			requestBoardView(request);
			RequestDispatcher rd = request.getRequestDispatcher("/BoardView.do");
			rd.forward(request, response);

		} else if (command.equals("/BoardView.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("./board/view.jsp");
			rd.forward(request, response);

		} else if (command.equals("/BoardUpdateAction.do")) {
			try {
				requestBoardUpdate(request);
				RequestDispatcher rd = request.getRequestDispatcher("/BoardListAction.do");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect(request.getContextPath() + "/errorPage.jsp"); // 에러 페이지로 리디렉션
			}

		} else if (command.equals("/BoardDeleteAction.do")) {
			requestBoardDelete(request);
			RequestDispatcher rd = request.getRequestDispatcher("/BoardListAction.do");
			rd.forward(request, response);
		} else if (command.equals("/BoardUpdateForm.do")) {
			// ========== 게시글 수정 폼 ==========

			// Get post_num from request
			int post_num = Integer.parseInt(request.getParameter("post_num"));

			// Fetch board details using BoardDAO
			BoardDAO dao = BoardDAO.getInstance();
			BoardDTO board = dao.getBoardByNum(post_num);

			// Set board details as attributes for the update form
			request.setAttribute("board", board);

			// Forward to the board update form page
			RequestDispatcher rd = request.getRequestDispatcher("./board/updateBoardForm.jsp");
			rd.forward(request, response);
			
			
		} else if (command.equals("/BoardLikeAction.do")) {
		    String sessionId = (String) request.getSession().getAttribute("sessionId");

		    if (sessionId == null || sessionId.isEmpty()) {
		        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		        return;
		    }

		    int postNum = Integer.parseInt(request.getParameter("post_num"));

		    BoardDAO dao = BoardDAO.getInstance();
		    boolean userLiked = dao.toggleLike(postNum, sessionId);

		 // 변경된 게시글 정보 다시 조회해서 board_like를 최신값으로 가져옴
		 int likeCount = dao.getBoardByNum(postNum).getBoard_like();

		 response.setContentType("application/json;charset=UTF-8");
		 response.getWriter().write("{\"likeCount\":" + likeCount + ",\"userLiked\":" + userLiked + "}");

			
		}else if (command.equals("/ReservationViewAction.do")) { // 예약글 상자 페이지 가져오기
			// $$$$$$$$$$$$$$$$$ 예약 관련 $$$$$$$$$$$$$$$$$
				requestReservationView(request);
	            RequestDispatcher rd = request.getRequestDispatcher("/ReservationView.do");
	            rd.forward(request, response);
	        }else if (command.equals("/ReservationView.do")) { // 예약글 상세 페이지 출력
	            RequestDispatcher rd = request.getRequestDispatcher("./payment/reservation.jsp");
	            rd.forward(request, response);
	        }else if (command.equals("/PaymentSaveAction.do")) { // 예약정보 테이블에 저장하기
	        	requestSaveReservation(request, response);
	            RequestDispatcher rd = request.getRequestDispatcher("/PaymentAction.do");
	            rd.forward(request, response);
	        }else if (command.equals("/PaymentAction.do")) { // 예약정보 테이블에 저장하기
	            RequestDispatcher rd = request.getRequestDispatcher("./payment/checkout.jsp");
	            rd.forward(request, response);
	        }
		
	}

	// ======================= Board 관련 메서드 =======================

	public void requestBoardList(HttpServletRequest request) {
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

		int total_record = dao.getListCount(items, text);
		boardlist = dao.getBoardList(pageNum, limit, items, text);

		if (boardlist == null)
			boardlist = new ArrayList<>();

		int total_page = (total_record / limit) + (total_record % limit == 0 ? 0 : 1);

		request.setAttribute("pageNum", pageNum);
		request.setAttribute("total_page", total_page);
		request.setAttribute("total_record", total_record);
		request.setAttribute("boardlist", boardlist);
	}

	public void requestBoardWrite(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			String user_id = (String) session.getAttribute("sessionId");

			if (user_id == null) {
				// 로그인 정보가 없을 경우 예외 처리 또는 리턴
				System.out.println("로그인 정보가 없습니다.");
				return;
			}

			BoardDAO dao = BoardDAO.getInstance();
			BoardDTO board = new BoardDTO();

			// 세션에서 가져온 user_id 설정
			board.setUser_id(user_id);

			// 일반 파라미터 설정
			board.setTitle(request.getParameter("title"));
			board.setContent(request.getParameter("content"));
			board.setCategory(request.getParameter("category"));
			board.setTag(request.getParameter("tag"));
			board.setLocation(request.getParameter("location"));
			board.setPeople(Integer.parseInt(request.getParameter("people")));
			board.setPrice(Integer.parseInt(request.getParameter("price")));
			board.setDeleted("N");

			// 날짜 설정
			String created_date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
			board.setCreated_date(created_date);
			board.setReservation_date(request.getParameter("reservation_date"));
			board.setEnd_date(request.getParameter("end_date"));

			// DB 저장
			dao.insertBoard(board);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void requestBoardView(HttpServletRequest request) {
	    BoardDAO dao = BoardDAO.getInstance();
	    int post_num = Integer.parseInt(request.getParameter("post_num"));
	    int pageNum = 1;

	    if (request.getParameter("pageNum") != null) {
	        try {
	            pageNum = Integer.parseInt(request.getParameter("pageNum"));
	        } catch (NumberFormatException e) {
	            pageNum = 1;
	        }
	    }

	    BoardDTO board = dao.getBoardByNum(post_num);

	    // 👍 로그인한 사용자의 좋아요 여부 확인
	    String sessionId = (String) request.getSession().getAttribute("sessionId");
	    if (sessionId != null) {
	        board.setUser_liked(dao.isLikedByUser(sessionId, post_num));
	    }

	    request.setAttribute("post_num", post_num);
	    request.setAttribute("pageNum", pageNum);
	    request.setAttribute("board", board);
	}


	public void requestBoardUpdate(HttpServletRequest request) throws Exception {
	    HttpSession session = request.getSession();
	    String loggedInUserId = (String) session.getAttribute("user_id");

	

	    int post_num = Integer.parseInt(request.getParameter("post_num"));
	    BoardDAO dao = BoardDAO.getInstance();

	    // 게시글 정보 조회
	    BoardDTO board = dao.getBoardByNum(post_num);

	   

	    // 게시글 수정 정보 설정
	    board.setPost_num(post_num);
	    board.setUser_id(request.getParameter("user_id"));
	    board.setTitle(request.getParameter("title"));
	    board.setContent(request.getParameter("content"));
	    board.setCategory(request.getParameter("category"));
	    board.setTag(request.getParameter("tag"));

	    // 추가된 부분: end_date 설정
	    board.setEnd_date(request.getParameter("end_date"));

	    board.setReservation_date(request.getParameter("reservation_date"));
	    board.setLocation(request.getParameter("location"));
	    board.setPeople(Integer.parseInt(request.getParameter("people")));
	    board.setPrice(Integer.parseInt(request.getParameter("price")));
	    board.setThumbnail(request.getParameter("thumbnail"));
	    board.setImages(request.getParameter("images"));
	    board.setDeleted(request.getParameter("deleted"));

	    // 'updated_date' 설정 (created_date는 설정하지 않음)
	    String updated_date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
	    board.setCreated_date(updated_date); // 여기서 updated_date를 설정해야 합니다.

	    // 업데이트 메서드 호출
	    dao.updateBoard(board); // 예외가 발생할 경우 try-catch로 처리 가능합니다.
	}


	public void requestBoardDelete(HttpServletRequest request) {
		int post_num = Integer.parseInt(request.getParameter("post_num"));
		BoardDAO.getInstance().deleteBoard(post_num);
	}
	
	// $$$$$$$$$$$$$$$$$ 예약 관련 메서드 $$$$$$$$$$$$$$$$$
		 public void requestReservationView(HttpServletRequest request) {
			
	     	BoardDAO dao = BoardDAO.getInstance();
	         
	         int post_num = Integer.parseInt(request.getParameter("post_num"));
	         
	         BoardDTO reservationInfo = dao.getBoardByNum(post_num);

	         request.setAttribute("post_num", post_num);
	         request.setAttribute("reservationInfo", reservationInfo);
	     }
		 
		 public void requestSaveReservation(HttpServletRequest request, HttpServletResponse response) {
		 
			 try {
			        HttpSession session = request.getSession();
			        String userId = (String) session.getAttribute("sessionId");

			        if (userId == null) {
			            System.out.println("세션이 만료되었습니다. 로그인 후 다시 시도해주세요.");
			            response.sendRedirect(request.getContextPath() + "/login/login.jsp");
			            return; // 더 이상 아래 로직이 실행되지 않도록 종료
			        } 
			        
			        HobbyDAO hobbyDao = HobbyDAO.getInstance(); 
			        HobbyDTO reservationUser = hobbyDao.getUserById(userId); // 유저 검색을 위한 dao 
					        
					 PaymentDAO boarddao = PaymentDAO.getInstance();
					 int post_num = Integer.parseInt(request.getParameter("post_num"));			 
					 BoardDTO classReservation = boarddao.getBoardByNum(post_num);  // 게시글 불러오기 위한 dao
					 
					 PaymentDTO reservationPaymentInfo = new PaymentDTO();
					 	
					 	reservationPaymentInfo.setUser_id(reservationUser.getUserId());
					 	reservationPaymentInfo.setName(reservationUser.getName());
					 	reservationPaymentInfo.setPhone(reservationUser.getPhone());
					 	reservationPaymentInfo.setEmail(reservationUser.getEmail());
					 	reservationPaymentInfo.setTitle(classReservation.getTitle());
					 	reservationPaymentInfo.setPrice(classReservation.getPrice());
					 	reservationPaymentInfo.setReservation_date(classReservation.getReservation_date()); // String이지만 yyyy-MM-dd 형식 가정
					 	reservationPaymentInfo.setEnd_date(classReservation.getEnd_date());
					 	reservationPaymentInfo.setState("WAIT");
					 	reservationPaymentInfo.setDeleted("N");
					 	
					 	PaymentDAO paymentDao = PaymentDAO.getInstance();
					 	paymentDao.insertPayment(reservationPaymentInfo);
					 
					 request.setAttribute("post_num", post_num);
			         request.setAttribute("reservationPaymentInfo", reservationPaymentInfo);

			 } catch (Exception e) {
			        e.printStackTrace();
			    }
		 }
}
