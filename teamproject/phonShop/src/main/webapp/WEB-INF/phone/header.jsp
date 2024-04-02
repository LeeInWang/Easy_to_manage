<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css?ver=1"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>할머니 할아버지도 쉽게하는 관리자 페이지</title>
</head>
<body>
<div id = "wrapheader">
    <nav class="fixed-nav-bar">
    <div id='cssmenu'>
      <ul id="headerul">
        <li><a href="home.do"><span>회원관리</span></a></li>
         <li><a href="getProductList.do3"><span>상품관리</span></a></li>
         <li><a href="getOrder.do3"><span>주문관리</span></a></li>
         <!--   <li><a href="${pageContext.request.contextPath}/WEB-INF/phone/statistics/statistics1.jsp"><span>통계관리</span></a></li> --> 
         <li><a href="getBoard.do3"><span>게시판관리</span></a></li>
		<!--  <li><a href="/WEB-INF/phone/design/designManagement.jsp"><span>디자인관리</span></a></li>-->
		
   		<div id='cssmenu2'>
        <li><a href='#' id="icon1"><i class="material-icons">home</i>HOME</a></li>
        <li><a href='#' id="icon2"><i class="material-icons">account_circle</i>Admin님 접속 성공</a></li>
        <li id="logout"><a href='#'><span>로그아웃</span></a></li>
        </div>
    </ul>
</div>



</nav>
</div>
</body>
</html>