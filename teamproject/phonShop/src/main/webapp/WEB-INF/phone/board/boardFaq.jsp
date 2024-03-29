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
	.board_btn_update {
   
	width: 10%;
    display: inline;
    margin: 10 0px;
    padding: 5 10px;
    padding-top: 10px;
    margin-top: 10px;
    font-size: 20px;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border: 1px;
    border-radius: 5px;
    border-color: black;
    background-color: #92A8D1;
    color: white;
    transition: background-color 0.3s, color 0.3s, border-color 0.3s;
  }

  /* 버튼 호버 효과 */
  .board_btn_update:hover {
    background-color: #ffffff;
    color: #5898d8;
  }
  
  .board_btn_delete {
    
    width: 10%;
    display: inline;
    padding: 5 10px;
    padding-top: 10px;
    margin-top: 10px;
    font-size: 20px;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border: 1px black;
    border-radius: 5px;
    border-color: black;
    background-color: #F7CAC9;
    color: black;
    transition: background-color 0.3s, color 0.3s, border-color 0.3s;
  }

  /* 버튼 호버 효과 */
  .board_btn_delete:hover {
    background-color: #ffffff;
    color: #d85872;
  }
  
  
  .board_btn_insert {
    width: 10%;
    display: inline;
    padding: 5 10px;
    padding-top: 10px;
    margin-top: 10px;
    font-size: 20px;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border: 1px black;
    border-radius: 5px;
    border-color: black;
    background-color: #85AF4B;
    color: #E2E2E2;
    transition: background-color 0.3s, color 0.3s, border-color 0.3s;
  }

  /* 버튼 호버 효과 */
  .board_btn_insert:hover {
    background-color: #ffffff;
    color: #d85872;
  }

</style>
</head>
<body>
<div class="wrap">
	<header>
		 <jsp:include page="/WEB-INF/phone/header.jsp" flush="true"/>		
	</header>

	<div class="wrapper">
		<div class= "wrapfaq">
			<h2 class="faqh2">FAQ</h2>
			<br>
			<c:forEach items="${boardFaqList}" var="b" varStatus="i">
				<div class="faq-item">
					
					<div id="acodiv">
						<button class="accordion"><p>${b.getBoardFaqTitle()}</p></button>
						<div class="panel">
							<p>${b.getBoardFaqContent()}</p>
						</div>
					</div>
					<div id="checdiv">
						<input type="checkbox" id="boardFaqcheck${i.index}" name="boardFaqcheck" value="${b.getBoardFaqNumber()}"/>	
						<label for="boardFaqcheck${i.index}"></label>
					</div>
				</div>
			</c:forEach>
				<form action="boardFaqInsert.do7" method="post">
	         		<input type="hidden" name="boardFaqNumber">
	         		<button class="board_btn_insert">FAQ 추가</button>
        		 </form>
				<form id="updateForm" action="boardFaqUpdate.do2" method="post">
				    <!-- 수정 버튼 클릭 시 선택된 checkbox의 값이 추가될 hidden input -->
				    <!-- 선택된 checkbox의 값이 여기에 추가됩니다. -->
				    <button type="button" class="board_btn_update" onclick="getCheckedItemValueForUpdate();">FAQ 수정</button>
				</form>
		         <form id="deleteForm" action="boardFaqDelete.do4" method="post">
   				 	<button type="button" class="board_btn_delete" onclick="deleteCheckedItems();">FAQ 삭제</button>
				 </form>
		         <script src="${pageContext.request.contextPath}/js/faq.js"></script>
		</div>

		


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