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
      <h2>공지사항 작성</h2>
      <form action="boardInsert.do5" method="post">
      <div class="form-group">
      <label for="boardCategory">공지사항</label>
      <select id="boardCategory" name="boardCategory" required>
        <option value="공지사항" >공지사항</option>
      </select>
    </div>
        <div class="form-group">
          <input type="text" id="boardTitle" name="boardTitle" placeholder="제목" required>
        </div>
        <div class="form-group">
          <textarea id="boardContent" name="boardContent" placeholder="내용"></textarea>
        </div>
        <div class="form-group">
            <input type="file" name="boardImage">
        </div>
        <div class="form-group">
            <label for="boardDate">작성일</label>
            <input type="date" id="boardDate" name="boardDate" readonly>
          </div>
        <div class="form-group">
          <input type="submit" name="boardInput" value="게시글 등록">
          <input type="button" name="boardExit" value="취소"  onclick = "location.href= 'getBorder.do3'">
        </div>
        </form>
        </div>
	<footer>
		<jsp:include page="/WEB-INF/phone/footer.jsp" flush="true"/>
	</footer>
	</div>
</body>
</html>