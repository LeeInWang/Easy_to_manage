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
            상품관리
         </div>
         <ul id="sideul">
            <li class="active">
            <form action="getproductManagement.do3">
                  <input type="submit" id="hiddenSubmit" style="display:none;">
                  <a href="javascript:document.querySelector('#hiddenSubmit').click();">전체상품관리</a></li>
               </form>
            
            <!-- 
			<li class="serv-btn"><a href="./productManagementList.jsp">상품관리</a></li>
			<li class="serv-btn"><a href="./productManagementList.jsp">상품진열관리</a></li>
			<li class="serv-btn"><a href="./productManagementList.jsp">퀵메뉴관리</a></li>
			<li class="serv-btn"><a href="./productManagementList.jsp">상품리뷰관리</a></li>
			 -->
			
         </ul>
      </nav>
</div>
      <script src="${pageContext.request.contextPath}/js/sidebar2.js"></script>
</body>
</html>