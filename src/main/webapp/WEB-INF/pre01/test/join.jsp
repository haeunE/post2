<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../layout/header.jsp" %>
<ul>
	<c:forEach items="${errorMsg}" var = "msg">
		<li>${msg}</li>
	</c:forEach>
</ul>
<form action="/test/join" method="POST">
	아이디 : <input type="text" name="username" value="${userDTO.username}"><br>
	비밀번호 : <input type="password" name="password" value="${userDTO.password}"><br>
	이메일 : <input type="text" name="email" value="${userDTO.email}"><br>
	<input type="submit" value="회원가입">
</form>
<%@ include file = "../layout/footer.jsp" %>