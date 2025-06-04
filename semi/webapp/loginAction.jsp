<%@page import="java.io.PrintWriter"%>
<%@page import="user.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="user.User" scope="page" />
<jsp:setProperty name="user" property="userID" />    
 <jsp:setProperty name="user" property="userPassword" />    
       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
      UserDAO userDAO = new UserDAO();
      int result = userDAO.login(user.getUserID(), user.getUserPassword());
      if(result == 1){
         PrintWriter script = response.getWriter();
         script.println("<script>");
         script.println("alert('로그인성공')");
         script.println("location.href = 'main.jsp'");
         script.println("</script>");
      }else if(result == 0){
         PrintWriter script = response.getWriter();
         script.println("<script>");
         script.println("alert('비밀번호가 틀립니다.')");
         script.println("history.back()"); //자바스크립트 뒤로가기
         script.println("</script>");
      }else if(result == -1){
         PrintWriter script = response.getWriter();
         script.println("<script>");
         script.println("alert('존재하지않는 아이디입니다.')");
         script.println("history.back()"); //자바스크립트 뒤로가기
         script.println("</script>");
      }else if(result == -2){
         PrintWriter script = response.getWriter();
         script.println("<script>");
         script.println("alert('데이터베이스오류입니다.')");
         script.println("history.back()"); //자바스크립트 뒤로가기
         script.println("</script>");
      }
      
   %>
</body>
</html>










