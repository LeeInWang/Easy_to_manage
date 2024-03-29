<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/faq.css?ver=1"/>
<title>FAQ</title>
<style>
	.wrapper{
		width: 100%;
	  	height: 100vh;
	  	
	}


</style>
</head>
<body>
<div class="wrap">
	<header>
		 <jsp:include page="/WEB-INF/phone/header.jsp" flush="true"/>		
	</header>
<form>
	<div class=".wrapper">
		
		<div class= "wrapfaq">
			<h2 class="faqh2">FAQ</h2>
			
			<div id="acodiv">
				<button class="accordion">질문 1</button>
				<div class="panel">
					<p>답변 1.</p>
				</div>
			
				<button class="accordion">질문 2</button>		
				<div class="panel">
					<p>답변 2.</p>
				</div>
			
				<button class="accordion">질문 3</button>
				<div class="panel">
					<p>답변 3.</p>
				</div>
			</div>			
			
		
			<div id="checdiv">
				<input type="checkbox" checked id="check1" name="check1" checked />	
				<label for="check1"></label>
				<br>
				<input type="checkbox" checked id="check2" name="check2" checked />	
				<label for="check2"></label>
				<br>
				<input type="checkbox" checked id="check3" name="check3" checked />	
				<label for="check3"></label>
			</div>
		</div>
</form>
<script src="${pageContext.request.contextPath}/js/faq.js"></script>
	
	<aside class="side">
	 <jsp:include page="/WEB-INF/phone/board/boardaside.jsp" flush="true"/>
	</aside>
</div>
</div>
	<footer>
		<jsp:include page="/WEB-INF/phone/footer.jsp" flush="true"/>
	</footer>
</body>
</html>