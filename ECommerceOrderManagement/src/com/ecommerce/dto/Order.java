package com.ecommerce.dto;

public class Order {

    private int id;
    private String productName;
    public Order(int id, String productName, int quantity, double totalPrice) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	private int quantity;
    private double totalPrice;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
