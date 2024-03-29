package com.choong.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconnection.MyDBConnection;

public class BoardDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	

	private String BOARD_INSERT ="insert into boardManagement(boardTitle, boardCategory, boardContent, boardImage, boardUser) values(?,?,?,?,?)";	
	private  String BOARD_UPDATE = "update boardManagement set boardTitle=?,boardCategory=?, boardContent=?,boardImage=? where boardNumber=?";
	private  String BOARD_DELETE = "delete from boardManagement where boardNumber=?";
	private  String BOARD_SELECT ="select * from boardManagement where boardNumber=?";
	private  String BOARD_LIST ="select * from boardManagement";
	private String BOARDFAQ_LIST = "select * from boardManagementFaq";
	private String BOARDFAQ_UPDATE = "update boardManagementFaq set boardFaqTitle=?, boardFaqContent=? where boardFaqNumber=?";
	private String BOARDFAQ_DELETE = "delete from boardManagementFaq where boardFaqNumber=?";
	private String BOARDFAQ_INSERT = "insert into boardManagementFaq(boardFaqTitle,boardFaqContent,boardFaqUser) values(?,?,?)";
	private String BOARDFAQ_SELECT ="select * from boardManagementFaq where boardFaqNumber=?";
	//글 등록
	public void insertBoard(BoardDTO dto) {
	    try {
	        con = MyDBConnection.getConnection();
	        pstmt = con.prepareStatement(BOARD_INSERT, Statement.RETURN_GENERATED_KEYS); // auto_increment된 primary key 반환을 위해 수정
	        pstmt.setString(1, dto.getBoardTitle());
	        pstmt.setString(2, dto.getBoardCategory());
	        pstmt.setString(3, dto.getBoardContent());
	        pstmt.setString(4, dto.getBoardImage());
	        pstmt.setString(5, dto.getBoardUser());

	        pstmt.executeUpdate();
	        ResultSet rs = pstmt.getGeneratedKeys(); // auto_increment된 primary key 반환
	        if (rs.next()) {
	            int boardNumber = rs.getInt(1);
	            dto.setBoardNumber(boardNumber); // DTO에 auto_increment된 primary key 설정
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        MyDBConnection.close(rs, pstmt, con);
	    }
	}

		
		//글 수정
		public void updateBoard(BoardDTO dto) {
			//"update boardManagement set boardTitle=?, boardContent=?,boardImage=? where boardNumber=?";
			try {
				con = MyDBConnection.getConnection();
				pstmt = con.prepareStatement(BOARD_UPDATE);
				pstmt.setString(1,dto.getBoardTitle());
				pstmt.setString(2,dto.getBoardCategory());
				pstmt.setString(3,dto.getBoardContent());
				pstmt.setString(4,dto.getBoardImage());		
				pstmt.setInt(5, dto.getBoardNumber());
				
				pstmt.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				MyDBConnection.close(rs, pstmt, con);
			}
		
		}
		
		// 글 삭제
		
		public void deleteBoard(BoardDTO dto) {
			
			try {
				con = MyDBConnection.getConnection();
				pstmt = con.prepareStatement(BOARD_DELETE);
				pstmt.setInt(1, dto.getBoardNumber());
				
				pstmt.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				MyDBConnection.close(rs, pstmt, con);
			}
		
		}
		
		
		
		//글 상세 조회
		public BoardDTO selectBoard(BoardDTO dto) { 
			// 번호 하나로만 검색하기에 번호를 매개값으로 받아도 되지만
			// 결과를 이용하기 해서 상세 검색을 표현하기 위해 BoardDTO로 받음
			BoardDTO board = null;
			
			try {
				con = MyDBConnection.getConnection();
				pstmt = con.prepareStatement(BOARD_SELECT);
				pstmt.setInt(1,dto.getBoardNumber());
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					board = new BoardDTO();
				    board.setBoardNumber(rs.getInt("boardNumber"));
				    board.setBoardTitle(rs.getString("boardTitle"));
				    board.setBoardCategory(rs.getString("boardCategory"));
				    board.setBoardUser(rs.getString("boardUser"));		    
				    board.setBoardContent(rs.getString("boardContent"));
				    board.setBoardImage(rs.getString("boardImage"));
				    board.setBoardDate(rs.getDate("boardDate"));			
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				MyDBConnection.close(rs, pstmt, con);
			}
			return board;
		}
		
		public List<BoardDTO>boardList(){
			List<BoardDTO> boardList = new ArrayList<>();
			
			try {
				con = MyDBConnection.getConnection();
				pstmt = con.prepareStatement(BOARD_LIST);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BoardDTO board = new BoardDTO();
					
					board = new BoardDTO();
					board.setBoardNumber(rs.getInt("boardNumber"));
				    board.setBoardTitle(rs.getString("boardTitle"));
				    board.setBoardCategory(rs.getString("boardCategory"));
				    board.setBoardUser(rs.getString("boardUser"));		    
				    board.setBoardContent(rs.getString("boardContent"));
				    board.setBoardImage(rs.getString("boardImage"));
				    board.setBoardDate(rs.getDate("boardDate"));
				    
				    boardList.add(board);
				}			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				MyDBConnection.close(rs, pstmt, con);
			}
		
			return boardList;
			
		}
		
		//Faq 삽입
		public void insertBoardFaq(BoardFaqDTO dto) {
		    try {
		        con = MyDBConnection.getConnection();
		        pstmt = con.prepareStatement(BOARDFAQ_INSERT, Statement.RETURN_GENERATED_KEYS); // auto_increment된 primary key 반환을 위해 수정
		        pstmt.setString(1, dto.getBoardFaqTitle());
		        pstmt.setString(2, dto.getBoardFaqContent());
		        pstmt.setString(3, dto.getBoardFaqUser());

		        pstmt.executeUpdate();
		        ResultSet rs = pstmt.getGeneratedKeys(); // auto_increment된 primary key 반환
		        if (rs.next()) {
		            int boardFaqNumber = rs.getInt(1);
		            dto.setBoardFaqNumber(boardFaqNumber); // DTO에 auto_increment된 primary key 설정
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        MyDBConnection.close(rs, pstmt, con);
		    }
		}
		
		
		//글 수정
				public void updateBoardFaq(BoardFaqDTO dto) {
					//"update boardManagement set boardTitle=?, boardContent=?,boardImage=? where boardNumber=?";
					try {
						con = MyDBConnection.getConnection();
						pstmt = con.prepareStatement(BOARDFAQ_UPDATE);
						pstmt.setString(1,dto.getBoardFaqTitle());
						pstmt.setString(2,dto.getBoardFaqContent());	
						pstmt.setInt(3, dto.getBoardFaqNumber());
						
						pstmt.executeUpdate();
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						MyDBConnection.close(rs, pstmt, con);
					}
				
				}
				
				// 글 삭제
				
				public void deleteBoardFaq(BoardFaqDTO dto) {
					
					try {
						con = MyDBConnection.getConnection();
						pstmt = con.prepareStatement(BOARDFAQ_DELETE);
						pstmt.setInt(1, dto.getBoardFaqNumber());
						
						pstmt.executeUpdate();
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						MyDBConnection.close(rs, pstmt, con);
					}
				
				}
				
				public List<BoardFaqDTO>boardListFaq(){
					List<BoardFaqDTO> boardFaqList = new ArrayList<>();
					
					try {
						con = MyDBConnection.getConnection();
						pstmt = con.prepareStatement(BOARDFAQ_LIST);
						rs = pstmt.executeQuery();
						
						while(rs.next()) {
							BoardFaqDTO board = new BoardFaqDTO();
							
							
							board.setBoardFaqNumber(rs.getInt("boardFaqNumber"));
						    board.setBoardFaqTitle(rs.getString("boardFaqTitle"));
						    board.setBoardFaqUser(rs.getString("boardFaqUser"));		    
						    board.setBoardFaqContent(rs.getString("boardFaqContent"));
						    
						    boardFaqList.add(board);
						}			
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						MyDBConnection.close(rs, pstmt, con);
					}
				
					return boardFaqList;
					
				}
				
				
				//글 상세 조회
				public BoardFaqDTO selectFaqBoard(BoardFaqDTO dto) { 
					// 번호 하나로만 검색하기에 번호를 매개값으로 받아도 되지만
					// 결과를 이용하기 해서 상세 검색을 표현하기 위해 BoardDTO로 받음
					BoardFaqDTO board = null;
					
					try {
						con = MyDBConnection.getConnection();
						pstmt = con.prepareStatement(BOARDFAQ_SELECT);
						pstmt.setInt(1,dto.getBoardFaqNumber());
						
						rs = pstmt.executeQuery();
						
						if(rs.next()) {
							board = new BoardFaqDTO();
						    board.setBoardFaqNumber(rs.getInt("boardFaqNumber"));
						    board.setBoardFaqTitle(rs.getString("boardFaqTitle"));
						    board.setBoardFaqUser(rs.getString("boardFaqUser"));		    
						    board.setBoardFaqContent(rs.getString("boardFaqContent"));
		
						}			
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						MyDBConnection.close(rs, pstmt, con);
					}
					return board;
				}
//		//글 리스트 검색
//		public List<BoardDTO> getBoardList(BoardDTO dto){
//			List<BoardDTO> boardList = new ArrayList<>();
//			
//			try {
//				con = MyDBConnection.getConnection();
//				
//				if(dto.getSearchCondition().equalsIgnoreCase("TITLE")) {
//					pstmt = con.prepareStatement(BOARD_LIST_T);
//				} else if(dto.getSearchCondition().equalsIgnoreCase("CONTENT")) {
//					pstmt = con.prepareStatement(BOARD_LIST_C);
//				}
//				
//				String searchKeyword ="%" + dto.getSearchKeyword() + "%";
//				
//				//pstmt.setString(1, dto.getSearchKeyword());
//				pstmt.setString(1, searchKeyword);
//				rs = pstmt.executeQuery();
//				
//				while(rs.next()) {
//					BoardDTO board = new BoardDTO();
//					
//					board = new BoardDTO();
//				    board.setSeq(rs.getInt("seq"));
//				    board.setTitle(rs.getString("title"));
//				    board.setWriter(rs.getString("writer"));
//				    board.setContent(rs.getString("content"));
//				    board.setRegDate(rs.getTimestamp("regDate"));
//				    board.setCount(rs.getInt("count"));	
//				    
//				    boardList.add(board);
//				}			
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//				MyDBConnection.close(rs, pstmt, con);
//			}
//		
//			return boardList;
//			
//		}
//		
		
		
		
}
