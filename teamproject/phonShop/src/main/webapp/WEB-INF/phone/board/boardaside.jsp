<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sidebar</title>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
	<link href="${pageContext.request.contextPath}/css/sidebar2.css" rel="stylesheet"/>
	
</head>
<body>
<div class="wrapside">
	<nav class="sidebar">
         <div class="text">
            게시판관리
         </div>
         <ul id="sideul">
            <li class="active">
            	<form action="getBoard.do3">
	            <input type="submit" id="hiddenSubmit1" style="display:none;">
	             <a href="javascript:document.querySelector('#hiddenSubmit1').click();">공지사항</a></li>
				</form> 
			</li>
			
			<li>
			<form action="getBoardFaq.do3">
		        <input type="submit" id="hiddenSubmit2" style="display:none;">
				<a href="javascript:document.querySelector('#hiddenSubmit2').click();">Faq</a></li>
			</form> 
         </ul>
      </nav>
</div>
      <script src="${pageContext.request.contextPath}/js/sidebar2.js"></script>

</body>
</html>