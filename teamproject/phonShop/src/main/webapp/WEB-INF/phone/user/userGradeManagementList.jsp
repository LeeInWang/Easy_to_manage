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
		margin-top: 200px;
		width: 80%;
		height: 80%;
		display: block;
	
		float: right;
	}
	



  
 
 .userGradeManagement_btn_update {
   
   width: 30%;
    display: inline;
    padding: 5 10px;
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
  .userGradeManagement_btn_update:hover {
    background-color: #ffffff;
    color: #5898d8;
  }
  
  
  .userGradeManagement_btn_delete {
    
    width: 30%;
    display: inline;
    padding: 5 10px;
    margin-top: 5px;
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
  
   .userGradeManagement_btn_delete:hover {
    background-color: #ffffff;
    color: #d85872;
  }
  
  
  .userGradeManagement_btn_insert {
    width: 30%;
    display: block;
    margin: 0 auto;
    padding: 5 10px;
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
   .userGradeManagement_btn_insert:hover {
    background-color: #ffffff;
    color: #d85872;
  } 
  
  
  .th2, .td2{
  	text-align: center;
  }
  

 .loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 120px;
  height: 120px;
  -webkit-animation: spin 2s linear infinite; /* Safari */
  animation: spin 2s linear infinite;
}

/* Safari */
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
  

#userGradeCountManagement_div_reset{
	display: flex;
}

#userGradeCountManagement_btn_reset{
margin-left: 10px;
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
	    displayLength: 10, 					// -셋트1(같이사용해야 기능이 사용됩니다.)
	 // 검색 기능 숨기기
    searching: false,
    // 페이징 기능 숨기기
    paging: false,
	    
	  
	  columnDefs: [
		  // 1번재 항목 열을 숨김
	        { targets: 0, width: 70 },
	    
	        // 2번째 항목의 넓이를 100px로 설정
	        { targets: 4, width: 100 }
	        
	    ]
  
  
 
	 
    
	   
  });
	
	
});


/* 삭제요청기능 */
function confirmValid(){
    // $('.form-control')[0].value or 
    // document.getElementById('identity').value or 
    // document.querySelector('#identity').value 등 다양한 방법으로 대체할 수도있음
    inputId = $('#identity').val();
    inputPwd =  $('password').val();
    
    if ( confirm('정말 삭제하시겠습니까?') == true) 
    	{
    	  return true;
    	}
    else{
    	  return false;
   		 }
    
    
 
}



  
</script>


</head>
<body>
	<header>
		 <jsp:include page="/WEB-INF/phone/header.jsp" flush="true"/>		
	</header>
<div class=".wrapper">

	<div class= "wrap">
	
		 <table id="example" class="table table-striped" style="width:90%">
		   <thead>
        <tr>
			<th class="th1" width="5%">No</th>
			<th class="th1" width="15%">등급명</th>
			
			<th class="th1" width="10%" >
			등급회원수	
			</th>
        	 <th class="th1" width="15%"><form action="userGradeCountUpdate.do6" method="post">
            <input type="hidden">
            <button class="userGradeManagement_btn_insert">리셋</button>
        	 </form></th>
			<th class="th1" width="17%">구매금액</th>
			<th class="th1" width="8%">할인율</th>
			<th class="th2" width="15%">
			
		
			<form action="userGradeInsertPage.do7" method="post">
            <input type="hidden">
            <button class="userGradeManagement_btn_insert">추가</button>
        	 </form>
     
         
      
			
			</th>
		</tr>
    </thead>
    <tbody>

		<c:forEach items="${userGradeList}" var="b" varStatus="i">
		<tr>
			<td class="td1">${i.count}</td>	<!--  index(0번부터시작) count(1번부터시작) -->
			<td class="td1">${b.getUserGradeName()}</td> <!--  등급명 -->
			<td class="td1">${b.getUserGradeCount()}</td> <!--  회원수 -->
			<td></td>
			<td class="td1">${b.getUserGradeTotalPurchaseAmount()}</td> <!--  평가조건 -->
			<td class="td1">${b.getUserGradeDiscountRate()}</td> <!--  혜택 -->
	
			<td class="td2">
			
			<form action="userGradeUpdate.do6" method="post">
            <input type="hidden" name="userGradeNumber" value="${b.getUserGradeNumber()}">
            <button class="userGradeManagement_btn_update">수정</button>
         </form>
   
		  <form action="userGradeDelete.do4?userGradeNumber" onsubmit="return confirmValid()">
             <input type="hidden" name="userGradeNumber" value="${b.getUserGradeNumber()}">
            <button class="userGradeManagement_btn_delete">삭제</button>
            </form>
    
			
			
			
		</tr>
		</c:forEach>
		
		</tbody>

</table>
		
		

	
	
	


	
	
	
	</div>
	<aside class="side">
	 <jsp:include page="useraside.jsp" flush="true"/>
	</aside>
</div>
	<footer>
		<jsp:include page="/WEB-INF/phone/footer.jsp" flush="true"/>
	</footer>

</body>
</html>