package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
		System.out.println("Connection is created");
		Statement st = con.createStatement();
		String q = "select * from posts";
		ResultSet rs = st.executeQuery(q);
		System.out.println("id\ttitle\tbody");
		while (rs.next()) {
			System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
		}
	}

}
