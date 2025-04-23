package com.databaseaccess;

import java.sql.*;

public class EmployeeDatabase {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/batchdb";
	private static final String USER = "root";
	private static final String PASSWORD = "vardhan123";

	public static void getEmployeeById(int id) {
		String query = "SELECT * FROM student WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(query)) {

			stmt.setInt(1, id); // Set parameter value

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					System.out.println("Employee ID: " + rs.getInt("id"));
					System.out.println("Name: " + rs.getString("name"));
					System.out.println("Position: " + rs.getString("email"));
				} else {
					System.out.println("Employee not found.");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getEmployeeById(1); // Example call
	}

}
