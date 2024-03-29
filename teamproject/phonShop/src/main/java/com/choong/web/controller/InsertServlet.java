package com.choong.web.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.choong.biz.board.BoardDAO;
import com.choong.biz.board.BoardDTO;
import com.choong.biz.board.BoardFaqDTO;
import com.choong.biz.product.ProductDAO;
import com.choong.biz.product.ProductDTO;
import com.choong.biz.user.UserDAO;
import com.choong.biz.user.UserDTO;
import com.choong.biz.user.UserGradeDAO;
import com.choong.biz.user.UserGradeDTO;

@WebServlet("*.do5")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertServlet() {
        super();

    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//#1. 사용자 요청이 들어오면 요청 경로(path)를 추출
				final String URI = request.getRequestURI();
				final String PATH =	URI.substring(URI.lastIndexOf("/"));
				
				
				//요청에 따라 처리하기
				if(PATH.equals("/boardInsert.do5")) {
					boardInsert(request, response);
				}else if(PATH.equals("/boardFaqInsert.do5")) {
					boardFaqInsert(request, response);
				}else if(PATH.equals("/getproductInsert.do5")) {
					productInsert(request, response);
				}else if(PATH.equals("/userInsert.do5")){
					userInsert(request, response);     
					//#.회원가입페이지- 입력
				}else if(PATH.equals("/userGradeInsert.do5")){
					userGradeInsert(request, response);
					//#유저등급 페이지 - 입력
				}
	}
		
		//#유저회원가입  - 입력
		private void userInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//관리자 회원 추가
			System.out.println("회원가입");
			
			
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
	  
	         System.out.println(userZipcode);
	         System.out.println(userAddress1);
	         System.out.println(userAddress2);
	               
	     
	         //체크
	         
	         if(id==null || id.equals("") || password1==null || password1.equals("") ||
	            password2==null || password2.equals("") || name==null || name.equals("") ||   
	            		userPhoneNumber1==null || userPhoneNumber1.equals("")|| userPhoneNumber2==null || userPhoneNumber2.equals("")||   
	            				userPhoneNumber3==null || userPhoneNumber3.equals("") ) {
	            
	            request.getSession().setAttribute("messageType","오류 메시지");
	            request.getSession().setAttribute("messageContent","필수 입력란은 모두 입력해주세요.");
	            
	            RequestDispatcher dispatcher = request.getRequestDispatcher("home.do");
	            dispatcher.forward(request, response);
	            
	            return;
	         }
	         

	         
	         //#회원 정보 DTO
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
	      
	         //현재시간 구하기
	         Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
	         //String을 Timestamp로 변환
	         	         
	         dto.setUserBirthdayYear(userBirthdayYear);
	         dto.setUserBirthdayMonth(userBirthdayMonth);
	         dto.setUserBirthdayDay(userBirthdayDay);
	         
	         dto.setUserJoinDate(timestamp2);
	         dto.setUserLastLoginDate(timestamp2);
	         dto.setUserTotalPurchaseCount(0);	//임시
	         dto.setUserAccessBlocked(0);		//임시
	         dto.setUserEmail1(userEmail1); 			
	         dto.setUserEmail2(userEmail2); 			
	       			
	         dto.setUserTotalPurchaseAmount(0);	//임시
	         dto.setUserNumber(123123);	//임의값
	         	        
	         
	         UserDAO user = new UserDAO();
	         int result = user.insertUser(dto); //리턴값
	         
	         if(result == 1) {
	            request.getSession().setAttribute("messageType","입력 성공 메시지");
	            request.getSession().setAttribute("messageContent","회원 가입 완료");
	            
	            RequestDispatcher dispatcher = request.getRequestDispatcher("home.do");
	            dispatcher.forward(request, response);
	            return;
	           
	         }else {
	            request.getSession().setAttribute("messageType","입력 오류 메시지");
	            request.getSession().setAttribute("messageContent","이미 존재하는 회원입니다.");
	            
	            RequestDispatcher dispatcher = request.getRequestDispatcher("home.do");
	            dispatcher.forward(request, response);
	            return;
	         }
				
		}
		
		//#유저등급  - 추가
		private void userGradeInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//등급추가
			System.out.println("회원등급추가");
			
			
			
			//입력(요청) 값 받아 오기
			String userGradeName = request.getParameter("userGradeName");
			
			//(콤마 변환)
			String str = request.getParameter("userGradeTotalPurchaseAmount");
			System.out.println(str);
			
			String[] splitTmp = str.split(",");
			String splitTmpResult = "";
			int userGradeTotalPurchaseAmount = 0;

			for(int i=0; i<splitTmp.length; i++){
			  System.out.println(i+"= "+splitTmp[i]);
			  splitTmpResult += splitTmp[i];
			}
			System.out.println("결과 : " + splitTmpResult );
			
			userGradeTotalPurchaseAmount = Integer.parseInt(splitTmpResult);
	         int userGradeDiscountRate = Integer.parseInt(request.getParameter("userGradeDiscountRate"));
	      
	         //체크
	         
	         if(userGradeName==null || userGradeName.equals("")){
	            
	            request.getSession().setAttribute("messageType","오류 메시지");
	            request.getSession().setAttribute("messageContent","필수 입력란은 모두 입력해주세요.");
	            
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/user/userManagementList.jsp");
	            dispatcher.forward(request, response);
	            
	         //   return;
	         }
	         

	         
	         UserGradeDTO dto = new UserGradeDTO();
	        
	         dto.setUserGradeName(userGradeName);
	         dto.setUserGradeTotalPurchaseAmount(userGradeTotalPurchaseAmount);
	         dto.setUserGradeDiscountRate(userGradeDiscountRate);
	         
	         UserGradeDAO userGrade = new UserGradeDAO();
	         int result = userGrade.userGradeinsert(dto);//리턴값
	         
	         if(result == 1) {
	            request.getSession().setAttribute("messageType","입력 성공 메시지");
	            request.getSession().setAttribute("messageContent","회원 가입 완료");
	            
	            RequestDispatcher dispatcher = request.getRequestDispatcher("getUserGrade.do3");
	            dispatcher.forward(request, response);
	            
	           
	         }else {
	            request.getSession().setAttribute("messageType","입력 오류 메시지");
	            request.getSession().setAttribute("messageContent","이미 존재하는 회원입니다.");
	            
	            RequestDispatcher dispatcher = request.getRequestDispatcher("getUserGrade.do3");
	            dispatcher.forward(request, response);
	         }
				
		}
	public void boardInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("글 추가 처리");
		HttpSession session = request.getSession();
		
		UserDTO user = (UserDTO) session.getAttribute("user");
		String boardUser = user.getUserId();
		String boardTitle = request.getParameter("boardTitle");
		String boardCategory = request.getParameter("boardCategory");
		String boardContent = request.getParameter("boardContent");
		String boardImage = request.getParameter("boardImage");
		
		
		System.out.println(boardUser);
		System.out.println(boardTitle);
		System.out.println(boardCategory);
		System.out.println(boardContent);
		
		BoardDTO dto = new BoardDTO();
		dto.setBoardTitle(boardTitle);
		dto.setBoardCategory(boardCategory);
		dto.setBoardUser(boardUser);
		dto.setBoardContent(boardContent);
		dto.setBoardImage(boardImage);
		


		BoardDAO dao = new BoardDAO();
		dao.insertBoard(dto);
		
		//추가한후에는 글 목록으로 이동
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("getBoard.do3");
		dispatcher.forward(request, response);
}
	public void boardFaqInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("글 추가 처리");
		HttpSession session = request.getSession();
		
		UserDTO user = (UserDTO) session.getAttribute("user");
		String boardFaqUser = user.getUserId();
		String boardFaqTitle = request.getParameter("boardFaqTitle");
		String boardFaqContent = request.getParameter("boardFaqContent");
		
		
		System.out.println(boardFaqUser);
		System.out.println(boardFaqTitle);
		System.out.println(boardFaqContent);
		
		BoardFaqDTO dto = new BoardFaqDTO();
		dto.setBoardFaqTitle(boardFaqTitle);
		dto.setBoardFaqUser(boardFaqUser);
		dto.setBoardFaqContent(boardFaqContent);
		


		BoardDAO dao = new BoardDAO();
		dao.insertBoardFaq(dto);
		
		//추가한후에는 글 목록으로 이동
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/getBoardFaq.do3");
		dispatcher.forward(request, response);
}
	
	public void productInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("글 추가 처리");
		
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

		
		

		System.out.println(dto);
		ProductDAO dao = new ProductDAO();
		dao.productInsert(dto);
		
		//추가한후에는 글 목록으로 이동
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("getProductList.do3");
		dispatcher.forward(request, response);
}
}
