<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <title>charts</title>
</head>

	



<body>
<div class=".wrapper">
	<div class= "wrap">


	

	<header>
		 <jsp:include page="/WEB-INF/phone/header.jsp" flush="true"/>		
	</header>


    <div class="container">
        <div class="chart">
                <canvas id="myChart" width="300" height="300"></canvas>
        </div>
        <div class="chart2">
                <canvas id="myChart2" width="300" height="300"></canvas>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="${pageContext.request.contextPath}/js/chart1.js"></script>
    <script src="${pageContext.request.contextPath}/js/chart2.js"></script>
    	</div>

 	
    	
    	
    	
	
	<aside class="side">
	 <jsp:include page="Statiisticsaside.jsp" flush="true"/>
	</aside>
</div>
	<footer>
		<jsp:include page="/WEB-INF/phone/footer.jsp" flush="true"/>	
	</footer>

</body>
</html>