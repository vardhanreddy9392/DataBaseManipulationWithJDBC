package com.ecommerce.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
     public static Connection getDbConnection() throws ClassNotFoundException, SQLException
     {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","vardhan123");
    	 if(con!=null)
    	 {
    		 System.out.println("connection establishment");
    	 }
    	 else
    	 {
    		 System.out.println("failed to connect");
    	 }
    	 return con;
     }
     
}