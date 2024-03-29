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

.board_btn_update {
   
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
  .board_btn_update:hover {
    background-color: #ffffff;
    color: #5898d8;
  }
  
  .board_btn_delete {
    
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
  .board_btn_delete:hover {
    background-color: #ffffff;
    color: #d85872;
  }
  
  
  .board_btn_insert {
    width: 50%;
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
  .board_btn_insert:hover {
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
       displayLength: 20,                // -셋트1(같이사용해야 기능이 사용됩니다.)
       
    // 검색 기능 숨기기
    searching: true,
       
     
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
	   		
       <table id="example" class="table table-striped" style="width:100%">
         <thead>
        <tr>
         <th class="th1" style="width:5%">No</th>
         <th class="th1" style="width:60%">제목</th>
         <th class="th1" style="width:10%">작성자</th>
         <th class="th1" style="width:10%">작성일</th>
         <th class="th1" style="width:15%">
         	 <form action="boardInsert.do7" method="post">
		         <input type="hidden" name="boardNumber">
		         <button class="board_btn_insert">글쓰기</button>
	         </form>
	    </th>
         
      </tr>
    </thead>
    <tbody>

      <c:forEach items="${boardList}" var="b" varStatus="i">
      <tr>
         <td class="td1">${b.getBoardNumber()}</td>
         <td class="td1"><a href="boardSelect.do2?boardNumber=${b.getBoardNumber()}">${ b.getBoardTitle()}</a></td>
         <td class="td1">${b.getBoardUser()}</td>
         <td class="td1">${b.getBoardDate()}</td>
         
         
         <td class="td2">
         <form action="boardUpdate.do2" method="post">
         	<input type="hidden" name="boardNumber" value="${b.getBoardNumber()}">
         	<button class="board_btn_update">수정</button>
         </form>
         <form action="boardDelete.do4" method="post">
         	<input type="hidden" name="boardNumber" value="${b.getBoardNumber()}">
         	<button class="board_btn_delete">삭제</button>
         </form>
         </td>    
      </tr>
      </c:forEach>
      </tbody>
</table> 
   </div>
   <aside class="side">
    <jsp:include page="/WEB-INF/phone/board/boardaside.jsp" flush="true"/>
   </aside>
</div>
   <footer>
      <jsp:include page="/WEB-INF/phone/footer.jsp" flush="true"/>
   </footer>

</body>
</html>