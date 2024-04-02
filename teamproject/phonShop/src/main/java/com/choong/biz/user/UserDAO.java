package com.choong.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import dbconnection.MyDBConnection;

public class UserDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//userDTO sql문
	private String USER_GET = "select * from userManagement where userId=?"; //상세
	private String USER_DELETE = "delete from userManagement where userId=?"; //삭제
	private String USER_LIST = "select * from userManagement";		//목록
	private String USER_INSERT = "insert into userManagement values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; //DB갯수 21
	private String USER_UPDATE = "update userManagement set userName=?, userGrade=?, userTotalPurchaseCount=?, userAccessBlocked=?, userPassword=?, userEmail1=?, userEmail2=?, userZipcode=?, userAddress1=?, userAddress2=?, userBirthdayYear=?, userBirthdayMonth=?, userBirthdayDay=?, userTotalPurchaseAmount=?, userPhoneNumber1=?, userPhoneNumber2=?, userPhoneNumber3=?, userNumber=? where userId=?";
	private String USER_LASTLOGINDATE_UPDATE = "update userManagement set userLastLoginDate=? where userId=?";
	
	
	//회원 관련 CRUD(create, read, update, delete)
	
	
	//1. 회원 상세조회
	public UserDTO getUser(String id) { //DispacherServlet 수정
		UserDTO user = null;
		
		
		//private String USER_GET = "select * from users where id=?"; //상세
		
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_GET);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
		
			
			if(rs.next()) { //DB의 이름이랑 같아야 하고, 
				
			
				user = new UserDTO(); 
				user.setUserId(rs.getString("userId")); //rs.
				user.setUserName(rs.getString("userName")); //rs.
				user.setUserGrade(rs.getString("userGrade")); //rs.
				user.setUserJoinDate(rs.getTimestamp("userJoinDate")); //rs.			//date
				user.setUserLastLoginDate(rs.getTimestamp("userLastLoginDate")); //rs.		//date
				user.setUserTotalPurchaseCount(rs.getInt("userTotalPurchaseCount")); //rs.
				user.setUserAccessBlocked(rs.getInt("userAccessBlocked")); //rs.
				user.setUserPassword(rs.getString("userPassword")); //rs.
				user.setUserEmail1(rs.getString("userEmail1")); //rs.
				user.setUserEmail2(rs.getString("userEmail2")); //rs.
				
				user.setUserZipcode(rs.getString("userZipcode")); //rs.
				user.setUserAddress1(rs.getString("userAddress1")); //rs.
				user.setUserAddress2(rs.getString("userAddress2")); //rs.
				user.setUserBirthdayYear(rs.getString("userBirthdayYear")); //rs.			
				user.setUserBirthdayMonth(rs.getString("userBirthdayMonth")); //rs.			
				user.setUserBirthdayDay(rs.getString("userBirthdayDay")); //rs.			
				
				user.setUserTotalPurchaseAmount(rs.getInt("userTotalPurchaseAmount")); //rs.
				user.setUserPhoneNumber1(rs.getString("userPhoneNumber1")); //rs.
				user.setUserPhoneNumber2(rs.getString("userPhoneNumber2")); //rs.
				user.setUserPhoneNumber3(rs.getString("userPhoneNumber3")); //rs.
				user.setUserNumber(rs.getInt("userNumber")); //rs.
				
		
				
				
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return user;
		
		
	}
	
	
	//private String USER_DELETE = "delete users where id=?";
	//2. 회원 삭제
	public void deleteUser(String id) {
		
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_DELETE);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MyDBConnection.close(rs, pstmt, con);
		}
		
		
	}
	
	//private String USER_UPDATE = "update users set name=?, role=? where id=?";
	//3. 회원 수정
	public void updateUser(UserDTO dto) {
		
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_UPDATE);
			
			
			pstmt.setString(1, dto.getUserName());
			pstmt.setString(2, dto.getUserGrade());
			pstmt.setString(3, dto.getUserPassword());
			pstmt.setString(4, dto.getUserEmail1());
			pstmt.setString(5, dto.getUserEmail2());
			
			pstmt.setString(6, dto.getUserZipcode());
			pstmt.setString(7, dto.getUserAddress1());
			pstmt.setString(8, dto.getUserAddress2());
			
			pstmt.setString(9, dto.getUserBirthdayYear());
			pstmt.setString(10, dto.getUserBirthdayMonth());
			pstmt.setString(11, dto.getUserBirthdayDay());
			
			
			pstmt.setInt(12, dto.getUserTotalPurchaseAmount());
			pstmt.setString(13, dto.getUserPhoneNumber1());
			pstmt.setString(14, dto.getUserPhoneNumber2());
			pstmt.setString(15, dto.getUserPhoneNumber3());
			pstmt.setInt(16, dto.getUserNumber());
			pstmt.setString(17, dto.getUserId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyDBConnection.close(rs, pstmt, con);
		}
		
		
	}
	
	
	//private String USER_INSERT = "insert into users values(?,?,?,?)";
	//4. 회원 등록
	public int insertUser(UserDTO dto) {
		
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_INSERT);
			
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserName());
			pstmt.setString(3, dto.getUserGrade());
			pstmt.setTimestamp(4, dto.getUserJoinDate());
			pstmt.setTimestamp(5, dto.getUserLastLoginDate());
			pstmt.setInt(6, dto.getUserTotalPurchaseCount());
			pstmt.setInt(7, dto.getUserAccessBlocked());
			pstmt.setString(8, dto.getUserPassword());
			pstmt.setString(9, dto.getUserEmail1());
			pstmt.setString(10, dto.getUserEmail2());
			
			pstmt.setString(11, dto.getUserZipcode());
			pstmt.setString(12, dto.getUserAddress1());
			pstmt.setString(13, dto.getUserAddress2());
			
			pstmt.setString(14, dto.getUserBirthdayYear());
			pstmt.setString(15, dto.getUserBirthdayMonth());
			pstmt.setString(16, dto.getUserBirthdayDay());
			
			
			pstmt.setInt(17, dto.getUserTotalPurchaseAmount());
			pstmt.setString(18, dto.getUserPhoneNumber1());
			pstmt.setString(19, dto.getUserPhoneNumber2());
			pstmt.setString(20, dto.getUserPhoneNumber3());
			pstmt.setInt(21, dto.getUserNumber());
		

			System.out.println(	dto.toString());
			
		
			
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyDBConnection.close(rs, pstmt, con);
		}
		
		return 1;
		
	}
	

	
	//private String USER_LIST = "select * from users";
		//5. 회원 목록 조회
		public List<UserDTO> getUserList() {
			
			 List<UserDTO>  userList = new ArrayList<UserDTO>();
			
			
			try {
				con = MyDBConnection.getConnection();
				pstmt = con.prepareStatement(USER_LIST);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					UserDTO user = new UserDTO();
					
					user.setUserId(rs.getString("userId")); //rs.
					user.setUserName(rs.getString("userName")); //rs.
					user.setUserGrade(rs.getString("userGrade")); //rs.
					user.setUserJoinDate(rs.getTimestamp("userJoinDate")); //rs.			//date
					user.setUserLastLoginDate(rs.getTimestamp("userLastLoginDate")); //rs.		//date
					user.setUserTotalPurchaseCount(rs.getInt("userTotalPurchaseCount")); //rs.
					user.setUserAccessBlocked(rs.getInt("userAccessBlocked")); //rs.
					user.setUserPassword(rs.getString("userPassword")); //rs.
					user.setUserEmail1(rs.getString("userEmail1")); //rs.
					user.setUserEmail2(rs.getString("userEmail2")); //rs.
					
					user.setUserZipcode(rs.getString("userZipcode")); //rs.
					user.setUserAddress1(rs.getString("userAddress1")); //rs.
					user.setUserAddress1(rs.getString("userAddress2")); //rs.
					user.setUserBirthdayYear(rs.getString("userBirthdayYear")); //rs.			
					user.setUserBirthdayMonth(rs.getString("userBirthdayMonth")); //rs.			
					user.setUserBirthdayDay(rs.getString("userBirthdayDay")); //rs.			
					
					user.setUserTotalPurchaseAmount(rs.getInt("userTotalPurchaseAmount")); //rs.
					user.setUserPhoneNumber1(rs.getString("userPhoneNumber1")); //rs.
					user.setUserPhoneNumber2(rs.getString("userPhoneNumber2")); //rs.
					user.setUserPhoneNumber3(rs.getString("userPhoneNumber3")); //rs.
					user.setUserNumber(rs.getInt("userNumber")); //rs.
					
					
				
					userList.add(user);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				MyDBConnection.close(rs, pstmt, con);
			}
			
			return userList;
			
			
			
		}
		
		   // 6. 중복 체크(회원 중복체크)
		   public int registerUserCheck(String id) {
		      //private String USER_GET = "select * from users where id=?";
		      
		      try {
		         con = MyDBConnection.getConnection();
		         pstmt = con.prepareStatement(USER_GET);
		         pstmt.setString(1, id);
		         
		         rs = pstmt.executeQuery();
		         if(rs.next() || id.equals("")) {//공백을 넘겨 주면 안되기 때문에
		            return 0; //이미 회원이 존재한다. 아이디가 있다.
		         }else {
		            return 1; // 가입 가능한 회원 아이디
		         }         
		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }finally {
		         MyDBConnection.close(rs, pstmt, con);
		      }
		      
		      return -1; //데이터베이스 오류 알려주기
		      
		   }  
	
	
	
			//7. 회원 최근접속일 수정
			public void updateUserLastLoginDate(UserDTO dto) {
				
				try {
					con = MyDBConnection.getConnection();
					pstmt = con.prepareStatement(USER_LASTLOGINDATE_UPDATE);
					
					pstmt.setTimestamp(1, dto.getUserLastLoginDate());
					pstmt.setString(2, dto.getUserId());
					
					pstmt.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					MyDBConnection.close(rs, pstmt, con);
				}
				
				
			}
	
	
	
	

}
