<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/css/userInsert.css" rel="stylesheet"/> 
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
   
   
   .wrapper{
      width: 100%;
      display: flex;        
   }
   

   
   
   
   select.box {
  width: 100%;
  height: 50px;
  box-sizing: border-box;
  margin-left: 5px;
  padding: 5px 0 5px 10px;
  border-radius: 4px;
  border: 1px solid #d9d6d6;
  color: #383838;
  background-color: #ffffff;
  font-family: 'Montserrat', 'Pretendard', sans-serif;
}

option {
  font-size: 16px;
}

.info .box#domain-list option {
  font-size: 14px;
  background-color: #ffffff;
}


/* SECTION - BIRTH */
.info#info__birth {
  display: flex;
}

.info#info__birth select {
  margin-left : 7px;
}

.info#info__birth select:first-child {
  margin-left : 0px;
}


.info#info__birth select::-webkit-scrollbar {
  width: 10px;
}

.info#info__birth select::-webkit-scrollbar-thumb {
  background-color: #b6b6b6;
  border-radius: 3px;
}

.info#info__birth select::-webkit-scrollbar-track {
  background-color: #ebe9e9;
  border-radius: 6px;
}
   
   
   
   
   
   
   
   
   
   
   
   
</style>




<!-- 
#1. 주소 
-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>    
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	document.addEventListener('DOMContentLoaded', function(){
	
	//#. 우편번호 검색
	const zipbtn = document.querySelector("#zipbtn");
	
	//버튼이 눌려 졌을 때만 동작
	zipbtn.addEventListener('click', function() { //() => {} function(){
	
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            
	            // ★
	    		//바로들어가는 방식
	    		//폼명.우편번호코드입력할_input_태그의_이름.값 = 넘어온 데이터의 zonecode 값 넘겨주기
	    		document.userMember.userZipcode.value = data.zonecode;
	    		//주소 전체를 받기 위한 변수
	    		let fullAddress ='';
	    		//추가 주소, 건물명/동명을 받을 변수 
	            let extendAddress='';
	    		
	    		//기본주소 (R-도로명, J-지번)
	    		if(data.userSelectedType === 'R'){
	    			fullAddress = data.roadAddress;
	    		}else{
	    			fullAddress = data.jibunAddress;
	    		}
	    		
	    		//확인용
	    		//주소태그의 id가 아닌 name으로 가져옵니다.
	    		//document.userMember.address1.value = fullAddress
	    		
	    		//추가 주소 - 법정동/법정리 이름, 건물명
	    		//빌딩명과 법정동/법정리가 있을 수도 있고 없을 수도 있음
	    		if(data.userSelectedType === 'R'){
	    			if(data.bname !== ''){
	    				extendAddress += data.bname;	
	    			}
	    		
	    		if(data.buildingName !== ''){ //건물명이 있으면
	    			extendAddress += (extendAddress !== '' ? ', ' + data.buildingName : data.buildingName);
	    		}
	    		
	    		//기본주소(추가 주소)
	    		fullAddress += (extendAddress !== '' ? '(' + extendAddress + ')' : '');
	    		}
	    		
	    		//폼에 찍기 -확인
	    		document.userMember.userAddress1.value = fullAddress;
	    		document.userMember.userAddress2.focus(); //마우스커서 여기로 보내기.
	    
	    		
	    		
	        
	       	
	        }
	    }).open();
    
	});	//zipbtn이 클릭되었을 때 동작의 끝
    
	});




//#2. 패스워드 중복체크
function passwordCheckFunction(){
	
	
	//자바스크립트
	/* let password1 = document.querySelector("#password1").value; //name에 있는 것
	let password2 = document.querySelector("#password2").value; //name에 있는 것
	if(password1 !== password2){
		let span = document.querySelector("#passwordText");
		document.querySelector("#passwordText").textContent() = "비밀번호가 일치하지 않습니다.";			
	
	}else{
		
	} */ 
	
	//jQuery
	let password1 = $('#userPwd1').val();	//value 값 
	let password2 = $('#userPwd2').val();	//value 값 
	if(password1 !== password2){
		$("#passwordText").text("비밀번호가 일치하지 않습니다.")
	}else{
		$("#passwordText").text('');
		//$("#password2").attr('disabled', true); //비활성화(true), 활성화(false)
												   //(비밀번호가 일치하는지 표시)
	}
	
}



//#3. 아이디 중복체크
function registerFunction(){
	let id = $('#userId').val();
	//$.ajax({경로, 동기화 여부, 성공하면 할 일})
	//$.ajax({url:'경로',async:true/false, sussess: function(result)})
	
	
	$.ajax({ //넘기는방식( ajax)
		type : 'POST', //전달방식, 경로,데이터를 넣어 줘야 함
		url : 'UserRegisterCheck.do2', //URL
				//파라미터 : 값
		data : {id:id},
		success:function(result){
			if(result == 1){
				$('#idText').text("사용할 수 있는 아이디 입니다.");
			}else{
				$('#idText').text("사용할 수 없는 아이디 입니다.");
			}
		}
		
	
	});
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
  <h2>관리자계정</h2>
  <form action="userUpdate2.do6" method="post" name="userMember">
  
    <div class="form-group">
    
      <label for="userId ">아이디:</label>
      <input type="text" class="input1" name="userId" id="userId"  required="required" value="${userselect.getUserId()}" readonly="readonly">
                            <button type="button" class="btn" id="overlapCheck" onclick="registerFunction()">중복체크</button><br>
                            <span id="idText"></span>
    </div>
    
    <div class="form-group">
      <label for="userPwd1">비밀번호:</label>
       <input type="password" class="input1" name="userPwd1" id="userPwd1"  required="required" value="${userselect.getUserPassword()}">
    </div>
    
      <div class="form-group">
      <label for="userPwd2">비밀번호 확인:</label>
      <input type="password" class="input1" name="userPwd2" id="userPwd2" onkeyup="passwordCheckFunction()" required="required" value="${userselect.getUserPassword()}">
      <br><span id="passwordText"></span>
    </div>
      
      <div class="form-group">
      <label for="userName">이름:</label>
      <input type="text" id="userName" name="userName" value="${userselect.getUserName()}">
    </div>
      
      <div class="form-group phone">
      <label for="userPhoneNumber">휴대폰 번호:</label>
      <input type="text" id="userPhoneNumber1" name="userPhoneNumber1" value="${userselect.getUserPhoneNumber1()}">
       <input type="text" id="userPhoneNumber2" name="userPhoneNumber2" value="${userselect.getUserPhoneNumber2()}">
        <input type="text" id="userPhoneNumber3" name="userPhoneNumber3" value="${userselect.getUserPhoneNumber3()}">
      </div>
      
  
   
     <div class="form-group">
      <label for="userPhoneNumber">이메일:</label>
      <input type="text" id="userEmail1" name="userEmail1" value="${userselect.getUserEmail1()}">
   

    
		<select class="box" id="userEmail2" name="userEmail2" value="${userselect.getUserEmail2()}">
		  <option value="@naver.com" <c:if test="${userselect.getUserEmail2() eq '@naver.com'}">selected</c:if>>@naver.com</option>
		  <option value="@google.com" <c:if test="${userselect.getUserEmail2() eq '@google.com'}">selected</c:if>>@google.com</option>
		  <option value="@hanmail.net" <c:if test="${userselect.getUserEmail2() eq '@hanmail.net'}">selected</c:if>>@hanmail.net</option>
		  <option value="@nate.com" <c:if test="${userselect.getUserEmail2() eq '@nate.com'}">selected</c:if>>@nate.com</option>
		  <option value="@kakao.com" <c:if test="${userselect.getUserEmail2() eq '@kakao.com'}">selected</c:if>>@kakao.com</option>
		</select>
     </div> 
     
 
     
      

       
      <div class="form-group">
	 <label for="post">우편번호</label>
      <button type="button" class="btn" id="zipbtn">우편번호</button>
       <br>
       <br>
       
      <input type="text" class="input1 ipost" name="userZipcode" id="post" value="${userselect.getUserZipcode()}">
    </div>
    

    <div class="form-group">
     <label for="userAddress1">주소</label>
      <input type="text" class="input1 iaddress" name="userAddress1" id="userAddress1" readonly="readonly" value="${userselect.getUserAddress1()}">
    </div>
    
 
     <div class="form-group">
      <label for="userAddress2">상세주소</label>
      <input type="text" class="input1 iaddress" name="userAddress2" id="userAddress2"value="${userselect.getUserAddress2()}">
    </div>

      <div class="form-group">
  		<label for="userAddress2">생년월일</label>
  		 <input type="text" class="input1 iaddress" id="userBirthdayYear" name="userBirthdayYear" value="${userselect.getUserBirthdayYear()}">년
  		 <input type="text" class="input1 iaddress" id="userBirthdayMonth" name="userBirthdayMonth" value="${userselect.getUserBirthdayMonth()}">월
  		 <input type="text" class="input1 iaddress" id="userBirthdayDay" name="userBirthdayDay" value="${userselect.getUserBirthdayDay()}">일
     </div>
   
 	
 	         

            <input type="submit" id="hiddenSubmit" style="display:none;">
            <input type="submit" id="hiddenSubmit" style="display:none;">
			
   
    
    
    
  
    <div class="form-group">
      <input type="submit" value="가입" id="userInsertSubmit">
    </div>
  </form>
  </article>
</div>


   <footer>
      <jsp:include page="/WEB-INF/phone/footer.jsp" flush="true"/>      
   </footer>
</body>
</html>