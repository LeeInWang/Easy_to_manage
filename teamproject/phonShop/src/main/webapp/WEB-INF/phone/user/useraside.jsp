<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
	<link href="${pageContext.request.contextPath}/css/sidebar2.css" rel="stylesheet"/>
	
	
	
</head>
<body>
<div class="wrapside">
	<nav class="sidebar">
         <div class="text">
          
         <ul id="sideul">
            <li class="active">
            
            <form action="home.do">
            <input type="submit" id="hiddenSubmit" style="display:none;">
			<a href="javascript:document.querySelector('#hiddenSubmit').click();">회원정보관리</a>
            </form>
            
            </li>
            
            <li class="serv-btn">
             <form action="getUserGrade.do3">
            <input type="submit" id="hiddenSubmit2" style="display:none;">
			<a href="javascript:document.querySelector('#hiddenSubmit2').click();">회원등급</a>
            </form>
        	<span class="fas fa-caret-down second"></span></li>    
            
            
		
		
         </ul>
      </nav>
</div>
      <script src="${pageContext.request.contextPath}/js/sidebar2.js"></script>
</body>
</html>