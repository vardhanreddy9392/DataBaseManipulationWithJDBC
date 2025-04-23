package com.ecommerce.service;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.ecommerce.dao.OrderDAO;
import com.ecommerce.dto.Order;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		OrderDAO orderDAO=new OrderDAO();
		orderDAO.placeOrder(3,"vardhan",2,34.0);
		orderDAO.updateOrder(1,2,38.0);
		List<Order> orders=orderDAO.getAllOrders();
		for (Order o : orders) {
		    System.out.println("Order ID:"+o.getId()+" | Product:"+ o.getProductName()+"| Qty:"+ o.getQuantity()+" | Price:"+ o.getTotalPrice()+"\n");
		}
		
		orderDAO.deleteOrder(1);
		
		
	}

}
