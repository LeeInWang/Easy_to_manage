<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>상품 목록</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="footer.css">
<script src="https://cdn.datatables.net/2.0.2/js/dataTables.js"></script>
<script
	src="https://cdn.datatables.net/2.0.2/js/dataTables.bootstrap5.js"></script>

<style>
.wrap {
	margin-top: 100px;
	width: 80%;
	height: 80%;
	display: block;
	float: right;
	justify-content: space-between;
	padding-left: 0px;
}

/*NO~상품등록 전체박스*/
#example_wrapper {
	display: inline-block;
	width: 100%;
	justify-content: space-around;
}

/*상품등록 버튼*/
#prdInsert {
	width: 55%;
	display: block;
	margin: auto;
	padding: 0;
	font-size: 16px;
	font-weight: bold;
	text-align: center;
	text-decoration: none;
	cursor: pointer;
	border: 1px black;
	border-radius: 5px;
	border-color: black;
	background-color: #85AF4B;
	color: #E2E2E2;
	transition: background-color 0.3s, color 0.3s, border-color 0.3s;
	font-size: 16px;
}

#prdInsert:hover {
	board_btn_insert: hover background-color: #ffffff;
	color: #d85872;
}

/*수정버튼*/
.user_btn_update {
	width: 30%;
	display: inline-block;
	padding: 5 10px;
	font-size: 15px;
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

.user_btn_update:hover {
	background-color: #ffffff;
	color: #5898d8;
}

/*삭제버튼*/
.user_btn_delete {
	width: 30%;
	display: inline-block;
	padding: 5 10px;
	margin-top: 5px;
	font-size: 15px;
	text-decoration: none;
	cursor: pointer;
	border: 1px black;
	border-radius: 5px;
	border-color: black;
	background-color: #F7CAC9;
	color: black;
	transition: background-color 0.3s, color 0.3s, border-color 0.3s;
}

.user_btn_delete:hover {
	background-color: #ffffff;
	color: #d85872;
}

.td1, .th2, .td2 {
	justify-content: space-between;
	text-align: center;
	vertical-align: middle;
	font-size: 15px;
}

.td1 {
	padding: 0;
}

#example, .col-12 {
	width: auto;
}

.title-column {
	width: auto; /* 각 열의 너비를 자동으로 조정합니다. */
}
</style>

<script>
	document.addEventListener('DOMContentLoaded', function() {

		new DataTable('#example', {
			// 표시 건수기능 숨기기
			lengthChange : false,
			// 정보 표시 숨기기
			info : false,
			lengthMenu : [ 10, 20, 30, 40, 50 ], // -셋트1(같이사용해야 기능이 사용됩니다.)
			// 기본 표시 건수를 20건으로 설정
			displayLength : 10, // -셋트1(같이사용해야 기능이 사용됩니다.)
			// 검색 기능 숨기기

			columnDefs : [
			// 1번재 항목 열을 숨김
			{
				targets : 0,
				width : 70
			},

			// 2번째 항목의 넓이를 100px로 설정
			{
				targets : 4,
				width : 100
			} ]

		});

	});
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/phone/header.jsp" flush="true" />
	</header>
	<div class="wrap">
		<table id="example" class="table table-striped" style="width: 100%">
			<thead>
				<tr>
					<!-- 	<th class="th1 title-column" style="padding-left: 7px; width: 5%; font-weight: bold; font-size: 15px;">No</th>
					<th class="th1 title-column" style="width: 10%; font-weight: bold; font-size: 15px;">상품코드</th>
					<th class="th1 title-column" style="width: 13%; font-weight: bold; font-size: 15px;">원가</th>
					<th class="th1 title-column" style="width: 13%; font-weight: bold; font-size: 15px;">판매가</th>
					<th class="th1 title-column" style="width: 10%; font-weight: bold; font-size: 15px;">재고수량</th>
					<th class="th1 title-column" style="width: 15%; font-weight: bold; font-size: 15px;">상품명</th>
					<th class="th1 title-column" style="width: 10%; font-weight: bold; font-size: 15px;">전시상태</th>
					<th class="th1 title-column" style="width: 10%; font-weight: bold; font-size: 15px;">결제방식</th>
					<th class="th2 title-column" style="width: 15%; font-weight: bold; font-size: 13px;">메인카테고리</th>
					<th class="th2 title-column" style="width: 15%; font-weight: bold; font-size: 13px;">서브카테고리</th>
					<th class="th2 title-column">
    				<input type="button" name="boardExit" value="상품등록" id="prdInsert" style="width: 15%;"
    				onclick="location.href='${pageContext.request.contextPath}/phone/product/productManagementInsert.jsp';">
					</th>-->



					<th class="th1" style="width: 5%;">No</th>
					<th class="th1" style="width: 10%;">　상품코드</th>
					<th class="th1" style="width: 5%; font-size: 1 rem;">　원가</th>
					<th class="th1" style="width: 8%; font-size: 0.6 rem;">　판매가</th>
					<th class="th1" style="width: 5%; font-size: 1 rem;">재고수량</th>
					<th class="th1" style="width: 15%;">　　　상 품 명</th>
					<th class="th1" style="width: 10%;">　전시상태</th>
					<th class="th1" style="width: 10%;">　결제방식</th>
					<th class="th1" style="width: 10%;">메인카테고리</th>
					<th class="th1" style="width: 10%;">서브카테고리</th>
					<th class="th1 title-column" style="width: 20%;">
						<form action="productInsert.do7" method="post">
							<input type="hidden" name="boardExit">
							<button class="board_btn_insert" id="prdInsert">상품등록</button>
						</form>
					</th>

				</tr>
			</thead>
			<div class="product-table">
				<tbody>
					<!-- getOrder.do3에서 설정한 orderList를 가지고 와서 셋팅하고 별명을 o로 설정한다. -->
					<c:forEach items="${productList}" var="o" varStatus="i">
						<tr>
							<td class="td1">${i.count}</td>
							<td class="td1"><a
								href="SelectProduct.do2?productCode=${o.getProductCode()}">${o.getProductCode()}</a></td>
							<td class="td1">${o.getProductOriginalPrice()}</td>
							<td class="td1">${o.getProductSalePrice()}</td>
							<td class="td1">${o.getProductInventoryQuantity()}</td>
							<td class="td1">${o.getProductName()}</td>
							<td class="td1">${o.getProductDisplayStatus()}</td>
							<td class="td1">${o.getProductPaymentType()}</td>
							<td class="td1">${o.getMainCategory()}</td>
							<td class="td1">${o.getSubCategory()}</td>

							<td class="td2">
								<form action="SelectUpdate.do2" method="post">
									<input type="hidden" name="productCode"
										value="${o.getProductCode()}">
									<button class="user_btn_update">수정</button>
								</form>
								<form action="productDelete.do4" method="post">
									<input type="hidden" name="productCode"
										value="${o.getProductCode()}">
									<button class="user_btn_delete">삭제</button>
								</form>
							</td>

							<!-- <td class="td2">
							<form action="SelectUpdate.do2" method="post">
								<input type="hidden" name="productCode"
									value="${o.getProductCode()}">
								<button class="user_btn_update">수정</button>
							</form>
							<br>
							<form action="productDelete.do4" method="post">
								<input type="hidden" name="productCode"
									value="${o.getProductCode()}">
								<button class="user_btn_delete">삭제</button>
							</form>
						</td>  -->


						</tr>
					</c:forEach>

				</tbody>
			</div>
		</table>
	</div>
	<aside class="side">
		<jsp:include page="productaside.jsp" flush="true" />
	</aside>
	<footer>
		<jsp:include page="/WEB-INF/phone/footer.jsp" flush="true" />
	</footer>
</body>
</html>