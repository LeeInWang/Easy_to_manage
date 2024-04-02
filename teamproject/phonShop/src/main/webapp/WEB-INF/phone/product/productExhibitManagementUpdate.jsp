<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/footer.css?ver=1" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/productinsert.css?ver=1" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<header>
			<jsp:include page="header.jsp" flush="true" />
		</header>
		<aside class="side">
			<jsp:include page="productaside.jsp" flush="true" />
		</aside>
		<div class="wrapper">
			<article>
		</div>
		<aside class="side">
			<jsp:include page="productaside.jsp" flush="true" />
		</aside>
		</article>
		<article>
			<div class="container">
				<h2>상품 조회</h2>
				<form>
					<div class="form-group">
						<label for="productDisplayStatus">노출숨김:</label> <select
							id="productDisplayStatus" name="productDisplayStatus" required>
							<option value="productDisplayStatus1">노출</option>
							<option value="productDisplayStatus2">숨김</option>
							<!-- 기타 결제 방법 추가 -->
						</select>
					</div>
					<div class="form-group">
						<label for="productCode">상품코드:</label> <input type="text"
							id="productCode" name="productCode" required>
					</div>
					<div class="form-group">
						<label for="productName">상품명:</label> <input type="text"
							id="productName" name="productName" required>
					</div>
					<div class="form-group">
						<label for="productRegistrationDate">등록일:</label> <input
							type="datetime-local" id="productRegistrationDate"
							name="productRegistrationDate" required>
					</div>
					<div class="form-group">
						<label for="productCostPrice">가격:</label> <input type="number"
							id="productCostPrice" name="productCostPrice" required>
					</div>
					<div class="form-group">
						<label for="productSalePrice">할인가격:</label> <input type="number"
							id="productSalePrice" name="productSalePrice" required>
					</div>
					<div class="form-group">
						<label for="productInventoryQuantity">재고량:</label> <input
							type="number" id="productInventoryQuantity"
							name="productInventoryQuantity" required>
					</div>
					<div class="form-group">
						<label for="mainCagegory">1차 카테고리:</label> <select
							id="mainCagegory" name="mainCagegory" required>
							<option value="creditCard">신용카드</option>
							<option value="bankTransfer">무통장입금</option>
							<!-- 기타 결제 방법 추가 -->
						</select>
					</div>
					<div class="form-group">
						<label for="subCagegory">2차 카테고리:</label> <select id="subCagegory"
							name="subCagegory" required>
							<option value="creditCard">신용카드</option>
							<option value="bankTransfer">무통장입금</option>
							<!-- 기타 결제 방법 추가 -->
						</select>
					</div>
					<div class="form-group">
						<label for="productDiscountStatus">할인중상태:</label> <input
							type="number" id="productDiscountStatus"
							name="productDiscountStatus" required>
					</div>
					<div class="form-group">
						<label for="productContent">게시글내용:</label>
						<textarea id="productContent" name="productContent"></textarea>
					</div>
					<div class="form-group">
						<label for="productImage">이미지:</label> <input type="file"
							id="productImage" name="productImage"> <input
							type="submit" value="파일 올리기">
					</div>
					<div class="form-group">
						<label for="productHashtags">해시태그:</label> <input type="text"
							id="productHashtags" name="productHashtags">
					</div>
					<div class="form-group">
						<label for="productBest">추천상품여부:</label> <input type="number"
							id="productBest" name="productBest" required>
					</div>
				</form>
		</article>
	</div>


	<hr>
	<div class="footerwrap">
		<hr>
		ⓒ누구나 사용하기 쉽조
	</div>
</body>
</html>