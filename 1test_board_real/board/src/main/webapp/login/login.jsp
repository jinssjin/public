<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<title>Login</title>
</head>
 <body >
<div class="container py-4">
   <jsp:include page="/WEB-INF/header.jsp" />   

   
    <div class="row align-items-md-stretch text-center">
      <div class="row justify-content-center align-items-center ">
        <div class="h-500 p-5 col-md-6">
                <h3>로그인</h3>    
            <%
            String error = request.getParameter("error");
            if (error != null) {
               out.println("<div class='alert alert-danger'>");
               out.println("아이디와 비밀번호를 확인해 주세요");
               out.println("</div>");
            }
         	%>
         	
           <form class="form-signin" action="/board/login/loginAction.do" method="post">
             <div class="form-floating  mb-3 row">
                  <input type="text"  class="form-control" name='userId' required>
                  <label for="floatingInput">ID</label>      
             </div>
             <div class="form-floating  mb-3 row">      
                  <input type="password" class="form-control" name='password' >
                <label for="floatingInput">Password</label>
             </div>
   
              <button class="btn btn-lg btn-success" type="submit">로그인</button>
               
           </form>
         </div>  
       </div>   
    </div> 
      <jsp:include page="/WEB-INF/footer.jsp" />   
  </div>
  </body>         
   
</html>