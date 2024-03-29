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
		margin-top: 100px;
		width: 85%;
		height: 80%;
		display: block;
	
		float: right;
	}
	
	  .th2, .td2{
  	text-align: center;
  }

  
 
 .userManagement_btn_update {
   
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
  .userManagement_btn_update:hover {
    background-color: #ffffff;
    color: #5898d8;
  }
  
  
  .userManagement_btn_delete {
    
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
  
   .userManagement_btn_delete:hover {
    background-color: #ffffff;
    color: #d85872;
  }
  
  
  .userManagement_btn_insert {
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
   .userManagement_btn_insert:hover {
    background-color: #ffffff;
    color: #d85872;
  } 
  

  

  
</style>


<script>
document.addEventListener('DOMContentLoaded', function(){

  new DataTable('#example',{
	// 표시 건수기능 숨기기
	  lengthChange: false,
	// 정보 표시 숨기기
	    info: false,
	    lengthMenu: [5,10, 20, 30, 40, 50 ], // -셋트1(같이사용해야 기능이 사용됩니다.)
	 // 기본 표시 건수를 20건으로 설정
	    displayLength: 5, 					// -셋트1(같이사용해야 기능이 사용됩니다.)
	  
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
	
       
          


				<!-- 테이블 -->  
		 <table id="example" class="table table-striped" style="width:100%">
		   <thead>
        <tr>
			<th class="th1" width="5%">No</th>
			<th class="th1" width="10%">아이디</th>
			<th class="th1" width="7%">이름</th>
			<th class="th1" width="15%">이메일</th>
			<th class="th1" width="15%">핸드폰</th>
			<th class="th1" width="19%">가입일</th>
			<th class="th1" width="14%">최근접속일</th>
			<th class="th2" width="15%">
			
		 <form action="userInsertPage.do7" method="post">
            <input type="hidden">
            <button class="userManagement_btn_insert">추가</button>
         </form>
			
			</th>
			
		</tr>
    </thead>
    <tbody>

		<c:forEach items="${userList}" var="b" varStatus="i">
		<tr>
			<td class="td1" >${i.count}</td>
			<td class="td1" ><a href="userUpdate.do6?userId=${b.getUserId()}">${ b.getUserId()}</a></td>
			<td class="td1" >${b.getUserName()}</td>
			<td class="td1" >${b.getUserEmail1()}${b.getUserEmail2()}</td>
			<td class="td1" >${b.getUserPhoneNumber1()}-${b.getUserPhoneNumber2()}-${b.getUserPhoneNumber3()}</td>
			<td class="td1" >${b.getUserJoinDate()}</td>
			<td class="td1" >${b.getUserLastLoginDate()}</td>
			
			<td class="td2">
			
	 		
	 		
			
		 <form action="userUpdate.do6" method="post">
            <input type="hidden" name="userId" value="${b.getUserId()}">
            <button class="userManagement_btn_update">수정</button>
         </form>
         
         <form action="userDelete.do4" method="post" onsubmit="return confirmValid()">
            <input type="hidden" name="userId" value="${b.getUserId()}" >
            <button class="userManagement_btn_delete">삭제</button>
         </form>
			      
	
   
			</td>
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