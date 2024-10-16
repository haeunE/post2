<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../layout/header.jsp" %>

<div class="container mt-3">
   <form method="post" action="/auth/login">
     <div class="mb-3 mt-3">
       <label for="username" class="form-label">userName:</label>
       <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
     </div>
     <div class="mb-3">
       <label for="password" class="form-label">Password:</label>
       <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
     </div>
     <button id="btn-login" type="submit" class="btn btn-primary">로그인</button>
   </form>
   <a href = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=2b9a3010369c5138ce0adef97b47c746&redirect_uri=http://localhost:8888/oauth/kakao
   ">
   	<img src="/img/kakao_login_btn.png">
   </a>
   <a href = "../oauth2/authorization/google"">
   	<img src="/img/google_login_btn.png">
   </a>
</div>

<%@ include file = "../layout/footer.jsp"%>