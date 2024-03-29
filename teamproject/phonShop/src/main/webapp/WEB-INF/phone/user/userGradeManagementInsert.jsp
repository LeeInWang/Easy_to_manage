<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/css/userGradeInsert.css" rel="stylesheet"/> 
<link href="${pageContext.request.contextPath}/css/baisc.css" rel="stylesheet"/> 
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
   .wrapper{
      width: 100%;
      display: flex;        
   }

   
</style>






<script>
	


//#. 회원등급 중복체크
function graderegisterFunction(){
	let tmp = $('#userGradeName').val();
	//$.ajax({경로, 동기화 여부, 성공하면 할 일})
	//$.ajax({url:'경로',async:true/false, sussess: function(result)})
		
	
	$.ajax({ //넘기는방식( ajax)
		type : 'POST', //전달방식, 경로,데이터를 넣어 줘야 함
		url : 'UserGradeRegisterCheck.do2', //URL
				//파라미터 : 값
		data : {userGradeName:tmp},	//파라미터이름 : 값 
		success:function(result){
			if(result == 1){
				$('#userGradeNameText').text("사용할 수 있는 등급명 입니다.");
			}else{
				$('#userGradeNameText').text("사용할 수 없는 등급명 입니다.");
			}
		}
		
	
	});
}



/* 콤마 자동으로 넣기 */

function comma(str) {
        str = String(str);
        return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
    }

    function uncomma(str) {
        str = String(str);
        return str.replace(/[^\d]+/g, '');
    } 
    
    function inputNumberFormat(obj) {
        obj.value = comma(uncomma(obj.value));
    }
    
    function inputOnlyNumberFormat(obj) {
        obj.value = onlynumber(uncomma(obj.value));
    }
    
    function onlynumber(str) {
	    str = String(str);
	    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g,'$1');
	}


  

  

</script>


</head>
<body>
<div class="wrap">
   <header>
       <jsp:include page="/WEB-INF/phone/header.jsp" flush="true"/>      
   </header>

<div class="wrapper">
   <article>
   </div>
   <aside class="side">
    <jsp:include page="useraside.jsp" flush="true"/>
   </aside>
   </article>
   <article>
<div class="container">
  <h2>등급추가</h2>
  <form action="userGradeInsert.do5" method="post" name="userGrade">
  
    <div class="form-group">
    
      <label for="userGradeName ">등급명:</label>
      <input type="text" class="input1" name="userGradeName" id="userGradeName"  required="required" >
                            <button type="button" class="btn" id="overlapCheck" onclick="graderegisterFunction()">중복체크</button><br>
                            <span id="userGradeNameText"></span>
   
    </div>
    
    <div class="form-group">
      <label for="userPwd1">평가조건(구매금액)</label>
       <input type="text" class="input1" name="userGradeTotalPurchaseAmount" id="userGradeTotalPurchaseAmount"  required="required" maxlength="10" onkeyup="inputNumberFormat(this);" placeholder="숫자 입력"><span>&nbsp원</span>
    </div>
      <div class="form-group">
      <label for="userPwd2">할인율:</label>
      <input type="number" class="input1" name="userGradeDiscountRate" id="userGradeDiscountRate" required="required" min="1" max="99"><span>&nbsp%</span>
    </div>
    

     
  
    <div class="form-group">
      <input type="submit" value="추가" id="userInsertSubmit">
    </div>
  </form>
  </article>
</div>


   <footer>
      <jsp:include page="/WEB-INF/phone/footer.jsp" flush="true"/>      
   </footer>
</body>
</html>