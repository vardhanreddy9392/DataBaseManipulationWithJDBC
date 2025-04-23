package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.dbconnection.DatabaseConnection;
import com.ecommerce.dto.Order;

public class OrderDAO {
	public void placeOrder(int productId, String name, int quantity, double totalPrice)
			throws SQLException, ClassNotFoundException {
		Connection conn = DatabaseConnection.getDbConnection();
		System.out.println(conn);
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO orders (id, Productname,quantity, price) VALUES (?,?, ?, ?)");
		ps.setInt(1, productId);
		ps.setString(2, name);
		ps.setInt(3, quantity);
		ps.setDouble(4, totalPrice);
		ps.executeUpdate();
		conn.close();
	}

	public List<Order> getAllOrders() throws SQLException, ClassNotFoundException {
		Connection conn = DatabaseConnection.getDbConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM orders");
		ResultSet rs = ps.executeQuery();

		List<Order> orders = new ArrayList<>();
		while (rs.next()) {
			Order order = new Order(rs.getInt("id"), rs.getString("Productname"), rs.getInt("quantity"),
					rs.getDouble("price"));
			orders.add(order);
		}

		conn.close();
		return orders;
	}

	public void deleteOrder(int orderId) throws SQLException, ClassNotFoundException {
		Connection conn = DatabaseConnection.getDbConnection();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM orders WHERE id = ?");
		ps.setInt(1, orderId);
		int rowsDeleted = ps.executeUpdate();
		conn.close();

		if (rowsDeleted == 0) {
			System.out.println("No order found with ID: " + orderId);
		} else {
			System.out.println("Order deleted successfully.");
		}
	}

	public void updateOrder(int orderId, int newQuantity, double newPrice) throws SQLException, ClassNotFoundException {
		Connection conn = DatabaseConnection.getDbConnection();
		PreparedStatement ps = conn.prepareStatement("UPDATE orders SET quantity = ?, price = ? WHERE id = ?");
		ps.setInt(1, newQuantity);
		ps.setDouble(2, newPrice);
		ps.setInt(3, orderId);
		int rowsUpdated = ps.executeUpdate();
		conn.close();

		if (rowsUpdated == 0) {
			System.out.println("No order found with ID: " + orderId);
		} else {
			System.out.println("Order updated successfully.");
		}
	}

}
