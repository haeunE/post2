<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container mt-3">
   <form>
   <input type = "hidden" id = "id" value="${principal.user.id}">
     <div class="mb-3 mt-3">
       <label for="username" class="form-label">userName:</label>
       <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" value = "${principal.user.username}" disabled="disabled">
     </div>
     <div class="mb-3">
       <label for="password" class="form-label">Password:</label>
       <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" >
     </div>
     <div class="mb-3 mt-3">
       <label for="email" class="form-label">email:</label>
       <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" value="${principal.user.email}">
     </div>
     <div class="mb-3 mt-3">
       <label for="role" class="form-label">role:</label>
       <input type="text" class="form-control" id="role" name="role" value="${principal.user.role}" disabled="disabled">
     </div>
     <div class="mb-3 mt-3">
       <label for="createDate" class="form-label">createDate:</label>
       <input type="text" class="form-control" id="createDate" name="createDate" value="${principal.user.createDate}" disabled="disabled">
     </div>
     <button id="btn-update" type="button" class="btn btn-primary" >정보수정</button>
     <button id="btn-delete" type="button" class="btn btn-danger" >회원탈퇴</button>
   </form>
</div>
<script src="/js/user.js"></script>
<%@ include file = "../layout/footer.jsp" %>