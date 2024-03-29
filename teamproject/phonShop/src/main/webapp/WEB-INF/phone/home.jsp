<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> home</h1>
	
	<form action="home.do" method="post">
		<div class="search">
			<select name="searchCondition">
				<option value="TITLE">제목</option>
				<option value="CONTENT">내용</option>
			</select> <input name="searchKeyword" type="text" />
			 <input type="submit" value="검색" class="sub" />
		</div>
	</form>
	
</body>
</html>