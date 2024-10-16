<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<div class="container border py-3 mt-3">
   <form>
      <input type="hidden" id="id" value="${post.id }">
      <div class="mb-3">
         <label for="title">Title : </label>
         <input type="text" class="form-control" id="title" value="${post.title}">
      </div>
      <div class="mb-3">
         <label for="content">Content : </label>
         <textarea class="form-control" id="content" >
         	${post.content}
         </textarea>
      </div>
   
   </form>
   
   <hr>
   <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
   <button id="btn-update" class="btn btn-warning">수정완료</button>
</div>
<script src="/js/post.js"></script>
<%@ include file = "../layout/footer.jsp" %>