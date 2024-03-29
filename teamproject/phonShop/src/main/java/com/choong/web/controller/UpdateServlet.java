package com.choong.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.choong.biz.board.BoardDAO;
import com.choong.biz.board.BoardDTO;
import com.choong.biz.board.BoardFaqDTO;
import com.choong.biz.order.OrderDAO;
import com.choong.biz.order.OrderDTO;
import com.choong.biz.product.ProductDAO;
import com.choong.biz.product.ProductDTO;
import com.choong.biz.user.UserDAO;
import com.choong.biz.user.UserDTO;
import com.choong.biz.user.UserGradeDAO;
import com.choong.biz.user.UserGradeDTO;


@WebServlet("*.do6")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//먼저 한글 필터 처리 부터 하기   

    public UpdateServlet() {
        super();
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//#1. 사용자 요청이 들어오면 요청 경로(path)를 추출
		final String URI = request.getRequestURI();
		final String PATH =	URI.substring(URI.lastIndexOf("/"));
		
		//요청에 따라 처리하기
		if(PATH.equals("/orderUpdate.do6")) {
			orderUpdate(request, response);
		}else if(PATH.equals("/boardUpdate.do6")) {
			boardUpdate(request, response);
		}else if(PATH.equals("/boardFaqUpdate.do6")) {
			boardFaqUpdate(request, response);
		}else if(PATH.equals("/getproductManagement.do6")) {
			productUpdate(request, response);
		}else if(PATH.equals("/userUpdate.do6")) {
			 userUpdate(request,response);
		 //#회원 업데이트 실행
		 }else if(PATH.equals("/userUpdate2.do6")) {	
			 userUpdate2(request,response);
		 //#등급명 업데이트 페이지 이동	 
		 }else if(PATH.equals("/userGradeUpdate.do6")) {
			 userGradeUpdate(request,response);	
		 //#등급명 업데이트 실행	 
		 }else if(PATH.equals("/userGradeUpdate2.do6")) {
			 userGradeUpdate2(request,response);
		 }else if(PATH.equals("/userGradeCountUpdate.do6")) {
			 userGradeCountUpdate(request,response);
		 }
		 
	}
	 //#회원 업데이트 페이지 이동
		private void userUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("업데이트");
			//타이틀 누르면 상세 조회되게
			//사용자 입력 정보
			String id = request.getParameter("userId");

			UserDTO userDTO = new UserDTO();
			userDTO.setUserId(id);
			
	        UserDAO userDAO = new UserDAO();
	        UserDTO userselect = userDAO.getUser(id); //리턴값
	           
	    
	        request.setAttribute("userselect", userselect);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/user/userManagementUpdate.jsp");
			dispatcher.forward(request, response);	
		}
		
		 //#회원 업데이트 실행
		private void userUpdate2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("업데이트2");
			//타이틀 누르면 상세 조회되게
			//입력(요청) 값 받아 오기
			
			
			//입력(요청) 값 받아 오기
			String id = request.getParameter("userId");
	        String password1 = request.getParameter("userPwd1");
	        String password2 = request.getParameter("userPwd2");
	        String name =  request.getParameter("userName");
	        
	        String userPhoneNumber1 =  request.getParameter("userPhoneNumber1");
	        String userPhoneNumber2 =  request.getParameter("userPhoneNumber2");
	        String userPhoneNumber3 =  request.getParameter("userPhoneNumber3");
	        
	        String userZipcode = request.getParameter("userZipcode");
	        String userAddress1 =request.getParameter("userAddress1");
	        String userAddress2 =request.getParameter("userAddress2");
	        
	        String userBirthdayYear =  request.getParameter("userBirthdayYear");
	        String userBirthdayMonth =  request.getParameter("userBirthdayMonth");
	        String userBirthdayDay =  request.getParameter("userBirthdayDay");
	        
	        String userEmail1 =  request.getParameter("userEmail1");
	        String userEmail2 =  request.getParameter("userEmail2");
	 
	    
	    
	        //체크
	        
	        if(id==null || id.equals("") || password1==null || password1.equals("") ||
	           password2==null || password2.equals("") || name==null || name.equals("") ||   
	           		userPhoneNumber1==null || userPhoneNumber1.equals("")|| userPhoneNumber2==null || userPhoneNumber2.equals("")||   
	           				userPhoneNumber3==null || userPhoneNumber3.equals("") ) {
	           
	           request.getSession().setAttribute("messageType","오류 메시지");
	           request.getSession().setAttribute("messageContent","필수 입력란은 모두 입력해주세요.");
	           
	           RequestDispatcher dispatcher = request.getRequestDispatcher("/");
	           dispatcher.forward(request, response);
	           
	           return;
	        }
	         

	         
	         UserDTO dto = new UserDTO();
	         
	         
	         dto.setUserId(id);
	         dto.setUserPassword(password1);
	         dto.setUserName(name);
	         dto.setUserZipcode(userZipcode);
	         dto.setUserAddress1(userAddress1);
	         dto.setUserAddress2(userAddress2);
	         
	         
	         dto.setUserPhoneNumber1(userPhoneNumber1);
	         dto.setUserPhoneNumber2(userPhoneNumber2);
	         dto.setUserPhoneNumber3(userPhoneNumber3);
	         dto.setUserGrade("ADMIN"); //관리자계정
	      
	         
		       
	         dto.setUserBirthdayYear(userBirthdayYear);    
	         dto.setUserBirthdayMonth(userBirthdayMonth);    
	         dto.setUserBirthdayDay(userBirthdayDay);    
	         dto.setUserEmail1(userEmail1); 
	         dto.setUserEmail2(userEmail2); 
	         
	         dto.setUserTotalPurchaseAmount(1);
	         dto.setUserNumber(123123);	//정보받기
	         	        
	         
	         UserDAO user = new UserDAO();
	         user.updateUser(dto); //리턴값
	         
	         
	          RequestDispatcher dispatcher = request.getRequestDispatcher("/home.do");
	          dispatcher.forward(request, response);
		}
		
		
		 //#등급명 업데이트 페이지 이동
		private void userGradeUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("업데이트");
			//타이틀 누르면 상세 조회되게
			//사용자 입력 정보
			String id = request.getParameter("userGradeNumber");

			System.out.println("업데이트 + " + id);
			
			UserGradeDTO userGradeDTO = new UserGradeDTO();
			userGradeDTO.setUserGradeNumber(Integer.parseInt(id));
			
	        UserGradeDAO userGradeDAO = new UserGradeDAO();
	        UserGradeDTO userGradeSelect = userGradeDAO.getUserGrade(id); //리턴값
	    
	        request.setAttribute("userGradeSelect", userGradeSelect);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/user/userGradeManagementUpdate.jsp");
			dispatcher.forward(request, response);	
		}
		
		 //#등급명 업데이트 실행
		private void userGradeUpdate2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("업데이트2");
			//타이틀 누르면 상세 조회되게
			//입력(요청) 값 받아 오기
			
			 String userGradeNumber = request.getParameter("userGradeNumber");
	         String userGradeName = request.getParameter("userGradeName");
	         String userGradeTotalPurchaseAmount = request.getParameter("userGradeTotalPurchaseAmount");
	         String userGradeDiscountRate =  request.getParameter("userGradeDiscountRate");
	      
	         //체크
	         
	         if(userGradeName==null || userGradeName.equals("")){
	            
	            request.getSession().setAttribute("messageType","오류 메시지");
	            request.getSession().setAttribute("messageContent","필수 입력란은 모두 입력해주세요.");
	            
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/");
	            dispatcher.forward(request, response);
	            
	         //   return;
	         }
	         

	         
	         UserGradeDTO dto = new UserGradeDTO();
	         
	         dto.setUserGradeNumber(Integer.parseInt(userGradeNumber));
	         dto.setUserGradeName(userGradeName);
	         dto.setUserGradeTotalPurchaseAmount(Integer.parseInt(userGradeTotalPurchaseAmount));
	         dto.setUserGradeDiscountRate(Integer.parseInt(userGradeDiscountRate));
	    
	         
	         UserGradeDAO userGrade = new UserGradeDAO();
	         userGrade.updateUserGrade(dto); //리턴값
	         
	         
	          RequestDispatcher dispatcher = request.getRequestDispatcher("/getUserGrade.do3");
	          dispatcher.forward(request, response);
	            
		}
		
		//등급에 따른 회원수 분류
		private void userGradeCountUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("등급에 관한 회원수 리셋");
			
			UserGradeDAO userGradeDAO = new UserGradeDAO();
			userGradeDAO.updateUserGradeCount();
	         
	         
	          RequestDispatcher dispatcher = request.getRequestDispatcher("/getUserGrade.do3");
	          dispatcher.forward(request, response);
	            
		}
	
	public void productUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		 String productCode = request.getParameter("productCode");
	      String productDisplayStatus = request.getParameter("productDisplayStatus");
	      int productSalePrice = Integer.parseInt(request.getParameter("productSalePrice"));
	      int productInventoryQuantity = Integer.parseInt(request.getParameter("productInventoryQuantity"));
	      String productName = request.getParameter("productName");
	      int productSaleCount = Integer.parseInt(request.getParameter("productSaleCount"));
	      int productDiscountStatus = Integer.parseInt(request.getParameter("productDiscountStatus"));
	      int productOriginalPrice = Integer.parseInt(request.getParameter("productOriginalPrice"));
	      int productCostPrice = Integer.parseInt(request.getParameter("productCostPrice"));
	      String productPaymentType = request.getParameter("productPaymentType");
	      String productContent = request.getParameter("productContent");
	      String productImage = request.getParameter("productImage");
	      String productHashtags = request.getParameter("productHashtags");
	      String mainCategory = request.getParameter("mainCategory");
	      String subCategory = request.getParameter("subCategory");
	      int productBest = Integer.parseInt(request.getParameter("productBest"));

		
     
       //체크
       
       if(productName==null || productName.equals("")){
          
          request.getSession().setAttribute("messageType","오류 메시지");
          request.getSession().setAttribute("messageContent","필수 입력란은 모두 입력해주세요.");
          
          RequestDispatcher dispatcher = request.getRequestDispatcher("/");
          dispatcher.forward(request, response);
          
       //   return;
       }
       ProductDTO dto = new ProductDTO();
       dto.setProductCode(productCode);
       dto.setProductDisplayStatus(productDisplayStatus);
       dto.setProductSalePrice(productSalePrice);
       dto.setProductInventoryQuantity(productInventoryQuantity);
       dto.setProductName(productName);
       dto.setProductSaleCount(productSaleCount);
       dto.setProductDiscountStatus(productDiscountStatus);
       dto.setProductOriginalPrice(productOriginalPrice);
       dto.setProductCostPrice(productCostPrice);
       dto.setProductPaymentType(productPaymentType);
       dto.setProductContent(productContent);
       dto.setProductImage(productImage);
       dto.setProductHashtags(productHashtags);
       dto.setMainCategory(mainCategory);
       dto.setSubCategory(subCategory);
       dto.setProductBest(productBest);

  
       
       ProductDAO productDAO = new ProductDAO();
       productDAO.productUpdate(dto); //리턴값
       
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("/getProductList.do3");
        dispatcher.forward(request, response);
        
        
        
        
}
		public void orderUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("글 수정 처리");
			
			int orderId = Integer.parseInt(request.getParameter("orderId"));  
			String orderDelivery = request.getParameter("orderDelivery");
			
			OrderDTO dto = new OrderDTO();
			dto.setOrderId(orderId);
			dto.setOrderDelivery(orderDelivery);

			
			System.out.println(dto.getOrderId());
			System.out.println(dto.getOrderDelivery());
			
			OrderDAO dao = new OrderDAO();
			dao.updateOrder(dto);
			
			//업데이트 후에는 글 목록으로 이동
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("getOrder.do3");
			dispatcher.forward(request, response);
	}
	
		public void boardUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("글 수정 처리");
			
			int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));  
			String boardTitle = request.getParameter("boardTitle");
			String boardCategory = request.getParameter("boardCategory");
			String boardContent = request.getParameter("boardContent");
			String boardImage = request.getParameter("boardImage");

			
			
			BoardDTO dto = new BoardDTO();
			dto.setBoardNumber(boardNumber);
			dto.setBoardTitle(boardTitle);
			dto.setBoardCategory(boardCategory);
			dto.setBoardContent(boardContent);
			dto.setBoardImage(boardImage);
		

			
			
			BoardDAO dao = new BoardDAO();
			dao.updateBoard(dto);
			
			//업데이트 후에는 글 목록으로 이동
			System.out.println(dto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("getBoard.do3");
			dispatcher.forward(request, response);
	}
		
		public void boardFaqUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("글 수정 처리");
			
			int boardFaqNumber = Integer.parseInt(request.getParameter("boardFaqNumber"));  
			String boardFaqTitle = request.getParameter("boardFaqTitle");
			String boardFaqContent = request.getParameter("boardFaqContent");

			
			
			BoardFaqDTO dto = new BoardFaqDTO();
			dto.setBoardFaqNumber(boardFaqNumber);
			dto.setBoardFaqTitle(boardFaqTitle);
			dto.setBoardFaqContent(boardFaqContent);
		
			System.out.println(boardFaqNumber);
			
			
			BoardDAO dao = new BoardDAO();
			dao.updateBoardFaq(dto);
			
			//업데이트 후에는 글 목록으로 이동
			System.out.println(dto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("getBoardFaq.do3");
			dispatcher.forward(request, response);
	}
		
		
}



