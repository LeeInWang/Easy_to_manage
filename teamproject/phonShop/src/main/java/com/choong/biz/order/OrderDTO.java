package com.choong.biz.order;

import java.sql.Date;
import java.sql.Timestamp;

public class OrderDTO {
	private int orderId;
	private int orderProductPrice;
	private String orderProductName;
	private int orderProductCount;
	private int orderDeliveryCost;
	private String orderUserName;
	private String orderRecipientName;
	private int orderTotalAmount;
	private String orderPaymentType;
	private String orderPhoneNumber;
	private String orderTrackingNumber;
	private String orderDeliveryCompanyName;
	private String orderRecipientAddress;
	private String orderDeliveryRequest;
	private String orderDelivery;
	private Timestamp orderDate;
	
	private String searchCondition;  // 검색 조건
	private String searchKeyword; // 검색 키워드
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderProductPrice() {
		return orderProductPrice;
	}
	public void setOrderProductPrice(int orderProductPrice) {
		this.orderProductPrice = orderProductPrice;
	}
	public String getOrderProductName() {
		return orderProductName;
	}
	public void setOrderProductName(String orderProductName) {
		this.orderProductName = orderProductName;
	}
	public int getOrderProductCount() {
		return orderProductCount;
	}
	public void setOrderProductCount(int orderProductCount) {
		this.orderProductCount = orderProductCount;
	}
	public int getOrderDeliveryCost() {
		return orderDeliveryCost;
	}
	public void setOrderDeliveryCost(int orderDeliveryCost) {
		this.orderDeliveryCost = orderDeliveryCost;
	}
	public String getOrderUserName() {
		return orderUserName;
	}
	public void setOrderUserName(String orderUserName) {
		this.orderUserName = orderUserName;
	}
	public String getOrderRecipientName() {
		return orderRecipientName;
	}
	public void setOrderRecipientName(String orderRecipientName) {
		this.orderRecipientName = orderRecipientName;
	}
	public int getOrderTotalAmount() {
		return orderTotalAmount;
	}
	public void setOrderTotalAmount(int orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}
	public String getOrderPaymentType() {
		return orderPaymentType;
	}
	public void setOrderPaymentType(String orderPaymentType) {
		this.orderPaymentType = orderPaymentType;
	}
	public String getOrderPhoneNumber() {
		return orderPhoneNumber;
	}
	public void setOrderPhoneNumber(String orderPhoneNumber) {
		this.orderPhoneNumber = orderPhoneNumber;
	}
	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}
	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}
	public String getOrderDeliveryCompanyName() {
		return orderDeliveryCompanyName;
	}
	public void setOrderDeliveryCompanyName(String orderDeliveryCompanyName) {
		this.orderDeliveryCompanyName = orderDeliveryCompanyName;
	}
	public String getOrderRecipientAddress() {
		return orderRecipientAddress;
	}
	public void setOrderRecipientAddress(String orderRecipientAddress) {
		this.orderRecipientAddress = orderRecipientAddress;
	}
	public String getOrderDeliveryRequest() {
		return orderDeliveryRequest;
	}
	public void setOrderDeliveryRequest(String orderDeliveryRequest) {
		this.orderDeliveryRequest = orderDeliveryRequest;
	}
	public String getOrderDelivery() {
		return orderDelivery;
	}
	public void setOrderDelivery(String orderDelivery) {
		this.orderDelivery = orderDelivery;
	}
	
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
}