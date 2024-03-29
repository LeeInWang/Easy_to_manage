package com.choong.biz.product;

import java.sql.Timestamp;

public class ProductDTO {
	 private String productCode;
	   private String productDisplayStatus;
	   private int productSalePrice;
	   private int productInventoryQuantity;
	   private Timestamp productRegistrationDate;
	   private String productName;
	   private int productSaleCount;
	   private int productDiscountStatus;
	   private int productOriginalPrice;
	   private int productCostPrice;
	   private String productPaymentType;
	   private String productContent;
	   private String productImage;
	   private String productHashtags;
	   private String mainCategory;
	   private String subCategory;
	   private int productBest;
	      
	   
	   @Override
	public String toString() {
		return "ProductDTO [productCode=" + productCode + ", productDisplayStatus=" + productDisplayStatus
				+ ", productSalePrice=" + productSalePrice + ", productInventoryQuantity=" + productInventoryQuantity
				+ ", productRegistrationDate=" + productRegistrationDate + ", productName=" + productName
				+ ", productSaleCount=" + productSaleCount + ", productDiscountStatus=" + productDiscountStatus
				+ ", productOriginalPrice=" + productOriginalPrice + ", productCostPrice=" + productCostPrice
				+ ", productPaymentType=" + productPaymentType + ", productContent=" + productContent
				+ ", productImage=" + productImage + ", productHashtags=" + productHashtags + ", mainCategory="
				+ mainCategory + ", subCategory=" + subCategory + ", productBest=" + productBest + "]";
	}
	   
	   
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductDisplayStatus() {
		return productDisplayStatus;
	}
	public void setProductDisplayStatus(String productDisplayStatus) {
		this.productDisplayStatus = productDisplayStatus;
	}
	public int getProductSalePrice() {
		return productSalePrice;
	}
	public void setProductSalePrice(int productSalePrice) {
		this.productSalePrice = productSalePrice;
	}
	public int getProductInventoryQuantity() {
		return productInventoryQuantity;
	}
	public void setProductInventoryQuantity(int productInventoryQuantity) {
		this.productInventoryQuantity = productInventoryQuantity;
	}
	public Timestamp getProductRegistrationDate() {
		return productRegistrationDate;
	}
	public void setProductRegistrationDate(Timestamp productRegistrationDate) {
		this.productRegistrationDate = productRegistrationDate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductSaleCount() {
		return productSaleCount;
	}
	public void setProductSaleCount(int productSaleCount) {
		this.productSaleCount = productSaleCount;
	}
	public int getProductDiscountStatus() {
		return productDiscountStatus;
	}
	public void setProductDiscountStatus(int productDiscountStatus) {
		this.productDiscountStatus = productDiscountStatus;
	}
	public int getProductOriginalPrice() {
		return productOriginalPrice;
	}
	public void setProductOriginalPrice(int productOriginalPrice) {
		this.productOriginalPrice = productOriginalPrice;
	}
	public int getProductCostPrice() {
		return productCostPrice;
	}
	public void setProductCostPrice(int productCostPrice) {
		this.productCostPrice = productCostPrice;
	}
	public String getProductPaymentType() {
		return productPaymentType;
	}
	public void setProductPaymentType(String productPaymentType) {
		this.productPaymentType = productPaymentType;
	}
	public String getProductContent() {
		return productContent;
	}
	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductHashtags() {
		return productHashtags;
	}
	public void setProductHashtags(String productHashtags) {
		this.productHashtags = productHashtags;
	}
	public String getMainCategory() {
		return mainCategory;
	}
	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public int getProductBest() {
		return productBest;
	}
	public void setProductBest(int productBest) {
		this.productBest = productBest;
	}
	
	   

	
	
}
