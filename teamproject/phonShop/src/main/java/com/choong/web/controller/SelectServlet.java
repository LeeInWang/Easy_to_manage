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
import com.choong.biz.user.UserGradeDAO;


@WebServlet("*.do2")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelectServlet() {
        super();

    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String URI = request.getRequestURI();
		final String PATH =	URI.substring(URI.lastIndexOf("/"));
		
		if(PATH.equals("/orderUpdateInput.do2")) {
			orderSelect(request, response);
			
		}else if(PATH.equals("/boardSelect.do2")) {
			boardSelect(request, response);
		}else if(PATH.equals("/boardUpdate.do2")) {
			boardUpdate(request, response);
		}else if(PATH.equals("/boardFaqUpdate.do2")) {
			boardFaqUpdate(request, response);
		}else if(PATH.equals("/SelectUpdate.do2")) {
			productSelect(request, response);
		}else if(PATH.equals("/UserRegisterCheck.do2")) {
			userRegisterCheck(request, response);
			//#아이디 중복체크처리
		}else if(PATH.equals("/UserGradeRegisterCheck.do2")) {
			userGradeRegisterCheck(request, response);
			 //#등급명 중복체크처리
		}
		
	}
	
	//#아이디 중복체크처리
	private void userRegisterCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");  
	    UserDAO user = new UserDAO();
	    response.getWriter().write(user.registerUserCheck(id) + "");
	}
		
		 //#등급명 중복체크처리
	private void userGradeRegisterCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userGradeName = request.getParameter("userGradeName");
		UserGradeDAO userGrade = new UserGradeDAO();
		response.getWriter().write(userGrade.registerGradeCheck(userGradeName) + "");
	}

	protected void productSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String URI = request.getRequestURI();
		final String PATH =	URI.substring(URI.lastIndexOf("/"));
		
		System.out.println("업데이트");
		//타이틀 누르면 상세 조회되게
		//사용자 입력 정보
		String productCode = request.getParameter("productCode");

		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductCode(productCode);
		
        ProductDAO productDAO = new ProductDAO();
        productDTO = productDAO.getProduct(productCode); //리턴값
           
    
        request.setAttribute("product", productDTO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/product/productManagementUpdate.jsp");
		dispatcher.forward(request, response);	
}
	
	protected void orderSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String URI = request.getRequestURI();
		final String PATH =	URI.substring(URI.lastIndexOf("/"));
		
		System.out.println("글 상세 조회 처리");
		//타이틀 누르면 상세 조회되게
		
		//사용자 입력 정보
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		
		OrderDTO dto = new OrderDTO();
		dto.setOrderId(orderId);
		
		OrderDAO dao = new OrderDAO();
		OrderDTO order = dao.selectOrder(dto);
		
		System.out.println(orderId);
		System.out.println(order.getOrderDelivery());
		request.setAttribute("order", order);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/order/orderManagementUpdate.jsp");
		dispatcher.forward(request, response);
}
	protected void boardSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String URI = request.getRequestURI();
		final String PATH =	URI.substring(URI.lastIndexOf("/"));
		
		System.out.println("글 상세 조회 처리");
		//타이틀 누르면 상세 조회되게
		
		//사용자 입력 정보
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		
		BoardDTO dto = new BoardDTO();
		dto.setBoardNumber(boardNumber);
		
		BoardDAO dao = new BoardDAO();
		BoardDTO board = dao.selectBoard(dto);
		
		System.out.println(board);
		request.setAttribute("board", board);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/board/boardSelect.jsp");
		dispatcher.forward(request, response);
}
	protected void boardUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String URI = request.getRequestURI();
		final String PATH =	URI.substring(URI.lastIndexOf("/"));
		
		System.out.println("글 상세 조회 처리");
		//타이틀 누르면 상세 조회되게
		
		//사용자 입력 정보
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		
		BoardDTO dto = new BoardDTO();
		dto.setBoardNumber(boardNumber);
		
		BoardDAO dao = new BoardDAO();
		BoardDTO board = dao.selectBoard(dto);
		
		System.out.println(board);
		request.setAttribute("board", board);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/board/boardUpdate.jsp");
		dispatcher.forward(request, response);
}
	protected void boardFaqUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String URI = request.getRequestURI();
		final String PATH =	URI.substring(URI.lastIndexOf("/"));
		
		System.out.println("글 상세 조회 처리");
		//타이틀 누르면 상세 조회되게
		
		//사용자 입력 정보
		int boardFaqNumber = Integer.parseInt(request.getParameter("boardFaqNumber"));
		
		BoardFaqDTO dto = new BoardFaqDTO();
		dto.setBoardFaqNumber(boardFaqNumber);
		
		System.out.println(boardFaqNumber);
		BoardDAO dao = new BoardDAO();
		BoardFaqDTO board = dao.selectFaqBoard(dto);
		
		System.out.println(board);
		request.setAttribute("board", board);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/board/boardFaqUpdate.jsp");
		dispatcher.forward(request, response);
}
}
