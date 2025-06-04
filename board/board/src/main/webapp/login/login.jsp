<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="model.BoardDTO"%>
<%@ page import="model.LoginDTO"%>

<%
	BoardDTO board = (BoardDTO) request.getAttribute("board");
	LoginDTO login = (LoginDTO) request.getAttribute("login");
	int num = ((Integer) request.getAttribute("num")).intValue();
	int nowPage = ((Integer) request.getAttribute("page")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<jsp:include page="/WEB-INF/header.jsp" />
	
<div class="container py-4">
   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">로그인</h1>
        <p class="col-md-8 fs-4">Login</p>      
      </div>
    </div>

    <div class="row align-items-md-stretch   text-center">
      <div class="row justify-content-center align-items-center ">
        <div class="h-100 p-5 col-md-6">
                <h3>Please sign in</h3>    
            <%
            String error = request.getParameter("error");
            if (error != null) {
               out.println("<div class='alert alert-danger'>");
               out.println("아이디와 비밀번호를 확인해 주세요");
               out.println("</div>");
            }
         %>
             <form class="form-signin" action="j_security_check" method="post">
				<!-- Tomcat 컨테이너가 처리하는 로그인 서블릿 -->
             <div class="form-floating  mb-3 row">
                  <input type="text"  class="form-control" name='j_username'   required autofocus>
                  <label for="floatingInput">ID</label>      
             </div>
             <div class="form-floating  mb-3 row">      
                  <input type="password" class="form-control" name='j_password' >
                <label for="floatingInput">Password</label>
             </div>
   
              <button class="btn btn-lg btn-success" type="submit">로그인</button>
               
           </form>
         </div>  
       </div>   
    </div> 
      <%@ include file="footer.jsp"%>   
  </div>
	<jsp:include page="/WEB-INF/footer.jsp" />
	
	
	</div>
	
	
</body>
</html>