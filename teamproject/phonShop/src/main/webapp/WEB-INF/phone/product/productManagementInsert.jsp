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
<title>상품 등록</title>
</head>
<body>
	<div class="wrap">
		<header>
			<jsp:include page="/WEB-INF/phone/header.jsp" flush="true" />
		</header>
		<aside class="side">
			<jsp:include page="productaside.jsp" flush="true" />
		</aside>
		<div class="wrapper">
			<article>
		</div>
		</article>
		<article>
			<div class="container">
				<h2>상품 등록</h2>
				<form action="getproductInsert.do5" method="post"> 
					<div class="form-group">
						<label for="productDisplayStatus">노출숨김:</label> <select
							id="productDisplayStatus" name="productDisplayStatus" required>
							<option value="노출">노출</option>
							<option value="숨김">숨김</option>
							<!-- 기타 결제 방법 추가 -->
						</select>
					</div>
					<div class="form-group">
						<label for="productCode">상품코드:</label> <input type="text"
							id="productCode" name="productCode" required>
					</div>
					<div class="form-group">
						<label for="productDiscountStatus">할인중상태:</label> <input
							type="number" id="productDiscountStatus"
							name="productDiscountStatus" required>
					</div>
					<div class="form-group">
						<label for="productSaleCount">판매량:</label> <input type="number"
							id="productSaleCount" name="productSaleCount" required>
					</div>
					<div class="form-group">
						<label for="productName">상품명:</label> <input type="text"
							id="productName" name="productName" required>
					</div>
					<div class="form-group">
						<label for="productRegistrationDate">등록일:</label> <input
							type="datetime-local" id="productRegistrationDate"
							name="productRegistrationDate" required readonly>
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
						<label for="productPaymentType">결제방식:</label> <select
							id="productPaymentType" name="productPaymentType" required>
							<option value="신용카드">신용카드</option>
							<option value="무통장">무통장</option>
							<!-- 기타 결제 방법 추가 -->
						</select>
					</div>
					<div class="form-group">
						<label for="productOriginalPrice">원가:</label> <input type="number"
							id="productOriginalPrice" name="productOriginalPrice" required>
					</div>
					<div class="form-group">
						<label for="productInventoryQuantity">재고수량:</label> <input
							type="number" id="productInventoryQuantity"
							name="productInventoryQuantity" required>
					</div>
					<div class="form-group">
						<label for="mainCategory">1차 카테고리:</label> <select
							id="mainCategory" name="mainCategory" required>
							<option value="젤리">젤리</option>
							<option value="하드">하드</option>
							<option value="z-플립">z-플립</option>
							<!-- 기타 결제 방법 추가 -->
						</select>
					</div>
					<div class="form-group">
						<label for="subCategory">2차 카테고리:</label> <select id="subCategory"
							name="subCategory" required>
							<option value="기본">기본</option>
							<option value="패턴">패턴</option>
							<option value="가죽">가죽</option>
						</select>
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
					<div class="form-group">
						<input type="submit" value="상품 등록"> 
						<input type="button"name="boardExit" value="취소" onclick="location.href='getProductList.do3'">
					</div>
				<!-- 		<div class="form-group">
    <input type="submit" value="상품 등록"> 
    <input type="button" name="boardExit" value="취소" onclick="getproductManagement.do3">
</div>-->
				</form>
		</article>
	</div>


	<hr>
	<div class="footerwrap">
		<jsp:include page="/WEB-INF/phone/footer.jsp" flush="true" />
	</div>
</body>
</html>