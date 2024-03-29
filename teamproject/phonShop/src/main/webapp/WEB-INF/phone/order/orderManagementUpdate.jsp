<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/css/insert.css" rel="stylesheet"/> 
<link href="${pageContext.request.contextPath}/css/baisc.css" rel="stylesheet"/> 
<!DOCTYPE html>
<html>
<head>
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
	 <jsp:include page="/WEB-INF/phone/order/orderaside.jsp" flush="true"/>
	</aside>
	</article>
	</div>
	
<div class="container">
  <h2>회원 주문</h2>
  <form action="orderUpdate.do6" method="post">
    <div class="form-group">
      <label for="orderId">주문번호:</label>
      <input type="text" id="orderId" name="orderId" value="${order.getOrderId()}" required>
    </div>
    <div class="form-group">
      <label for="orderProductName">주문상품명:</label>
      <input type="text" id="orderProductName" name="orderProductName" value="${order.getOrderProductName()}" required>
    </div>
    <div class="form-group">
      <label for="orderProductCount">수량:</label>
      <input type="number" id="orderProductCount" name="orderProductCount" value="${order.getOrderProductCount()}" required>
    </div>
    <div class="form-group">
      <label for="orderProductPrice">상품금액:</label>
      <input type="number" id="orderProductPrice" name="orderProductPrice" value="${order.getOrderProductPrice()}" required>
    </div>
    <div class="form-group">
      <label for="orderDeliveryCost">배송비:</label>
      <input type="number" id="orderDeliveryCost" name="orderDeliveryCost" value="${order.getOrderDeliveryCost()}" required>
    </div>
    <div class="form-group">
      <label for="orderTotalAmount">총주문액:</label>
      <input type="number" id="orderTotalAmount" name="orderTotalAmount" value="${order.getOrderTotalAmount()}" required>
    </div>
    <div class="form-group">
      <label for="orderDate">주문일시:</label>
      <input type="datetime-local" id="orderDate" name="orderDate" value="${order.getOrderDate()}" required>
    </div>
    <div class="form-group">
      <label for="orderUserName">주문자:</label>
      <input type="text" id="orderUserName" name="orderUserName" value="${order.getOrderUserName()}" required>
    </div>
    <div class="form-group">
      <label for="orderRecipientName">수령자:</label>
      <input type="text" id="orderRecipientName" name="orderRecipientName" value="${order.getOrderRecipientName()}" required>
    </div>
    <div class="form-group">
      <label for="orderPaymentType">결재방법:</label>
      <select id="orderPaymentType" name="orderPaymentType" required>
        <option value="신용카드" <c:if test="${order.getOrderPaymentType() eq '신용카드'}">selected</c:if>>신용카드</option>
        <option value="무통장입금" <c:if test="${order.getOrderPaymentType() eq '무통장입금'}">selected</c:if>>무통장입금</option>
        <!-- 기타 결제 방법 추가 -->
      </select>
    </div>
    <div class="form-group">
      <label for="orderPhoneNumber">핸드폰:</label>
      <input type="tel" id="orderPhoneNumber" name="orderPhoneNumber" value="${order.getOrderPhoneNumber()}" required placeholder="-을 제외하고 입력">
    </div>
    <div class="form-group">
      <label for="orderTrackingNumber">운송장번호:</label>
      <input type="text" id="orderTrackingNumber" name="orderTrackingNumber" value="${order.getOrderTrackingNumber()}" required>
    </div>
    <div class="form-group">
      <label for="orderDeliveryCompanyName">배송회사:</label>
      <input type="text" id="orderDeliveryCompanyName" name="orderDeliveryCompanyName" value="${order.getOrderDeliveryCompanyName()}" required>
    </div>
    <div class="form-group">
      <label for="orderRecipientAddress">받는사람주소:</label>
      <textarea id="orderRecipientAddress" name="orderRecipientAddress" required>${order.getOrderRecipientAddress()}</textarea>
    </div>
    <div class="form-group">
      <label for="orderDeliveryRequest">배송시요청사항:</label>
      <textarea id="orderDeliveryRequest" name="orderDeliveryRequest" >${order.getOrderDeliveryRequest()}</textarea>
    </div>
    <div class="form-group">
    
      <label for="orderDelivery">배송상태:</label>
      <select id="orderDelivery" name="orderDelivery"required>
        <option value="배송대기" <c:if test="${order.getOrderDelivery() eq '배송대기'}">selected</c:if>>배송대기</option>
    	<option value="배송중" <c:if test="${order.getOrderDelivery() eq '배송중'}">selected</c:if>>배송중</option>
   		<option value="배송완료" <c:if test="${order.getOrderDelivery() eq '배송완료'}">selected</c:if>>배송완료</option>
        <!-- 기타 배송 상태 추가 -->
      </select>
      
     
     
    </div>
    <div class="form-group">
      <input type="submit" value="주문 확인">
      
      <input type="button" name="boardExit" value="취소" onclick = "location.href= 'getOrder.do3">
    </div>
  </form>
  </div>
 



	<footer>
		<jsp:include page="/WEB-INF/phone/footer.jsp" flush="true"/>		
	</footer>
	</div>
</body>
</html>