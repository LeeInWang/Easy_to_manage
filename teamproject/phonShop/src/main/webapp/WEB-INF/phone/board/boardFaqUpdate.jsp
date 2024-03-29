<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>공지사항 입력</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/insert.css?ver=1"/>
<link href="${pageContext.request.contextPath}/css/baisc.css?after" type="text/css"/> 
<style>
	.wrapper{
		width: 100%;
		display: flex;	  	
	}

</style>
</head>
<body>
<div class="wrap">
        <header>
             <jsp:include page="/WEB-INF/phone/header.jsp" flush="true"/>		
        </header>
    
    <div class="wrapper">
        <article>
       
        <aside class="side">
         <jsp:include page="/WEB-INF/phone/board/boardaside.jsp" flush="true"/>
        </aside>
        </article>
        
     </div>
    <div class="container">
    <h2>Faq 수정</h2>
    <form action="boardFaqUpdate.do6" method="post">
        <div class="form-group">
            <input type="hidden" id="boardFaqNumber" name="boardFaqNumber" value="${board.getBoardFaqNumber()}" placeholder="순서" required>
        </div>   
        <div class="form-group">
            <input type="text" id="boardFaqTitle" name="boardFaqTitle" value="${board.getBoardFaqTitle()}" placeholder="제목" required>
        </div>
        <div class="form-group">
            <textarea id="boardFaqContent" name="boardFaqContent" placeholder="내용" required>${board.getBoardFaqContent()}</textarea>
        </div>
        <div class="form-group">
            <input type="submit" name="boardFaqInput" value="수정">
            <input type="button" name="boardFaqExit" value="취소" onclick="location.href='getBorderFaq.do3'">
        </div>
    </form>
</div>
	<footer>
		<jsp:include page="/WEB-INF/phone/footer.jsp" flush="true"/>
	</footer>
	</div>
</body>
</html>