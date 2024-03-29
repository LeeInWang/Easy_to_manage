package com.choong.web.controller;

import java.io.IOException;

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
import com.choong.biz.order.OrderDAO;
import com.choong.biz.order.OrderDTO;
import com.choong.biz.product.ProductDAO;
import com.choong.biz.product.ProductDTO;
import com.choong.biz.user.UserDAO;
import com.choong.biz.user.UserDTO;
import com.choong.biz.user.UserGradeDAO;
import com.choong.biz.user.UserGradeDTO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("*.do4")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//#1. 사용자 요청이 들어오면 요청 경로(path)를 추출
		final String URI = request.getRequestURI();
		final String PATH =	URI.substring(URI.lastIndexOf("/"));
		if(PATH.equals("/orderDelete.do4")) {
			orderDelete(request,response);
			
			
		}else if(PATH.equals("/boardDelete.do4")) {
			boardDelete(request,response);
		}else if(PATH.equals("/boardFaqDelete.do4")) {
			boardFaqDelete(request,response);
		}else if(PATH.equals("/productDelete.do4")) {
	         productDelete(request,response);
	     }else if(PATH.equals("/userDelete.do4")) {
			userDelete(request,response);	
			//#회원삭제
	     }else if(PATH.equals("/userGradeDelete.do4")) {
	    	 userGradeDelete(request,response);
	    	//#회원등급삭제
		}

		
	}
	
	//#회원삭제
		private void userDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			System.out.println("회원삭제");
			
			String id = request.getParameter("userId");
			
			UserDTO dto = new UserDTO();
	        dto.setUserId(id);
	        
	        UserDAO user = new UserDAO();
	        user.deleteUser(id); //리턴값
	    

			HttpSession session = request.getSession();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.do");
			dispatcher.forward(request, response);
			
		}
		
		//#회원등급삭제
		private void userGradeDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			System.out.println("회원등급삭제");
			
			String userGradeNumber = request.getParameter("userGradeNumber");
			
			UserGradeDTO dto = new UserGradeDTO();
		    dto.setUserGradeNumber(Integer.parseInt(userGradeNumber));
		    
		    UserGradeDAO userGradeDAO = new UserGradeDAO();
		    userGradeDAO.deleteUser(userGradeNumber); //리턴값
		
		
			HttpSession session = request.getSession();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/getUserGrade.do3");
			dispatcher.forward(request, response);
				
		}
	 // 상품삭제 메소드 productDelete
	   protected void productDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      System.out.println("상품 삭제 처리");
	      String productCode = request.getParameter("productCode");
	      
	      // 2. DB 연동 처리
	      ProductDTO dto = new ProductDTO();
	      dto.setProductCode(productCode);
	      
	      ProductDAO dao = new ProductDAO();
	      dao.productDelete(productCode);
	      
	      // 3. 페이지 네비게이션
	      RequestDispatcher dispatcher = 
	         request.getRequestDispatcher("getProductList.do3");
	      dispatcher.forward(request, response);

	   }

	protected void orderDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("글 삭제 처리");
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		
		
		// 2. DB 연동 처리
		OrderDTO dto = new OrderDTO();
		dto.setOrderId(orderId);
		
		OrderDAO boardDAO = new OrderDAO();
		boardDAO.orderDelete(dto);
		
		// 3. 페이지 네비게이션
		RequestDispatcher dispatcher = 
			request.getRequestDispatcher("/getOrder.do3");
		dispatcher.forward(request, response);

	}
	
	protected void boardDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("글 삭제 처리");
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		
		
		// 2. DB 연동 처리
		BoardDTO dto = new BoardDTO();
		dto.setBoardNumber(boardNumber);
		
		BoardDAO BoardDAO = new BoardDAO();
		BoardDAO.deleteBoard(dto);
		
		// 3. 페이지 네비게이션
		RequestDispatcher dispatcher = 
			request.getRequestDispatcher("/getBoard.do3");
		dispatcher.forward(request, response);

	}
	
	protected void boardFaqDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("글 삭제 처리");
	    String[] boardNumberStrings = request.getParameterValues("boardFaqNumber");
	    
	    if (boardNumberStrings != null) {
	        int[] boardNumbers = new int[boardNumberStrings.length];
	        for (int i = 0; i < boardNumberStrings.length; i++) {
	            boardNumbers[i] = Integer.parseInt(boardNumberStrings[i]);
	        }
	        
	        // 2. DB 연동 처리
	        BoardDAO boardDAO = new BoardDAO();
	        for (int boardFaqNumber : boardNumbers) {
	            BoardFaqDTO dto = new BoardFaqDTO();
	            dto.setBoardFaqNumber(boardFaqNumber);
	            boardDAO.deleteBoardFaq(dto);
	        }
	    }
	    
	    // 3. 페이지 네비게이션
	    RequestDispatcher dispatcher = 
	        request.getRequestDispatcher("/getBoardFaq.do3");
	    dispatcher.forward(request, response);
	}
}
