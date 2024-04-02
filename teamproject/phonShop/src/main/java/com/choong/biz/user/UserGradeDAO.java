package com.choong.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import dbconnection.MyDBConnection;

public class UserGradeDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//userGradeDTO sql문
	private String USER_GRADE_GET = "select * from userGradeManagement where userGradeName=?"; //상세(userGradeName) 조건검색
	private String USER_GRADE_GET2 = "select * from userGradeManagement where userGradeNumber=?"; //상세(userGradeNumber) 조건검색
	
	private String USER_GRADE_DELETE = "delete from userGradeManagement where userGradeNumber=?"; //삭제
	private String USER_GRADE_LIST = "select * from userGradeManagement";		//목록
	private String USER_GRADE_INSERT = "insert into userGradeManagement (userGradeName, userGradeTotalPurchaseAmount, userGradeDiscountRate, userGradeCount)VALUES (?, ?, ?, ?)";
	
	private String USER_GRADE_UPDATE = "update userGradeManagement set userGradeName=?, userGradeTotalPurchaseAmount=?, userGradeDiscountRate=? where userGradeNumber=?";
	private String USER_GRADE_GETALL ="select * from userGradeManagement order by userGradeNumber desc";

	//회원수SQL - 조인사용
	private String USER_GRADE_GradeCount ="select (select userGradeName from userGradeManagement C where O.userGrade = C.userGradeName ) as userGrade,"
											+ "count(O.userGrade) as userGradeCount from userManagement O group by O.userGrade";
	private String USER_GRADE_GradeCount_UPDATE = "update userGradeManagement set userGradeCount=? where userGradeName=?";
	

	
	
			
			
	//1. 회원등급 상세조회
	public UserGradeDTO getUserGrade(String id) { //DispacherServlet 수정
		UserGradeDTO userGrade = null;

		//private String USER_GET = "select * from users where id=?"; //상세
		
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_GRADE_GET2);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //DB의 이름이랑 같아야 하고, 
			
				userGrade = new UserGradeDTO(); 
				
				userGrade.setUserGradeNumber(rs.getInt("userGradeNumber")); //rs.
				userGrade.setUserGradeName(rs.getString("userGradeName")); //rs.
				userGrade.setUserGradeTotalPurchaseAmount(rs.getInt("userGradeTotalPurchaseAmount")); //rs.
				userGrade.setUserGradeDiscountRate(rs.getInt("userGradeDiscountRate")); //rs.
				userGrade.setUserGradeCount(rs.getInt("userGradeCount")); //rs.
		
				
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return userGrade;
		
		
	}
	
	
	//private String USER_DELETE = "delete users where id=?";
	//2. 회원등급 삭제
	public void deleteUser(String id) {
		
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_GRADE_DELETE);
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
	
	//USER_GRADE_UPDATE = "update userGradeManagement set userGradeName=?, userGradeTotalPurchaseAmount=?, userGradeDiscountRate=?, userGradeCount=?  where userGradeNumber=?";
	//3. 회원등급 수정
	public void updateUserGrade(UserGradeDTO dto) {
		
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_GRADE_UPDATE);
			pstmt.setString(1, dto.getUserGradeName());
			pstmt.setInt(2, dto.getUserGradeTotalPurchaseAmount());
			pstmt.setInt(3, dto.getUserGradeDiscountRate());
			pstmt.setInt(4, dto.getUserGradeNumber());
			
			
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
	//4. 회원등급 등록
	public int userGradeinsert(UserGradeDTO dto) {
		
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(USER_GRADE_INSERT);
			
			
		
			pstmt.setString(1, dto.getUserGradeName());
			pstmt.setInt(2, dto.getUserGradeTotalPurchaseAmount());
			pstmt.setInt(3, dto.getUserGradeDiscountRate());		//date
			pstmt.setInt(4, dto.getUserGradeCount()); //date
			
			
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
		//5. 회원등급 목록 조회
		public List<UserGradeDTO> getUserGradeList() {
			
			 List<UserGradeDTO>  userGradeList = new ArrayList<UserGradeDTO>();
			
			
			try {
				con = MyDBConnection.getConnection();
				pstmt = con.prepareStatement(USER_GRADE_GETALL);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					UserGradeDTO userGrade = new UserGradeDTO();
					
					userGrade.setUserGradeNumber(rs.getInt("userGradeNumber"));
					userGrade.setUserGradeName(rs.getString("userGradeName"));
					userGrade.setUserGradeTotalPurchaseAmount(rs.getInt("userGradeTotalPurchaseAmount"));
					userGrade.setUserGradeDiscountRate(rs.getInt("userGradeDiscountRate"));
					userGrade.setUserGradeCount(rs.getInt("userGradeCount"));

					userGradeList.add(userGrade);
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
			
			return userGradeList;
			
			
			
		}
		
		
		//#6.회원등급 중복확인
		public int registerGradeCheck(String id) {
		      //private String USER_GET = "select * from users where id=?";
		      
		      try {
		         con = MyDBConnection.getConnection();
		         pstmt = con.prepareStatement(USER_GRADE_GET);
		         pstmt.setString(1, id);
		         
		         rs = pstmt.executeQuery();
		         if(rs.next() || id.equals("")) {//공백을 넘겨 주면 안되기 때문에
		            return 0; //이미 등급명이 존재한다. 아이디가 있다.
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
	
		
		//#7.회원수 업데이트( 조인 사용 + 업데이트 문)
		public void updateUserGradeCount() {
			
	
			//private String USER_GET = "select * from users where id=?"; //상세
			
			try {
				con = MyDBConnection.getConnection();
				pstmt = con.prepareStatement(USER_GRADE_GradeCount);
				rs = pstmt.executeQuery();
				
				while(rs.next()) { //DB의 이름이랑 같아야 하고, 
					
					String userGrade = rs.getString("userGrade");
					String userGradeCount = rs.getString("userGradeCount");
				
			
					try {
						con = MyDBConnection.getConnection();
						pstmt = con.prepareStatement(USER_GRADE_GradeCount_UPDATE);
						pstmt.setString(1, userGradeCount);
						pstmt.setString(2, userGrade);
					
						
						
						pstmt.executeUpdate();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
					
					}

				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				MyDBConnection.close(rs, pstmt, con);
			}
		
			
		}
	
	
	
	

}
