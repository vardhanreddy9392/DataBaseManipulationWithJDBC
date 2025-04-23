package com.batchprocess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchInsertExample {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/batchdb";
		String user = "root";
		String password = "vardhan123";

		String insertSQL = "INSERT INTO student (id, name, email) VALUES (?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

			conn.setAutoCommit(false); // Disable auto-commit for batch execution

			for (int i = 1; i <= 1000; i++) {
				pstmt.setInt(1, i);
				pstmt.setString(2, "Student " + i);
				pstmt.setString(3, "student" + i + "@example.com");

				pstmt.addBatch(); // Add statement to batch

				if (i % 100 == 0) {
					pstmt.executeBatch(); // Execute every 100 records
				}
			}

			pstmt.executeBatch(); // Execute remaining records
			conn.commit(); // Commit transaction

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
