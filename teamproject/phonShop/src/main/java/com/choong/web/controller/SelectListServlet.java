package com.choong.web.controller;

import java.io.IOException;
import java.util.List;

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
import com.choong.biz.user.UserGradeDAO;
import com.choong.biz.user.UserGradeDTO;





@WebServlet("*.do3")
public class SelectListServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   //먼저 한글 필터 처리 부터 하기   

    public SelectListServlet() {
        super();
      
    }

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //#1. 사용자 요청이 들어오면 요청 경로(path)를 추출
      final String URI = request.getRequestURI();
      final String PATH =   URI.substring(URI.lastIndexOf("/"));
      //getOrder.do3이 view에서 호출되면 @WebServlet("*.do3") 을 가진 서블렛으로 들어와 service를 실행시킨다. 
      // service에서 들어온 request와 response를 가지고 path를 찾아가는데 이때 찾아가는 path가 /getOrder.do3이다. 
      if(PATH.equals("/getOrder.do3")) {  ///getOrder.do3을 찾아와서 값이 동일하면 orderList() 메소드를 request와 response를 가지고 실행시킨다.
         orderList(request,response);
      }else if(PATH.equals("/getOrderDel.do3")){
         orderList1(request, response);
      }else if(PATH.equals("/getOrderDel2.do3")){
         orderList2(request, response);
      }else if(PATH.equals("/getOrderDel3.do3")){
         orderList3(request, response);
      }else if(PATH.equals("/getBoard.do3")) {
         boardList(request, response);
      }else if(PATH.equals("/getBoardFaq.do3")) {
         boardListFaq(request, response);
      }else if(PATH.equals("/getProductList.do3")) {
         productList(request, response);
      }else if(PATH.equals("/getUserGrade.do3")) {
    	 getUserGrade(request,response);
      }
         
      
      
}
   
 //#유저등급리스트출력
 	private void getUserGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 		System.out.println("유저등급리스트출력");
 		
 		
 		// 2. DB 연동 처리
 		
 		UserGradeDAO dao = new UserGradeDAO();
 		List<UserGradeDTO> userGradeList = dao.getUserGradeList();
 		
 		// 3. 화면 이동
 		request.setAttribute("userGradeList", userGradeList);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/user/userGradeManagementList.jsp");
 		dispatcher.forward(request, response);	
 			
 	}
   protected void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("글 상세 조회 처리");
      
      // 세션에 검색 관련 정보를 저장한다. 
      HttpSession session = request.getSession();


      // 2. DB 연동 처리
      ProductDTO dto = new ProductDTO();
   
      
      ProductDAO dao = new ProductDAO();
      List<ProductDTO> productList = dao.getProductList();
      
      //삭제예정
   
      
      
      
      // 3. 화면 이동
      request.setAttribute("productList", productList);
      //RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/user/userManagementList.jsp");
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/phone/product/productManagementList.jsp");
      dispatcher.forward(request, response);   
      
   }
   
   protected void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("글 상세 조회 처리");

      //db연동 처리
      OrderDTO dto = new OrderDTO(); 
         
      //db 데이터 가져오기
      OrderDAO dao = new OrderDAO();
      
      // 모든 값을 가져와야하니 List객체를 생성하고 dao 안에있는 orderList 메소드로 들어가 값을 가져와서 orderList에 저장한다.
      List<OrderDTO> orderList = dao.orderList();  
      //orderList.add(order);를 넘겨 받음
      
      //화면 이동
      // orderList객체를 view에 전달하는데 이름은 orderList로 전달한다(이름 부분 마음대로 설정 가능 " " 안에있는 부분)
      request.setAttribute("orderList", orderList); 
      // 저장한 값을 가지고 ("/phone/order/orderManagementList.jsp") 안에 있는 경로로 찾아간다.
      request.getRequestDispatcher("/WEB-INF/phone/order/orderManagementList.jsp").forward(request, response); 
   }
            
            

       protected void orderList1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //#1. 사용자 요청이 들어오면 요청 경로(path)를 추출
         final String URI = request.getRequestURI();
         final String PATH =   URI.substring(URI.lastIndexOf("/"));
            
               //db연동 처리
               OrderDTO dto = new OrderDTO();
                  
               //db 데이터 가져오기
               OrderDAO dao = new OrderDAO();
                           
               List<OrderDTO> orderList = dao.orderListPacking();
               //boardList.add(board);를 넘겨 받음
               
               //화면 이동
               request.setAttribute("orderList", orderList);
               request.getRequestDispatcher("/WEB-INF/phone/order/orderManagement1.jsp").forward(request, response);
               
         
            
       }
         
      protected void orderList2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         final String URI = request.getRequestURI();
         final String PATH =   URI.substring(URI.lastIndexOf("/"));
         
          if(PATH.equals("/getOrderDel2.do3")) {
   
               //db연동 처리
               OrderDTO dto = new OrderDTO();
                  
               //db 데이터 가져오기
               OrderDAO dao = new OrderDAO();
                           
               List<OrderDTO> orderList = dao.orderListOn();
               //boardList.add(board);를 넘겨 받음
               
               //화면 이동
               request.setAttribute("orderList", orderList);
               request.getRequestDispatcher("/WEB-INF/phone/order/orderManagement2.jsp").forward(request, response);
            }
       
      }
      
      protected void orderList3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         final String URI = request.getRequestURI();
         final String PATH =   URI.substring(URI.lastIndexOf("/"));
         
          if(PATH.equals("/getOrderDel3.do3")) {

               //db연동 처리
               OrderDTO dto = new OrderDTO();
                  
               //db 데이터 가져오기
               OrderDAO dao = new OrderDAO();
                           
               List<OrderDTO> orderList = dao.orderListOver();
               //boardList.add(board);를 넘겨 받음
               
               //화면 이동
               request.setAttribute("orderList", orderList);
               request.getRequestDispatcher("/WEB-INF/phone/order/orderManagement3.jsp").forward(request, response);
            }
      }
      
      protected void boardList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         System.out.println("글 상세 조회 처리");

         //db연동 처리
         BoardDTO dto = new BoardDTO(); 
            
         //db 데이터 가져오기
         BoardDAO dao = new BoardDAO();
         
         // 모든 값을 가져와야하니 List객체를 생성하고 dao 안에있는 orderList 메소드로 들어가 값을 가져와서 orderList에 저장한다.
         List<BoardDTO> boardList = dao.boardList();  
         //orderList.add(order);를 넘겨 받음
         
         //화면 이동
         // orderList객체를 view에 전달하는데 이름은 orderList로 전달한다(이름 부분 마음대로 설정 가능 " " 안에있는 부분)
         request.setAttribute("boardList", boardList); 
         // 저장한 값을 가지고 ("/phone/order/orderManagementList.jsp") 안에 있는 경로로 찾아간다.
         request.getRequestDispatcher("/WEB-INF/phone/board/board.jsp").forward(request, response); 
      }
   
      protected void boardListFaq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         System.out.println("글 상세 조회 처리");

         //db연동 처리
         BoardFaqDTO dto = new BoardFaqDTO(); 
            
         //db 데이터 가져오기
         BoardDAO dao = new BoardDAO();
         
         // 모든 값을 가져와야하니 List객체를 생성하고 dao 안에있는 orderList 메소드로 들어가 값을 가져와서 orderList에 저장한다.
         List<BoardFaqDTO> boardFaqList = dao.boardListFaq();  
         //orderList.add(order);를 넘겨 받음
         
         //화면 이동
         // orderList객체를 view에 전달하는데 이름은 orderList로 전달한다(이름 부분 마음대로 설정 가능 " " 안에있는 부분)
         request.setAttribute("boardFaqList", boardFaqList); 
         // 저장한 값을 가지고 ("/phone/order/orderManagementList.jsp") 안에 있는 경로로 찾아간다.
         request.getRequestDispatcher("/WEB-INF/phone/board/boardFaq.jsp").forward(request, response); 
      }
}