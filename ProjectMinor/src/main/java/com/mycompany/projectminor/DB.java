/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectminor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Lenovo
 */
public class DB {
    private final String HOST = "jdbc:mysql://localhost:3306/";
//	private final String PORT = "3306";
		private final String USERNAME = "root";
		private final String PASSWORD = "12345";
		private final String DATABASE_NAME = "Management";
		private final String DRIVER = "com.mysql.cj.jdbc.Driver";
		public Connection getConnection() throws Exception{
			Connection connection ;
			Class.forName(DRIVER);
			System.out.println("Connecting to Database.....");
			connection = DriverManager.getConnection(HOST + DATABASE_NAME, USERNAME, PASSWORD);
			System.out.println("Connection SUCCESSFULL");
			return connection;
		}
		
		public void close(Connection connection,PreparedStatement pstmt) throws Exception{
			if (connection == null) {
		        return;
		    }
			connection.close();
			pstmt.close();
		}
	
}
