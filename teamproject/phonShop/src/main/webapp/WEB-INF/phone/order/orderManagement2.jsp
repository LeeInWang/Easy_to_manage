<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://cdn.datatables.net/2.0.2/js/dataTables.js"></script>
<script src="https://cdn.datatables.net/2.0.2/js/dataTables.bootstrap5.js"></script>
<style>
   .wrap{
      margin-top: 150px;
      width: 80%;
      height: 80%;
      display: block;
      float: right;
   }

.user_btn_update {
   

    display: inline-block;
    padding: 5 10px;
    font-size: 10px;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border: 0.1px #f8f9fa;
    border-radius: 5px;
    background-color: #f8f9fa;
    color: #c5c1c1;
    transition: background-color 0.3s, color 0.3s, border-color 0.3s;
  }

  /* 버튼 호버 효과 */
  .user_btn_update:hover {
    background-color: #ffffff;
    color: #5898d8;
  }
  
  .user_btn_delete {
     margin-left:10px;
     
    display: inline-block;
    padding: 5 10px;
    font-size: 10px;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border: 0.1px #f8f9fa;
    border-radius: 5px;
    background-color: #f8f9fa;
    color: #c5c1c1;
    transition: background-color 0.3s, color 0.3s, border-color 0.3s;
  }

  /* 버튼 호버 효과 */
  .user_btn_delete:hover {
    background-color: #ffffff;
    color: #d85872;
  }
  
  .th2, .td2{
     text-align: center;
  }

</style>

<script>
document.addEventListener('DOMContentLoaded', function(){

  new DataTable('#example',{
   // 표시 건수기능 숨기기
     lengthChange: false,
   // 정보 표시 숨기기
       info: false,
       lengthMenu: [ 10, 20, 30, 40, 50 ], // -셋트1(같이사용해야 기능이 사용됩니다.)
    // 기본 표시 건수를 20건으로 설정
       displayLength: 10,                // -셋트1(같이사용해야 기능이 사용됩니다.)
       
    // 검색 기능 숨기기
    
       
     
     columnDefs: [
        // 1번재 항목 열을 숨김
           { targets: 0, width: 70 },
       
           // 2번째 항목의 넓이를 100px로 설정
           { targets: 4, width: 100 }
           
       ]
    
  });

});

</script>


</head>
<body>
   <header>
       <jsp:include page="/WEB-INF/phone/header.jsp" flush="true"/>      
   </header>
<div class=".wrapper">
   <div class= "wrap">
   
   <form action="getOrderdel2.do3" method="post">
       <table id="example" class="table table-striped" style="width:100%">
         <thead>
        <tr>
         <th class="th1" >No</th>
         <th class="th1" >운송장번호</th>
         <th class="th1" >주문자</th>
         <th class="th1" >주문상품명</th>
         <th class="th1" >배송상태</th>
         <th class="th1" >주문일</th>
         
      </tr>
    </thead>
    <tbody>

      <c:forEach items="${orderList}" var="b" varStatus="i">
      <tr>
         <td class="td1">${i.count}</td>
         <td class="td1"><a href="orderUpdateInput.do2?orderId=${b.getOrderId()}">${b.getOrderTrackingNumber()}</a></td>
         <td class="td1">${b.getOrderUserName()}</td>
         <td class="td1">${b.getOrderProductName()}</td>
         <td class="td1">${b.getOrderDelivery()}</td>
         <td class="td1">${b.getOrderDate()}</td>
         
         
            
      </tr>
      </c:forEach>
      </tbody>
</table> 
</form>
   </div>
   <aside class="side">
    <jsp:include page="/WEB-INF/phone/order/orderaside.jsp" flush="true"/>
   </aside>
</div>
   <footer>
      <jsp:include page="/WEB-INF/phone/footer.jsp" flush="true"/>
   </footer>

</body>
</html>