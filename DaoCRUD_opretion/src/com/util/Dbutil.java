package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
	
	private static final String DRVER_PATH="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/data";
	private static final String USERNAME="root";
	private static final String PASSWORD="Root";
	
	public Dbutil() {
		try {
			Class.forName(DRVER_PATH);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("something went wronng.......");
		}
	}//end of construct

	public Connection getConnection() throws SQLException {
		System.out.println("Driver loaded ..........");
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
}
