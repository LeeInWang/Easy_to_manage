package com.choong.biz.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnection.MyDBConnection;

public class ProductDAO {
   private Connection con = null;
   private PreparedStatement pstmt = null;
   private ResultSet rs = null;
   
   private String PRODUCT_SELECT = "select * from productManagement where productCode=?";      
   private String PRODUCT_LIST = "select * from productManagement";
   private String PRODUCT_INSERT = "insert into productManagement(productDisplayStatus, productCode, productSalePrice, productInventoryQuantity, productName, productSaleCount, productDiscountStatus, productOriginalPrice, productCostPrice, productPaymentType, productContent, productImage, productHashtags, mainCategory, subCategory, productBest) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
   private String PRODUCT_UPDATE = "update productManagement set productDisplayStatus=?, productSalePrice=?, productInventoryQuantity=?, "
	         + "productName=?, productSaleCount=?, productDiscountStatus=?, productOriginalPrice=?, "
	         + "productCostPrice=?, productPaymentType=?, productContent=?, productImage=?, productHashtags=?, "
	         + "mainCategory=?, subCategory=?, productBest=? where productCode=?";
   
   private String PRODUCT_DELETE = "delete from productManagement where productCode=?";

   
   
   // [ 1 ] Insert
   
   public void productInsert(ProductDTO dto) {

	   try {
		    con = MyDBConnection.getConnection();
		    pstmt = con.prepareStatement(PRODUCT_INSERT);   

		    pstmt.setString(1, dto.getProductDisplayStatus());
		    pstmt.setString(2, dto.getProductCode());  // productCode는 두 번째로 설정됨
		    pstmt.setInt(3, dto.getProductSalePrice());
		    pstmt.setInt(4, dto.getProductInventoryQuantity());
		    pstmt.setString(5, dto.getProductName());
		    pstmt.setInt(6, dto.getProductSaleCount());
		    pstmt.setInt(7, dto.getProductDiscountStatus());
		    pstmt.setInt(8, dto.getProductOriginalPrice());
		    pstmt.setInt(9, dto.getProductCostPrice());
		    pstmt.setString(10, dto.getProductPaymentType());
		    pstmt.setString(11, dto.getProductContent());
		    pstmt.setString(12, dto.getProductImage());
		    pstmt.setString(13, dto.getProductHashtags());
		    pstmt.setString(14, dto.getMainCategory());
		    pstmt.setString(15, dto.getSubCategory());
		    pstmt.setInt(16, dto.getProductBest());

		    pstmt.executeUpdate();   
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    MyDBConnection.close(rs, pstmt, con);
		}

   }

   
   

// [ 2 ] Update
   
   public void productUpdate(ProductDTO dto) {

      try {
         con = MyDBConnection.getConnection();
         pstmt = con.prepareStatement(PRODUCT_UPDATE);
         
         pstmt.setString(1, dto.getProductDisplayStatus());
         pstmt.setInt(2, dto.getProductSalePrice());
         pstmt.setInt(3, dto.getProductInventoryQuantity());
         pstmt.setString(4, dto.getProductName());
         pstmt.setInt(5, dto.getProductSaleCount());
         pstmt.setInt(6, dto.getProductDiscountStatus());
         pstmt.setInt(7, dto.getProductOriginalPrice());
         pstmt.setInt(8, dto.getProductCostPrice());
         pstmt.setString(9, dto.getProductPaymentType());
         pstmt.setString(10, dto.getProductContent());
         pstmt.setString(11, dto.getProductImage());
         pstmt.setString(12, dto.getProductHashtags());
         pstmt.setString(13, dto.getMainCategory());
         pstmt.setString(14, dto.getSubCategory());
         pstmt.setInt(15, dto.getProductBest());   
         pstmt.setString(16, dto.getProductCode());   

         

         pstmt.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         MyDBConnection.close(rs, pstmt, con);
      }
      
   }

   // [ 3 ] Delete
   
   public void productDelete (String productCode) {
      
      try {
         con = MyDBConnection.getConnection();
         pstmt = con.prepareStatement(PRODUCT_DELETE);
         pstmt.setString(1, productCode);
         pstmt.executeUpdate();
         
      } catch (SQLException e) {
         e.printStackTrace();
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         MyDBConnection.close(rs, pstmt, con);
      }
   }


   
   // [ 4 ] List - 전체
   public List<ProductDTO> getProductList(){
      List<ProductDTO> productList = new ArrayList<ProductDTO>();
      
      try {
         con = MyDBConnection.getConnection();
         pstmt = con.prepareStatement(PRODUCT_LIST);   
         rs=pstmt.executeQuery();   
         
         while(rs.next()) {   
            ProductDTO dto = new ProductDTO();
            
            dto.setProductCode(rs.getString("productCode"));
            dto.setProductDisplayStatus(rs.getString("productDisplayStatus"));
            dto.setProductSalePrice(rs.getInt("productSalePrice"));
            dto.setProductInventoryQuantity(rs.getInt("productInventoryQuantity"));
            dto.setProductRegistrationDate(rs.getTimestamp("productRegistrationDate"));
            dto.setProductName(rs.getString("productName"));
            dto.setProductSaleCount(rs.getInt("productSaleCount"));
            dto.setProductDiscountStatus(rs.getInt("productDiscountStatus"));
            dto.setProductOriginalPrice(rs.getInt("productOriginalPrice"));
            dto.setProductCostPrice(rs.getInt("productCostPrice"));
            dto.setProductPaymentType(rs.getString("productPaymentType"));
            dto.setProductContent(rs.getString("productContent"));
            dto.setProductImage(rs.getString("productImage"));
            dto.setProductHashtags(rs.getString("productHashtags"));
            dto.setMainCategory(rs.getString("mainCategory"));
            dto.setSubCategory(rs.getString("subCategory"));
            dto.setProductBest(rs.getInt("productBest"));
            
            productList.add(dto);
         } 
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {   
         MyDBConnection.close(rs, pstmt, con);
      }   
      return productList;   
   }

   
   // [ 5 ] Select - 한개
   public ProductDTO getProduct(String id){
	   ProductDTO productDTO = null;
		
		
		//private String USER_GET = "select * from users where id=?"; //상세
		
		try {
			con = MyDBConnection.getConnection();
			pstmt = con.prepareStatement(PRODUCT_SELECT);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
		
			
			if(rs.next()) { //DB의 이름이랑 같아야 하고, 
				  productDTO = new ProductDTO(); 
				
				  productDTO.setProductDisplayStatus(rs.getString("productDisplayStatus"));
				  productDTO.setProductSalePrice(rs.getInt("productSalePrice"));
				  productDTO.setProductInventoryQuantity(rs.getInt("productInventoryQuantity"));
				  productDTO.setProductRegistrationDate(rs.getTimestamp("productRegistrationDate"));
				  productDTO.setProductName(rs.getString("productName"));
				  productDTO.setProductSaleCount(rs.getInt("productSaleCount"));
				  productDTO.setProductDiscountStatus(rs.getInt("productDiscountStatus"));
				  productDTO.setProductOriginalPrice(rs.getInt("productOriginalPrice"));
				  productDTO.setProductCostPrice(rs.getInt("productCostPrice"));
				  productDTO.setProductPaymentType(rs.getString("productPaymentType"));
				  productDTO.setProductContent(rs.getString("productContent"));
				  productDTO.setProductImage(rs.getString("productImage"));
				  productDTO.setProductHashtags(rs.getString("productHashtags"));
				  productDTO.setMainCategory(rs.getString("mainCategory"));
				  productDTO.setSubCategory(rs.getString("subCategory"));
				  productDTO.setProductBest(rs.getInt("productBest"));
				  productDTO.setProductCode(rs.getString("productCode"));	         
	
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return productDTO;
   }
}