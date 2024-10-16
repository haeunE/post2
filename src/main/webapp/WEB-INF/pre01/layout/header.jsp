<%@page import="com.example.demo.controller.copy.UserController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Insert title here</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
      <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
      <!-- include summernote css/js -->
	  <link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.css" rel="stylesheet">
	  <script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.js"></script>
   </head>
<body>

   <nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
      <div class="container-fluid">
         <a class="navbar-brand" href="/">Home</a>
         <button class="navbar-toggler" type="button"
            data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02"
            aria-controls="navbarTogglerDemo02" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
         </button>
         <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
         	<c:if test = "${principal == null}">
	            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	               <li class="nav-item"><a class="nav-link active"
	                  aria-current="page" href="/auth/insertuser">Sign up</a></li>
	                 <li class="nav-item"><a class="nav-link" href="/jointest">회원가입연습</a></li>
	               <li class="nav-item"><a class="nav-link" href="/auth/login">Login</a></li>
	               <li class="nav-item"><a class="nav-link disabled"
	                  aria-disabled="true" href = "/post">Write</a></li>
	            </ul>
            </c:if>
            <c:if test = "${principal != null}">
	            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	               <li class="nav-item"><a class="nav-link" href="/auth/userinfo">User</a></li>
	               <li class="nav-item"><a class="nav-link" href="/auth/logout">Logout</a></li>
	               <li class="nav-item"><a class="nav-link" href="/post">Write</a></li>
	            </ul>
            </c:if>
            <form class="d-flex" role="search" action = "/post/search">
               <input class="form-control me-2" type="search" placeholder="Search"
                  aria-label="Search" name = "keyword" value="${keyword}">
               <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
         </div>
      </div>
   </nav>