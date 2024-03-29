package com.choong.biz.user;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class UserDTO {
	private String userId;	//회원아이디
	private String userName;	//회원이름 
	private String userGrade;	//회원등급  -기본 Bronze(그렇다면, 브론즈에서 청동으로 바꿀려면...)
	private Timestamp userJoinDate;	//가입일 //date
	private Timestamp userLastLoginDate;	//최근접속일 //date
	private int userTotalPurchaseCount;	//누적구매수 
	private int userAccessBlocked;	//접근차단 (기본0, 접근제한1)
	private String userPassword;	//비밀번호 
	
	private String userEmail1;	//이메일(아이디) 
	private String userEmail2;	//이메일(이메일주소)
	
	private String userZipcode;	//주소(집코드)
	private String userAddress1;	//주소(도로명)
	private String userAddress2;	//주소(상세주소)  
	
	private String userBirthdayYear;	//생년월일 		
	private String userBirthdayMonth;	//생년월일 		
	private String userBirthdayDay;	//생년월일 	
	
	
	private int userTotalPurchaseAmount;	//구매금액 (스크립트에, 원 표시) 
	
	private String userPhoneNumber1;	//핸드폰 (형식필요 010-2413-1234 ,3자,4자,4자형식틀
	private String userPhoneNumber2;	//핸드폰 
	private String userPhoneNumber3;	//핸드폰 
	
	
	private int userNumber;	//회원번호 (회원고유번호...)
	
	public UserDTO(){
		
	}

	public UserDTO(String userId, String userName, String userGrade, Timestamp userJoinDate,
			Timestamp userLastLoginDate, int userTotalPurchaseCount, int userAccessBlocked, String userPassword,
			String userEmail1, String userEmail2, String userZipcode, String userAddress1, String userAddress2,
			String userBirthdayYear, String userBirthdayMonth, String userBirthdayDay, int userTotalPurchaseAmount,
			String userPhoneNumber1, String userPhoneNumber2, String userPhoneNumber3, int userNumber) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userGrade = userGrade;
		this.userJoinDate = userJoinDate;
		this.userLastLoginDate = userLastLoginDate;
		this.userTotalPurchaseCount = userTotalPurchaseCount;
		this.userAccessBlocked = userAccessBlocked;
		this.userPassword = userPassword;
		this.userEmail1 = userEmail1;
		this.userEmail2 = userEmail2;
		this.userZipcode = userZipcode;
		this.userAddress1 = userAddress1;
		this.userAddress2 = userAddress2;
		this.userBirthdayYear = userBirthdayYear;
		this.userBirthdayMonth = userBirthdayMonth;
		this.userBirthdayDay = userBirthdayDay;
		this.userTotalPurchaseAmount = userTotalPurchaseAmount;
		this.userPhoneNumber1 = userPhoneNumber1;
		this.userPhoneNumber2 = userPhoneNumber2;
		this.userPhoneNumber3 = userPhoneNumber3;
		this.userNumber = userNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public Timestamp getUserJoinDate() {
		return userJoinDate;
	}

	public void setUserJoinDate(Timestamp userJoinDate) {
		this.userJoinDate = userJoinDate;
	}

	public Timestamp getUserLastLoginDate() {
		return userLastLoginDate;
	}

	public void setUserLastLoginDate(Timestamp userLastLoginDate) {
		this.userLastLoginDate = userLastLoginDate;
	}

	public int getUserTotalPurchaseCount() {
		return userTotalPurchaseCount;
	}

	public void setUserTotalPurchaseCount(int userTotalPurchaseCount) {
		this.userTotalPurchaseCount = userTotalPurchaseCount;
	}

	public int getUserAccessBlocked() {
		return userAccessBlocked;
	}

	public void setUserAccessBlocked(int userAccessBlocked) {
		this.userAccessBlocked = userAccessBlocked;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail1() {
		return userEmail1;
	}

	public void setUserEmail1(String userEmail1) {
		this.userEmail1 = userEmail1;
	}

	public String getUserEmail2() {
		return userEmail2;
	}

	public void setUserEmail2(String userEmail2) {
		this.userEmail2 = userEmail2;
	}

	public String getUserZipcode() {
		return userZipcode;
	}

	public void setUserZipcode(String userZipcode) {
		this.userZipcode = userZipcode;
	}

	public String getUserAddress1() {
		return userAddress1;
	}

	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;
	}

	public String getUserAddress2() {
		return userAddress2;
	}

	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;
	}

	public String getUserBirthdayYear() {
		return userBirthdayYear;
	}

	public void setUserBirthdayYear(String userBirthdayYear) {
		this.userBirthdayYear = userBirthdayYear;
	}

	public String getUserBirthdayMonth() {
		return userBirthdayMonth;
	}

	public void setUserBirthdayMonth(String userBirthdayMonth) {
		this.userBirthdayMonth = userBirthdayMonth;
	}

	public String getUserBirthdayDay() {
		return userBirthdayDay;
	}

	public void setUserBirthdayDay(String userBirthdayDay) {
		this.userBirthdayDay = userBirthdayDay;
	}

	public int getUserTotalPurchaseAmount() {
		return userTotalPurchaseAmount;
	}

	public void setUserTotalPurchaseAmount(int userTotalPurchaseAmount) {
		this.userTotalPurchaseAmount = userTotalPurchaseAmount;
	}

	public String getUserPhoneNumber1() {
		return userPhoneNumber1;
	}

	public void setUserPhoneNumber1(String userPhoneNumber1) {
		this.userPhoneNumber1 = userPhoneNumber1;
	}

	public String getUserPhoneNumber2() {
		return userPhoneNumber2;
	}

	public void setUserPhoneNumber2(String userPhoneNumber2) {
		this.userPhoneNumber2 = userPhoneNumber2;
	}

	public String getUserPhoneNumber3() {
		return userPhoneNumber3;
	}

	public void setUserPhoneNumber3(String userPhoneNumber3) {
		this.userPhoneNumber3 = userPhoneNumber3;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", userGrade=" + userGrade + ", userJoinDate="
				+ userJoinDate + ", userLastLoginDate=" + userLastLoginDate + ", userTotalPurchaseCount="
				+ userTotalPurchaseCount + ", userAccessBlocked=" + userAccessBlocked + ", userPassword=" + userPassword
				+ ", userEmail1=" + userEmail1 + ", userEmail2=" + userEmail2 + ", userZipcode=" + userZipcode
				+ ", userAddress1=" + userAddress1 + ", userAddress2=" + userAddress2 + ", userBirthdayYear="
				+ userBirthdayYear + ", userBirthdayMonth=" + userBirthdayMonth + ", userBirthdayDay=" + userBirthdayDay
				+ ", userTotalPurchaseAmount=" + userTotalPurchaseAmount + ", userPhoneNumber1=" + userPhoneNumber1
				+ ", userPhoneNumber2=" + userPhoneNumber2 + ", userPhoneNumber3=" + userPhoneNumber3 + ", userNumber="
				+ userNumber + "]";
	}
	
	
	
	




	
	

	
}
	