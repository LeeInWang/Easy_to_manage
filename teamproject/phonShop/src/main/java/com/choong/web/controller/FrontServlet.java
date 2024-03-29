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

import com.choong.biz.user.UserDAO;
import com.choong.biz.user.UserDTO;
import com.choong.biz.user.UserGradeDAO;
import com.choong.biz.user.UserGradeDTO;

@WebServlet("*.do7")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontServlet() {
        super();
       
    }


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//#1. 사용자 요청이 들어오면 요청 경로(path)를 추출
		final String URI = request.getRequestURI();
		final String PATH =	URI.substring(URI.lastIndexOf("/"));
		//getOrder.do3이 view에서 호출되면 @WebServlet("*.do3") 을 가진 서블렛으로 들어와 service를 실행시킨다. 
		// service에서 들어온 request와 response를 가지고 path를 찾아가는데 이때 찾아가는 path가 /getOrder.do3이다. 
		if(PATH.equals("/boardInsert.do7")) {  ///getOrder.do3을 찾아와서 값이 동일하면 orderList() 메소드를 request와 response를 가지고 실행시킨다.
			boardInsert(request,response);
		}else if(PATH.equals("/boardFaqInsert.do7")){
			boardFaqInsert(request, response);
		}else if(PATH.equals("/productInsert.do7")){
			productInsert(request, response);
		}else if(PATH.equals("/userInsertPage.do7")){
			userInsertPage(request, response);
			//#.회원가입페이지- 이동
		}else if(PATH.equals("/userGradeInsertPage.do7")){	
			userGradeInsertPage(request, response);  
			//#유저등급 페이지 - 이동	
		}
		
		
}
  //#유저회원가입 페이지 - 이동
  	private void userInsertPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		
  		System.out.println("관리자회원가입");
  		
  		
  		
  		HttpSession session = request.getSession();
  		
  		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/user/userManagementInsert.jsp");
  		dispatcher.forward(request, response);
  			
  	}
  	
  	//#유저등급 페이지 - 이동
  	private void userGradeInsertPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		
  		System.out.println("회원등급");
  		
  		
  		
  		HttpSession session = request.getSession();
  		
  		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/user/userGradeManagementInsert.jsp");
  		dispatcher.forward(request, response);
  			
  	}
  	
    protected void boardInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		
		// 저장한 값을 가지고 ("/phone/order/orderManagementList.jsp") 안에 있는 경로로 찾아간다.
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/board/boardInsert.jsp");
		dispatcher.forward(request, response);
	}
    
	protected void boardFaqInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	
			
			// 저장한 값을 가지고 ("/phone/order/orderManagementList.jsp") 안에 있는 경로로 찾아간다.
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/board/boardFaqInsert.jsp");
			dispatcher.forward(request, response);
		}

	protected void productInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 저장한 값을 가지고 ("/phone/order/orderManagementList.jsp") 안에 있는 경로로 찾아간다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/product/productManagementInsert.jsp");
		dispatcher.forward(request, response);
	}
}
