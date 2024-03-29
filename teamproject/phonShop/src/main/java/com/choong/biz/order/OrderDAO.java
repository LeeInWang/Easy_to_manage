package com.choong.biz.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnection.MyDBConnection;



public class OrderDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//orderId, orderTrackingNumber, orderUserName, orderProductName, orderDelivery, orderDate
	//orderId, orderTrackingNumber, orderUserName, orderProductName, orderTotalAmount, orderPaymentType, orderDate
	private String ORDER_UPDATE= "update orderManagement set orderDelivery=? where orderId=?";
	private String ORDER_LIST_T= "select * from orderManagement";
	private String ORDER_LIST_D_PACKING= "select * from orderManagement where orderDelivery like ?";
	private String ORDER_LIST_D_ON= "select * from orderManagement where orderDelivery like ?";
	private String ORDER_LIST_D_OVER= "select * from orderManagement where orderDelivery like ?";	
	private String ORDER_DELETE= "delete from orderManagement where orderId=?";
	private String ORDER_SELECT = "select * from orderManagement where orderId=?";
	
	
	//주문 상세 조회
	public OrderDTO selectOrder(OrderDTO dto) {
		OrderDTO order = null;
		
		//db연결 - sql전달 -> 결과 얻어오기
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(ORDER_SELECT); // "select * from users where id=?"
			//매개변수에 값 담기 - ? 
			pstmt.setInt(1, dto.getOrderId());
			//sql 실행
			rs = pstmt.executeQuery(); //select, executeUpdate() - insert, delete, update
			//결과가 있으면
			if(rs.next()) {
				order = new OrderDTO();
				order.setOrderId(rs.getInt("orderId"));
				order.setOrderTrackingNumber(rs.getString("orderTrackingNumber"));
				order.setOrderUserName(rs.getString("orderUserName"));
				order.setOrderProductName(rs.getString("orderProductName"));
				order.setOrderTotalAmount(rs.getInt("orderTotalAmount"));
				order.setOrderPaymentType(rs.getString("orderPaymentType"));
				order.setOrderDate(rs.getTimestamp("orderDate"));
				order.setOrderProductPrice(rs.getInt("orderProductPrice"));
				order.setOrderProductCount(rs.getInt("orderProductCount"));
				order.setOrderDeliveryCost(rs.getInt("orderDeliveryCost"));
				order.setOrderRecipientName(rs.getString("orderRecipientName"));
				order.setOrderPhoneNumber(rs.getString("orderPhoneNumber"));
				order.setOrderDeliveryCompanyName(rs.getString("orderDeliveryCompanyName"));
				order.setOrderRecipientAddress(rs.getString("orderRecipientAddress"));
				order.setOrderDeliveryRequest(rs.getString("orderDeliveryRequest"));
				order.setOrderDelivery(rs.getString("orderDelivery"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyDBConnection.close(rs, pstmt, con);
		}
		
		//전달- 
		return order;
	}
	//글 수정
		//private String BOARD_UPDATE ="update board set title=?, content=? where seq=?";
		public void updateOrder(OrderDTO dto) {
			
			try {
				con = MyDBConnection.getConnection();
				pstmt = con.prepareStatement(ORDER_UPDATE);
				
				pstmt.setString(1,dto.getOrderDelivery());
				pstmt.setInt(2,dto.getOrderId());

				
				
				
				
				pstmt.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				MyDBConnection.close(rs, pstmt, con);
			}
		
		}
		
		// 글 삭제
		
		public void orderDelete(OrderDTO dto) {
			
			try {
				con = MyDBConnection.getConnection();
				pstmt = con.prepareStatement(ORDER_DELETE);
				pstmt.setInt(1, dto.getOrderId());
				
				pstmt.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				MyDBConnection.close(rs, pstmt, con);
			}
		
		}
		
		//dao.orderList로 호출되면 이 메소드를 실행한다. 
		public List<OrderDTO> orderList(){
			// 가져온 값을 저장하기 위한 List객체 orderList를 ArrayList로 설정한다.
			List<OrderDTO> orderList = new ArrayList<>();
			
			try {
				con = MyDBConnection.getConnection(); // DB와 연결
				pstmt = con.prepareStatement(ORDER_LIST_T); // SQL문 전달
				rs = pstmt.executeQuery(); // 값을 셋팅 // List select executeQuery, 나머지 executeUpdate
				
				while(rs.next()) { //rs.next(다음 값이 없을떄까지 반복해서 실행한다) while(db에서 불러올 값이 없을떄까지 반복한다.)
					OrderDTO order = new OrderDTO(); // orderDTO객체에 값을 저장하기 위한 객체 생성
						
					// OrderDTO 안에 값을 넣어줘야 하는데 private로 설정되어 있어 set으로 넘겨줘야 한다. 
					// rs.getInt(db에서 받아올 엔티티명) :  (get + 타입명) 
					order.setOrderId(rs.getInt("orderId"));
					order.setOrderTrackingNumber(rs.getString("orderTrackingNumber"));
					order.setOrderUserName(rs.getString("orderUserName"));
					order.setOrderProductName(rs.getString("orderProductName"));
					order.setOrderTotalAmount(rs.getInt("orderTotalAmount"));
					order.setOrderPaymentType(rs.getString("orderPaymentType"));
					order.setOrderDate(rs.getTimestamp("orderDate"));
					order.setOrderProductPrice(rs.getInt("orderProductPrice"));
					order.setOrderProductCount(rs.getInt("orderProductCount"));
					order.setOrderDeliveryCost(rs.getInt("orderDeliveryCost"));
					order.setOrderRecipientName(rs.getString("orderRecipientName"));
					order.setOrderPhoneNumber(rs.getString("orderPhoneNumber"));
					order.setOrderDeliveryCompanyName(rs.getString("orderDeliveryCompanyName"));
					order.setOrderRecipientAddress(rs.getString("orderRecipientAddress"));
					order.setOrderDeliveryRequest(rs.getString("orderDeliveryRequest"));
					
				    orderList.add(order); // 받아온 값들을 orderList 객체에 저장한다. (한 줄씩 저장되며 모든 필드를 저장함)
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				MyDBConnection.close(rs, pstmt, con);
			}
			return orderList;	// 저장된 값들을 다시 SelectListServlet 안에있는 List<OrderDTO> orderList = dao.orderList();로 리턴한다.
		}
		
		
		public List<OrderDTO> orderListPacking(){
			List<OrderDTO> orderList = new ArrayList<>();
			
			try {
				con = MyDBConnection.getConnection();
				pstmt = con.prepareStatement(ORDER_LIST_D_PACKING);
				pstmt.setString(1, "%대기");
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					OrderDTO order = new OrderDTO();
					
					order = new OrderDTO();
					
					
					order.setOrderId(rs.getInt("orderId"));
					order.setOrderTrackingNumber(rs.getString("orderTrackingNumber"));
					order.setOrderUserName(rs.getString("orderUserName"));
					order.setOrderProductName(rs.getString("orderProductName"));
					order.setOrderDelivery(rs.getString("orderDelivery"));
					order.setOrderDate(rs.getTimestamp("orderDate"));

				    orderList.add(order);
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				MyDBConnection.close(rs, pstmt, con);
			}
			return orderList;	
		}
		
		
		public List<OrderDTO> orderListOn(){
			List<OrderDTO> orderList = new ArrayList<>();
			
			try {
				con = MyDBConnection.getConnection();
				pstmt = con.prepareStatement(ORDER_LIST_D_ON);
				pstmt.setString(1, "%중");
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					OrderDTO order = new OrderDTO();
					
					order = new OrderDTO();
					
					
					order.setOrderId(rs.getInt("orderId"));
					order.setOrderTrackingNumber(rs.getString("orderTrackingNumber"));
					order.setOrderUserName(rs.getString("orderUserName"));
					order.setOrderProductName(rs.getString("orderProductName"));
					order.setOrderDelivery(rs.getString("orderDelivery"));
					order.setOrderDate(rs.getTimestamp("orderDate"));

				    orderList.add(order);
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				MyDBConnection.close(rs, pstmt, con);
			}
			return orderList;	
		}
		
		public List<OrderDTO> orderListOver(){
			List<OrderDTO> orderList = new ArrayList<>();
			
			try {
				con = MyDBConnection.getConnection();
				pstmt = con.prepareStatement(ORDER_LIST_D_OVER);
				pstmt.setString(1, "%완료");
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					OrderDTO order = new OrderDTO();
					
					order = new OrderDTO();
					
					
					order.setOrderId(rs.getInt("orderId"));
					order.setOrderTrackingNumber(rs.getString("orderTrackingNumber"));
					order.setOrderUserName(rs.getString("orderUserName"));
					order.setOrderProductName(rs.getString("orderProductName"));
					order.setOrderDelivery(rs.getString("orderDelivery"));
					order.setOrderDate(rs.getTimestamp("orderDate"));

				    orderList.add(order);
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				MyDBConnection.close(rs, pstmt, con);
			}
			return orderList;	
		}
}
