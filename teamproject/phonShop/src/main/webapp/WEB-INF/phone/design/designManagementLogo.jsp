<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.wrapper{
		width: 100%;
	  	height: 100vh;
	  	
	}

	.wrap{
		margin-top: 100px;
		width: 80%;
		height: 80%;
		display: block;
		background-color: aliceblue;
		float: right;
	}
	
	.footerwrap{
		width: 100%;
		height: 100px;
		position : fixed;
		bottom : 0;
		background-color: pink;
		float: left;
  }
</style>
</head>
<body>
	<header>
		 <jsp:include page="/WEB-INF/phone/header.jsp" flush="true"/>		
	</header>
<div class=".wrapper">
	<div class= "wrap">
		<h1>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc,</h1>
		<h1>asd</h1>
	</div>
	<aside class="side">
	 <jsp:include page="/WEB-INF/phone/design/designaside.jsp" flush="true"/>
	</aside>
</div>
	<footer>
		<div class="/WEB-INF/phone/footerwrap"> 푸터부분</div>
	</footer>

</body>
</html>