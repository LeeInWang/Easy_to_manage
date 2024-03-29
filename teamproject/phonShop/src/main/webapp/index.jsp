<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/css/basic.css" rel="stylesheet"/>
</head>
<body>

	<div class="login-box">
        <h2>Login</h2>  
        <form action="login.do" method="post">
          <div class="user-box">
            <input type="text" name="id" >
            <label>Username</label>
          </div>
          <div class="user-box">
            <input type="password" name="password">
            <label>Password</label>
          </div>
       		<input type="submit" name="btn" value="로그인" > 
        </form>
      </div>
      
</body>
</html>